const pify = require('pify');
const fs = require('fs-jetpack');
const path = require('path');
const loadJsonFile = require('load-json-file');
const inline = pify(require('inline-source'));
const gulp = require('gulp');
const $ = require('gulp-load-plugins')();
const cssnext = require('postcss-cssnext');
const browserSync = require('browser-sync').create();
var webpack = require('webpack-stream');
// var webpack = require('webpack');
var webpackConfig = require('./webpack.config.js')

const nunjucks = require('nunjucks');
const del = require('del');
nunjucks.configure('views', {
  noCache: true,
  watch: false,
  tags: {
    commentStart: '<#',
    commentEnd: '#>'
  }
});
const render = pify(nunjucks.render);

process.env.NODE_ENV = "development"
gulp.task('prod', () => {
  return Promise.resolve(process.env.NODE_ENV = 'production');
});

gulp.task('dev', () => {
  return Promise.resolve(process.env.NODE_ENV = 'development');
});
  /**
 * 读出数据之后接着循环，再return出promise对象，其实resolve就是promise对象
   读出对象，把对象render到页面中，渲染并读出需要模板、路径名、渲染页面中的data
   如果css和js文件不一样，继续在json中添加元素
 */ 
gulp.task('build-page', () => {
  
  const destDir = '.tmp';
  const pathDetail = loadJsonFile('views/data/path-detail.json');
  // detail返回promise
  return pathDetail.then(data => {
    const demos = data.demos;
    //  此运行完之后再返回promise，进行循环返回promise
    return Promise.all(demos.map((demo) => {
      return renderPerView(demo);
    }))
  })
  .then(() => {
      console.log('inline--'+process.env.NODE_ENV)
      browserSync.reload('*.html');
      // return Promise.resolve();
    })
    .catch(err => {
      console.log(err);
    });

 
  async function renderPerView(demo){
    const env = {
      isProduction: process.env.NODE_ENV === 'production'
    };
    
    const name = demo.name;
    const template = demo.template;
    const dataPath = demo.data;
    // dataPath不为空loadJsonFile读取不会报错，否则会报错,并且报错后环境为development，可以把页面数据集中在一个json文件中
      return loadJsonFile(dataPath)
      .then(data => {
        
        if (name ==='chart'){
          return render(template, {
            env
          });
        }else{
          return render(template, {
            env
          });
        }
        
      })
      .then(html => {  

        if (process.env.NODE_ENV === 'production') {
          return inline(html, {
            compress: true,
            rootpath: path.resolve(process.cwd(), '.tmp')
          });
        }    
        return html;
        })
        .then(html => {
          const destFile = path.resolve(destDir, `${name}.html`);
          return fs.writeAsync(destFile, html);
      })


  }
  
});


gulp.task('styles', function styles() {
  const DEST = '.tmp/styles';
  return gulp.src(['client/styles/*.scss'])
    .pipe($.changed(DEST))
    .pipe($.plumber())
    .pipe($.sourcemaps.init({loadMaps:true}))
    .pipe($.sass({
      outputStyle: 'expanded',
      precision: 10,
      includePaths: ['bower_components']
    }).on('error', $.sass.logError))
    .pipe($.postcss([
      cssnext({
        features: {
          colorRgba: false
        }
      })
    ]))
    .pipe($.sourcemaps.write('./'))
    .pipe(gulp.dest(DEST))
    .pipe(browserSync.stream());
});


gulp.task('jshint', function () {
  return gulp.src('client/scripts/**/*.js')
    .pipe($.jshint())
    .pipe($.jshint.reporter('jshint-stylish'))
    .pipe($.jshint.reporter('fail'));
});

// gulp.task('scripts', () => {
//   const details =  fs.readAsync('views/data/path-detail.json','json');
//   const demos = details.demos;
//   function rollup(demo){
//     gulp.src(`client/scripts/${demo.js}`)
//     .pipe($.plumber())  //自动处理全部错误信息防止因为错误而导致 watch 不正常工作
//     .pipe($.sourcemaps.init({loadMaps:true})) 
//     .pipe($.babel())
//     .pipe(webpack(webpackConfig))
//     .pipe($.sourcemaps.write('./'))
//     .pipe(gulp.dest(`.tmp/scripts/${demo.js}`))
//     .pipe(browserSync.reload({stream: true}));
//   }
//   return demos.forEach(rollup);    
// });

gulp.task('scripts', () => {
  return gulp.src('client/scripts/observe.js')
    .pipe($.plumber())  //自动处理全部错误信息防止因为错误而导致 watch 不正常工作
    .pipe($.sourcemaps.init({loadMaps:true})) 
    .pipe($.babel())
    .pipe(webpack(webpackConfig))
    .pipe($.sourcemaps.write('./'))
    .pipe(gulp.dest('.tmp/scripts/'))
    .pipe(browserSync.reload({stream: true}));
});

// gulp.task('scripts', async () => {
//   const details = await fs.readAsync('views/data/path-detail.json','json');
//   const demos = details.demos;
//   async function rollupOneJs(demo) {
//     const bundle = await rollup({
//       input:`client/scripts/${demo.js}`,
//       plugins:[
//         babel({
//           exclude:'node_modules/**'
//         }),
//         nodeResolve({
//           jsnext:true,
//         })
//       ]
//     });

//     await bundle.write({
//         file: `.tmp/scripts/${demo.js}`,
//         format: 'iife',
//         sourcemap: true
//     });
//   }

//   await demos.forEach(rollupOneJs);
//   browserSync.reload();
// });



gulp.task('comJs', () => {
  return gulp.src('.tmp/scripts/*.js')
    .pipe($.uglify())
    .pipe(gulp.dest('.tmp/scripts/'));
});
gulp.task('comCss', () => {
  return gulp.src('.tmp/styles/*.css')
    .pipe($.cssnano())
    .pipe(gulp.dest('.tmp/styles/'));
});


gulp.task('clean', () => {
  return del(['.tmp/**','.dest/**']);
});

gulp.task('jshint', function () {
  return gulp.src('client/scripts/**/*.js')
    .pipe($.jshint())
    .pipe($.jshint.reporter('jshint-stylish'))
    .pipe($.jshint.reporter('fail'));
});

gulp.task('copylib', () => {
  return gulp.src('client/lib/**')
    .pipe(gulp.dest('.tmp/lib/'));
});
gulp.task('serve', gulp.parallel('build-page', 'styles', 'scripts','copylib',  () => {
  browserSync.init({
    server: {
      baseDir: ['.tmp'],
      index: 'index.html',
      directory: true,
      routes: {
        '/bower_components': 'bower_components'
      }
    }
  });

  gulp.watch(['views/*.{html,json}'], 
    gulp.parallel('build-page')
  );

  gulp.watch(['client/**/*.scss'],
    gulp.parallel('styles')
  );

  gulp.watch(['client/**/*.js'],
    gulp.parallel('scripts')
  );

  gulp.watch(['/*.js'],
    gulp.parallel('scripts')
  );

}));

gulp.task('build', gulp.series('prod','clean','copylib','styles', 'scripts', 'build-page','comJs','comCss', 'copylib', 'dev'));





