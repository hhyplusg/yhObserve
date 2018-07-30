var webpack = require('webpack');
var path = require('path');
const uglify = require('uglifyjs-webpack-plugin');

// https://blog.csdn.net/maomaolaoshi/article/details/78741007
// 打包思路：可以把库文件打包在一个文件中；把公共不变文件打包到一个文件中
// https://webpack.js.org/configuration/  官网配置
// webpack在gulpfile中引用，则读取不到插件
module.exports = {
    // mode: "development", 
    devtool: 'cheap-module-source-map',
    entry:
    {
        'observe':['./client/scripts/observe.js'],
        'page':['./client/scripts/page.js'],
        'exportword':['./client/scripts/exportword.js']
    },
   
    output: {
        path: path.join(__dirname, '.tmp/'),  //这儿好像没起作用
        filename: '[name].js', //输出文件名，[name].js默认是main.js。如果指定则是指定名
        publicPath: '/tmp/',
        chunkFilename: "[chunkhash].js"
    },
    module: {
        rules:[
             {
                test: /\.js|\.jsx$/,
                exclude: [
                    path.resolve(__dirname, "node_modules")
                ],
                loader: "babel-loader",
                options: {
                    presets: ["es2015"]
                },
             },
             {
                test: /\.css$/,
                exclude: [
                    path.resolve(__dirname, "node_modules")
                ],
                loader: 'style-loader!css-loader?modules&importLoaders&localIdentName=[name]__[local]__[hash:base64:5]!sass-loader?sourceMap=true&sourceMapContents=true',            
             },
             {
                test: /\.json?$/,
                loader: 'json'
             },
             {
                test:  /\.scss$/,  
                exclude: [
                    path.resolve(__dirname, "node_modules")
                ],
                use: [
                    {  
                        loader: 'style-loader'   // 将 JS 字符串生成为 style 节点
                    },
                    {
                        loader: 'css-loader',  // 将 CSS 转化成 CommonJS 模块
                    },
                    {
                        loader: 'sass-loader',  // 将 Sass 编译成 CSS
                        options: { 
                            sourceMap:true  ,
                            sourceMapContents:true
                        }
                    }
                ]
            },
             {
                test: /\.html$/,
                use: [
                    "htmllint-loader",
                    {
                        loader: "html-loader",
                        options: {
                        }
                    }
                ]
            }
        ]      
    },
     resolve: {
        // options for resolving module requests解决模块请求的选项。
        // 查找模块的目录
        extensions: [".js", ".json", ".jsx", ".css"],
    },
    plugins: [
        new uglify()
    ],
    // watch: true
    
};

