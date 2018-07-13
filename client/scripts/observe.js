import {EventObject,GetCookie,SetCookie,DeleteCookie,isWeiXin,parseUrlSearch,getUrlParams,isEmptyObj,getDeviceType} from './api';

// import * as SandSignika from '../lib/Highstock-6.1.0/code/themes/sand-signika';

$(function(){ 
	console.log("开始画图--");
	drawChart();  //<!-- 博弈/存量指标 -->
	drawChart2(); //百分比图方法实现双轴</li>     <!-- 融资买入/可用担保价值 -->
	drawChart3(); // 基础表实现双轴</li>           <!-- 综合性情绪指标 -->
	drawChart31(); //百分比图方法实现双轴</li>     <!-- 融资买入/可用担保价值 -->
	drawChart32();
	drawChart33();  //换手率
	drawChart34();  //指定版块的个股估值分布
	// drawChart4(); // 基础表实现双轴（自己造数据）</li>     <!-- 强势股占比 -->
	// drawChart5(); // 散点图</li>          <!--  指数换手率分布图（散点图）-->
	drawChart_A32();
	drawChart_B11();  //指定版块的相对换手率历史变化
	drawChart_B21();   //柱状图  换手率变化最大的基准
	drawChart_B22();   //柱状图  换手率绝对水平最高的基准
	drawChart_B23();   //表格   基准/版块的周换手率
	drawChart_B24();
	drawChart_B31();   //柱状图
	drawChart6(); // 反转图 
	drawChart7(); // 象限图
	drawChart_B41();
	// export
	$("#exportButton").click(function(event){
		console.log("zhixinle导出函数！");
		// var blob = new Blob(['out_put_string'], {type: "text/plain;charset=utf-8"});//out_put_string为需要保存到文件的字符串内容
		// saveAs(blob, "filename.php");//filename.php为保存的文件名
		$("#bigDiv").wordExport();
	});



});

//基础表单轴
function drawChart(){
	console.log("开始drawChart-123");
	//获取数据
	$.getJSON('../lib/dataForOne.json',function (dataYH) {
		var data=dataYH.obj;
		for (var index = 0;index <= data.length - 1;  index = index + 1) {
			var a=data[index][0]*1000;
			data[index][0]=a;
		} 

	// $.getJSON('http://localhost/weekly/IndicatorQuery?indicatorId=0001',function (dataYH) {	
	// var jsonObject =$.parseJSON(dataYH);
	// var data=jsonObject.obj;
	// console.log("图1的obj数据为：\n");
	console.log(data);


		// Create the chart
		Highcharts.setOptions({
		    global: {
		        useUTC: false
		    },
		    lang:{
				contextButtonTitle:"图表导出菜单",
				decimalPoint:".",
				downloadJPEG:"下载JPEG图片",
				downloadPDF:"下载PDF文件",
				downloadPNG:"下载PNG文件",
				downloadSVG:"下载SVG文件",
				drillUpText:"返回 {series.name}",
				loading:"加载中",
				months:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
				noData:"没有数据",
				numericSymbols: [ "千" , "兆" , "G" , "T" , "P" , "E"],
				printChart:"打印图表",
				resetZoom:"恢复缩放",
				resetZoomTitle:"恢复图表",
				shortMonths: [ "Jan" , "Feb" , "Mar" , "Apr" , "May" , "Jun" , "Jul" , "Aug" , "Sep" , "Oct" , "Nov" , "Dec"],
				thousandsSep:",",
				weekdays: ["星期一", "星期二", "星期三", "星期三", "星期四", "星期五", "星期六","星期天"]
		}

		});
		var mychart =Highcharts.stockChart('showDiagram1', {
			credits: {
				enabled: false
			},
			scrollbar: {
		        enabled: true
		    },
		    legend: {
		        enabled: true,
		        align: 'right',
		        // backgroundColor: '#FCFFC5',
		        // borderColor: 'black',
		        // borderWidth: 2,
		        color: 'gray',
		        layout: 'vertical',
		        verticalAlign: 'top',
		        x: -40,
				y: 15,
				floating: true,
				itemStyle:{
					"color": "black", 
					"cursor": "pointer", 
					"fontSize": "12px", 
					// "fontWeight": "bold"
				}
		        // shadow: true,
		        // itemWidth: 80,
		        // maxHeight:10
		    },
			rangeSelector: {
				enabled: true,
				selected: 5,
				buttonTheme: { // styles for the buttons
		  //           fill: 'none',
		  //           stroke: 'none',
		  //           'stroke-width': 0,
		  //           // r: 20,
		  //           width: 22,
    //     			// height: 20,
		            style: {
		                // color: 'gray',
		                // fontWeight: 'bold',
		                fontSize:13,
		          
		            },
		  //           states: {
		  //               hover: {
		  //               },
		  //               select: {
		  //                   fill: '#039',
		  //                   style: {
		  //                       color: 'white'
		  //                   }
		  //               }
		  //               // disabled: { ... }
		  //           }
		        },
		        inputBoxBorderColor: 'gray',
		        inputBoxWidth: 90,
		        inputBoxHeight: 18,
		        inputStyle: {
		            color: 'black',
		            // fontWeight: 'bold'
		            fontSize:13
		        },
		        labelStyle: {
		            color: 'gray',
		            fontWeight: 'bold',
		            fontSize:13
		        },
			},
			exporting: {
			    enabled: false,
			    scale: 1,
			    sourceWidth: 700,
        		sourceHeight: 500
			},
			title: {
				text: '博弈/存量指标',
				style: {
							color: 'black',
							fontWeight: 'bold',
							fontSize: '18px'
						},
				margin: 30
			},
			plotOptions: {
		        series: {
		            events: {
		                click: function (event) {
		                    // alert(this.name + ' clicked\n' +
		                    //     'Alt: ' + event.altKey + '\n' +
		                    //     'Control: ' + event.ctrlKey + '\n' +
		                    //       'Shift: ' + event.shiftKey + '\n');
		                    console.log('zhixingle点击函数，看看土包更新');
		                    let cdiv=document.getElementById('ChildDiv');
		                    if(cdiv!=null){  
						        let p = cdiv.parentNode;  
						        p.removeChild(cdiv);  
						    }  

		                    var mouseX;//记录鼠标点击位置。  
							var mouseY;//记录鼠标点击位置

		                    var ev = ev||event;   
						    if(ev.pageX || ev.pageY){   
						        mouseX = ev.pageX+'px';   
						        mouseY = ev.pageY+'px';  
						    }else{//兼容ie   
						        mouseX = ev.clientX+document.body.scrollLeft - document.body.clientLeft+'px';  
						      mouseY = ev.clientY+document.documentElement.scrollTop+'px';  
						    } 
						    var my = document.createElement("ChildDiv");   //创建一个div    
						    document.body.appendChild(my);   //添加到页面     
						    my.style.position="absolute";    //通过样式指定该div的位置方式,  
						    my.style.top= mouseY;   //通过样式指定y坐标  
						    my.style.left= mouseX;   //通过样式指定x坐标  
						    my.style.border='1px solid #FF0000'; // 设置边框  
						    my.style.width='300px';  
							my.style.height='200px';//通过样式指定宽度、高度    
							//通过样式指定背景颜色,,若是背景图片 例为my.style.backgroundImage="url(img/3.jpg)"     
							my.style.backgroundColor="#ffffcc";   //设置样式透明  
							var alpha = 80;  
							my.style.filter='alpha(opacity:'+alpha+')';//IE   
							my.style.opacity=alpha/100;//IE之外其他浏览器  
							my.id = "ChildDiv";//设置ID 

							//给div加一个点击后隐藏的函数 
							my.onclick = function(){
							   if(  (cdiv=document.getElementById('ChildDiv'))!=null){  
							        p = cdiv.parentNode;  
							        p.removeChild(cdiv);  
							    } 
							 };

							//在div中创建图表
							var chart = Highcharts.chart('ChildDiv', {
							chart: {
									type: 'column'
							},
							credits: {
								enabled: false
							},
							title: {
									text: 'PE频率'
							},
							subtitle: {
									text: '数据截止 2017-03'
							},
							xAxis: {
									type: 'category',
									labels: {
											rotation: -45  // 设置轴标签旋转角度
									}
							},
							yAxis: {
									min: 0,
									title: {
											// text: '人口 (百万)'
									}
							},
							legend: {
									enabled: false
							},
							tooltip: {
									pointFormat: 'PE频率: <b>{point.y:.1f} 百万</b>'
							},
							series: [{
										name: 'PE频率',
										data: [
											['0', 24.25],
											['15', 23.50],
											['30', 21.51],
											['45', 16.78],
											['60', 16.06],
											['75', 15.20],
											['90', 14.16],
											['105', 13.51],
											['120', 13.08],
											['135', 12.44],
											['150', 12.19],
											['165', 12.03],
											['180', 10.46],
											['195', 10.07],
											['210', 10.05],
											['225', 9.99],
											['240', 9.78],
											['255', 9.73],
											['270', 9.27],
											['290', 8.87]
										],
										dataLabels: {
											enabled: true,
											rotation: -90,
											color: '#FFFFFF',
											align: 'right',
											format: '{point.y:.1f}', // :.1f 为保留 1 位小数
											y: 10
										}
									}]
							});
		                }
		            }
		        }
		    },
		    tooltip: {
				split: false,
				dateTimeLabelFormats: {
						millisecond: '%H:%M:%S.%L',
						second: '%H:%M:%S',
						minute: '%H:%M',
						hour: '%H:%M',
						day: '%m-%d',
						year: '%Y-%m-%d',
				},
				headerFormat: '{point.x:%Y-%m-%d}<br>'
			},
			navigator: {
				enabled: true,
				xAxis: {
					dateTimeLabelFormats: {
							millisecond: '%H:%M:%S.%L',
							second: '%H:%M:%S',
							minute: '%H:%M',
							hour: '%H:%M',
							day: '%m-%d',
							week: '%Y-%m-%d',
				            month: '%Y-%m',
				            year: '%Y'
					}
				}
			},

		    xAxis: {				
		        title: {
		            enabled: true,
		            // text: '2本周换手率历史分位'
		        },
		        type: 'datetime',
		        // tickInterval: 24*3600*1000,
				dateTimeLabelFormats: {
					millisecond: '%H:%M:%S.%L',
					second: '%H:%M:%S',
					minute: '%H:%M',
					hour: '%H:%M',
					day: '%Y-%m-%d',
		            week: '%Y-%m-%d',
		            month: '%Y-%m',
		            year: '%Y'
				},
				// crosshair: {
				// 	label: {
				// 			format: '%Y-%m-%d'
				// 	}
				// }

		        labels: {
		        	// rotation: -10
		        // 	formatter: function() {
		        //      	return Math.round(this.value*100) + '%';
		        //      	// return Highcharts.numberFormat(this.value.percentage,2)+ '%';
		        //  	}
		        },
		        // startOnTick: true,
		        // endOnTick: true,
		        // showLastLabel: true
		    },
			yAxis: {
				opposite: false,
				lineWidth:1,
				title: {
					// text: '这个是Y轴'
				},
				plotLines: [{
						zIndex: 999,
						value: 0.25,
						color: 'blue',
						dashStyle: 'shortdash',
						width: 2,
						label: {
								text: '0.25'
						}
				}, {
						zIndex: 999,
						value: 0.4,
						color: 'red',
						dashStyle: 'shortdash',
						width: 2,
						label: {
								 text: '0.4'
						}
				}]
			},

			series: [{
				name: '博弈/存量资金',
				data: data,
				tooltip: {
						valueDecimals: 4
				},
				dashStyle:'Dot'
			}]
		});

	});
	$("#testExport").click(function(event){
		console.log("点击了导出图片！");
		var chart = $('#showDiagram1').highcharts();
		$('#showDiagram1').find('.svg').css("color","red");

		var curTime=getCurrentTime();
		// console.log('获取的时间是：---\n');console.log(curTime);

		chart.exportChart({
			exportFormat : 'PNG',
			filename: '博弈_存量指标'+curTime
		});

		//图标转换成图片
		// var svg = chart.getSVG()
		// 		.replace(/</g, '\n<') // make it slightly more readable
		// 		.replace(/>/g, '>');				
		// console.log('svg---');
		// $("#showDiagram1").html(svg);

	});

}


// 百分比图方法实现双轴
function drawChart2(){   
	console.log("开始drawChart-2-");
	var seriesOptions = [],
	seriesCounter = 0,
	names = ['MSFT', 'GOOG'],
	// create the chart when all data is loaded
	createChart = function () {
		Highcharts.stockChart('showDiagram2', {
				credits: {
					enabled: false
				},
				rangeSelector: {
					selected: 5,
					enabled: false,
				},
				exporting: {
			        enabled: false
			    },
			    navigator: {
			        enabled: false
			    },
			    scrollbar: {
			        enabled: false
			    },
				title: {
					text: '融资买入/可用担保价值',
					style: {
								color: 'black',
								fontWeight: 'bold',
								fontSize: 20
						},
					margin: 30
				},
				yAxis: [
				{
						title: {
							// text: '融资买入/可用担保价值',
						},
						lineWidth:1,
						opposite: false
				},
				{
						title: {
							// text: '沪深300',
						},
						lineWidth:1,
						plotLines: [{
								value: 350,
								width: 2,
								color: 'gray',
								dashStyle: 'shortdash',
						},
						{
								value: 700,
								width: 2,
								color: 'gray',
								dashStyle: 'shortdash',
						}
						],
						labels: {
								// formatter: function () {
								// 		return (this.value > 0 ? ' + ' : '') + this.value + '%';
								// }
						},
						
				}				
				],
				// plotOptions: {
				// 		series: {
				// 				compare: 'percent'
				// 		}
				// },
				tooltip: {
						pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> ({point.change}%)<br/>',
						valueDecimals: 2
				},
				series: seriesOptions
		});
	};
	$.each(names, function (i, name) {
			// $.getJSON('../lib/data2.json',    function (data) {
			$.getJSON('https://data.jianshukeji.com/jsonp?filename=json/' + name.toLowerCase() + '-c.json&callback=?',    function (data) {
				
					seriesOptions[i] = {
							name: name,
							data: data,
							yAxis: i
					};
					seriesCounter += 1;
					if (seriesCounter === names.length) {
							createChart();
					}
				
					
			});

	});

}
 //基础表实现双轴
function drawChart3(){
	console.log("开始drawChart-3-");
	// $.getJSON('../lib/data3.json', function (data) {
	$.getJSON('https://data.jianshukeji.com/jsonp?filename=json/usdeur.json&callback=?', function (data) {
		var startDate = new Date(data[data.length - 1][0]), // Get year of last data point
				minRate = 1,
				maxRate = 0,
				startPeriod,
				date,
				rate,
				index;
		var Xdata=new Array();
		var ydata1=new Array();
		var ydata2=new Array();
		var copydata=new Array();

		startDate.setMonth(startDate.getMonth() - 3); // a quarter of a year before last data point
		startPeriod = Date.UTC(startDate.getFullYear(), startDate.getMonth(), startDate.getDate());
		for (index = data.length - 1; index >= 0; index = index - 1) {
				date = data[index][0]; // data[i][0] is date
				rate = data[index][1]; // data[i][1] is exchange rate
				if (date < startPeriod) {
						break; // stop measuring highs and lows
				}
				if (rate > maxRate) {
						maxRate = rate;
				}
				if (rate < minRate) {
						minRate = rate;
				}

		}

		for (var m = 0; m <=data.length - 1; m = m + 1) {
				Xdata[m]=data[m][0];
				ydata1[m]=data[m][1];
				ydata2[m]=data[m][1];

				copydata[m]=new Array(2);
				copydata[m][0]=data[m][0];
				copydata[m][1]=data[m][1]+2*Math.random();

				// copydata.push(data[m]);
		}

		// console.log(data);
		// console.log(copydata);
		// console.log(copydata.length);
		// Create the chart
		Highcharts.stockChart('showDiagram3', {
			credits: {
				enabled: false
			},
			rangeSelector: {
				selected: 5
			},
			title: {
				text: '市场情绪指数',  //基础表实现双轴（网络数据）
				style: {
							color: 'black',
							fontWeight: 'bold',
							fontSize: 20
						},
				margin: 30
			},

			yAxis:[
				{
					opposite: false,
					title: {
							// text: 'Y轴1'
					},
				},
				{
					title: {
							// text: 'Y轴2'
					},
				}
			], 
			series: [
				{
					name: ' 类别1',
					data: data,
					yAxis:1	
				},
				{
					name: ' 类别2',
					data: copydata,					
				}
			]
		});

		// SandSignika(Highcharts);
	});
}

function drawChart31(){   
	console.log("开始drawChart-31-");
	var seriesOptions = [],
	seriesCounter = 0,
	names = ['MSFT', 'GOOG'],
	// create the chart when all data is loaded
	createChart = function () {
		Highcharts.stockChart('showDiagram4', {
				credits: {
					enabled: false
				},
				rangeSelector: {
					selected: 5,
					enabled: false,
				},
				exporting: {
			        enabled: false
			    },
			    navigator: {
			        enabled: false
			    },
			    scrollbar: {
			        enabled: false
			    },
			    legend: {
			        enabled: false,
			        align: 'center',
					verticalAlign: 'bottom',
				    // layout: 'vertical',
			     //    y: 100,
			        // shadow: true,
			        // itemWidth: 80,
			        // maxHeight:10
			    },
				title: {
					text: '指定版块强势股占比',
					style: {
								color: 'black',
								fontWeight: 'bold',
								fontSize: 20
						},
					margin: 30
				},
				yAxis: [
				{
						title: {
							// text: '融资买入/可用担保价值',
						},
						lineWidth:1,
						opposite: false
				},
				{
						title: {
							// text: '沪深300',
						},
						lineWidth:1,
						// plotLines: [{
						// 		value: 250,
						// 		width: 2,
						// 		color: 'gray',
						// 		dashStyle: 'shortdash',
						// },
						// {
						// 		value: 900,
						// 		width: 2,
						// 		color: 'gray',
						// 		dashStyle: 'shortdash',
						// }
						// ],
						labels: {
								// formatter: function () {
								// 		return (this.value > 0 ? ' + ' : '') + this.value + '%';
								// }
						},
						
				}				
				],
				// plotOptions: {
				// 		series: {
				// 				compare: 'percent'
				// 		}
				// },
				tooltip: {
						pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> ({point.change}%)<br/>',
						valueDecimals: 2
				},
				series: seriesOptions
		});
	};
	$.each(names, function (i, name) {
	
			$.getJSON('https://data.jianshukeji.com/jsonp?filename=json/' + name.toLowerCase() + '-c.json&callback=?',    function (data) {
				
					seriesOptions[i] = {
							name: name,
							data: data,
							yAxis: i
					};
					seriesCounter += 1;
					if (seriesCounter === names.length) {
							createChart();
					}
				
					
			});

	});

}
function drawChart32(){   
	console.log("开始drawChart-32-");
	var seriesOptions = [],
	seriesCounter = 0,
	names = ['MSFT', 'GOOG'],
	// create the chart when all data is loaded
	createChart = function () {
		Highcharts.stockChart('showDiagram5', {
				credits: {
					enabled: false
				},
				rangeSelector: {
					selected: 5,
					enabled: false,
				},
				exporting: {
			        enabled: false
			    },
			    navigator: {
			        enabled: false
			    },
			    scrollbar: {
			        enabled: false
			    },
			    legend: {
			        enabled: false,
			        align: 'center',
					verticalAlign: 'bottom',
				    // layout: 'vertical',
			     //    y: 100,
			        // shadow: true,
			        // itemWidth: 80,
			        // maxHeight:10
			    },
				title: {
					text: '分级基金成交显示的风险偏好',
					style: {
								color: 'black',
								fontWeight: 'bold',
								fontSize: 20
						},
					margin: 30
				},
				yAxis: [
				{
						title: {
							// text: '融资买入/可用担保价值',
						},
						lineWidth:1,
						opposite: false
				},
				{
						title: {
							// text: '沪深300',
						},
						lineWidth:1,
						plotLines: [{
								value: 350,
								width: 3,
								color: 'red',
								dashStyle: 'shortdash',
						},
						{
								value: 700,
								width: 3,
								color: 'red',
								dashStyle: 'shortdash',
						}
						],
						labels: {
								// formatter: function () {
								// 		return (this.value > 0 ? ' + ' : '') + this.value + '%';
								// }
						},
						
				}				
				],
				// plotOptions: {
				// 		series: {
				// 				compare: 'percent'
				// 		}
				// },
				tooltip: {
						pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> ({point.change}%)<br/>',
						valueDecimals: 2
				},
				series: seriesOptions
		});
	};
	$.each(names, function (i, name) {
	
			$.getJSON('https://data.jianshukeji.com/jsonp?filename=json/' + name.toLowerCase() + '-c.json&callback=?',    function (data) {
				
					seriesOptions[i] = {
							name: name,
							data: data,
							yAxis: i
					};
					// As we're loading the data asynchronously, we don't know what order it will arrive. So
					// we keep a counter and create the chart when all the data is loaded.
					seriesCounter += 1;
					if (seriesCounter === names.length) {
							createChart();
					}
				
					
			});

	});

}
function drawChart33(){   
	console.log("开始drawChart-33-");
	var seriesOptions = [],
	seriesCounter = 0,
	names = ['MSFT', 'GOOG'],
	// create the chart when all data is loaded
	createChart = function () {
		Highcharts.stockChart('showDiagram6', {
				credits: {
					enabled: false
				},
				rangeSelector: {
					selected: 5,
					enabled: false,
				},
				exporting: {
			        enabled: false
			    },
			    navigator: {
			        enabled: false
			    },
			    scrollbar: {
			        enabled: false
			    },
			    legend: {
			        enabled: false,
			        align: 'center',
					verticalAlign: 'bottom',
				    // layout: 'vertical',
			     //    y: 100,
			        // shadow: true,
			        // itemWidth: 80,
			        // maxHeight:10
			    },
				title: {
					text: '指定版块的历史换手率',
					style: {
								color: 'black',
								fontWeight: 'bold',
								fontSize: 20
						},
					margin: 30
				},
				yAxis: [
				{
						title: {
							// text: '融资买入/可用担保价值',
						},
						lineWidth:1,
						opposite: false,						
						plotLines: [{
								value: 10,
								width: 2,
								color: 'red',
								dashStyle: 'shortdash',
						},
						{
								value: 20,
								width: 2,
								color: 'red',
								dashStyle: 'shortdash',
						}
						],
				},
				{
						title: {
							// text: '沪深300',
						},
						// lineWidth:1,
						labels: {
								// formatter: function () {
								// 		return (this.value > 0 ? ' + ' : '') + this.value + '%';
								// }
						},
						
				}				
				],
				// plotOptions: {
				// 		series: {
				// 				compare: 'percent'
				// 		}
				// },
				tooltip: {
						pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> ({point.change}%)<br/>',
						valueDecimals: 2
				},
				series: seriesOptions
		});
	};
	$.each(names, function (i, name) {
	
			$.getJSON('https://data.jianshukeji.com/jsonp?filename=json/' + name.toLowerCase() + '-c.json&callback=?',    function (data) {
				
					seriesOptions[i] = {
							name: name,
							data: data,
							yAxis: i
					};
					// As we're loading the data asynchronously, we don't know what order it will arrive. So
					// we keep a counter and create the chart when all the data is loaded.
					seriesCounter += 1;
					if (seriesCounter === names.length) {
							createChart();
					}
				
					
			});

	});

}

function drawChart34(){
	console.log("开始drawChart-34-");
	$.getJSON('https://data.jianshukeji.com/jsonp?filename=json/usdeur.json&callback=?', function (data) {
		var startDate = new Date(data[data.length - 1][0]), // Get year of last data point
				minRate = 1,
				maxRate = 0,
				startPeriod,
				date,
				rate,
				index;
		startDate.setMonth(startDate.getMonth() - 3); // a quarter of a year before last data point
		startPeriod = Date.UTC(startDate.getFullYear(), startDate.getMonth(), startDate.getDate());
		for (index = data.length - 1; index >= 0; index = index - 1) {
				date = data[index][0]; // data[i][0] is date
				rate = data[index][1]; // data[i][1] is exchange rate
				if (date < startPeriod) {
						break; // stop measuring highs and lows
				}
				if (rate > maxRate) {
						maxRate = rate;
				}
				if (rate < minRate) {
						minRate = rate;
				}
		}
		// Create the chart
		var mychart =Highcharts.stockChart('showDiagram7', {
			credits: {
				enabled: false
			},
			scrollbar: {
		        enabled: false
		    },
		    navigator: {
		        enabled: false
		    },
		    legend: {
		        enabled: false,
		        align: 'right',
		        // backgroundColor: '#FCFFC5',
		        // borderColor: 'black',
		        // borderWidth: 2,
		        layout: 'vertical',
		        verticalAlign: 'top',
		        x: -10,
				y: 10,
				floating: true
		        // shadow: true,
		        // itemWidth: 80,
		        // maxHeight:10
		    },
			rangeSelector: {
				enabled: false,
				selected: 1,
			},
			exporting: {
			    enabled: false
			},
			title: {
				text: '指定版块的个股估值分布',
				style: {
							color: 'black',
							fontWeight: 'bold',
							fontSize: 20
						},
				margin: 30
			},
			plotOptions: {
		        series: {
		            events: {
		                click: function (event) {
		                    let cdiv=document.getElementById('ChildDiv');
		                    if(cdiv!=null){  
						        let p = cdiv.parentNode;  
						        p.removeChild(cdiv);  
						    }  

		                    var mouseX;//记录鼠标点击位置。  
							var mouseY;//记录鼠标点击位置

		                    var ev = ev||event;   
						    if(ev.pageX || ev.pageY){   
						        mouseX = ev.pageX+'px';   
						        mouseY = ev.pageY+'px';  
						    }else{//兼容ie   
						        mouseX = ev.clientX+document.body.scrollLeft - document.body.clientLeft+'px';  
						      mouseY = ev.clientY+document.documentElement.scrollTop+'px';  
						    } 
						    var my = document.createElement("ChildDiv");   //创建一个div    
						    document.body.appendChild(my);   //添加到页面     
						    my.style.position="absolute";    //通过样式指定该div的位置方式,  
						    my.style.top= mouseY;   //通过样式指定y坐标  
						    my.style.left= mouseX;   //通过样式指定x坐标  
						    my.style.border='1px solid #FF0000'; // 设置边框  
						    my.style.width='300px';  
							my.style.height='200px';//通过样式指定宽度、高度    
							//通过样式指定背景颜色,,若是背景图片 例为my.style.backgroundImage="url(img/3.jpg)"     
							my.style.backgroundColor="#ffffcc";   //设置样式透明  
							var alpha = 80;  
							my.style.filter='alpha(opacity:'+alpha+')';//IE   
							my.style.opacity=alpha/100;//IE之外其他浏览器  
							my.id = "ChildDiv";//设置ID 

							//给div加一个点击后隐藏的函数 
							my.onclick = function(){
							   if(  (cdiv=document.getElementById('ChildDiv'))!=null){  
							        p = cdiv.parentNode;  
							        p.removeChild(cdiv);  
							    } 
							 };

							//在div中创建图表
							var chart = Highcharts.chart('ChildDiv', {
							chart: {
									type: 'column'
							},
							credits: {
								enabled: false
							},
							title: {
									text: 'PE频率'
							},
							subtitle: {
									text: '数据截止 2017-03'
							},
							xAxis: {
									type: 'category',
									labels: {
											rotation: -45  // 设置轴标签旋转角度
									}
							},
							yAxis: {
									min: 0,
									title: {
											// text: '人口 (百万)'
									}
							},
							legend: {
									enabled: false
							},
							tooltip: {
									pointFormat: 'PE频率: <b>{point.y:.1f} 百万</b>'
							},
							series: [{
									name: 'PE频率',
									data: [
											['0', 24.25],
											['15', 23.50],
											['30', 21.51],
											['45', 16.78],
											['60', 16.06],
											['75', 15.20],
											['90', 14.16],
											['105', 13.51],
											['120', 13.08],
											['135', 12.44],
											['150', 12.19],
											['165', 12.03],
											['180', 10.46],
											['195', 10.07],
											['210', 10.05],
											['225', 9.99],
											['240', 9.78],
											['255', 9.73],
											['270', 9.27],
											['290', 8.87]
									],
									dataLabels: {
											enabled: true,
											rotation: -90,
											color: '#FFFFFF',
											align: 'right',
											format: '{point.y:.1f}', // :.1f 为保留 1 位小数
											y: 10
									}
							}]
					});




		                }
		            }
		        }
		    },

		    xAxis: {				
		        title: {
		            enabled: true,
		            // text: '2本周换手率历史分位'
		        },
		        // labels: {
		        // 	formatter: function() {
		        //      	return Math.round(this.value*100) + '%';
		        //      	// return Highcharts.numberFormat(this.value.percentage,2)+ '%';
		        //  	}
		        // },
		        // startOnTick: true,
		        // endOnTick: true,
		        // showLastLabel: true
		    },
			yAxis: {
				opposite: false,
				lineWidth:1,
				title: {
					// text: '这个是Y轴'
				},
				// plotLines: [{
				// 		value: minRate,
				// 		color: 'gray',
				// 		dashStyle: 'shortdash',
				// 		width: 2,
				// 		label: {
				// 				text: '0.25'
				// 		}
				// }, {
				// 		value: maxRate,
				// 		color: 'red',
				// 		dashStyle: 'shortdash',
				// 		width: 2,
				// 		label: {
				// 				 text: '0.4'
				// 		}
				// }]
			},

			series: [{
				name: '博弈/存量资金',
				data: data,
				tooltip: {
						valueDecimals: 4
				}
			}]
		});

		// //图标转换成图片
		// var svg = mychart.getSVG()
		// 		.replace(/</g, '\n<') // make it slightly more readable
		// 		.replace(/>/g, '>');
				
		// console.log('svg---');

		// $("#showDiagram1").html(svg);

		// canvg();

		// var imgSrc = $("#showDiagram1").children("canvas")[0].toDataURL("image/png");
		// console.log(imgSrc);
		// $("#showDiagram1").html('<img src='+imgSrc+' />');

	});
}

function drawChart_A32(){
	console.log("开始drawChart-A32");
	//获取数据
	$.getJSON('../lib/dataForOne.json',function (dataYH) {
		var data=dataYH.obj;
		for (var index = 0;index <= data.length - 1;  index = index + 1) {
			var a=data[index][0]*1000;
			data[index][0]=a;
		} 

	// $.getJSON('http://localhost/weekly/IndicatorQuery?indicatorId=0001',function (dataYH) {	
	// var jsonObject =$.parseJSON(dataYH);
	// var data=jsonObject.obj;
	// console.log("图1的obj数据为：\n");
	console.log(data);


		// Create the chart
		Highcharts.setOptions({
		    global: {
		        useUTC: false
		    },
		    lang:{
				contextButtonTitle:"图表导出菜单",
				decimalPoint:".",
				downloadJPEG:"下载JPEG图片",
				downloadPDF:"下载PDF文件",
				downloadPNG:"下载PNG文件",
				downloadSVG:"下载SVG文件",
				drillUpText:"返回 {series.name}",
				loading:"加载中",
				months:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
				noData:"没有数据",
				numericSymbols: [ "千" , "兆" , "G" , "T" , "P" , "E"],
				printChart:"打印图表",
				resetZoom:"恢复缩放",
				resetZoomTitle:"恢复图表",
				shortMonths: [ "Jan" , "Feb" , "Mar" , "Apr" , "May" , "Jun" , "Jul" , "Aug" , "Sep" , "Oct" , "Nov" , "Dec"],
				thousandsSep:",",
				weekdays: ["星期一", "星期二", "星期三", "星期三", "星期四", "星期五", "星期六","星期天"]
		}

		});
		var mychart =Highcharts.stockChart('showDiagram8', {
			credits: {
				enabled: false
			},
			scrollbar: {
		        enabled: true
		    },
		    legend: {
		        enabled: true,
		        align: 'right',
		        // backgroundColor: '#FCFFC5',
		        // borderColor: 'black',
		        // borderWidth: 2,
		        color: 'gray',
		        layout: 'vertical',
		        verticalAlign: 'top',
		        x: -40,
				y: 15,
				floating: true,
				itemStyle:{
					"color": "black", 
					"cursor": "pointer", 
					"fontSize": "12px", 
					// "fontWeight": "bold"
				}
		        // shadow: true,
		        // itemWidth: 80,
		        // maxHeight:10
		    },
			rangeSelector: {
				enabled: true,
				selected: 5,
				buttonTheme: { // styles for the buttons
		  //           fill: 'none',
		  //           stroke: 'none',
		  //           'stroke-width': 0,
		  //           // r: 20,
		  //           width: 22,
    //     			// height: 20,
		            style: {
		                // color: 'gray',
		                // fontWeight: 'bold',
		                fontSize:13,
		          
		            },
		  //           states: {
		  //               hover: {
		  //               },
		  //               select: {
		  //                   fill: '#039',
		  //                   style: {
		  //                       color: 'white'
		  //                   }
		  //               }
		  //               // disabled: { ... }
		  //           }
		        },
		        inputBoxBorderColor: 'gray',
		        inputBoxWidth: 90,
		        inputBoxHeight: 18,
		        inputStyle: {
		            color: 'black',
		            // fontWeight: 'bold'
		            fontSize:13
		        },
		        labelStyle: {
		            color: 'gray',
		            fontWeight: 'bold',
		            fontSize:13
		        },
			},
			exporting: {
			    enabled: false,
			    scale: 1,
			    sourceWidth: 700,
        		sourceHeight: 500
			},
			title: {
				text: '个股估值分布的重要时点比较',
				style: {
							color: 'black',
							fontWeight: 'bold',
							fontSize: '18px'
						},
				margin: 30
			},
			plotOptions: {
		        series: {
		            events: {
		                click: function (event) {
		                    // alert(this.name + ' clicked\n' +
		                    //     'Alt: ' + event.altKey + '\n' +
		                    //     'Control: ' + event.ctrlKey + '\n' +
		                    //       'Shift: ' + event.shiftKey + '\n');
		                    console.log('zhixingle点击函数，看看土包更新');
		                    let cdiv=document.getElementById('ChildDiv');
		                    if(cdiv!=null){  
						        let p = cdiv.parentNode;  
						        p.removeChild(cdiv);  
						    }  

		                    var mouseX;//记录鼠标点击位置。  
							var mouseY;//记录鼠标点击位置

		                    var ev = ev||event;   
						    if(ev.pageX || ev.pageY){   
						        mouseX = ev.pageX+'px';   
						        mouseY = ev.pageY+'px';  
						    }else{//兼容ie   
						        mouseX = ev.clientX+document.body.scrollLeft - document.body.clientLeft+'px';  
						      mouseY = ev.clientY+document.documentElement.scrollTop+'px';  
						    } 
						    var my = document.createElement("ChildDiv");   //创建一个div    
						    document.body.appendChild(my);   //添加到页面     
						    my.style.position="absolute";    //通过样式指定该div的位置方式,  
						    my.style.top= mouseY;   //通过样式指定y坐标  
						    my.style.left= mouseX;   //通过样式指定x坐标  
						    my.style.border='1px solid #FF0000'; // 设置边框  
						    my.style.width='300px';  
							my.style.height='200px';//通过样式指定宽度、高度    
							//通过样式指定背景颜色,,若是背景图片 例为my.style.backgroundImage="url(img/3.jpg)"     
							my.style.backgroundColor="#ffffcc";   //设置样式透明  
							var alpha = 80;  
							my.style.filter='alpha(opacity:'+alpha+')';//IE   
							my.style.opacity=alpha/100;//IE之外其他浏览器  
							my.id = "ChildDiv";//设置ID 

							//给div加一个点击后隐藏的函数 
							my.onclick = function(){
							   if(  (cdiv=document.getElementById('ChildDiv'))!=null){  
							        p = cdiv.parentNode;  
							        p.removeChild(cdiv);  
							    } 
							 };

							//在div中创建图表
							var chart = Highcharts.chart('ChildDiv', {
							chart: {
									type: 'column'
							},
							credits: {
								enabled: false
							},
							title: {
									text: 'PE频率'
							},
							subtitle: {
									text: '数据截止 2017-03'
							},
							xAxis: {
									type: 'category',
									labels: {
											rotation: -45  // 设置轴标签旋转角度
									}
							},
							yAxis: {
									min: 0,
									title: {
											// text: '人口 (百万)'
									}
							},
							legend: {
									enabled: false
							},
							tooltip: {
									pointFormat: 'PE频率: <b>{point.y:.1f} 百万</b>'
							},
							series: [{
										name: 'PE频率',
										data: [
											['0', 24.25],
											['15', 23.50],
											['30', 21.51],
											['45', 16.78],
											['60', 16.06],
											['75', 15.20],
											['90', 14.16],
											['105', 13.51],
											['120', 13.08],
											['135', 12.44],
											['150', 12.19],
											['165', 12.03],
											['180', 10.46],
											['195', 10.07],
											['210', 10.05],
											['225', 9.99],
											['240', 9.78],
											['255', 9.73],
											['270', 9.27],
											['290', 8.87]
										],
										dataLabels: {
											enabled: true,
											rotation: -90,
											color: '#FFFFFF',
											align: 'right',
											format: '{point.y:.1f}', // :.1f 为保留 1 位小数
											y: 10
										}
									}]
							});
		                }
		            }
		        }
		    },
		    tooltip: {
				split: false,
				dateTimeLabelFormats: {
						millisecond: '%H:%M:%S.%L',
						second: '%H:%M:%S',
						minute: '%H:%M',
						hour: '%H:%M',
						day: '%m-%d',
						year: '%Y-%m-%d',
				},
				headerFormat: '{point.x:%Y-%m-%d}<br>'
			},
			navigator: {
				enabled: true,
				xAxis: {
					dateTimeLabelFormats: {
							millisecond: '%H:%M:%S.%L',
							second: '%H:%M:%S',
							minute: '%H:%M',
							hour: '%H:%M',
							day: '%m-%d',
							week: '%Y-%m-%d',
				            month: '%Y-%m',
				            year: '%Y'
					}
				}
			},

		    xAxis: {				
		        title: {
		            enabled: true,
		            // text: '2本周换手率历史分位'
		        },
		        type: 'datetime',
		        // tickInterval: 24*3600*1000,
				dateTimeLabelFormats: {
					millisecond: '%H:%M:%S.%L',
					second: '%H:%M:%S',
					minute: '%H:%M',
					hour: '%H:%M',
					day: '%Y-%m-%d',
		            week: '%Y-%m-%d',
		            month: '%Y-%m',
		            year: '%Y'
				},
				// crosshair: {
				// 	label: {
				// 			format: '%Y-%m-%d'
				// 	}
				// }

		        labels: {
		        	// rotation: -10
		        // 	formatter: function() {
		        //      	return Math.round(this.value*100) + '%';
		        //      	// return Highcharts.numberFormat(this.value.percentage,2)+ '%';
		        //  	}
		        },
		        // startOnTick: true,
		        // endOnTick: true,
		        // showLastLabel: true
		    },
			yAxis: {
				opposite: false,
				lineWidth:1,
				title: {
					// text: '这个是Y轴'
				},
			},
			series: [{
				name: '2018年6月1日',
				data: data,
				tooltip: {
						valueDecimals: 4
				},
				dashStyle:'Dot'
			}]
		});

	});
	$("#testExport").click(function(event){
		console.log("点击了导出图片！");
		var chart = $('#showDiagram1').highcharts();
		$('#showDiagram1').find('.svg').css("color","red");

		var curTime=getCurrentTime();
		// console.log('获取的时间是：---\n');console.log(curTime);

		chart.exportChart({
			exportFormat : 'PNG',
			filename: '博弈_存量指标'+curTime
		});

		//图标转换成图片
		// var svg = chart.getSVG()
		// 		.replace(/</g, '\n<') // make it slightly more readable
		// 		.replace(/>/g, '>');				
		// console.log('svg---');
		// $("#showDiagram1").html(svg);

	});

}

function drawChart_B11(){   
	console.log("开始drawChart-2-");
	var seriesOptions = [],
	seriesCounter = 0,
	names = ['MSFT', 'GOOG'],
	// create the chart when all data is loaded
	createChart = function () {
		Highcharts.stockChart('showDiagram9', {
				credits: {
					enabled: false
				},
				rangeSelector: {
					selected: 5,
					enabled: false,
				},
				exporting: {
			        enabled: false
			    },
			    navigator: {
			        enabled: false
			    },
			    scrollbar: {
			        enabled: false
			    },
				title: {
					text: '指定版块相对换手率的历史变化',
					style: {
								color: 'black',
								fontWeight: 'bold',
								fontSize: 20
						},
					margin: 30
				},
				yAxis: [
				{
						title: {
							// text: '融资买入/可用担保价值',
						},
						lineWidth:1,
						opposite: false
				},
				{
						title: {
							// text: '沪深300',
						},
						lineWidth:1,
						plotLines: [{
								value: 350,
								width: 2,
								color: 'gray',
								dashStyle: 'shortdash',
						},
						{
								value: 700,
								width: 2,
								color: 'gray',
								dashStyle: 'shortdash',
						}
						],
						labels: {
								// formatter: function () {
								// 		return (this.value > 0 ? ' + ' : '') + this.value + '%';
								// }
						},
						
				}				
				],
				// plotOptions: {
				// 		series: {
				// 				compare: 'percent'
				// 		}
				// },
				tooltip: {
						pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> ({point.change}%)<br/>',
						valueDecimals: 2
				},
				series: seriesOptions
		});
	};
	$.each(names, function (i, name) {
	
			$.getJSON('https://data.jianshukeji.com/jsonp?filename=json/' + name.toLowerCase() + '-c.json&callback=?',    function (data) {
				
					seriesOptions[i] = {
							name: name,
							data: data,
							yAxis: i
					};
					seriesCounter += 1;
					if (seriesCounter === names.length) {
							createChart();
					}
				
					
			});

	});

}

function drawChart_B21(){
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('showDiagram10'));
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '换手率最大的版块',
            left:'center',
            textStyle:{fontFamily: '宋体',	fontSize: 18,fontWeight: 'bolder',	color: '#000000'} 
        },
        tooltip: {},
        toolbox: {
        	show:false, left:'8%', top:'4%',itemSize:10,
        	feature:{
        		saveAsImage:{show:true},
        		dataView:{show:true},
        		restore:{show:true},
        		magicType:{type: ['line', 'bar']}
        	}
        },
        legend: {
            // data:['数量'],
            // left:'80%',
            // top:'10%',
            // textStyle:{fontSize:12}
        },
        xAxis: {
        	type: 'category',
        	data: ['乐风', '瑞纳', '腾翼C30', '悦翔', '比亚迪F3']
        },
        yAxis: { 
        	// axisLine: {show: false},
        	minInterval: 1,
        	splitLine:{ 
                show:false 
            }
        },
        grid: {  
		    left: '8%',  
		    right: '8%',  
		    bottom: '8%',  
		    containLabel: true  
		},
      //   series: [{
      //       name: '数量',
      //       type: 'bar',
      //       barWidth:'50%',
      //       data: [],
	     //    itemStyle: {
		    //     normal:{
		    //     	color:'#2914E5',
	     //         	label:{
		    //         	show:true,
		    //         	// formatter: '{b} : {c} \n ({d}%)',  position:'outer'
		    //         	textStyle:{fontFamily: '宋体',fontSize: 15} 
		    //         },
		    //         // labelLine:{show:true}
		    //     }
		    // }
      //   }]
        series: [{
        	barWidth:'50%',
	        data: [5, 4, 4, 3, 2],
	        type: 'bar',
	        itemStyle: {
                    normal:{  
                    color: function (params){
                        var colorList = ['#ff4844','#9ac3e5','#66ac52','#ffc032','#549bd3','#f47e39'];
                        return colorList[params.dataIndex];
                    }
                },
            },
	    }]
    };
    // //set searchedData into option
    // option.xAxis.data=histogramChartData1;
    // option.series[0].data=histogramChartData2;  
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);


}

function drawChart_B22(){
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('showDiagram11'));
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '换手率绝对水平最高的基准/版块',
            left:'center',
            textStyle:{fontFamily: '宋体',	fontSize: 18,fontWeight: 'bolder',	color: '#000000'} 
        },
        tooltip: {},
        toolbox: {
        	show:false, left:'8%', top:'4%',itemSize:10,
        	feature:{
        		saveAsImage:{show:true},
        		dataView:{show:true},
        		restore:{show:true},
        		magicType:{type: ['line', 'bar']}
        	}
        },
        legend: {
            // data:['数量'],
            // left:'80%',
            // top:'10%',
            // textStyle:{fontSize:12}
        },
        xAxis: {
        	type: 'category',
        	data: ['乐风', '瑞纳', '腾翼C30', '悦翔', '比亚迪F3']
        },
        yAxis: { 
        	// axisLine: {show: false},
        	minInterval: 1,
        	splitLine:{ 
                show:false 
            }
        },
        grid: {  
		    left: '8%',  
		    right: '8%',  
		    bottom: '8%',  
		    containLabel: true  
		},
      //   series: [{
      //       name: '数量',
      //       type: 'bar',
      //       barWidth:'50%',
      //       data: [],
	     //    itemStyle: {
		    //     normal:{
		    //     	color:'#2914E5',
	     //         	label:{
		    //         	show:true,
		    //         	// formatter: '{b} : {c} \n ({d}%)',  position:'outer'
		    //         	textStyle:{fontFamily: '宋体',fontSize: 15} 
		    //         },
		    //         // labelLine:{show:true}
		    //     }
		    // }
      //   }]
        series: [{
        	barWidth:'50%',
	        data: [5, 4, 4, 3, 2],
	        type: 'bar',
	        itemStyle: {
                    normal:{  
                    color: function (params){
                        var colorList = ['#ff4844','#9ac3e5','#66ac52','#ffc032','#549bd3','#f47e39'];
                        return colorList[params.dataIndex];
                    }
                },
            },
	    }]
    };
    // //set searchedData into option
    // option.xAxis.data=histogramChartData1;
    // option.series[0].data=histogramChartData2;  
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);


}

function drawChart_B23(){
	console.log("开始drawChart-B23-");

	var contentSet=['上证综指','-0.32%','0.6%','1.17','1.35','31.83%','44.17%'];
	// var contentSet=['基准指数','本周涨跌幅','上周涨跌幅','本周年化换手率','上周年化换手率','本周换手率分位','上周换手率分位'];
	var row_obj=$("<tr></tr>");
	var col_td=$("<td style='width:80px;font-Weight:bold'></td>");
	col_td.html('基准指数');row_obj.append(col_td);
	col_td=$("<td style='width:80px;font-Weight:bold'></td>");
	col_td.html('本周涨跌幅');row_obj.append(col_td);
	col_td=$("<td style='width:80px;font-Weight:bold'></td>");
	col_td.html('上周涨跌幅');row_obj.append(col_td);
	col_td=$("<td style='width:120px;font-Weight:bold'></td>");
	col_td.html('本周年化换手率');row_obj.append(col_td);
	col_td=$("<td style='width:120px;font-Weight:bold'></td>");
	col_td.html('上周年化换手率');row_obj.append(col_td);
	col_td=$("<td style='width:120px;font-Weight:bold'></td>");
	col_td.html('本周换手率分位');row_obj.append(col_td);
	col_td=$("<td style='width:120px;font-Weight:bold'></td>");
	col_td.html('上周换手率分位');row_obj.append(col_td);

	var row_obj2=$("<tr></tr>");
	for (let i = 0; i < contentSet.length; i++) {		
		col_td=$("<td align='center' bgcolor='#FFFFFF'></td>");
		col_td.html(contentSet[i]);
		row_obj2.append(col_td);
	}

	$('#showTable').append(row_obj);
	$('#showTable').append(row_obj2);



                // <table width="800" border="0" cellpadding="0" cellspacing="0" class="showTable0">  
                //     <tr>  
                //       <td height='30' class="showTable" style="font-weight:bold;"></td>  
                       
                //     </tr>          
                // </table>

}

function drawChart_B24(){
	console.log("开始drawChart-3-");
	$.getJSON('https://data.jianshukeji.com/jsonp?filename=json/usdeur.json&callback=?', function (data) {
		var startDate = new Date(data[data.length - 1][0]), // Get year of last data point
				minRate = 1,
				maxRate = 0,
				startPeriod,
				date,
				rate,
				index;
		var Xdata=new Array();
		var ydata1=new Array();
		var ydata2=new Array();
		var copydata=new Array();

		startDate.setMonth(startDate.getMonth() - 3); // a quarter of a year before last data point
		startPeriod = Date.UTC(startDate.getFullYear(), startDate.getMonth(), startDate.getDate());
		for (index = data.length - 1; index >= 0; index = index - 1) {
				date = data[index][0]; // data[i][0] is date
				rate = data[index][1]; // data[i][1] is exchange rate
				if (date < startPeriod) {
						break; // stop measuring highs and lows
				}
				if (rate > maxRate) {
						maxRate = rate;
				}
				if (rate < minRate) {
						minRate = rate;
				}

		}

		for (var m = 0; m <=data.length - 1; m = m + 1) {
				Xdata[m]=data[m][0];
				ydata1[m]=data[m][1];
				ydata2[m]=data[m][1];

				copydata[m]=new Array(2);
				copydata[m][0]=data[m][0];
				copydata[m][1]=data[m][1]+2*Math.random();

				// copydata.push(data[m]);
		}

		// console.log(data);
		// console.log(copydata);
		// console.log(copydata.length);
		// Create the chart
		Highcharts.stockChart('showDiagram13', {
			credits: {
				enabled: false
			},
			rangeSelector: {
				selected: 5
			},
			title: {
				text: '指定版块周换手率的历史变化',  //基础表实现双轴（网络数据）
				style: {
							color: 'black',
							fontWeight: 'bold',
							fontSize: 20
						},
				margin: 30
			},

			yAxis:[
				{
					opposite: false,
					title: {
							// text: 'Y轴1'
					},
				},
				{
					title: {
							// text: 'Y轴2'
					},
				}
			], 
			series: [
				{
					name: ' 类别1',
					data: data,
					yAxis:1	
				},
				{
					name: ' 类别2',
					data: copydata,					
				}
			]
		});

		// SandSignika(Highcharts);
	});
}

function drawChart_B31(){
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('showDiagram14'));
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '本周新增“速度/加速度”加强/衰竭的行业',
            left:'center',
            textStyle:{fontFamily: '宋体',	fontSize: 18,fontWeight: 'bolder',	color: '#000000'} 
        },
        tooltip: {},
        toolbox: {
        	show:false, left:'8%', top:'4%',itemSize:10,
        	feature:{
        		saveAsImage:{show:true},
        		dataView:{show:true},
        		restore:{show:true},
        		magicType:{type: ['line', 'bar']}
        	}
        },
        legend: {
            // data:['数量'],
            // left:'80%',
            // top:'10%',
            // textStyle:{fontSize:12}
        },
        xAxis: {
        	type: 'category',
        	data: ['乐风', '瑞纳', '腾翼C30', '悦翔', '比亚迪F3']
        },
        yAxis: { 
        	// axisLine: {show: false},
        	minInterval: 1,
        	splitLine:{ 
                show:false 
            }
        },
        grid: {  
		    left: '8%',  
		    right: '8%',  
		    bottom: '8%',  
		    containLabel: true  
		},
      //   series: [{
      //       name: '数量',
      //       type: 'bar',
      //       barWidth:'50%',
      //       data: [],
	     //    itemStyle: {
		    //     normal:{
		    //     	color:'#2914E5',
	     //         	label:{
		    //         	show:true,
		    //         	// formatter: '{b} : {c} \n ({d}%)',  position:'outer'
		    //         	textStyle:{fontFamily: '宋体',fontSize: 15} 
		    //         },
		    //         // labelLine:{show:true}
		    //     }
		    // }
      //   }]
        series: [{
        	barWidth:'50%',
	        data: [5, 4, 4, 3, 2],
	        type: 'bar'
	    }]
    };
    // //set searchedData into option
    // option.xAxis.data=histogramChartData1;
    // option.series[0].data=histogramChartData2;  
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);


}

//基础表实现双轴（自己造数据）
function drawChart4(){

	console.log("开始drawChart-4-");


	// $.post("DatabaseOperation.php?action=reworkRecordSearch_db",function(data){

	// 	console.log("--data-----");
	// 	console.log(data);

	// 	var row_items=$.parseJSON(data);


	// 	console.log("--row_items-----"+row_items.length);
	// 	console.log(row_items);

	// 	var timeSet=new Array();
	// 	if (row_items.length>0) {
	// 		for(var i=1;i<row_items.length;i++){

	// 					timeSet[i]=row_items[i]['CT TIME'];
	// 		}
	// 	}						
				

	console.log("--时间数组为-----");
	// 	console.log(timeSet);

	var MYdata=[[Date.UTC(2013,5,2),0.7695],[Date.UTC(2013,5,3),0.7648],[Date.UTC(2013,5,4),0.7645],[Date.UTC(2013,5,5),0.7638],[Date.UTC(2013,5,6),0.7549],[Date.UTC(2013,5,7),0.7562],[Date.UTC(2013,5,9),0.7574],[Date.UTC(2013,5,10),0.7543],[Date.UTC(2013,5,11),0.7510],[Date.UTC(2013,5,12),0.7498],[Date.UTC(2013,5,13),0.7477],[Date.UTC(2013,5,14),0.7492],[Date.UTC(2013,5,16),0.7487],[Date.UTC(2013,5,17),0.7480],[Date.UTC(2013,5,18),0.7466],[Date.UTC(2013,5,19),0.7521],[Date.UTC(2013,5,20),0.7564],[Date.UTC(2013,5,21),0.7621],[Date.UTC(2013,5,23),0.7630],[Date.UTC(2013,5,24),0.7623],[Date.UTC(2013,5,25),0.7644],[Date.UTC(2013,5,26),0.7685],[Date.UTC(2015,5,9),0.8862],[Date.UTC(2015,5,10),0.8829],[Date.UTC(2015,5,11),0.8882],[Date.UTC(2015,5,12),0.8873],[Date.UTC(2015,5,14),0.8913],[Date.UTC(2015,5,15),0.8862],[Date.UTC(2015,5,16),0.8891],[Date.UTC(2015,5,17),0.8821],[Date.UTC(2015,5,18),0.8802],[Date.UTC(2015,5,19),0.8808],[Date.UTC(2015,5,21),0.8794],[Date.UTC(2015,5,22),0.8818],[Date.UTC(2015,5,23),0.8952],[Date.UTC(2015,5,24),0.8924],[Date.UTC(2015,5,25),0.8925],[Date.UTC(2015,5,26),0.8955],[Date.UTC(2015,5,28),0.9113],[Date.UTC(2015,5,29),0.8900],[Date.UTC(2015,5,30),0.8950]];

	var MYdata2=[[Date.UTC(2013,5,2),1.7695],[Date.UTC(2013,5,3),1.7648],[Date.UTC(2013,5,4),1.7645],[Date.UTC(2013,5,5),0.7638],[Date.UTC(2013,5,6),0.7549],[Date.UTC(2013,5,7),0.7562],[Date.UTC(2013,5,9),0.7574],[Date.UTC(2013,5,10),0.7543],[Date.UTC(2013,5,11),0.7510],[Date.UTC(2013,5,12),0.7498],[Date.UTC(2013,5,13),0.7477],[Date.UTC(2013,5,14),0.7492],[Date.UTC(2013,5,16),0.7487],[Date.UTC(2013,5,17),0.7480],[Date.UTC(2013,5,18),0.7466],[Date.UTC(2013,5,19),0.7521],[Date.UTC(2013,5,20),0.7564],[Date.UTC(2013,5,21),0.7621],[Date.UTC(2013,5,23),0.7630],[Date.UTC(2013,5,24),0.7623],[Date.UTC(2013,5,25),1.7644],[Date.UTC(2013,5,26),1.7685],[Date.UTC(2015,5,9),0.8862],[Date.UTC(2015,5,10),0.8829],[Date.UTC(2015,5,11),0.8882],[Date.UTC(2015,5,12),0.8873],[Date.UTC(2015,5,14),0.8913],[Date.UTC(2015,5,15),0.8862],[Date.UTC(2015,5,16),0.8891],[Date.UTC(2015,5,17),0.8821],[Date.UTC(2015,5,18),0.8802],[Date.UTC(2015,5,19),0.8808],[Date.UTC(2015,5,21),0.8794],[Date.UTC(2015,5,22),0.8818],[Date.UTC(2015,5,23),0.8952],[Date.UTC(2015,5,24),0.8924],[Date.UTC(2015,5,25),0.8925],[Date.UTC(2015,5,26),0.8955],[Date.UTC(2015,5,28),0.9113],[Date.UTC(2015,5,29),1.8900],[Date.UTC(2015,5,30),1.8950]];

	$.get('data.json', function (data) {
		console.log("--MYdata222-----");

		// var MYdata2=data;

	// 	console.log("--MYdata-----");
	// 	console.log(MYdata);

	// $.getJSON('https://data.jianshukeji.com/jsonp?filename=json/usdeur.json&callback=?', function (data) {
		// var startDate = new Date(data[data.length - 1][0]), // Get year of last data point
		// 		minRate = 1,
		// 		maxRate = 0,
		// 		startPeriod,
		// 		date,
		// 		rate,
		// 		index;
		// console.log("--MYdata-----");
		var Xdata=new Array();
		var ydata1=new Array();
		var ydata2=new Array();
		var copydata=new Array();

		// startDate.setMonth(startDate.getMonth() - 3); // a quarter of a year before last data point
		// startPeriod = Date.UTC(startDate.getFullYear(), startDate.getMonth(), startDate.getDate());


		for (var m = 0; m <=data.length - 1; m = m + 1) {
				Xdata[m]=data[m][0];
				ydata1[m]=data[m][1];
				ydata2[m]=data[m][1];

				copydata[m]=new Array(2);
				copydata[m][0]=data[m][0];
				copydata[m][1]=data[m][1]+2*Math.random();

				// copydata.push(data[m]);
		}
		console.log("自己造数据画双轴");
		console.log(copydata[0][0]);
		console.log(copydata);
		console.log(copydata.length);
		// Create the chart
		Highcharts.stockChart('showDiagram4', {
			credits: {
				enabled: false
			},
			rangeSelector: {
				selected: 5
			},
			title: {
				text: '基础表实现双轴（自己造数据）',
				style: {
							color: 'black',
							fontWeight: 'bold',
							fontSize: 20
						},
				margin: 30
			},

			yAxis:[
				{
					opposite: false,
					title: {
							text: 'Yzhou1'
					},
				},
				{
					title: {
							text: 'Yzhou2'
					},
				}
			], 
			series: [
				{
					name: ' 类别1',
					data: MYdata2,
					yAxis:1	
				},
				{
					name: ' 类别2',
					data: MYdata,					
				}
			]
		});
	});
}
//散点图
function drawChart5(){
	console.log("开始drawChart-5-");
	var chart = Highcharts.chart('showDiagram5', {
	    chart: {
	        type: 'scatter',
	        zoomType: 'xy'
	    },
	    credits: {
					enabled: false
				},
	    title: {
	        text: '指数换手率分布图（散点图）',
	        style: {
						color: 'black',
						fontWeight: 'bold',
						fontSize: 20
					},
			margin: 30
	    },
	    // subtitle: {
	    //     text: '数据来源: Heinz  2003'
	    // },
	    xAxis: {
	        title: {
	            enabled: true,
	            text: '本周换手率历史分位'
	        },
	        labels: {
	        	formatter: function() {
	             	return Math.round(this.value*100) + '%';
	             	// return Highcharts.numberFormat(this.value.percentage,2)+ '%';
	         	}
	        },
	        startOnTick: true,
	        endOnTick: true,
	        showLastLabel: true
	    },
	    yAxis: {
	        title: {
	            text: '上周换手率历史分位'
	        },
	        labels: {
	        	formatter: function() {
	             return Math.round(this.value*100) + '%';
		        }
		    }
	    },
	    legend: {
	        layout: 'vertical',
	        align: 'left',
	        verticalAlign: 'top',
	        x: 750,
	        y: 60,
	        floating: true,
	        backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF',
	        borderWidth: 1
	    },
	    plotOptions: {
	        scatter: {
	            marker: {
	                radius: 5,
	                states: {
	                    hover: {
	                        enabled: true,
	                        lineColor: 'rgb(100,100,100)'
	                    }
	                }
	            },
	            states: {
	                hover: {
	                    marker: {
	                        enabled: false
	                    }
	                }
	            },
	            tooltip: {
	                headerFormat: '<b>{series.name}</b><br>',
	                pointFormat: '{point.x}, {point.y}'
	            }
	        }
	    },
	    series: [{
	        name: '一级行业',
	        color: 'rgba(223, 83, 83, .5)',
	        data: [[0.50, 0.20], [0.52, 0.30], [0.53, 0.18], [0.54, 0.11], [0.55, 0.13]]
	 
	    }, {
	        name: '概念板块',
	        color: 'rgba(119, 152, 191, .5)',
	        data: [[0.90, 0.20], [0.42, 0.30], [0.83, 0.18], [0.14, 0.11], [0.25, 0.13]]
	        // [[10%, 20%], [22%, 30%], [33%, 88%], [54%, 11%], [95%, 13%]]
	    },
	    {
	        name: '细分行业',
	        color: 'rgba(119, 152, 191, 110)',
	        data: [[0.90, 0.40], [0.42, 0.20], [0.83, 0.78], [0.14, 0.91], [0.25, 0.93]]
	    }]
	});
}
// 反转图
function drawChart6(){
	console.log("开始drawChart-6-");
	var chart = Highcharts.chart('showDiagram16', {
	    chart: {
	        type: 'spline',
	        inverted: true
	    },
	    credits: {
			enabled: false
		},
	    title: {
	        text: '指定行业“速度/加速度”的历史变化路径'
	    },
	    subtitle: {
	        // text: '根据标准大气模型绘制'
	    },
	    xAxis: {
	        reversed: false,
	        title: {
	            enabled: true,
	            // text: '海拔高度'
	        },
	        labels: {
	            formatter: function () {
	                return this.value;
	            }
	        },
	        maxPadding: 0.05,
	        showLastLabel: true
	    },
	    yAxis: {
	        title: {
	            // text: '温度'
	        },
	        labels: {
	            formatter: function () {
	                return this.value + '°';
	            }
	        },
	        lineWidth: 2,
	    },
	    legend: {
	        enabled: false
	    },
	    tooltip: {
	        headerFormat: '<b>速度/加速度</b><br/>',
	        pointFormat: '{point.x} : {point.y}'
	    },
	    plotOptions: {
	        spline: {
	            marker: {
	                enable: false
	            }
	        }
	    },
	    series: [{
	        name: '温度',
	        data: [[0, 15], [10, -50], [20, -56.5], [30, -46.5], [40, -22.1],[50, -2.5], [60, -27.7], [70, -55.7], [80, -76.5],[-60, -27.7], [-70, -55.7], [-20, -76.5]]
	    }]
	});

}
// 象限图 
function drawChart7(){
	console.log("开始drawChart-7-");
	var data = [[3.275154, 2.957587],    [-3.344465, 2.603513],
    [0.355083, -3.376585],    [1.852435, 3.547351],
    [-2.078973, 2.552013],    [-0.993756, -0.884433],
    [2.682252, 4.007573],
    [-3.087776, 2.878713],    [-1.565978, -1.256985],
    [2.441611, 0.444826],
    [-0.659487, 3.111284],    [-0.459601, -2.618005],
    [2.17768, 2.387793],
    [-2.920969, 2.917485],    [-0.028814, -4.168078],
    [3.625746, 2.119041],    [-3.912363, 1.325108],
    [-0.551694, -2.814223],
    [2.855808, 3.483301],    [-3.594448, 2.856651],
    [0.421993, -2.372646],    [1.650821, 3.407572],
    [-2.082902, 3.384412],    [-0.718809, -2.492514],
    [4.513623, 3.841029],
    [-4.822011, 4.607049],    [-0.656297, -1.449872],
    [1.919901, 4.439368],
    [-3.287749, 3.918836],    [-1.576936, -2.977622],
    [3.598143, 1.97597],    [-3.977329, 4.900932],
    [-1.79108, -2.184517],    [3.914654, 3.559303],
    [-1.910108, 4.166946],    [-1.226597, -3.317889],
    [1.148946, 3.345138],
    [-2.113864, 3.548172],    [0.845762, -3.589788],
    [2.629062, 3.535831],
    [-1.640717, 2.990517],
    [-1.881012, -2.485405],
    [4.606999, 3.510312],
    [-4.366462, 4.023316],
    [0.765015, -3.00127],    [3.121904, 2.173988],
    [-4.025139, 4.65231],
    [-0.559558, -3.840539],
    [4.376754, 4.863579],
    [-1.874308, 4.032237],    [-0.089337, -3.026809],
    [3.997787, 2.518662],
    [-3.082978, 2.884822],
    [0.845235, -3.454465],
    [1.327224, 3.358778],    [-2.889949, 3.596178],
    [-0.966018, -2.839827],
    [2.960769, 3.079555],    [-3.275518, 1.577068],
    [0.639276, -3.41284]];

	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('showDiagram15'));

	var clusterNumber = 6;
	// See https://github.com/ecomfe/echarts-stat
	var step = ecStat.clustering.hierarchicalKMeans(data, clusterNumber, true);
	var result;

	var option = {
	    timeline: {
	        top: 'center',
	        right: 35,
	        height: 300,
	        width: 10,
	        inverse: true,
	        playInterval: 2500,
	        symbol: 'none',
	        orient: 'vertical',
	        axisType: 'category',
	        autoPlay: true,
	        label: {
	            normal: {
	                show: false
	            }
	        },
	        data: []
	    },
	    baseOption: {
	        title: {
	            text: '速度/加速度(象限图)',
	            // subtext: 'By ecStat.hierarchicalKMeans',
	            sublink: 'https://github.com/ecomfe/echarts-stat',
	            left: 'center'
	        },
	        xAxis: {
	            type: 'value'
	        },
	        yAxis: {
	            type: 'value'
	        },
	        series: [{
	            type: 'scatter'
	        }]
	    },
	    options: []
	};

	for (var i = 0; !(result = step.next()).isEnd; i++) {

	    option.options.push(getOption(result, clusterNumber));
	    option.timeline.data.push(i + '');

	}

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);


	function getOption(result, k) {
	    var clusterAssment = result.clusterAssment;
	    var centroids = result.centroids;
	    var ptsInCluster = result.pointsInCluster;
	    var color = ['#c23531', '#2f4554', '#61a0a8', '#d48265', '#91c7ae', '#749f83', '#ca8622', '#bda29a', '#6e7074', '#546570', '#c4ccd3'];
	    var series = [];
	    for (i = 0; i < k; i++) {
	        series.push({
	            name: 'scatter' + i,
	            type: 'scatter',
	            animation: false,
	            data: ptsInCluster[i],
	            markPoint: {
	                symbolSize: 29,
	                label: {
	                    normal: {
	                        show: false
	                    },
	                    emphasis: {
	                        show: true,
	                        position: 'top',
	                        formatter: function (params) {
	                            return Math.round(params.data.coord[0] * 100) / 100 + '  ' +
	                                Math.round(params.data.coord[1] * 100) / 100 + ' ';
	                        },
	                        textStyle: {
	                            color: '#000'
	                        }
	                    }
	                },
	                itemStyle: {
	                    normal: {
	                        opacity: 0.7
	                    }
	                },
	                data: [{
	                    coord: centroids[i]
	                }]
	            }
	        });
	    }

	    return {
	        tooltip: {
	            trigger: 'axis',
	            axisPointer: {
	                type: 'cross'
	            }
	        },
	        series: series,
	        color: color
	    };
	}
}

function drawChart_B41(){
	console.log("开始drawChart-1111");
	//获取数据
	// $.get('http://172.16.6.26:9001/ds/yhapi?service=yhig.StrategicObserv&method=IndicatorQuery&p={appid:"6F8411ADF7E20006E053AC10521FB31A",indicator_id:"0001",start_date:"20180101",end_date:"20180622"}',function(res){
	// 	console.log('读取到的数据为----：\n');
	// 	console.log(res);
	// });	


	$.getJSON('https://data.jianshukeji.com/jsonp?filename=json/usdeur.json&callback=?', function (data) {
		var startDate = new Date(data[data.length - 1][0]), // Get year of last data point
				minRate = 1,
				maxRate = 0,
				startPeriod,
				date,
				rate,
				index;
		startDate.setMonth(startDate.getMonth() - 3); // a quarter of a year before last data point
		startPeriod = Date.UTC(startDate.getFullYear(), startDate.getMonth(), startDate.getDate());
		for (index = data.length - 1; index >= 0; index = index - 1) {
				date = data[index][0]; // data[i][0] is date
				rate = data[index][1]; // data[i][1] is exchange rate
				if (date < startPeriod) {
						break; // stop measuring highs and lows
				}
				if (rate > maxRate) {
						maxRate = rate;
				}
				if (rate < minRate) {
						minRate = rate;
				}
		}
		// Create the chart
		var mychart =Highcharts.stockChart('showDiagram17', {
			credits: {
				enabled: false
			},
			scrollbar: {
		        enabled: false
		    },
		    navigator: {
		        enabled: false
		    },
		    legend: {
		        enabled: false,
		        align: 'right',
		        // backgroundColor: '#FCFFC5',
		        // borderColor: 'black',
		        // borderWidth: 2,
		        layout: 'vertical',
		        verticalAlign: 'top',
		        x: -10,
				y: 10,
				floating: true
		        // shadow: true,
		        // itemWidth: 80,
		        // maxHeight:10
		    },
			rangeSelector: {
				enabled: false,
				selected: 1,
			},
			exporting: {
			    enabled: false
			},
			title: {
				text: '中期_HP滤波后的行业估值',
				style: {
							color: 'black',
							fontWeight: 'bold',
							fontSize: 20
						},
				margin: 30
			},
			plotOptions: {
		        series: {
		            events: {
		                click: function (event) {
		                    // alert(this.name + ' clicked\n' +
		                    //     'Alt: ' + event.altKey + '\n' +
		                    //     'Control: ' + event.ctrlKey + '\n' +
		                    //       'Shift: ' + event.shiftKey + '\n');
		                    console.log('zhixingle点击函数，看看土包更新');
		                    // drawChart2();
		                    let cdiv=document.getElementById('ChildDiv');
		                    if(cdiv!=null){  
						        let p = cdiv.parentNode;  
						        p.removeChild(cdiv);  
						    }  

		                    var mouseX;//记录鼠标点击位置。  
							var mouseY;//记录鼠标点击位置

		                    var ev = ev||event;   
						    if(ev.pageX || ev.pageY){   
						        mouseX = ev.pageX+'px';   
						        mouseY = ev.pageY+'px';  
						    }else{//兼容ie   
						        mouseX = ev.clientX+document.body.scrollLeft - document.body.clientLeft+'px';  
						      mouseY = ev.clientY+document.documentElement.scrollTop+'px';  
						    } 
						    var my = document.createElement("ChildDiv");   //创建一个div    
						    document.body.appendChild(my);   //添加到页面     
						    my.style.position="absolute";    //通过样式指定该div的位置方式,  
						    my.style.top= mouseY;   //通过样式指定y坐标  
						    my.style.left= mouseX;   //通过样式指定x坐标  
						    my.style.border='1px solid #FF0000'; // 设置边框  
						    my.style.width='300px';  
							my.style.height='200px';//通过样式指定宽度、高度    
							//通过样式指定背景颜色,,若是背景图片 例为my.style.backgroundImage="url(img/3.jpg)"     
							my.style.backgroundColor="#ffffcc";   //设置样式透明  
							var alpha = 80;  
							my.style.filter='alpha(opacity:'+alpha+')';//IE   
							my.style.opacity=alpha/100;//IE之外其他浏览器  
							my.id = "ChildDiv";//设置ID 

							//给div加一个点击后隐藏的函数 
							my.onclick = function(){
							   if(  (cdiv=document.getElementById('ChildDiv'))!=null){  
							        p = cdiv.parentNode;  
							        p.removeChild(cdiv);  
							    } 
							 };

							//在div中创建图表
							var chart = Highcharts.chart('ChildDiv', {
							chart: {
									type: 'column'
							},
							credits: {
								enabled: false
							},
							title: {
									text: 'PE频率'
							},
							subtitle: {
									text: '数据截止 2017-03'
							},
							xAxis: {
									type: 'category',
									labels: {
											rotation: -45  // 设置轴标签旋转角度
									}
							},
							yAxis: {
									min: 0,
									title: {
											// text: '人口 (百万)'
									}
							},
							legend: {
									enabled: false
							},
							tooltip: {
									pointFormat: 'PE频率: <b>{point.y:.1f} 百万</b>'
							},
							series: [{
									name: 'PE频率',
									data: [
											['0', 24.25],
											['15', 23.50],
											['30', 21.51],
											['45', 16.78],
											['60', 16.06],
											['75', 15.20],
											['90', 14.16],
											['105', 13.51],
											['120', 13.08],
											['135', 12.44],
											['150', 12.19],
											['165', 12.03],
											['180', 10.46],
											['195', 10.07],
											['210', 10.05],
											['225', 9.99],
											['240', 9.78],
											['255', 9.73],
											['270', 9.27],
											['290', 8.87]
									],
									dataLabels: {
											enabled: true,
											rotation: -90,
											color: '#FFFFFF',
											align: 'right',
											format: '{point.y:.1f}', // :.1f 为保留 1 位小数
											y: 10
									}
							}]
					});




		                }
		            }
		        }
		    },

		    xAxis: {				
		        title: {
		            enabled: true,
		            // text: '2本周换手率历史分位'
		        },
		        // labels: {
		        // 	formatter: function() {
		        //      	return Math.round(this.value*100) + '%';
		        //      	// return Highcharts.numberFormat(this.value.percentage,2)+ '%';
		        //  	}
		        // },
		        // startOnTick: true,
		        // endOnTick: true,
		        // showLastLabel: true
		    },
			yAxis: {
				opposite: false,
				lineWidth:1,
				title: {
					// text: '这个是Y轴'
				},
				plotLines: [{
						value: minRate,
						color: 'blue',
						dashStyle: 'shortdash',
						width: 2,
						label: {
								text: '1 X Sigma'
						}
				}, {
						value: 0.96,
						color: 'red',
						dashStyle: 'shortdash',
						width: 2,
						label: {
								 text: '3 X Sigma'
						}
				},
				{
						value: 0.82,
						color: 'blue',
						dashStyle: 'shortdash',
						width: 2,
						label: {
								text: '1 X Sigma'
						}
				}, {
						value: 0.72,
						color: 'red',
						dashStyle: 'shortdash',
						width: 2,
						label: {
								 text: '3 X Sigma'
						}
				}]
			},

			series: [{
				name: '博弈/存量资金',
				data: data,
				tooltip: {
						valueDecimals: 4
				}
			}]
		});

		// //图标转换成图片
		// var svg = mychart.getSVG()
		// 		.replace(/</g, '\n<') // make it slightly more readable
		// 		.replace(/>/g, '>');
				
		// console.log('svg---');

		// $("#showDiagram1").html(svg);

		// canvg();

		// var imgSrc = $("#showDiagram1").children("canvas")[0].toDataURL("image/png");
		// console.log(imgSrc);
		// $("#showDiagram1").html('<img src='+imgSrc+' />');

	});
}

function getCurrentTime(){
	//获取当前时间
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	if (month<10) {month='0'+month;}
	var day = date.getDate();
	if (day<10) {day='0'+day;}
	var hour = date.getHours();
	var minute = date.getMinutes();
	var second = date.getSeconds();
	var currentTime=year+month+day+hour+minute+second;
	return currentTime;
}




