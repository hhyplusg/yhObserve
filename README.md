应该是"inline-source": "^5.2.0"
如果是6点几版本，gulp build会出现问题

## 怎么遍历多个js文件
1. 在webpack.config.js中entry中添加对应js文件
2. gulp.src('client/scripts/*.js')   //js需要用通配符*

## 易错点
gulp不能return forEach
```
gulp.task('scripts', () => {
return demos.forEach(rollup);  //出错
 });
```

## import example
```
import * as exp from './export';
import test from './page';
test();
exp.test0();
```


后面加了-new是上传到svn中的最新版