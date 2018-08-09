
var EventObject = {
    addHandler:function(element,type,handler){
        if (element.addEventListener){
            element.addEventListener(type,handler,false);
        }else if (element.attachEvent){
            element.attachEvent("on"+type,handler);
        }else{
            element["on"+type] = handler;
        }
    },
    removeHandler:function(element,type,handler){
        if (element.removeEventListener){
            element.removeEventListener(type,handler,false);
        }else if (element.attachEvent){
            element.detachEvent("on"+type,handler);
        }else{
            element["on"+type] = null;
        }
    }
};


function isWeiXin() {
    var ua = window.navigator.userAgent.toLowerCase();
    if (/micromessenger/.test(ua)) {
        return true;
    } else {
        return false;
    }
}



function parseUrlSearch(){
    var para = location.search;
    if(para){
        para = para.substring(1);
        para = decodeURIComponent(para);
        var paraArr = para.split('&');
        return paraArr;
    }
    return undefined;
}

function getUrlParams(key){
    var value = '';
    var paraArr = parseUrlSearch();
    if (paraArr && paraArr.length>0){
        var arr = [];
        for(var i=0,len=paraArr.length; i<len; i++){
            if(paraArr[i].indexOf(key)>-1){
                arr = paraArr[i].split('=');
                if(arr.length>1 && arr[0]===key){
                    value = arr[1];
                }
            }
        }
        
        return value;
    }
    return value;
}

function isEmptyObj(dataObj){
     var arr = Object.keys(dataObj);    
     if (arr.length > 0){
        return false;
     }else{
        return true;
     }
}



const keys = {
	"A11":"0001",
	"A12":"0002",
	"A21":"0003",
	"A22":"0004",
	"A23":"0009",
	"A24":"0018",
	"A31":"2000",
	"A32":"1011",
	"B11":"0019",
	"B21":"1018",
	"B22":"1019",
	"B23":"1022",
	"B24":"0022",
	"B31":"1017",
	"B32":"0016",
	"B33":"1016",
	"B41":"0014"
};



var pickOption = {
			showAnim: 'slideDown',
			nextText : '>',
			prevText : '<',
			showButtonPanel: false,
			duration : 'fast',
			monthNames: ['一月','二月','三月','四月','五月','六月',
'七月','八月','九月','十月','十一月','十二月'],
			monthNamesShort: ['一','二','三','四','五','六',
			'七','八','九','十','十一','十二'],
			dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
			dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
			dayNamesMin: ['日','一','二','三','四','五','六'],
			closeText: '关闭',
			dateFormat: 'yy-mm-dd',
			// firstDay: 1,
			defaultDate:'2011-03-10',
			
			// minDate: -1,
			// maxDate: +17
}

// import * as SandSignika from '../lib/Highstock-6.1.0/code/themes/sand-signika';
var globalColorRed='red';  //#1E90FF  #FF4500
var globalColorBlue='blue';
var globalColorGray='gray';
var onlineOrLocal=false;  //false=online, true=local
if (window.location.href=='http://localhost:3000/observesystem.html'||location.pathname=='/observesystem.html') {onlineOrLocal=true;}
var globalDataURL='';
var globalClicked=false;

var GlobalLegendStyle={
    enabled: true,
    align: 'right',
    // layout: 'vertical',
    verticalAlign: 'top',
    x: -50,
	y: 5,
	floating: false,
	itemStyle:{
		"color": "black", 
		"cursor": "pointer", 
		"fontSize": "12px", 
		// "fontWeight": "bold"
	},
    // shadow: true,
    // itemWidth: 80,
    // maxHeight:20,
    margin:0,
    // padding:0
};

var GlobalPNGLegend={
    enabled: true,
    align: 'right',
    verticalAlign: 'top',
    x: -10,
	y: 35,
	floating: false,
	itemStyle:{
		"color": "black", 
		"cursor": "pointer", 
		"fontSize": "12px", 
	},
    margin:0,
};


var GlobalTitleStyle={
				// text: '博弈/存量指标',
				style: {
							color: 'black',
							fontWeight: 'bold',
							fontSize: '18px'
						},
				// margin: 30
};


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
		printChart:"打印图表",
		resetZoom:"恢复缩放",
		resetZoomTitle:"恢复图表",
		shortMonths: [ "Jan" , "Feb" , "Mar" , "Apr" , "May" , "Jun" , "Jul" , "Aug" , "Sep" , "Oct" , "Nov" , "Dec"],
		thousandsSep:",",
		weekdays: ["星期一", "星期二", "星期三", "星期三", "星期四", "星期五", "星期六","星期天"]
	}

});


$(function(){
	drawChart_A11();  //<!-- 博弈/存量指标 -->
	drawChart_A12(); //百分比图方法实现双轴</li>     <!-- 融资买入/可用担保价值 -->
	drawChart_A21(); // 基础表实现双轴</li>           <!-- 综合性情绪指标 -->
	drawChart_A22(keys.A22,'881001.WI','MA5','万得全A','MA5');  //百分比图方法实现双轴</li>     <!-- 融资买入/可用担保价值 -->
	drawChart_A23(keys.A23,'000001.SH','上证综指'); 
	drawChart_A24(keys.A24,'000001.SH','上证综指');  //换手率
	drawChart_A31(keys.A31,'000300.SH','沪深300');  //指定版块的个股估值分布
	// drawSmallDiagram('000300.SH','沪深300');

	drawChart_A32(keys.A32,'000001.SH','上证综指');
	drawChart_B11(keys.B11,'000001.SH','000016.SH','MA5','上证综指','上证50','MA5');  //指定版块的相对换手率历史变化 key,windCode1,windCode2,smooth
	drawChart_B21();   //柱状图  换手率变化最大的基准
	drawChart_B22();   //柱状图  换手率绝对水平最高的基准
	drawChart_B23();   //表格   基准/版块的周换手率
	drawChart_B24(keys.B24,'000001.SH','上证综指');   //双轴  指定板块周换手率的历史变化
	drawChart_B31();   //柱状图
	drawChart_B32();   //象限图
	drawChart_B33(keys.B33,'CI005001.WI','石油石化(中信)');  // 反转图 	
	drawChart_B41(keys.B41,'000001.SH','上证综指');

	$("#exportButton").click(function(event){

		$("#bigDiv").wordExport();
	});
	
	$('.selectDataArea .benchmark').css('backgroundColor','#d7d7d7');
	$('.selectDataArea .plate').css('backgroundColor','white');	

});

// 设置图表中的函数
$.datepicker.setDefaults({
    dateFormat: 'yy-mm-dd',
    onSelect: function () {
        this.onchange();
        this.onblur();
    },
});
// $.datepicker.setDefaults($.datepicker.regional['zh-CN']);
//基础表单轴
function drawChart_A11(){
	console.log("开始drawChart-_A11-");
	if (onlineOrLocal) {
		globalDataURL='../lib/dataForOne.json';
	}else{
		globalDataURL='weekly/IndicatorQuery?indicatorId=0001';
	}
	
	$.getJSON(globalDataURL,function (dataYH) {	
		if (onlineOrLocal) {
			var dataObj=dataYH.obj;
			for (var index = 0;index <= dataObj.length - 1;  index = index + 1) {
				var a=dataObj[index][0]*1000;
				dataObj[index][0]=a;
			} 
		}else{
			var jsonObject =$.parseJSON(dataYH);
			var dataObj=jsonObject.obj;			
		}
		console.log("图1A11的obj数据为：\n");
		console.log(dataObj);



		var mychart =Highcharts.stockChart('showDiagram1', {
			credits: {
				enabled: false
			},
			chart: {
				// marginTop: 20
			},
			scrollbar: {
		        enabled: true
		    },
		    legend:GlobalLegendStyle,

			rangeSelector: {
				enabled: true,
				selected: 3,
				buttonTheme: { 
		            style: {
		                fontSize:13,    
		            },
		        },
		        inputBoxBorderColor: 'gray',
		        inputBoxWidth: 90,
		        inputBoxHeight: 18,
		        inputStyle: {
		            color: 'black',
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
			    sourceWidth: 800,
        		sourceHeight: 500,
			},
			title: {
				style: {
							color: 'black',
							fontWeight: 'bold',
							fontSize: '18px'
						},
				margin: 30
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
				},
				series: {
					type: 'line',
					color: 'gray',
				}
			},

		    xAxis: {				
		        title: {
		            enabled: true,
		        },
		        type: 'datetime',
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
		        labels: {
		        },

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
			plotOptions:{
				line:{
					states:{
						hover:{
							lineWidthPlus:0
						}
					}
				}
			},

			series: [{
				name: '博弈/存量资金',
				data: dataObj,
				lineWidth:2,
				color:globalColorBlue
			}]
		},function (chart) {

			setTimeout(function () {
				$('input.highcharts-range-selector', $(chart.container).parent())
					.datepicker(pickOption);
			}, 0);
    	});

	});

	

	$("#testExport").click(function(event){
		var chart = $('#showDiagram1').highcharts();

		var curTime=getCurrentTime(1);

		chart.title.update({ text: '博弈/存量指标'});
		chart.legend.update({
		    enabled: true,
		    align: 'right',
		    verticalAlign: 'top',
		    x: -10,
			y: 35,
			floating: false,
			itemStyle:{
				"color": "black", 
				"cursor": "pointer", 
				"fontSize": "12px", 
			},
		    margin:0
		});

		var svg = chart.getSVG()
				.replace(/</g, '\n<') 
				.replace(/>/g, '>');				
		
		var pngName='博弈_存量指标'+curTime;
		svgToPng(svg,800,500,pngName);

		chart.title.update({ text: ''});
		chart.legend.update({
		    enabled: true,
		    align: 'right',
		    verticalAlign: 'top',
		    x: -50,
			y: 5,
			floating: false,
			itemStyle:{
				"color": "black", 
				"cursor": "pointer", 
				"fontSize": "12px", 
			},
		    margin:0
		});

	});
}

// 百分比图方法实现双轴
function drawChart_A12(){   
	console.log("开始drawChart-_A12-");
	if (onlineOrLocal) {
		globalDataURL='../lib/data2.json';
	}else{
		globalDataURL='weekly/IndicatorQuery?indicatorId=0002';
	}
	
	$.getJSON(globalDataURL,function (dataYH) {	
		if (onlineOrLocal) {
			var dataObj=dataYH.obj; 
		}else{
			var jsonObject =$.parseJSON(dataYH);
			var dataObj=jsonObject.obj;			
		}

		console.log("图2A12的obj数据为：\n"+dataObj);
	

		var myChart=Highcharts.stockChart('showDiagram2', {
			credits: {
				enabled: false
			},
			
			navigator: {
		        enabled: true,
		        series: {
					type: 'line',
					color: 'gray',
				}
		    },
		    exporting: {
			    enabled: false,
			    scale: 1,
			    sourceWidth: 800,
        		sourceHeight: 600

			},

			rangeSelector: {
				enabled: true,
				selected: 3,
				// margin:50,
				buttonTheme: { 
		            style: {
		                fontSize:13,
		          
		            },
		        },
		        inputBoxBorderColor: 'gray',
		        inputBoxWidth: 80,
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
			// legend:GlobalLegendStyle,
		    legend: {
		        enabled: true,
			    align: 'right',
			    verticalAlign: 'top',
			    x: -80,
				y: 20,
				floating: false,
				itemStyle:{
					"color": "black", 
					"cursor": "pointer", 
					"fontSize": "12px", 
				},
			    margin:0,
		    },

			title:GlobalTitleStyle,
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

					
			}				
			],
			plotOptions:{
				line:{
					states:{
						hover:{
							lineWidthPlus:0
						}
					}
				}
			},
			tooltip: {
					pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b>',
					valueDecimals: 3
			},
			series: [
				{
					name: '融资买入/可用担保价值',
					data: dataObj.data,
					yAxis:0,
					lineWidth:2,
					color:globalColorBlue
				},
				{
					name: '沪深300(右轴)',
					data: dataObj.index_data,	
					yAxis:1,
					lineWidth:2,
					color:globalColorRed		
				}
			]
		},function (chart) {
			setTimeout(function () {
				$('input.highcharts-range-selector', $(chart.container).parent())
					.datepicker(pickOption);
			}, 0);
    	});
	});



}
$('#diagramDiv2').find('.spanExportButton').click(function(event){
	console.log("点击了导出图片A12--！");

	var chart = $('#showDiagram2').highcharts();
	var curTime=getCurrentTime(1);
	
	chart.title.update({ text: '融资买入/可用担保价值'});
	chart.legend.update({
        enabled: true,
	    align: 'right',
	    verticalAlign: 'top',
	    x: -10,
		y: 35,
		floating: false,
		itemStyle:{
			"color": "black", 
			"cursor": "pointer", 
			"fontSize": "12px", 
		},
	    margin:0,
    });

	
	var svg = chart.getSVG();
	// .replace(/</g, '\n<').replace(/>/g, '>'); 							
	var pngName='融资买入/可用担保价值'+curTime;
	svgToPng(svg,800,600,pngName);
	
	chart.title.update({ text: ''});
	chart.legend.update({
        enabled: true,
	    align: 'right',
	    verticalAlign: 'top',
	    x: -80,
		y: 20,
		floating: false,
		itemStyle:{
			"color": "black", 
			"cursor": "pointer", 
			"fontSize": "12px", 
		},
	    margin:0,
    });

});

//基础表实现双轴
function drawChart_A21(){
	console.log("开始drawChart-_A21-");
	if (onlineOrLocal) {
		globalDataURL='../lib/data3.json';
	}else{
		globalDataURL='weekly/IndicatorQuery?indicatorId=0003';
	}
	
	$.getJSON(globalDataURL,function (dataYH) {	
		if (onlineOrLocal) {
			var dataObj=dataYH.obj; 
		}else{
			var jsonObject =$.parseJSON(dataYH);
			var dataObj=jsonObject.obj;			
		}
		console.log("图3A21的obj数据为：\n");
		console.log(dataObj);




		
		Highcharts.stockChart('showDiagram3', {
			credits: {
				enabled: false
			},
			rangeSelector: {
				selected: 3,
				labelStyle: {
		            color: 'gray',
		            fontWeight: 'bold',
		            fontSize:13
		        },
			},
			exporting: {
			    enabled: false,
			    scale: 1,
			    sourceWidth: 800,
        		sourceHeight: 600
			},
			navigator: {
		        enabled: true,
		        series: {
					type: 'line',
					color: 'gray',
				}
		    },

			title:GlobalTitleStyle,
			legend: {
		        enabled: true,
			    align: 'right',
			    verticalAlign: 'top',
			    x: -80,
				y: 20,
				floating: false,
				itemStyle:{
					"color": "black", 
					"cursor": "pointer", 
					"fontSize": "12px", 
				},
			    margin:0,
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
			plotOptions:{
				line:{
					states:{
						hover:{
							lineWidthPlus:0
						}
					}
				}
			},
			series: [
				{
					name: '市场情绪指数',
					data: dataObj.data,
					yAxis:0,
					lineWidth:2,
					color:globalColorBlue
				},
				{
					name: '沪指300(右轴)',
					data: dataObj.index_data,	
					yAxis:1,
					lineWidth:2,
					color:globalColorRed			
				}
			]
		},function (chart) {
			setTimeout(function () {
				$('input.highcharts-range-selector', $(chart.container).parent())
					.datepicker(pickOption);
			}, 0);
    	});


	});


}

$('#diagramDiv3').find('.spanExportButton').click(function(event){
	console.log("点击了导出图片A21！");
	var chart = $('#showDiagram3').highcharts();
	var curTime=getCurrentTime(1);
	chart.title.update({ text: '综合性情绪指标'});
	chart.legend.update(GlobalPNGLegend);

	var svg = chart.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 								
	var pngName='综合性情绪指标'+curTime;
	svgToPng(svg,800,600,pngName);

	chart.title.update({ text: ''});
	chart.legend.update({
        enabled: true,
	    align: 'right',
	    verticalAlign: 'top',
	    x: -80,
		y: 20,
		floating: false,
		itemStyle:{
			"color": "black", 
			"cursor": "pointer", 
			"fontSize": "12px", 
		},
	    margin:0,
    });
});
function drawChart_A22(key,windCode,smooth,windCodeText,smoothText){   
	console.log("开始drawChart-_A22");
	if (onlineOrLocal) {
		globalDataURL='../lib/data4A22.json';
	}else{
		globalDataURL='weekly/IndicatorQuery?indicatorId='+key+'&windCode='+windCode+'&smooth='+smooth;
	}
	
	$.getJSON(globalDataURL,function (dataYH) {	
		if (onlineOrLocal) {
			var dataObj=dataYH.obj; 
		}else{
			var jsonObject =$.parseJSON(dataYH);
			var dataObj=jsonObject.obj;			
		}



		
		Highcharts.stockChart('showDiagram4', {
			credits: {
				enabled: false
			},
			rangeSelector: {
				selected: 3,
				labelStyle: {
		            color: 'gray',
		            fontWeight: 'bold',
		            fontSize:13
		        },
			},
			navigator: {
		        enabled: true,
		        series: {
					type: 'line',
					color: 'gray',
				}
		    },
		    exporting: {
			    enabled: false,
			    scale: 1,
			    sourceWidth: 800,
        		sourceHeight: 600
			},

			title:GlobalTitleStyle,
			legend: {
		        enabled: true,
			    align: 'right',
			    verticalAlign: 'top',
			    x: -80,
				y: 20,
				floating: false,
				itemStyle:{
					"color": "black", 
					"cursor": "pointer", 
					"fontSize": "12px", 
				},
			    margin:0,
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
			plotOptions:{
				line:{
					states:{
						hover:{
							lineWidthPlus:0
						}
					}
				}
			}, 
			series: [
				{	
					name: windCodeText+smoothText+'强势股占比',
					data: dataObj.data,
					yAxis:0,
					lineWidth:2,
					color:globalColorBlue
				},
				{
					name: '沪深300(右轴)',
					data: dataObj.index_data,	
					yAxis:1,
					lineWidth:2,
					color:globalColorRed		
				}
			]
		},function (chart) {
			setTimeout(function () {
				$('input.highcharts-range-selector', $(chart.container).parent())
					.datepicker(pickOption);
			}, 0);
    	});

	});

}
$('#diagramDiv4').find('.spanExportButton').click(function(event){
	console.log("点击了导出图片A22！");
	var chart = $('#showDiagram4').highcharts();
	var curTime=getCurrentTime(1);
	
	chart.title.update({ text: '指定板块的强势股占比'});
	chart.legend.update(GlobalPNGLegend);
	
	var svg = chart.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 							
	var pngName='指定板块的强势股占比'+curTime;
	svgToPng(svg,800,600,pngName);
	
	chart.title.update({ text: ''});
	chart.legend.update({
        enabled: true,
	    align: 'right',
	    verticalAlign: 'top',
	    x: -80,
		y: 20,
		floating: false,
		itemStyle:{
			"color": "black", 
			"cursor": "pointer", 
			"fontSize": "12px", 
		},
	    margin:0,
    });
});
function drawChart_A23(key,selectedVal,selectedText){  
	console.log("开始drawChart-_5A23");
	if (onlineOrLocal) {
		globalDataURL='../lib/data5A23.json';
	}else{
		globalDataURL='weekly/IndicatorQuery?indicatorId='+key+'&windCode='+selectedVal;
	}
	
	$.getJSON(globalDataURL,function (dataYH) {	
		if (onlineOrLocal) {
			var dataObj=dataYH.obj; 
		}else{
			var jsonObject =$.parseJSON(dataYH);
			var dataObj=jsonObject.obj;			
		}
		console.log("图5A23的obj数据为：\n");
		console.log(dataObj);


	// 
	// $.getJSON('../lib/data5A23.json',function (dataYH) {
	// 	var dataObj=dataYH.obj;
	// 	console.log("obj--5A23-\n");console.log(dataObj);
	// 	console.log("dataObj.data--5A23-\n");console.log(dataObj.data);
	// 	console.log("dataObj.index_data--5A23-\n");console.log(dataObj.index_data);

	// $.getJSON('weekly/IndicatorQuery?indicatorId=0009&smooth=MA5',function (dataYH) {	
	// 	var jsonObject =$.parseJSON(dataYH);
	// 	var dataObj=jsonObject.obj;
	// 	console.log("图1的obj数据为：\n");
	// 	console.log(dataObj);


		
		Highcharts.stockChart('showDiagram5', {
			credits: {
				enabled: false
			},
			exporting: {
			    enabled: false,
			    scale: 1,
			    sourceWidth: 800,
        		sourceHeight: 600
			},
			rangeSelector: {
				selected: 3,
				labelStyle: {
		            color: 'gray',
		            fontWeight: 'bold',
		            fontSize:13
		        },
			},
			navigator: {
		        enabled: true,
		        series: {
					type: 'line',
					color: 'gray',
				}
		    },
			// title: {
			// 	text: '分级基金成交显示的风险偏好',  //基础表实现双轴（网络数据）
			// 	style: {
			// 				color: 'black',
			// 				fontWeight: 'bold',
			// 				fontSize: 20
			// 			},
			// 	margin: 30
			// },
			title:GlobalTitleStyle,
			legend: {
		        enabled: true,
			    align: 'right',
			    verticalAlign: 'top',
			    x: -100,
				y: 20,
				floating: false,
				itemStyle:{
					"color": "black", 
					"cursor": "pointer", 
					"fontSize": "12px", 
				},
			    margin:0,
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
			plotOptions:{
				line:{
					states:{
						hover:{
							lineWidthPlus:0
						}
					}
				}
			}, 
			series: [
				{
					name: '成交额：分级B/A',
					data: dataObj.data,
					yAxis:0,
					lineWidth:2,
					color:globalColorBlue
				},
				{
					name: '成交额：分级B/A(MA10)',
					data: dataObj.data_MA10,	
					yAxis:0,
					lineWidth:2,
					color:globalColorRed			
				},
				{
					name: selectedText+'(右轴)',
					data: dataObj.index_data,	
					yAxis:1,
					lineWidth:2,
					color:globalColorGray		
				}

			]
		},function (chart) {
			setTimeout(function () {
				$('input.highcharts-range-selector', $(chart.container).parent())
					.datepicker(pickOption);
			}, 0);
    	});

		// SandSignika(Highcharts);
	});
	


}
$('#diagramDiv5').find('.spanExportButton').click(function(event){
	console.log("点击了导出图片A23！");
	var chart = $('#showDiagram5').highcharts();
	var curTime=getCurrentTime(1);
	
	chart.title.update({ text: '分级基金成交显示的风险偏好'});
	chart.legend.update({
        enabled: true,
	    align: 'right',
	    verticalAlign: 'top',
	    x: -40,
		y: 30,
		floating: false,
		itemStyle:{
			"color": "black", 
			"cursor": "pointer", 
			"fontSize": "12px", 
		},
	    margin:0,
	});
	
	var svg = chart.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 							
	var pngName='分级基金成交显示的风险偏好'+curTime;
	svgToPng(svg,800,600,pngName);
	
	chart.title.update({ text: ''});
	chart.legend.update({
        enabled: true,
	    align: 'right',
	    verticalAlign: 'top',
	    x: -100,
		y: 20,
		floating: false,
		itemStyle:{
			"color": "black", 
			"cursor": "pointer", 
			"fontSize": "12px", 
		},
	    margin:0,
	});
});
function drawChart_A24(key,selectedVal,selectedText){   
	console.log("开始drawChart-_A24-");
	if (onlineOrLocal) {
		globalDataURL='../lib/data6A24.json';
	}else{
		globalDataURL='weekly/IndicatorQuery?indicatorId='+key+'&windCode='+selectedVal+'&smooth=MA5';
	}
	
	$.getJSON(globalDataURL,function (dataYH) {	
		if (onlineOrLocal) {
			var dataObj=dataYH.obj; 
		}else{
			var jsonObject =$.parseJSON(dataYH);
			var dataObj=jsonObject.obj;			
		}
		console.log("图6A24的obj数据为：\n");
		console.log(dataObj);


		
		Highcharts.stockChart('showDiagram6', {
			credits: {
				enabled: false
			},
			rangeSelector: {
				selected: 3,
				labelStyle: {
		            color: 'gray',
		            fontWeight: 'bold',
		            fontSize:13
		        },
			},
			navigator: {
		        enabled: true,
		        series: {
					type: 'line',
					color: 'gray',
				}
		    },
		    exporting: {
			    enabled: false,
			    scale: 1,
			    sourceWidth: 800,
        		sourceHeight: 600
			},
			// title: {
			// 	text: '指定版块的历史换手率',  //基础表实现双轴（网络数据）
			// 	style: {
			// 				color: 'black',
			// 				fontWeight: 'bold',
			// 				fontSize: 20
			// 			},
			// 	margin: 30
			// },
			title:GlobalTitleStyle,
			legend: {
		        enabled: true,
			    align: 'right',
			    verticalAlign: 'top',
			    x: -55,
				y: 20,
				floating: false,
				itemStyle:{
					"color": "black", 
					"cursor": "pointer", 
					"fontSize": "12px", 
				},
			    margin:0,
		    },
			yAxis:[
				{
					opposite: false,
					lineWidth:1,
					title: {
							// text: 'Y轴1'
					},
				},
				// {
				// 	title: {
				// 			// text: 'Y轴2'
				// 	},
				// }
			], 
			plotOptions:{
				line:{
					states:{
						hover:{
							lineWidthPlus:0
						}
					}
				}
			},
			series: [
				{
					name: selectedText+'年化换手率',
					data: dataObj.data,
					// yAxis:0,
					lineWidth:2,
					color:globalColorBlue
				},
				{
					name: selectedText+'年化换手率（MA20）',
					data: dataObj.data_MA20,	
					// yAxis:1,
					lineWidth:2,
					color:globalColorRed			
				}
			]
		},function (chart) {
			setTimeout(function () {
				$('input.highcharts-range-selector', $(chart.container).parent())
					.datepicker(pickOption);
			}, 0);
    	});

		// SandSignika(Highcharts);
	});

	
}

$('#diagramDiv6').find('.spanExportButton').click(function(event){
	console.log("点击了导出图片A24！");
	var chart = $('#showDiagram6').highcharts();
	var curTime=getCurrentTime(1);
	
	chart.title.update({ text: '指定板块的历史换手率'});
	chart.legend.update(GlobalPNGLegend);
	
	var svg = chart.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 							
	var pngName='指定板块的历史换手率'+curTime;
	svgToPng(svg,800,600,pngName);
	
	chart.title.update({ text: ''});
	chart.legend.update({
        enabled: true,
	    align: 'right',
	    verticalAlign: 'top',
	    x: -55,
		y: 20,
		floating: false,
		itemStyle:{
			"color": "black", 
			"cursor": "pointer", 
			"fontSize": "12px", 
		},
	    margin:0,
    });
});

function drawChart_A31(key,selectedVal,selectedText){
	// 第一次获取selectItem为null，因为还没请求到值。设置默认值
	
	console.log("开始drawChart-_A31-");
	if (onlineOrLocal) {
		globalDataURL='../lib/data7A31大图.json';
	}else{
		globalDataURL='weekly/IndicatorQuery?indicatorId='+key+'&windCode='+selectedVal;
	}
	
	$.getJSON(globalDataURL,function (dataYH) {	
		if (onlineOrLocal) {
			var dataObj=dataYH.obj;

		}else{
			var jsonObject =$.parseJSON(dataYH);
			var dataObj=jsonObject.obj;			
		}
		console.log("图7A31的obj数据为：\n");
		console.log(dataObj);

		var lastDateSecond=dataObj[dataObj.length-1][0];
		console.log("图7A31的obj最后一个数据为：\n");
		console.log(lastDateSecond);
		var date0=new Date(lastDateSecond);
		var year = date0.getFullYear();
		var month = date0.getMonth()+1;
		if (month<10) {month='0'+month;}
		var day = date0.getDate();
		if (day<10) {day='0'+day;}
        var lastDate=year+month+day;
        console.log(lastDate);

        drawSmallDiagram(selectedVal,selectedText,lastDate);


		
		var mychart =Highcharts.stockChart('showDiagram7', {
			credits: {
				enabled: false
			},
		    legend: {
		        enabled: true,
			    align: 'right',
			    verticalAlign: 'top',
			    x: -50,
				y: 20,
				floating: false,
				itemStyle:{
					"color": "black", 
					"cursor": "pointer", 
					"fontSize": "12px", 
				},
			    margin:0,
		    },
			rangeSelector: {
				selected: 3,
				labelStyle: {
		            color: 'gray',
		            fontWeight: 'bold',
		            fontSize:13
		        },
			},
			navigator: {
		        enabled: true,
		        series: {
					type: 'line',
					color: 'gray',
				}
		    },
			exporting: {
			    enabled: false,
			    scale: 1,
			    sourceWidth: 800,
        		sourceHeight: 600
			},
			title:GlobalTitleStyle,
			plotOptions: {
		        series: {
		            events: {
		                click: function (event) {
		                    console.log('zhixingle点击函数--');		                    
		                    //获取点击数据的时间
		                    var date = new Date(event.point.x);
							var year = date.getFullYear();
							var month = date.getMonth()+1;
							if (month<10) {month='0'+month;}
							var day = date.getDate();
							if (day<10) {day='0'+day;}
		                    var dateYMD=year+month+day;
		                    console.log(dateYMD+'----'+event.point.y);
		                    //传递点击数据，获取小图数据
							$.ajax({
								method: "GET",
								url: '/weekly/IndicatorQuery?indicatorId=0011&windCode='+selectedVal+'&startDate='+dateYMD+'&endDate='+dateYMD,							
							})
							.done(function( msg ) {
								console.log( "小图返回的Data " + msg );
								if (onlineOrLocal) {
									globalDataURL='../lib/data7A31小图.json';
									
									$.getJSON(globalDataURL,function (dataYH) {	
										var dataObj=dataYH.obj;
										console.log("图7A31小图的obj数据为：\n");
										console.log(dataObj);

										//var finalResult=calculateQuantity(dataObj);
										
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
									    }else{   
									        mouseX = ev.clientX+document.body.scrollLeft - document.body.clientLeft+'px';  
									      mouseY = ev.clientY+document.documentElement.scrollTop+'px';  
									    } 
									    var my = document.createElement("ChildDiv");    
									    document.body.appendChild(my);        
									    my.style.position="absolute";      
									    my.style.top= mouseY;     
									    my.style.left= mouseX;     
									    my.style.border='1px solid #FF0000';   
									    my.style.width='400px';  
										my.style.height='200px';     
										my.style.backgroundColor="#ffffcc";     
										var alpha = 80;  
										my.style.filter='alpha(opacity:'+alpha+')';  
										my.style.opacity=alpha/100;  
										my.id = "ChildDiv";//设置ID 
										my.style.zIndex=1000;

										 
										my.onclick = function(){
										   if(  (cdiv=document.getElementById('ChildDiv'))!=null){  
										       var p = cdiv.parentNode;  
										        p.removeChild(cdiv);  
										    } 
										 };

										//在div中创建图表
										var chart = Highcharts.chart('ChildDiv', {
											/*chart: {
													type: 'column'
											},
											credits: {
												enabled: false
											},
											title: {
													text: selectedText +' '+dateYMD+' '+'PE分布'
											},
											exporting:{
												enabled: false
											},
											xAxis: {
												type: 'category',
												labels: {
													rotation: -45,  
													style:{
	 
														"fontSize": "10px", 
													},
												}
											},
											yAxis: {
													min: 0,
													
											},
											legend: {
													enabled: false
											},
											tooltip: {
													pointFormat: 'PE频率: <b>{point.y:.1f}</b>'
											},
											series: [{
												name: 'PE频率',
												data: finalResult,
												dataLabels: {
													enabled: true,
													rotation: -90,
													color: '#FFFFFF',
													align: 'right',
													format: '{point.y:.1f}', // :.1f 为保留 1 位小数
													y: 10
												}
											}]*/
											chart: {
												type: 'column'
											},
											credits: {
												enabled: false
											},
											plotOptions: {
										        column: {
										            pointPlacement: 'between'
										        }
										    },
											xAxis: {
										        tickmarkPlacement: 'on',
										        labels: {
										            align: 'left',
										            rotation: 0
										        },
										        gridLineWidth: 0.5,
										        tickInterval: dataObj.data_interval
										    },
										    title: {
												text: selectedText +' '+dateYMD+' '+'PE分布',
											},
											exporting:{
												enabled: false
											},
										    legend: {
												enabled: false
											},
											tooltip: {
												pointFormat: 'PE频率: <b>{point.y}</b>'
											},
										    series: [{
										        name: 'PE频率',
										        data: dataObj.data,
										        pointStart: dataObj.data_start,
										        pointInterval: dataObj.data_interval,
										        type: 'column'
										    }]
										});
										globalClicked=true;

									});
								}
								else{   

									var jsonObject =$.parseJSON(msg);
									var dataObj=jsonObject.obj;	
									//var finalResult=calculateQuantity(dataObj);
									
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
								    }else{   
								        mouseX = ev.clientX+document.body.scrollLeft - document.body.clientLeft+'px';  
								      mouseY = ev.clientY+document.documentElement.scrollTop+'px';  
								    } 
								    var my = document.createElement("ChildDiv");   
								    document.body.appendChild(my);        
								    my.style.position="absolute";      
								    my.style.top= mouseY;     
								    my.style.left= mouseX;     
								    my.style.border='1px solid #FF0000';   
								    my.style.width='400px';  
									my.style.height='200px';    
									my.style.backgroundColor="#ffffcc";    
									var alpha = 90;  
									my.style.filter='alpha(opacity:'+alpha+')';  
									my.style.opacity=alpha/100;  
									my.id = "ChildDiv";//设置ID 
									my.style.zIndex=1000;

									 
									my.onclick = function(){
									   if(  (cdiv=document.getElementById('ChildDiv'))!=null){  
									        p = cdiv.parentNode;  
									        p.removeChild(cdiv);  
									    } 
									 };

									//在div中创建图表
									var chart = Highcharts.chart('ChildDiv', {
										/*chart: {
												type: 'column'
										},
										credits: {
											enabled: false
										},
										title: {
												text: selectedText +' '+dateYMD+' '+'PE分布'
										},
										exporting:{
											enabled: false
										},
										xAxis: {
											type: 'category',
											labels: {
												rotation: -45,  // 设置轴标签旋转角度
												style:{
													"fontSize": "10px", 
												},
											}
										},
										yAxis: {
												min: 0,
											
										},
										legend: {
												enabled: false
										},
										tooltip: {
												pointFormat: 'PE频率: <b>{point.y:.1f}</b>'
										},
										series: [{
											name: 'PE频率',
											data: finalResult,
											dataLabels: {
												enabled: true,
												rotation: -90,
												color: '#FFFFFF',
												align: 'right',
												format: '{point.y:.1f}', // :.1f 为保留 1 位小数
												y: 10
											}
										}]*/
										chart: {
											type: 'column'
										},
										credits: {
											enabled: false
										},
										plotOptions: {
									        column: {
									            pointPlacement: 'between'
									        }
									    },
										xAxis: {
									        tickmarkPlacement: 'on',
									        labels: {
									            align: 'left',
									            rotation: 0
									        },
									        gridLineWidth: 0.5,
									        tickInterval: dataObj.data_interval
									    },
									    title: {
											text: selectedText +' '+dateYMD+' '+'PE分布',
										},
										exporting:{
											enabled: false
										},
									    legend: {
											enabled: false
										},
										tooltip: {
											pointFormat: 'PE频率: <b>{point.y}</b>'
										},
									    series: [{
									        name: 'PE频率',
									        data: dataObj.data,
									        pointStart: dataObj.data_start,
									        pointInterval: dataObj.data_interval,
									        type: 'column'
									    }]
									});
									globalClicked=true;
								}
							})
							.fail(function( jqXHR, textStatus ) {
								console.log( "Request failed: " + textStatus );

								if (onlineOrLocal) {
									globalDataURL='../lib/data7A31小图.json';
									
									$.getJSON(globalDataURL,function (dataYH) {	
										var dataObj=dataYH.obj;
										console.log("图7A31小图的obj数据为：\n");
										console.log(dataObj);

										//var finalResult=calculateQuantity(dataObj);
										
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
									    }else{   
									        mouseX = ev.clientX+document.body.scrollLeft - document.body.clientLeft+'px';  
									      mouseY = ev.clientY+document.documentElement.scrollTop+'px';  
									    } 
									    var my = document.createElement("ChildDiv");   //创建一个div    
									    document.body.appendChild(my);   //添加到页面     
									    my.style.position="absolute";      
									    my.style.top= mouseY;     
									    my.style.left= mouseX;     
									    my.style.border='1px solid #FF0000';  
									    my.style.width='400px';  
										my.style.height='200px';     
										my.style.backgroundColor="#ffffcc";     
										var alpha = 95;  
										my.style.filter='alpha(opacity:'+alpha+')';   
										my.style.opacity=alpha/100;  
										my.id = "ChildDiv";
										my.style.zIndex=1000; 

										 

										//在div中创建图表
										var chart = Highcharts.chart('ChildDiv', {
											/*chart: {
													type: 'column'
											},
											credits: {
												enabled: false
											},
											title: {
													text: selectedText +' '+dateYMD+' '+'PE分布'
											},
											exporting:{
												enabled: false
											},
											xAxis: {
												type: 'category',
												labels: {
													rotation: -45,  // 设置轴标签旋转角度
													style:{
														"fontSize": 5, 
													},
												}
											},
											yAxis: {
													min: 0,											
											},
											legend: {
													enabled: false
											},
											tooltip: {
													pointFormat: 'PE频率: <b>{point.y}</b>'
											},
											series: [{
												name: 'PE频率',
												data: finalResult,
												dataLabels: {
													enabled: true,
													rotation: -90,
													color: '#FFFFFF',
													align: 'right',
													
													y: 10
												}
											}]*/
											chart: {
												type: 'column'
											},
											credits: {
												enabled: false
											},
											plotOptions: {
										        column: {
										            pointPlacement: 'between'
										        }
										    },
											xAxis: {
										        tickmarkPlacement: 'on',
										        labels: {
										            align: 'left',
										            rotation: 0
										        },
										        gridLineWidth: 0.5,
										        tickInterval: dataObj.data_interval
										    },
										    title: {
												text: selectedText +' '+dateYMD+' '+'PE分布',
											},
											exporting:{
												enabled: false
											},
										    legend: {
												enabled: false
											},
											tooltip: {
												pointFormat: 'PE频率: <b>{point.y}</b>'
											},
										    series: [{
										        name: 'PE频率',
										        data: dataObj.data,
										        pointStart: dataObj.data_start,
										        pointInterval: dataObj.data_interval,
										        type: 'column'
										    }]
										});
										globalClicked=true;

									});
								}
							});


		                    
		            	},
			            mouseOut: function (event) {
			            	 if(globalClicked) {
			            	 	globalClicked=false;	}
			            	 else{
			            	 	// console.log("---鼠标移除22");
			            	 	var cdiv=document.getElementById('ChildDiv');
			            	 	if(cdiv!=null){  
							        var p = cdiv.parentNode;  
							        p.removeChild(cdiv);  
							    }
			            	}		            	
			            }
		                
		            }
		        },
		        line:{
					states:{
						hover:{
							lineWidthPlus:0
						}
					}
				}
		    },
		    xAxis: {				
		        title: {
		            enabled: true,
		            // text: '2本周换手率历史分位'
		        },
		        
		    },
			yAxis: {
				opposite: false,
				lineWidth:1,
				title: {
					// text: '这个是Y轴'
				},
			},
			series: [{
				name: selectedText+'的个股收盘价',
				data: dataObj,
				lineWidth:2,
				color:globalColorBlue
			}]
		},function (chart) {
			setTimeout(function () {
				$('input.highcharts-range-selector', $(chart.container).parent())
					.datepicker(pickOption);
			}, 0);
    	});

	});
}

$('#diagramDiv7').find('.spanExportButton').unbind('click').click(function(event){
	console.log("点击了导出图片A31！");
	var chartBig = $('#showDiagram7').highcharts();
	var chartSmall = $('#showDiagram7Small').highcharts();
	var curTime=getCurrentTime(1);
	var pngName='指定板块的个股估值分布'+curTime;
	
	chartBig.title.update({ text: '指定板块的个股估值分布'});
	chartBig.legend.update(GlobalPNGLegend);
	
	var svgBig = chartBig.getSVG().replace(/</g, '\n<').replace(/>/g, '>');
	var svgSmall = chartSmall.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 
	var imageBig = new Image();
	imageBig.crossOrigin = 'anonymous';
	imageBig.src = 'data:image/svg+xml;base64,' + window.btoa(unescape(encodeURIComponent(svgBig)));
	var imageSmall= new Image();
	imageSmall.crossOrigin = 'anonymous';
	imageSmall.src = 'data:image/svg+xml;base64,' + window.btoa(unescape(encodeURIComponent(svgSmall))); 

	var canvas = document.createElement('canvas');  
	canvas.width = 800;  
    canvas.height = 800;    
			 
	var context = canvas.getContext('2d'); 
	context.fillStyle = "#fff";   
	context.fillRect(0, 0, canvas.width, canvas.height);

	imageBig.onload=function(){
		context.drawImage(imageBig, 0, 0);				
	};
	imageSmall.onload=function(){
		context.drawImage(imageSmall, 0, 600);
		var a = document.createElement("a"); 
			a.href = canvas.toDataURL('image/png');
			a.download = pngName+".png"; 
			a.click(); 
			a = null;				
	};
	
	chartBig.title.update({ text: ''});
	chartBig.legend.update({
        enabled: true,
	    align: 'right',
	    verticalAlign: 'top',
	    x: -50,
		y: 20,
		floating: false,
		itemStyle:{
			"color": "black", 
			"cursor": "pointer", 
			"fontSize": "12px", 
		},
	    margin:0,
    });
});
// 点线
function drawChart_A32(key,selectedVal,selectedText){

	console.log("开始drawChart-A32");
	// 获取选择的参数
	var selectItem=$('#diagramDiv8').find('.selected-index').val();
	console.log("当前选择的item是："+selectItem);
	var dateLastDay=getCurrentTime(3);	
	console.log("前一个自然日时间是："+dateLastDay);


	if (onlineOrLocal) {
		globalDataURL='../lib/data8A32.json';
	}else{		
		globalDataURL='weekly/IndicatorQuery?indicatorId='+key+'&windCode='+selectedVal+'&startDate='+dateLastDay+'&endDate='+dateLastDay;
	}
	
	$.getJSON(globalDataURL,function (dataYH) {	
		if (onlineOrLocal) {
			var dataObj=dataYH.obj; 
		}else{
			var jsonObject =$.parseJSON(dataYH);
			var dataObj=jsonObject.obj;			
		}
		console.log("图8A32的obj数据为：\n");
		console.log(dataObj);
		var dataObjBefore=dataObj.data_before;
		var dataObjFirst=dataObj.data_first;
		var dataObjSecond=dataObj.data_second;

		/*var dataOrderBefore=calculateQuantity(dataObjBefore);
		var dataOrderFirst=calculateQuantity(dataObjFirst);
		var dataOrderSecond=calculateQuantity(dataObjSecond);
		 */
		
		var mychart = Highcharts.chart('showDiagram8', {
			chart: {
				type: 'spline'
			},
			credits: {
				enabled: false
			},
		    legend: {
		        enabled: true,
			    align: 'right',
			    verticalAlign: 'top',
			    x: -50,
				y: 10,
				floating: false,
				itemStyle:{
					"color": "black", 
					"cursor": "pointer", 
					"fontSize": "12px", 
				},
			    margin:20,
		    },
			exporting: {
			    enabled: false,
			    scale: 1,
			    sourceWidth: 800,
        		sourceHeight: 600
			},
			title: {
				text: '',//个股估值分布的重要时点比较
			},
	
		    /*tooltip: {
				headerFormat: '',
				pointFormat: '<b>{series.name}</b><br>{point.x}, {point.y}',
			},*/
		    xAxis: {				
		        title: {
		            enabled: true,
		            // text: '2本周换手率历史分位'
		        },
		        type: 'category',
		    	categories: dataObj.data_X
		    },
			yAxis: {
				opposite: false,
				lineWidth:1,
				title: {
					// text: '这个是Y轴'
				},
			},
			plotOptions:{
				/*line:{
					states:{
						hover:{
							lineWidthPlus:0
						}
					}
				},*/
				series: {
					allowPointSelect: false
				}
			},
			series: [{
				name: selectedText + dataObj.data_before_date,
				data: dataObjBefore,
				//dashStyle:'line',
				color:'blue'
			},
			{
				name: selectedText+'20150616',
				data: dataObjFirst,
				//dashStyle:'line',
				color:'red'
			},
			{
				name: selectedText+'20160612',
				data: dataObjSecond,
				dashStyle:'Dot'
			}]
			
			
		});

	});
	

}

$('#diagramDiv8').find('.spanExportButton').click(function(event){
		console.log("点击了导出图片A32！");
		var chart = $('#showDiagram8').highcharts();
		var curTime=getCurrentTime(1);
		
		chart.title.update({ text: '个股估值分布的重要时点比较'});
		chart.legend.update(GlobalPNGLegend);
		
		var svg = chart.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 							
		var pngName='个股估值分布的重要时点比较'+curTime;
		svgToPng(svg,800,600,pngName);
		
		chart.title.update({ text: ''});
		chart.legend.update({
	        enabled: true,
		    align: 'right',
		    verticalAlign: 'top',
		    x: -50,
			y: 10,
			floating: false,
			itemStyle:{
				"color": "black", 
				"cursor": "pointer", 
				"fontSize": "12px", 
			},
		    margin:20,
	    });
	});
//双轴双线 
function drawChart_B11(key,windCode1,windCode2,smooth,windCode1Text,windCode2Text,smoothText){  
	console.log("开始drawChart-_B11-");
	if (onlineOrLocal) {
		globalDataURL='../lib/data9B11.json';
	}else{
		globalDataURL='weekly/IndicatorQuery?indicatorId='+key+'&windCode='+windCode1+','+windCode2+'&smooth='+smooth;
	}
	
	$.getJSON(globalDataURL,function (dataYH) {	
		if (onlineOrLocal) {
			var dataObj=dataYH.obj; 
		}else{
			var jsonObject =$.parseJSON(dataYH);
			var dataObj=jsonObject.obj;			
		}
		console.log("图9B11的obj数据为：\n");
		console.log(dataObj);
	
	
		var myChart=Highcharts.stockChart('showDiagram9', {
			credits: {
				enabled: false
			},
			rangeSelector: {
				selected: 3,
				labelStyle: {
		            color: 'gray',
		            fontWeight: 'bold',
		            fontSize:13
		        },
			},
			exporting: {
			    enabled: false,
			    scale: 1,
			    sourceWidth: 800,
        		sourceHeight: 600
			},
		    navigator: {
		        enabled: true,
		        series: {
					type: 'line',
					color: 'gray',
				}
		    },
		    
		    legend: {
		        enabled: true,
			    align: 'right',
			    verticalAlign: 'top',
			    x: -70,
				y: 20,
				floating: false,
				itemStyle:{
					"color": "black", 
					"cursor": "pointer", 
					"fontSize": "12px", 
				},
			    margin:0,
		    },


		    title:GlobalTitleStyle,
			
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
					
					labels: {
							
					},
					
			}				
			],
			
			plotOptions:{
				line:{
					states:{
						hover:{
							lineWidthPlus:0
						}
					}
				}
			},
			tooltip: {
					pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b>',
					valueDecimals: 3
			},
			series: [
				{
					name: '换手率：'+windCode1Text+'/'+windCode2Text+'('+smoothText+')',//'换手率：上证50/中证500(MA20)',
					data: dataObj.data,
					yAxis:0,
					lineWidth:2,
					color:globalColorBlue
				},
				{
					name: windCode1Text+'/'+windCode2Text+'(右轴)',//'上证50/中证500(右轴)',
					data: dataObj.index_data,	
					yAxis:1,
					lineWidth:2,
					color:globalColorRed			
				}
			]
		},function (chart) {
			setTimeout(function () {
				$('input.highcharts-range-selector', $(chart.container).parent())
					.datepicker(pickOption);
			}, 0);
    	});
	});

}
$('#diagramDiv9').find('.spanExportButton').click(function(event){
	console.log("点击了导出图片B11！");
	var chart = $('#showDiagram9').highcharts();
	var curTime=getCurrentTime(1);
	
	chart.title.update({ text: '指定板块相对换手率的历史变化'});
	chart.legend.update(GlobalPNGLegend);
	
	var svg = chart.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 							
	var pngName='指定板块相对换手率的历史变化'+curTime;
	svgToPng(svg,800,600,pngName);
	
	chart.title.update({ text: ''});
	chart.legend.update({
        enabled: true,
	    align: 'right',
	    verticalAlign: 'top',
	    x: -70,
		y: 20,
		floating: false,
		itemStyle:{
			"color": "black", 
			"cursor": "pointer", 
			"fontSize": "12px", 
		},
	    margin:0,
    });
});
//柱状图
function drawChart_B21(){

	if (onlineOrLocal) {
		globalDataURL='../lib/data10B21.json';
	}else{
		globalDataURL='weekly/IndicatorQuery?indicatorId=1018';
	}
	
	$.getJSON(globalDataURL,function (dataYH) {	
		if (onlineOrLocal) {
			var dataObj=dataYH.obj;
		}else{
			var jsonObject =$.parseJSON(dataYH);
			var dataObj=jsonObject.obj;
		}

		let xAxisDataLeft = dataObj.data_base[0];
		let xAxisDataRight = dataObj.data_index[0];

		let seriesData = {'left':dataObj.data_base[1],'right':dataObj.data_index[1]};
		drawHistogram(showDiagramLeft10,'基准'+dataObj.date,xAxisDataLeft,seriesData.left);
		drawHistogram(showDiagramRight10,'板块'+dataObj.date,xAxisDataRight,seriesData.right);

		$('#rightButton').click(function(event){
			console.log("点击了导出图片B21两个图！");
			var chartLeft = $('#showDiagramLeft10').highcharts();
			var chartRight = $('#showDiagramRight10').highcharts();
			var curTime=getCurrentTime(1);
			var pngName='本周换手率变化最大的基准/板块'+curTime;

			chartLeft.title.update({ text: '本周换手率变化最大的基准'+dataObj.date});
			chartLeft.exporting.update({ enabled: false,scale: 1,sourceWidth: 500,sourceHeight: 450});			
			var svgLeft = chartLeft.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 
			
			
			chartRight.title.update({ text: '本周换手率变化最大的板块'+dataObj.date});
			chartRight.exporting.update({ enabled: false,scale: 1,sourceWidth: 500,sourceHeight: 450});			
			var svgRight = chartRight.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 
			var imageLeft = new Image();
			imageLeft.crossOrigin = 'anonymous';
			imageLeft.src = 'data:image/svg+xml;base64,' + window.btoa(unescape(encodeURIComponent(svgLeft)));
			var imageRight = new Image();
			imageRight.crossOrigin = 'anonymous';
			imageRight.src = 'data:image/svg+xml;base64,' + window.btoa(unescape(encodeURIComponent(svgRight))); 
			var canvas = document.createElement('canvas');  
			canvas.width = 1000;  
		    canvas.height = 450; 			 
			var context = canvas.getContext('2d');  
			imageLeft.onload=function(){
				context.drawImage(imageLeft, 0, 0);				
			};
			imageRight.onload=function(){
				context.drawImage(imageRight, 500, 0);
				var a = document.createElement("a"); 
					a.href = canvas.toDataURL('image/png');
					a.download = pngName+".png"; 
					a.click(); 
					a = null;				
			};
			chartLeft.title.update({ text: '基准'+dataObj.date});
			chartRight.title.update({ text: '板块'+dataObj.date});
		});

	});



    
}
//柱状图
function drawChart_B22(){

	if (onlineOrLocal) {
		globalDataURL='../lib/data11B22.json';
	}else{
		globalDataURL='weekly/IndicatorQuery?indicatorId=1019';
	}
	
	$.getJSON(globalDataURL,function (dataYH) {	
		if (onlineOrLocal) {
			var dataObj=dataYH.obj;
		}else{
			var jsonObject =$.parseJSON(dataYH);
			var dataObj=jsonObject.obj;
		}
		console.log("图11B22的obj数据为：\n");
		console.log(dataObj);


		// 基于准备好的dom，初始化echarts实例
	    let myChartLeft = echarts.init(document.getElementById('showDiagramLeft11'));
		let myChartRight = echarts.init(document.getElementById('showDiagramRight11'));
	
		let xAxisDataLeft = dataObj.data_base[0];
		let xAxisDataRight = dataObj.data_index[0];

		let seriesData = {'left':dataObj.data_base[1],'right':dataObj.data_index[1]};
		drawHistogram(showDiagramLeft11,'基准'+dataObj.date,xAxisDataLeft,seriesData.left);
		drawHistogram(showDiagramRight11,'板块'+dataObj.date,xAxisDataRight,seriesData.right);

		// $('#leftButton11').click(function(event){
		// 	console.log("点击了导出图片B12左图！");
		// 	var chart = $('#showDiagramLeft11').highcharts();
		// 	var curTime=getCurrentTime(1);
			
		// 	chart.title.update({ text: '本周换手率绝对水平最高的基准'+dataObj.date});
		// 	chart.exporting.update({ enabled: false,scale: 1,sourceWidth: 500,sourceHeight: 450});
			
		// 	var svg = chart.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 
		// 	var pngName='本周换手率绝对水平最高的基准'+curTime;
		// 	svgToPng(svg,500,450,pngName);
		// 	chart.title.update({ text: '基准'+dataObj.date});
		// });

		// $('#rightButton11').click(function(event){
		// 	console.log("点击了导出图片B12右图！");
		// 	var chart = $('#showDiagramRight11').highcharts();
		// 	var curTime=getCurrentTime(1);
			
		// 	chart.title.update({ text: '本周换手率绝对水平最高的板块'+dataObj.date});
		// 	chart.exporting.update({ enabled: false,scale: 1,sourceWidth: 500,sourceHeight: 450});
			
		// 	var svg = chart.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 
		// 	var pngName='本周换手率绝对水平最高的板块'+curTime;
		// 	svgToPng(svg,500,450,pngName);
		// 	chart.title.update({ text: '板块'+dataObj.date});
		// });

		$('#rightButton11').click(function(event){
			console.log("点击了导出图片B22两个图！");
			var chartLeft = $('#showDiagramLeft11').highcharts();
			var chartRight = $('#showDiagramRight11').highcharts();
			var curTime=getCurrentTime(1);
			var pngName='本周换手率绝对水平最高的基准/板块'+curTime;

			chartLeft.title.update({ text: '本周换手率绝对水平最高的基准'+dataObj.date});
			chartLeft.exporting.update({ enabled: false,scale: 1,sourceWidth: 500,sourceHeight: 450});			
			var svgLeft = chartLeft.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 
			
			
			chartRight.title.update({ text: '本周换手率绝对水平最高的板块'+dataObj.date});
			chartRight.exporting.update({ enabled: false,scale: 1,sourceWidth: 500,sourceHeight: 450});			
			var svgRight = chartRight.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 
			var imageLeft = new Image();
			imageLeft.crossOrigin = 'anonymous';
			imageLeft.src = 'data:image/svg+xml;base64,' + window.btoa(unescape(encodeURIComponent(svgLeft)));
			var imageRight = new Image();
			imageRight.crossOrigin = 'anonymous';
			imageRight.src = 'data:image/svg+xml;base64,' + window.btoa(unescape(encodeURIComponent(svgRight))); 
			var canvas = document.createElement('canvas');  
			canvas.width = 1000;  
		    canvas.height = 450; 			 
			var context = canvas.getContext('2d');  
			imageLeft.onload=function(){
				context.drawImage(imageLeft, 0, 0);				
			};
			imageRight.onload=function(){
				context.drawImage(imageRight, 500, 0);
				var a = document.createElement("a"); 
					a.href = canvas.toDataURL('image/png');
					a.download = pngName+".png"; 
					a.click(); 
					a = null;				
			};
			chartLeft.title.update({ text: '基准'+dataObj.date});
			chartRight.title.update({ text: '板块'+dataObj.date});
		});

		
	});

}

// var isBenchmark = true;
// $('.selectDataArea .benchmark').click(function(){	
// 	isBenchmark = true;
// 	drawChart_B23();
// });
// $('.selectDataArea .plate').click(function(){	
// 	isBenchmark = false;
// 	drawChart_B23();
// });
function getB23Table(dataBase){
		$('#showTable').empty();
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

		$('#showTable').append(row_obj);
		for (let m = 0; m < dataBase.length; m++) {
			var row_obj2=$("<tr></tr>");
			for (let i = 0; i < dataBase[m].length; i++) {		
				col_td=$("<td align='center' bgcolor='#FFFFFF'></td>");
				col_td.html(dataBase[m][i]);
				row_obj2.append(col_td);				
			}
			$('#showTable').append(row_obj2);
		}
}
var dataObjForB23 = {};
//表格
function drawChart_B23(){
	console.log("开始drawChart-B23-");
	if (onlineOrLocal) {
		globalDataURL='../lib/data12B23.json';
	}else{
		globalDataURL='weekly/IndicatorQuery?indicatorId=1022';
	}
	var dataObj= undefined;
	var dataBase = undefined;
	$.getJSON(globalDataURL,function (dataYH) {	
		
		
		if (onlineOrLocal) {
			var dataObj=dataYH.obj;
			// if(isBenchmark){
				 dataBase = dataObj.data_base; 
			// }else{
			// 	 dataBase = dataObj.data_index;
			// }
			dataObjForB23 = dataObj;
		}else{
			var jsonObject =$.parseJSON(dataYH);
			var dataObj=jsonObject.obj;	
			dataBase = dataObj.data_base; 
			dataObjForB23 = dataObj;
		}
		console.log("图12B23的obj数据为：\n"+dataObj);
		getB23Table(dataBase);
	});

}

$('.selectDataArea .benchmark').click(function(){
	var dataBase = dataObjForB23.data_base;
	getB23Table(dataBase);	
	//设置样式
	this.style.backgroundColor='#d7d7d7';
	$('.selectDataArea .plate').css('backgroundColor','white');

});
$('.selectDataArea .plate').click(function(){	
	var dataIndex = dataObjForB23.data_index;
	getB23Table(dataIndex);
	//设置样式
	this.style.backgroundColor='#d7d7d7';
	$('.selectDataArea .benchmark').css('backgroundColor','white');
});

//双轴双线
function drawChart_B24(key,selectedVal,selectedText){

	console.log("开始drawChart-_B24-");
	if (onlineOrLocal) {
		globalDataURL='../lib/data2.json';
	}else{
		globalDataURL='weekly/IndicatorQuery?indicatorId='+key+'&windCode='+selectedVal;
	}
	
	$.getJSON(globalDataURL,function (dataYH) {	
		if (onlineOrLocal) {
			var dataObj=dataYH.obj; 
		}else{
			var jsonObject =$.parseJSON(dataYH);
			var dataObj=jsonObject.obj;			
		}
		console.log("图13B24的obj数据为：\n");
		console.log(dataObj);
	
	
		var myChart=Highcharts.stockChart('showDiagram13', {
			credits: {
				enabled: false
			},
			rangeSelector: {
				selected: 3,
				labelStyle: {
		            color: 'gray',
		            fontWeight: 'bold',
		            fontSize:13
		        },
			},
			exporting: {
			    enabled: false,
			    scale: 1,
			    sourceWidth: 800,
        		sourceHeight: 600
			},
		    navigator: {
		        enabled: true,
		        series: {
					type: 'line',
					color: 'gray',
				}
		    },

		    legend: {
		        enabled: true,
			    align: 'right',
			    verticalAlign: 'top',
			    x: -80,
				y: 20,
				floating: false,
				itemStyle:{
					"color": "black", 
					"cursor": "pointer", 
					"fontSize": "12px", 
				},
			    margin:0,
		    },


		    title:GlobalTitleStyle,

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
		
					},
					
			}				
			],

			plotOptions:{
				line:{
					states:{
						hover:{
							lineWidthPlus:0
						}
					}
				}
			},
			tooltip: {
					pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b>',
					valueDecimals: 3
			},
			series: [
				{
					name: selectedText+'换手率分位（MA5）',
					data: dataObj.data,
					yAxis:0,
					lineWidth:2,
					color:globalColorBlue
				},
				{
					name: selectedText+'收盘价(右轴)',
					data: dataObj.index_data,	
					yAxis:1,
					lineWidth:2,
					color:globalColorRed			
				}
			]
		},function (chart) {
			setTimeout(function () {
				$('input.highcharts-range-selector', $(chart.container).parent())
					.datepicker(pickOption);
			}, 0);
    	});
	});

}
$('#diagramDiv13').find('.spanExportButton').click(function(event){
	console.log("点击了导出图片B24！");
	var chart = $('#showDiagram13').highcharts();
	var curTime=getCurrentTime(1);
	
	chart.title.update({ text: '指定板块周换手率的历史变化'});
	chart.legend.update(GlobalPNGLegend);
	
	var svg = chart.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 							
	var pngName='指定板块周换手率的历史变化'+curTime;
	svgToPng(svg,800,600,pngName);
	
	chart.title.update({ text: ''});
	chart.legend.update({
        enabled: true,
	    align: 'right',
	    verticalAlign: 'top',
	    x: -80,
		y: 20,
		floating: false,
		itemStyle:{
			"color": "black", 
			"cursor": "pointer", 
			"fontSize": "12px", 
		},
	    margin:0,
    });
});
//柱状图
function drawChart_B31(){
	if (onlineOrLocal) {
		globalDataURL='../lib/data14B31.json';
	}else{
		globalDataURL='weekly/IndicatorQuery?indicatorId=1017';
	}
	
	$.getJSON(globalDataURL,function (dataYH) {	
		if (onlineOrLocal) {
			var dataObj=dataYH.obj;
		}else{
			var jsonObject =$.parseJSON(dataYH);
			var dataObj=jsonObject.obj;
		}
		console.log("图14B31的obj数据为：\n");
		console.log(dataObj);


		// 基于准备好的dom，初始化echarts实例
	    let myChartLeft = echarts.init(document.getElementById('showDiagramLeft14'));
		let myChartRight = echarts.init(document.getElementById('showDiagramRight14'));
		let xAxisDataLeft = dataObj.data_decay[0];
		let xAxisDataRight = dataObj.data_grow[0];

		let seriesData = {'left':dataObj.data_decay[1],'right':dataObj.data_grow[1]};
		drawHistogram(showDiagramLeft14,'加强'+dataObj.date,xAxisDataLeft,seriesData.left);
		drawHistogram(showDiagramRight14,'衰竭'+dataObj.date,xAxisDataRight,seriesData.right);

		$('#rightButton14').click(function(event){
			console.log("点击了导出图片B31两个图！");
			var chartLeft = $('#showDiagramLeft14').highcharts();
			var chartRight = $('#showDiagramRight14').highcharts();
			var curTime=getCurrentTime(1);
			var pngName='本周新增“速度/加速度”加强与衰竭的行业'+curTime;

			chartLeft.title.update({ text: '本周新增“速度/加速度”加强的行业'+dataObj.date});
			chartLeft.exporting.update({ enabled: false,scale: 1,sourceWidth: 500,sourceHeight: 450});			
			var svgLeft = chartLeft.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 
			
			
			chartRight.title.update({ text: '本周新增“速度/加速度”衰竭的行业'+dataObj.date});
			chartRight.exporting.update({ enabled: false,scale: 1,sourceWidth: 500,sourceHeight: 450});			
			var svgRight = chartRight.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 
			var imageLeft = new Image();
			imageLeft.crossOrigin = 'anonymous';
			imageLeft.src = 'data:image/svg+xml;base64,' + window.btoa(unescape(encodeURIComponent(svgLeft)));
			var imageRight = new Image();
			imageRight.crossOrigin = 'anonymous';
			imageRight.src = 'data:image/svg+xml;base64,' + window.btoa(unescape(encodeURIComponent(svgRight))); 
			var canvas = document.createElement('canvas');  
			canvas.width = 1000;  
		    canvas.height = 450; 			 
			var context = canvas.getContext('2d');  
			imageLeft.onload=function(){
				context.drawImage(imageLeft, 0, 0);				
			};
			imageRight.onload=function(){
				context.drawImage(imageRight, 500, 0);
				var a = document.createElement("a"); 
					a.href = canvas.toDataURL('image/png');
					a.download = pngName+".png"; 
					a.click(); 
					a = null;				
			};
			chartLeft.title.update({ text: '加强'+dataObj.date});
			chartRight.title.update({ text: '衰竭'+dataObj.date});
		});


		
	});
}

// 象限图 
function drawChart_B32(){
	console.log("开始drawChart-B32-");
	if (onlineOrLocal) {
		globalDataURL='../lib/data15B32.json';
	}else{
		var lastDay = getCurrentTime(3);
		globalDataURL='weekly/IndicatorQuery?indicatorId=0016&startDate='+lastDay+'&endDate='+lastDay;
	}
	
	$.getJSON(globalDataURL,function (dataYH) {	
		if (onlineOrLocal) {
			var dataObj=dataYH.obj;
			var dataSet=dataObj.data; 
		}else{
			var jsonObject =$.parseJSON(dataYH);
			var dataObj=jsonObject.obj;
			var dataSet=dataObj.data;			
		}
		console.log("图d15B32的obj数据为：\n");
		console.log(dataObj);
	

		//dataSet数组转化为json对象
		var dataJsonArray=[];
		// console.log("转化前dataJson为：\n");console.log(dataJsonArray);
		for (let i = 0; i < dataSet.length; i++) {
			let tempJson={name: dataSet[i][0],x: dataSet[i][1], y: dataSet[i][2]};
			dataJsonArray.push(tempJson);
		}
		// console.log("转化后后后dataJson为：\n");console.log(dataJsonArray);

		var data1 = [["点1",5, 11],["点2",6, 22]];
		var data2 = [[5, 11,"点11"],[6, 22,"jj"]];
		var data3 =[{ x: 2, y: 3, name: 'BE' ,renyi:"12131"},{ x: 4, y: 6, name: 'Bddd' ,renyi:"333"}];

	 var chart = Highcharts.chart('showDiagram15', {
		chart: {
				type: 'scatter',
				zoomType: 'xy'
		},
		credits: {
			enabled: false
		},
		title: {
			text: ''//所有行业的速度/加速度最新分布
		},
		exporting: {
		    enabled: false,
		    scale: 1,
		    sourceWidth: 800,
    		sourceHeight: 600
		},
		// title:GlobalTitleStyle,
		xAxis: {
			lineWidth:1,
			gridLineWidth:1,
			tickLength:0,
			title: {
					enabled: false,
					// text: '身高 (cm)'
			},
			startOnTick: true,
			endOnTick: true,
			showLastLabel: true,
			plotLines: [{
					zIndex: 99,
					value: 1,
					color: 'red',
					dashStyle: 'solid',
					width: 1,
					// label: {
					// 		text: '0.25'
					// }
			}]
		},
		yAxis: {
			lineWidth:1,
			gridLineWidth:1,
			// lineColor:'red',
			title: {
				enabled: false,
			// 		// text: '体重 (kg)'
			},
			plotLines: [{
				zIndex: 99,
				value: 1,
				color: 'red',
				dashStyle: 'solid',
				width: 1,
			}]
		},
		legend: {

			enabled: true,
		    align: 'right',
		    verticalAlign: 'top',
		    x: -60,
			y: 0,
			floating: false,
			itemStyle:{
				"color": "black", 
				"cursor": "pointer", 
				"fontSize": "12px", 
			},
		    margin:10,
		},
		tooltip: {
			style: {
				// color: "red",  //在这里设置颜色才顶用
			}
		},
		plotOptions: {
			scatter: {
				marker: {
					symbol: 'circle',
					fillColor:'blue',
					radius: 5,
					states: {
						hover: {
							enabled: true,
							lineColor: 'red'
						}
					}
				},
				tooltip: {
					headerFormat: '',
					pointFormat: '<b>{point.name}</b><br>{point.x}, {point.y}',				
				},
				dataLabels: {
	                enabled: true,
	                format: '{point.name}',
	                style: {
						// color: "red",  
						fontWeight: 'normal'
					},
					zIndex: -10,   //设置文本在点标下方
	            }
			}
		},
		series: [{
			name: '速度/加速度' + dataObj.data_date,
			// color: 'rgba(223, 83, 83, .5)',
			data: dataJsonArray,
			zIndex: 1000,
		}]
	}, function(chart){

		});

    });	

	
}
$('#diagramDiv15').find('.spanExportButton').click(function(event){
	console.log("点击了导出图片B32！");
	var chart = $('#showDiagram15').highcharts();
	var curTime=getCurrentTime(1);
	
	chart.title.update({ text: '所有行业“速度/加速度”的最新分布'});
	chart.legend.update({
		// enabled: false,
		enabled: true,
	    align: 'right',
	    verticalAlign: 'top',
	    x: -60,
		y: 0,
		floating: false,
		itemStyle:{
			"color": "black", 
			"cursor": "pointer", 
			"fontSize": "12px", 
		},
	    margin:10,
	});
	
	var svg = chart.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 							
	var pngName='所有行业“速度/加速度”的最新分布'+curTime;
	svgToPng(svg,800,600,pngName);
	
	chart.title.update({ text: ''});
	chart.legend.update({
		// enabled: false,
		enabled: true,
	    align: 'right',
	    verticalAlign: 'top',
	    x: -60,
		y: 0,
		floating: false,
		itemStyle:{
			"color": "black", 
			"cursor": "pointer", 
			"fontSize": "12px", 
		},
	    margin:10,
    });
});


(function(H) {

    H.wrap(H.Series.prototype, 'drawGraph', function(proceed) {

    var thisChart=this.chart;
	var curID=$(thisChart.container).parent().attr("id");


    proceed.apply(this, Array.prototype.slice.call(arguments, 1));

	
	if (curID==='showDiagram16') {

      var arrowLength = 20,
        arrowWidth = 10,
        series = this,
        data = series.data,
        len = data.length,
        segments = data,
        lastSeg = segments[segments.length - 1],
        path = [];

        // console.log(this);
        // console.log(lastSeg);

	    var lastPoint = null;
	    var nextLastPoint = null;

      if (lastSeg) {
      if (lastSeg.y === 0) {
        lastPoint = segments[segments.length - 2];
        nextLastPoint = segments[segments.length - 1];
      } else {
        lastPoint = segments[segments.length - 1];
        nextLastPoint = segments[segments.length - 2];
      }

      var angle = Math.atan((lastPoint.plotX - nextLastPoint.plotX) /
        (lastPoint.plotY - nextLastPoint.plotY));

      if (angle < 0) angle = Math.PI + angle;

      path.push('M', lastPoint.plotX, lastPoint.plotY);

      if (lastPoint.plotX > nextLastPoint.plotX) {
        path.push(
          'L',
          lastPoint.plotX + arrowWidth * Math.cos(angle),
          lastPoint.plotY - arrowWidth * Math.sin(angle)
        );
        path.push(
          lastPoint.plotX + arrowLength * Math.sin(angle),
          lastPoint.plotY + arrowLength * Math.cos(angle)
        );
        path.push(
          lastPoint.plotX - arrowWidth * Math.cos(angle),
          lastPoint.plotY + arrowWidth * Math.sin(angle),
          'Z'
        );
      } else {
        path.push(
          'L',
          lastPoint.plotX - arrowWidth * Math.cos(angle),
          lastPoint.plotY + arrowWidth * Math.sin(angle)
        );
        path.push(
          lastPoint.plotX - arrowLength * Math.sin(angle),
          lastPoint.plotY - arrowLength * Math.cos(angle)
        );
        path.push(
          lastPoint.plotX + arrowWidth * Math.cos(angle),
          lastPoint.plotY - arrowWidth * Math.sin(angle),
          'Z'
        );
      }

      $('#diagramDiv16').find('.myPath').remove();

      series.chart.renderer.path(path)
        .attr({
          fill: series.color,
          class:'myPath'
        })
        .add(series.group);
        // .add(series.chart.renderer.g().add());


      }
  }
    
    });
  }(Highcharts));


//反转图
function drawChart_B33(key,selectedVal,selectedText){
	console.log("开始drawChart-B33-");
	

 	if (onlineOrLocal) {
		globalDataURL='../lib/data16B33.json';
	}else{
		globalDataURL='weekly/IndicatorQuery?indicatorId='+key+'&windCode='+selectedVal;
	}
	// console.log("图16B33的URL数据为：\n"+globalDataURL);
	
	$.getJSON(globalDataURL,function (dataYH) {	
		if (onlineOrLocal) {
			var dataObj=dataYH.obj; 
		}else{
			var jsonObject =$.parseJSON(dataYH);
			var dataObj=jsonObject.obj;			
		}
		console.log("图16B33的obj数据为：\n");
		console.log(dataObj);

		//dataSet数组转化为json对象
		var dataSet=dataObj.data;
		var dataJsonArray=[];
		// console.log("转化前dataJson为：\n");console.log(dataJsonArray);
		for (let i = 0; i < dataSet.length; i++) {
			// let tempJson={x: dataSet[i][1], y: dataSet[i][2]};
			let tempJson={name: dataSet[i][0],x: dataSet[i][1], y: dataSet[i][2]};
			dataJsonArray.push(tempJson);
		}
	


		var chart = Highcharts.chart('showDiagram16', {
		    chart: {
		        type: 'spline',
		        inverted: false,
		        // marginTop:20,
		    },
		    credits: {
				enabled: false
			},
		    // title: {
		    //     // text: '指定行业“速度/加速度”的历史变化路径'
		    // },
		    title: {
		        text: ''
		    },
		    exporting: {
			    enabled: false,
			    scale: 1,
			    sourceWidth: 800,
	    		sourceHeight: 600
			},
		    xAxis: {
		        reversed: false,
		        title: {
		            enabled: false,
		            // text: '海拔高度'
		        },
		        labels: {
		            formatter: function () {
		                return this.value;
		            }
		        },
		        plotLines: [{
					zIndex: 99,
					value: 1,
					color: 'gray',
					dashStyle: 'solid',
					width: 1,
					
				}],
		        maxPadding: 0.05,
		        showLastLabel: true,
		        lineWidth: 0,
		        gridLineWidth:0,
		        tickLength:5,
		    },
		    yAxis: {
		        title: {
		            // text: '温度'
		        },
		        plotLines: [{
					zIndex: 99,
					value: 1,
					color: 'gray',
					dashStyle: 'solid',
					width: 1,
		
				}],
		        lineWidth: 0,
		        gridLineWidth:0,
		        tickLength:5,
		        tickWidth:1,
		    },
		    legend: {
		        enabled: true,
			    align: 'right',
			    verticalAlign: 'top',
			    x: -50,
				y: 0,
				floating: false,
				itemStyle:{
					"color": "black", 
					"cursor": "pointer", 
					"fontSize": "12px", 
				},
			    margin:10,
		    },
		    tooltip: {
		        headerFormat: '<b>速度/加速度</b><br/>',
		        pointFormat: '<b>{point.name}</b><br>{point.x}, {point.y}'
		    },
		    plotOptions: {
		        spline: {
		            marker: {
		                enable: true,
		                radius:3,
		                symbol: 'circle',
		            }
		        }
		    },
		    series: [{
		        name: selectedText,
		        data: dataJsonArray,
		        lineWidth:2,
				color:globalColorBlue
		    }]
		}, function(chart){
		
		});
	});

}
$('#diagramDiv16').find('.spanExportButton').click(function(event){
	console.log("点击了导出图片B33！");
	var chart = $('#showDiagram16').highcharts();
	var curTime=getCurrentTime(1);
	var pngName='指定行业“速度/加速度”的历史变化路径'+curTime;	
	// chart.title.update({ text: '指定行业“速度/加速度”的历史变化路径'});
	// chart.legend.update(GlobalPNGLegend);

	// var svg = chart.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 
	// svgToPng(svg,800,600,pngName);

	var newNodeTop = document.createElement("div");
    newNodeTop.innerHTML = pngName;
    newNodeTop.style.font = '微软雅黑 Regular';
    newNodeTop.style.fontSize = '18px';
    newNodeTop.style.textAlign = "center";
	$("#showDiagram16").prepend(newNodeTop);

	html2canvas(document.getElementById("showDiagram16")).then(function(canvas) { 
	    var imgUri = canvas.toDataURL("image/png").replace("image/png", "image/octet-stream"); // 获取生成的图片的url 　
	    var saveLink = document.createElement( 'a');
	    saveLink.href =imgUri;
	    saveLink.download = pngName+'.png';
	    saveLink.click();
	    newNodeTop.remove();
    });
	// chart.title.update({ text: ''});

});

function drawChart_B41(key,selectedVal,selectedText){
	console.log("开始drawChart-B41");
	
	if (onlineOrLocal) {
		globalDataURL='../lib/data17B41.json';
	}else{
		globalDataURL='weekly/IndicatorQuery?indicatorId='+key+'&windCode='+selectedVal;
	}
	
	$.getJSON(globalDataURL,function (dataYH) {	
		if (onlineOrLocal) {
			var dataObj=dataYH.obj;
			var dataObjData=dataObj.data;
			var dataObjDataY=dataObj.data_y;   
		}else{
			var jsonObject =$.parseJSON(dataYH);
			var dataObj=jsonObject.obj;
			var dataObjData=dataObj.data;
			var dataObjDataY=dataObj.data_y; 			
		}

		
		var mychart =Highcharts.stockChart('showDiagram17', {
			credits: {
				enabled: false
			},
		    legend: {
		        enabled: true,
			    align: 'right',
			    verticalAlign: 'top',
			    x: -50,
				y: 20,
				floating: false,
				itemStyle:{
					"color": "black", 
					"cursor": "pointer", 
					"fontSize": "12px", 
				},
			    margin:0,
		    },
			rangeSelector: {
				// enabled: false,
				selected: 3,
				labelStyle: {
		            color: 'gray',
		            fontWeight: 'bold',
		            fontSize:13
		        },
			},
			navigator: {
		        enabled: true,
		        series: {
					type: 'line',
					color: 'gray',
				}
		    },
			exporting: {
			    enabled: false,
			    scale: 1,
			    sourceWidth: 800,
        		sourceHeight: 600
			},
			
			title:GlobalTitleStyle,
		    xAxis: {				
		        title: {
		            enabled: true,
		            // text: '2本周换手率历史分位'
		        },
	
		        
		        
		    },
			yAxis: {
				opposite: false,
				lineWidth:1,
				title: {
					// text: '这个是Y轴'
				},
				plotLines: [{
						value: dataObjDataY[0],
						color: 'blue',
						dashStyle: 'shortdash',
						width: 2,
						label: {
								text: '1Sigma('+dataObjDataY[0]+')'
						},
						zIndex:200,

				},{
						value: dataObjDataY[1],
						color: 'red',
						dashStyle: 'shortdash',
						width: 2,
						label: {
								 text: '2Sigma('+dataObjDataY[1]+')'
						},
						zIndex:200,
				},{
					value: 0,
					color: 'black',
					//dashStyle: 'shortdash',
					width: 1,
					/*label: {
						text: '0Sigma(0)'
					},*/
					zIndex:200,
				},{
						value: -dataObjDataY[0],
						color: 'blue',
						dashStyle: 'shortdash',
						width: 2,
						label: {
								text: '1Sigma(-'+dataObjDataY[0]+')'
						},
						zIndex:200,
				}, {
						value: -dataObjDataY[1],
						color: 'red',
						dashStyle: 'shortdash',
						width: 2,
						label: {
								 text: '2Sigma(-'+dataObjDataY[1]+')'
						},
						zIndex:200,
				}]
			},
			plotOptions:{
				line:{
					states:{
						hover:{
							lineWidthPlus:0
						}
					}
				}
			},
			series: [{
				name: selectedText+'HP滤波后的估值',
				data: dataObjData,
				lineWidth:2,
				color:globalColorBlue
			}]
		},function (chart) {
			setTimeout(function () {
				$('input.highcharts-range-selector', $(chart.container).parent())
					.datepicker(pickOption);
			}, 0);
    	});



	});

}
$('#diagramDiv17').find('.spanExportButton').click(function(event){
	console.log("点击了导出图片B41！");
	var chart = $('#showDiagram17').highcharts();
	var curTime=getCurrentTime(1);
	
	chart.title.update({ text: '中期_HP滤波后的行业估值'});
	chart.legend.update(GlobalPNGLegend);
	
	var svg = chart.getSVG().replace(/</g, '\n<').replace(/>/g, '>'); 							
	var pngName='中期_HP滤波后的行业估值'+curTime;
	svgToPng(svg,800,600,pngName);
	
	chart.title.update({ text: ''});
	chart.legend.update({
        enabled: true,
	    align: 'right',
	    verticalAlign: 'top',
	    x: -50,
		y: 20,
		floating: false,
		itemStyle:{
			"color": "black", 
			"cursor": "pointer", 
			"fontSize": "12px", 
		},
	    margin:0,
    });
});



function getCurrentTime(lengthChoose){
	//获取当前时间
	var date = new Date();
	if (lengthChoose == 3) {
		date = new Date(date.getTime() - 86400000);
	}
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	if (month<10) {month='0'+month;}
	var day = date.getDate();
	if (day<10) {day='0'+day;}
	var hour = date.getHours();
	var minute = date.getMinutes();
	var second = date.getSeconds();
	var currentTime='';
	if (lengthChoose==1) {
		currentTime=year+month+day+hour+minute+second;
	}
	if (lengthChoose==2) { //20180912
		currentTime=year+month+day;		
	}
	if (lengthChoose==3) {  //前一天
		currentTime=year+month+day;		
	}
	console.log("-------"+currentTime);
	return currentTime;
}

function drawHistogram(showDiagramID,title,xAxisData,seriesData){
	var chart = Highcharts.chart(showDiagramID,{
	    chart: {
	        type: 'column'
	    },
	    credits: {
			enabled: false
		},
		exporting:{
			enabled: false
		},
		legend:{
			enabled: false
		},
	    title: {
	        text: title
	    },
	    // subtitle: {
	    //     text: '数据来源: WorldClimate.com'
	    // },
	    xAxis: {
	        categories: xAxisData,
	        // colors:['red','green','red','green','red','green'],
	        crosshair: true,
	        labels: {
	        	autoRotation:false,
		        style: {
		            fontSize: '10px',
		            textOverflow: 'none',
		            // whiteSpace:"wrap"
		        },
		        formatter: function() {
		            var labelVal = this.value;
		            var reallyVal = labelVal;
		            var lvl = labelVal.length;
		            if(lvl > 5 && lvl <=10){
		                reallyVal = labelVal.substr(0,5)+"<br/>"+labelVal.substring(5,lvl);
		            }else if(lvl > 10 && lvl <=15){
		                reallyVal = labelVal.substr(0,5)+"<br/>"+labelVal.substr(5,5)+"<br/>"+labelVal.substring(10,lvl);
		            }else if(lvl > 15 && lvl <=20){
		                reallyVal = labelVal.substr(0,5)+"<br/>"+labelVal.substr(5,5)+"<br/>"+labelVal.substr(10,5)+"<br/>"+labelVal.substring(15,lvl);
		            }else if(lvl > 20 && lvl <=25){
		                reallyVal = labelVal.substr(0,5)+"<br/>"+labelVal.substr(5,5)+"<br/>"+labelVal.substr(10,5)+"<br/>"+labelVal.substr(15,5)+"<br/>"+labelVal.substring(20,lvl);
		            }else if(lvl > 25){
		                reallyVal = labelVal.substr(0,5)+"<br/>"+labelVal.substr(5,5)+"<br/>"+labelVal.substr(10,5)+"<br/>"+labelVal.substr(15,5)+"<br/>"+labelVal.substr(20,5)+"<br/>"+labelVal.substring(25,lvl);
		            }
		            
		            return reallyVal;
		        }
		    },
	    },
	    yAxis: {
	        min: 0,
	        lineWidth:1
	    },
	    tooltip: {
	        headerFormat: '',
		    pointFormat: '{point.category}<br>{point.y}',
	        shared: true,
	        useHTML: true
	    },
	    plotOptions: {
	        column: {
	            borderWidth: 0,
	            colorByPoint:true
	        },
	        series: {
				dataLabels: {
					enabled: true,
					allowOverlap: true, // 允许数据标签重叠
					style:{
						fontSize:6,
						fontWeight:10,
					}
				}
			}
	    },
	    series: [{
	        name: '',
	        data: seriesData,
	        colors: ['#446FA4','#4877AF','#4C7DB8','#638AC1','#849FCA']
	    }]
	});
}

function svgToPng(svg,pngWidth,pngHeight,pngName){

	var image = new Image();
	image.crossOrigin = 'anonymous';
	image.src = 'data:image/svg+xml;base64,' + window.btoa(unescape(encodeURIComponent(svg))); 

	console.log('导出图片的URL---');


	var canvas = document.createElement('canvas');  
	canvas.width = pngWidth;  
    canvas.height = pngHeight; 
	 
	var context = canvas.getContext('2d');  
	image.onload=function(){
		context.drawImage(image, 0, 0);
		var a = document.createElement("a"); 
			a.href = canvas.toDataURL('image/png'); 
			a.download = pngName+".png";  
	 
			a.click(); //点击触发下载
			a = null;

		
	};

 
}

function calculateQuantity(row_items){
	//柱状图数据收集---------------------------------------------------
		var ProblemStatistic=new Array();
		if (row_items.length>0) {
			ProblemStatistic[0]=row_items[0];
			var ProblemNumStatistic=new Array();
			ProblemNumStatistic[0]=1;		
			for(var i=1;i<row_items.length;i++){
				// 统计问题种类和数量
				for (var j =0,a=ProblemStatistic.length; j<a; j++) {
					if (row_items[i]==ProblemStatistic[j]) {
						ProblemNumStatistic[j]++;
						break;
					}else if(j==ProblemStatistic.length-1){
						ProblemStatistic[j+1]=row_items[i];
						ProblemNumStatistic[j+1]=1;
					}
				}						
			}
		}
		else{
			console.log('数据库没有数据!');return;
		}

		
		//排序
		var i = 0, len = ProblemStatistic.length, j, d; 
		for(i=0; i<len-1; i++){ 
			for(j=0; j<len-i-1; j++){ 
				if(ProblemStatistic[j] > ProblemStatistic[j+1]){ 
					d = ProblemStatistic[j]; 
					ProblemStatistic[j] = ProblemStatistic[j+1]; 
					ProblemStatistic[j+1] = d; 
					d = ProblemNumStatistic[j]; 
					ProblemNumStatistic[j] = ProblemNumStatistic[j+1]; 
					ProblemNumStatistic[j+1] = d;
				} 
			} 
		}

		var caculateResult=new Array();
		for (var m = 0; m < ProblemStatistic.length; m++) {
			// console.log('统计结果为：'+ProblemStatistic[m]+'共'+ProblemNumStatistic[m]+'\n');
			var temp=new Array();
			temp[0]=ProblemStatistic[m];
			temp[1]=Math.round(ProblemNumStatistic[m]*1000/row_items.length)/1000;
			// temp[1]=ProblemNumStatistic[m]/row_items.length;
			caculateResult.push(temp);
			// console.log('统计结果为：'+temp[0]+'共'+temp[1]+'\n');
		}
		return caculateResult;
}

function drawSmallDiagram(selectedVal,selectedText,lastDate){

	//获取点击数据的时间
    // var dateYMD=getCurrentTime(2);
    // console.log(dateYMD);
    //传递点击数据，获取小图数据
	$.ajax({
		method: "GET",
		url: '/weekly/IndicatorQuery?indicatorId=0011&windCode='+selectedVal+'&startDate='+lastDate+'&endDate='+lastDate,								
	})
	.done(function( msg ) {
		console.log( "固定小图返回的Data " + msg );
		if (onlineOrLocal) {
			globalDataURL='../lib/data7A31小图.json';
			
			$.getJSON(globalDataURL,function (dataYH) {	
				var dataObj=dataYH.obj;
				console.log("图7A31小图的obj数据为：\n");
				console.log(dataObj);

				var finalResult=calculateQuantity(dataObj);				

				//在div中创建图表
				var chart = Highcharts.chart('showDiagram7Small', {
					/*chart: {
							type: 'column'
					},
					credits: {
						enabled: false
					},
					title: {
							text: selectedText +' '+lastDate+' '+'PE分布',
					},
					exporting:{	
					    enabled: false,
					    scale: 1,
					    sourceWidth: 500,
		        		sourceHeight: 200	
					},
	
					xAxis: {
						type: 'category',
						labels: {
							rotation: -45,  // 设置轴标签旋转角度
							style:{
								// "color": "black", 
								// "cursor": "pointer", 
								"fontSize": "10px", 
							},
							
						}
					},
					yAxis: {
							min: 0,
							lineWidth:1
							// title: {
							// 		// text: '人口 (百万)'
							// }
					},
					legend: {
							enabled: false
					},
					tooltip: {
							pointFormat: 'PE频率: <b>{point.y:.1f}</b>'
					},
					series: [{
						name: 'PE频率',
						data: finalResult,
						dataLabels: {
							enabled: true,
							rotation: -90,
							color: '#FFFFFF',
							align: 'right',
							format: '{point.y:.1f}', // :.1f 为保留 1 位小数
							y: 10
						}
					}]*/
					
					chart: {
						type: 'column'
					},
					credits: {
						enabled: false
					},
					plotOptions: {
				        column: {
				            pointPlacement: 'between'
				        }
				    },
					xAxis: {
				        tickmarkPlacement: 'on',
				        labels: {
				            align: 'left',
				            rotation: 0
				        },
				        gridLineWidth: 0.5,
				        tickInterval: dataObj.data_interval
				    },
				    title: {
						text: selectedText +' '+lastDate+' '+'PE分布',
					},
					exporting:{
						enabled: false,
					    scale: 1,
					    sourceWidth: 800,
		        		sourceHeight: 200
					},
				    legend: {
						enabled: false
					},
					tooltip: {
						pointFormat: 'PE频率: <b>{point.y}</b>'
					},
				    series: [{
				        name: 'PE频率',
				        data: dataObj.data,
				        pointStart: dataObj.data_start,
				        pointInterval: dataObj.data_interval,
				        type: 'column'
				    }]
				});
				// globalClicked=true;

			});
		}
		else{   //不是本地出小图
			console.log( "进入在线画小图：-" + msg );
			var jsonObject =$.parseJSON(msg);
			var dataObj=jsonObject.obj;	
			//var finalResult=calculateQuantity(dataObj);			

			//在div中创建图表
			var chart = Highcharts.chart('showDiagram7Small', {
				/*chart: {
						type: 'column'
				},
				credits: {
					enabled: false
				},
				title: {
						text: selectedText +' '+lastDate+' '+'PE分布',
				},
				exporting:{
					enabled: false,
				    scale: 1,
				    sourceWidth: 500,
	        		sourceHeight: 200	
				},
				xAxis: {
					type: 'category',
					labels: {
						rotation: -45,  // 设置轴标签旋转角度
						style:{
							// "color": "black", 
							// "cursor": "pointer", 
							"fontSize": "10px", 
						},
					}
				},
				yAxis: {
						min: 0,
						// title: {
						// 		// text: '人口 (百万)'
						// }
				},
				legend: {
						enabled: false
				},
				tooltip: {
						pointFormat: 'PE频率: <b>{point.y:.1f}</b>'
				},
				series: [{
					name: 'PE频率',
					data: finalResult,
					dataLabels: {
						enabled: true,
						rotation: -90,
						color: '#FFFFFF',
						align: 'right',
						format: '{point.y:.1f}', // :.1f 为保留 1 位小数
						y: 10
					}
				}]*/
				chart: {
					type: 'column'
				},
				credits: {
					enabled: false
				},
				plotOptions: {
			        column: {
			            pointPlacement: 'between'
			        }
			    },
				xAxis: {
			        tickmarkPlacement: 'on',
			        labels: {
			            align: 'left',
			            rotation: 0
			        },
			        gridLineWidth: 0.5,
			        tickInterval: dataObj.data_interval
			    },
			    title: {
					text: selectedText +' '+lastDate+' '+'PE分布',
				},
				exporting:{
					enabled: false,
				    scale: 1,
				    sourceWidth: 800,
	        		sourceHeight: 200
				},
			    legend: {
					enabled: false
				},
				tooltip: {
					pointFormat: 'PE频率: <b>{point.y}</b>'
				},
			    series: [{
			        name: 'PE频率',
			        data: dataObj.data,
			        pointStart: dataObj.data_start,
			        pointInterval: dataObj.data_interval,
			        type: 'column'
			    }]
			});
		}






	})
	.fail(function( jqXHR, textStatus ) {
		console.log( "Request failed: " + textStatus );

		if (onlineOrLocal) {
			globalDataURL='../lib/data7A31小图.json';
			
			$.getJSON(globalDataURL,function (dataYH) {	
				var dataObj=dataYH.obj;
				console.log("图7A31小图的obj数据为：\n");
				console.log(dataObj);

				var finalResult=calculateQuantity(dataObj);
				
				//在div中创建图表
				var chart = Highcharts.chart('showDiagram7Small', {
					/*chart: {
							type: 'column'
					},
					credits: {
						enabled: false
					},
					title: {
							text: selectedText +' '+lastDate+' '+'PE分布',
					},
					exporting:{
						enabled: false,
					    scale: 1,
					    sourceWidth: 500,
		        		sourceHeight: 200	
					},
					xAxis: {
						type: 'category',
						labels: {
							rotation: -45,  // 设置轴标签旋转角度
							style:{
								"fontSize": 5, 
							},
						}
					},
					yAxis: {
							min: 0,
							lineWidth:1
		
					},
					legend: {
							enabled: false
					},
					tooltip: {
							pointFormat: 'PE频率: <b>{point.y}</b>'
					},
					series: [{
						name: 'PE频率',
						data: finalResult,
						dataLabels: {
							enabled: true,
							rotation: -90,
							color: '#FFFFFF',
							align: 'right',
							y: 10
						}
					}]*/
					chart: {
						type: 'column'
					},
					credits: {
						enabled: false
					},
					plotOptions: {
				        column: {
				            pointPlacement: 'between'
				        }
				    },
					xAxis: {
				        tickmarkPlacement: 'on',
				        labels: {
				            align: 'left',
				            rotation: 0
				        },
				        gridLineWidth: 0.5,
				        tickInterval: dataObj.data_interval
				    },
				    title: {
						text: selectedText +' '+lastDate+' '+'PE分布',
					},
					exporting:{
						enabled: false,
					    scale: 1,
					    sourceWidth: 800,
		        		sourceHeight: 200
					},
				    legend: {
						enabled: false
					},
					tooltip: {
						pointFormat: 'PE频率: <b>{point.y}</b>'
					},
				    series: [{
				        name: 'PE频率',
				        data: dataObj.data,
				        pointStart: dataObj.data_start,
				        pointInterval: dataObj.data_interval,
				        type: 'column'
				    }]
				});

			});
		}
	});
}



/**
 * 选择下拉框
 * 如果既有平滑周期，又有指数名称，这2个值的class不一样，分别获取2个值，然后分别处理
 * 	// 没有下拉：A11 A12 A21 B21 B22 B23 B31 B32
	// 一个下拉：A23 A24 A31 A32 B24 B33(下拉值不一样) B41
	// 二个下拉：A22 
	// 三个下拉：B11
 */

$(".selected-index").change(function(){
	 
	var key = $(this).attr('key');
	if(key!==keys.B11){	
		var selectedVal = $(this).val();
		var selectedText = $(this).find("option:selected").text();
			
		switch (key)
		{
			case keys.A23: 
				drawChart_A23(key,selectedVal,selectedText); break;
			case keys.A24: ;
				drawChart_A24(key,selectedVal,selectedText); break;
			case keys.A31:
				// $('#showDiagram7').html='' ;
				drawChart_A31(key,selectedVal,selectedText);break;
				// drawSmallDiagram(selectedVal,selectedText);
			case keys.A32: 
				drawChart_A32(key,selectedVal,selectedText); break;
			case keys.B24: 
				drawChart_B24(key,selectedVal,selectedText); break;
			case keys.B41: ;
				drawChart_B41(key,selectedVal,selectedText); break;
		}
	}
});

// B33
$(".selected-citic-index").change(function(){	 
	var key = $(this).attr('key');
	var selectedVal = $(this).val();
	var selectedText = $(this).find("option:selected").text();	    
	drawChart_B33(key,selectedVal,selectedText);
});

// A22只要选择其中一个就更新
$("#diagramDiv4 .smooth").change(function(){	 
	var key = $(this).attr('key');
	var smooth = $(this).val();
	var windCode = $('#diagramDiv4').find('.windCode').val();	

	var smoothText = $(this).find("option:selected").text();   
	var windCodeText = $('#diagramDiv4').find('.windCode').find("option:selected").text();

	drawChart_A22(key,windCode,smooth,windCodeText,smoothText);
});
$("#diagramDiv4 .windCode").change(function(){	 
	var key = $(this).attr('key');
	var windCode = $(this).val();
	var smooth = $('#diagramDiv4').find('.smooth').val();
	var windCodeText = $(this).find("option:selected").text();
	var smoothText = $('#diagramDiv4').find('.smooth').find("option:selected").text();

	drawChart_A22(key,windCode,smooth,windCodeText,smoothText);
});

// B11
$("#diagramDiv9 .smooth").change(function(){
	var windCode1Select = $('#diagramDiv9').find('.windCode1');	 
	var windCode2Select = $('#diagramDiv9').find('.windCode2');	 
	var key = $(this).attr('key');
	var smooth = $(this).val();
	var windCode1 = windCode1Select.val();
	var windCode2 = windCode2Select.val();
	var smoothText = $(this).find("option:selected").text();	
	var windCode1Text = windCode1Select.find("option:selected").text();
	var windCode2Text = windCode2Select.find("option:selected").text();
	drawChart_B11(key,windCode1,windCode2,smooth,windCode1Text,windCode2Text,smoothText);
});

$("#diagramDiv9 .windCode1").change(function(){	 
	var key = $(this).attr('key');
	var windCode1 = $(this).val();
	var smooth = $('#diagramDiv9').find('.smooth').val();
	var windCode2 = $('#diagramDiv9').find('.windCode2').val();

	var windCode1Text = $(this).find("option:selected").text();	
	var smoothText = $('#diagramDiv9').find('.smooth').find("option:selected").text();
	var windCode2Text = $('#diagramDiv9').find('.windCode2').find("option:selected").text();


	drawChart_B11(key,windCode1,windCode2,smooth,windCode1Text,windCode2Text,smoothText);
});

$("#diagramDiv9 .windCode2").change(function(){	 
	var key = $(this).attr('key');
	var windCode2 = $(this).val();
	var smooth = $('#diagramDiv9').find('.smooth').val();
	var windCode1 = $('#diagramDiv9').find('.windCode1').val();

	var windCode2Text = $(this).find("option:selected").text();	
	var windCode1Text = $('#diagramDiv9').find('.windCode1').find("option:selected").text();
	var smoothText = $('#diagramDiv9').find('.smooth').find("option:selected").text();

	drawChart_B11(key,windCode1,windCode2,smooth,windCode1Text,windCode2Text,smoothText);


});


// $(".table-input .input-date").datepicker(pickOption); 

// $(".table-input .start-date").val(getFormatTimeWithLine());





// Mark:页面动画

	let expanders = document.querySelectorAll('.DiagramTitleThree');
	

	const expandToggle = function(event){
		let ariaExpanded= this.getAttribute('aria-expanded');
		let img = $(this).find('.right-img-three').get(0);
		let nextSbl = this.nextElementSibling;
		let id= this.getAttribute('id').replace('diagramThree','');	
		if (img){
			if (ariaExpanded == 'false'){
				let menuThreeCheck = $("#menuThreeCheck"+id);
				menuThreeCheck.attr('checked',true);
				menuThreeCheck.prop("checked","checked");

				this.setAttribute('aria-expanded','true'); 		
				img.style.animation = "arrowRotateDown 0.25s 1 forwards ease-in";
			}else{

				let menuThreeCheck = $("#menuThreeCheck"+id);
				menuThreeCheck.attr('checked',false);
				menuThreeCheck.removeAttr("checked");

				this.setAttribute('aria-expanded','false');
				img.style.animation = "arrowRotateUp 0.25s forwards ease-out";
			}
		}

		if (nextSbl){
			let ariaHidden = nextSbl.getAttribute('aria-hidden');
			if (ariaHidden == 'true'){       
				nextSbl.setAttribute('aria-hidden','false'); 
				nextSbl.style.maxHeight = '815px';
				nextSbl.style.transition = "max-height 0.25s ease";
			}else{
				nextSbl.setAttribute('aria-hidden','true');
				nextSbl.style.maxHeight = '0px';
				nextSbl.style.transition = "max-height 0.25s ease";
			}
		}
	};
	for (let i = 0,len=expanders.length; i < len; i++) { 
	    let firstChild = expanders[i];
		
	    EventObject.addHandler(firstChild,"click", expandToggle);  
		expand(firstChild);
	}

	function expand(ele){
		if(ele){
					
			let ariaExpanded= ele.getAttribute('aria-expanded');
	        let img = ele.children[0].children[2];
	        let nextSbl = ele.nextElementSibling;
	        if (img){
	            if (ariaExpanded == 'true'){
					let id= ele.getAttribute('id').replace('diagramThree','');	
					let menuThreeCheck = $("#menuThreeCheck"+id);
					menuThreeCheck.attr('checked',true);
	                ele.setAttribute('aria-expanded','true'); 
	                img.style.animation = "arrowRotateDown 0.25s 1 forwards ease-in";
	            }else{
					let id= ele.getAttribute('id').replace('diagramThree','');	
					let menuThreeCheck = $("#menuThreeCheck"+id);
					menuThreeCheck.attr('checked',false);
	                ele.setAttribute('aria-expanded','false');
	                img.style.animation = "arrowRotateUp 0.25s forwards ease-out";
	            }
	        }
	        if (nextSbl){
	        	let ariaHidden = nextSbl.getAttribute('aria-hidden');
	            if (ariaHidden == 'false'){       
	                nextSbl.setAttribute('aria-hidden','false'); 
	                nextSbl.style.maxHeight = '815px';
	                nextSbl.style.transition = "max-height 0.25s ease";
	            }else{
	                nextSbl.setAttribute('aria-hidden','true');
	                nextSbl.style.maxHeight = '0px';
	                nextSbl.style.transition = "max-height 0.25s ease";
	            }
	        }
		}
	}

	function expandBig(menuThreeCheck,i){
		// 应该判断默认选中，因为默认选中的逻辑正好相反，或者首先同意设置好属性。应该选出2种，一种是默认打开的，一种是没默认打开的。找出默认打开的，把属性设置初始化。

		let diagramThree = $("#diagramThree"+i);
		let img = diagramThree.find('.right-img-three').get(0);
		let ariaExpanded= diagramThree.attr('aria-expanded');
		if (ariaExpanded == 'true'){
			diagramThree.attr('aria-expanded',false);
		}
		if (img){
			if (ariaExpanded == 'false'){
				diagramThree.attr('aria-expanded',true);
				img.style.animation = "arrowRotateDown 0.25s 1 forwards ease-in";
			}else{
				diagramThree.attr('aria-expanded',false);
				img.style.animation = "arrowRotateUp 0.25s forwards ease-out";
			}
		}

		let	nextSbl = $("#diagramDiv"+i).get(0);
		let ariaHidden = $("#diagramDiv"+i).attr('aria-hidden');
		
		if (ariaHidden == 'true'){       
			nextSbl.setAttribute('aria-hidden','false'); 
			nextSbl.style.maxHeight = '815px';
			nextSbl.style.transition = "max-height 0.25s ease";
		}else{
			nextSbl.setAttribute('aria-hidden','true');
			nextSbl.style.maxHeight = '0px';
			nextSbl.style.transition = "max-height 0.25s ease";
		}			
		
	}


    let diagramTitleThreeTength = expanders.length;
    

	for(let i=1;i<=diagramTitleThreeTength;i++){
		$("#menuThreeSelected"+i).click(function(e) {
			$("html, body").animate({
				scrollTop: $("#diagramThree"+i).offset().top 
			}, {duration: 500,easing: "swing"});

		});
		$("#menuThreeCheck"+i).click(function(e) {	
			let menuThreeCheck = $(this);
			let currentState = menuThreeCheck.attr('checked');
			if (currentState) {
				menuThreeCheck.attr('checked',false); 
			}else{
				menuThreeCheck.attr('checked',true);
			}


			let diagramThree = $("#diagramThree"+i);
			let img = diagramThree.find('.right-img-three').get(0);
			let ariaExpanded= diagramThree.attr('aria-expanded');
	        if (img){
	            if (ariaExpanded == 'false'){
					diagramThree.attr('aria-expanded',true);
	                img.style.animation = "arrowRotateDown 0.25s 1 forwards ease-in";
	            }else{
					diagramThree.attr('aria-expanded',false);
	                img.style.animation = "arrowRotateUp 0.25s forwards ease-out";
	            }
	        }

			let	nextSbl = $("#diagramDiv"+i).get(0);
			let ariaHidden = $("#diagramDiv"+i).attr('aria-hidden');
			
			if (ariaHidden == 'true'){       
				nextSbl.setAttribute('aria-hidden','false'); 
				nextSbl.style.maxHeight = '815px';
				nextSbl.style.transition = "max-height 0.25s ease";
			}else{
				nextSbl.setAttribute('aria-hidden','true');
				nextSbl.style.maxHeight = '0px';
				nextSbl.style.transition = "max-height 0.25s ease";
			}	
			// 需要遍历同级的元素，来确定上一级标题是否被选中
			let menuLTwoS  = $(this).parent().parent().find('.MenuLThree');
			let menuLTwoInputS = menuLTwoS.find('input');
			let menuThreeChecks = menuLTwoS.find('input[type=checkbox]:checked');
			let menuTwoCheck = $(this).parent().parent().find('.menuTwoCheck');
			let menuThreeNotChecks = menuLTwoS.find('input[type=checkbox]:not(:checked)');
	
			if(menuLTwoInputS.length === menuThreeChecks.length){
				menuTwoCheck.prop("checked","checked");
				menuTwoCheck.attr('checked',true);
			}
			if(menuLTwoInputS.length === menuThreeNotChecks.length){
				menuTwoCheck.removeAttr("checked");
				menuTwoCheck.attr('checked',false);
			}
		
		});
	}


    $(".create-comment-btn").click(function(){
		$(this).parent().parent().parent().find('.create-comment-container').css('display','block');
    });

   $(".menuOneCheck,.menuTwoCheck").click(function(){
	    
	    let menuLOne = $(this).parent().parent();
	    let currentState = $(this).attr('checked');
		if (currentState) {			
			menuLOne.find('input').attr('checked',false);
			menuLOne.find('input').removeAttr("checked");
		}else{
			menuLOne.find('input').attr('checked',true);
			menuLOne.find('input').prop("checked","checked");
		}
		// 展开和折叠，选到对应的位置。过滤出包含menuThreeCheck。默认选中的折叠相反。因为默认扩展，假如是第一次点击，有默认扩展，就执行上面的。第一次分开，后面都不分开。
		// 当子集全部默认选中；当子集部分默认选中（部分默认选中，可以分别根据2个长度）
		
		let inputs = menuLOne.find('input').not('.menuTwoCheck,.menuOneCheck')  ;
		inputs = Array.from(inputs); 
		let idIndex = [];
		let defaultExpand = [];
		let defaultNotExpand = [];

		for(let i=0; i<inputs.length; i++){
			let menuThreeCheckIndex = $(inputs[i]).attr('id').replace('menuThreeCheck','');
			idIndex.push(menuThreeCheckIndex);
			if($("#diagramDiv"+menuThreeCheckIndex).attr('aria-hidden') == 'true'){
				defaultNotExpand.push(menuThreeCheckIndex);
			}else{
				defaultExpand.push(menuThreeCheckIndex);
			}
			
		}
		if(defaultExpand.length!==0 && defaultNotExpand.length == 0 ){
			for(let i=0; i<defaultExpand.length; i++){		
				let	nextSbl = $("#diagramDiv"+defaultExpand[i]);
				let ariaHidden = $("#diagramDiv"+defaultExpand[i]).attr('aria-hidden');	
				if (ariaHidden == 'false'){  
					nextSbl.attr('aria-hidden','true'); 
					nextSbl.css('maxHeight','0px');
					nextSbl.css('transition','max-height 0.25s ease');     
				}else{
					nextSbl.attr('aria-hidden','true');
					nextSbl.css('maxHeight','815px');
					nextSbl.css('transition','max-height 0.25s ease');   
				}
			}
			// console.log('expandconsole defaultExpand length:'+defaultExpand.length);	
		}else if(defaultNotExpand.length!=0 && defaultExpand.length!=0){
			for(let i=0; i<defaultExpand.length; i++){		
				let	nextSbl = $("#diagramDiv"+defaultExpand[i]);
				let ariaHidden = $("#diagramDiv"+defaultExpand[i]).attr('aria-hidden');	
				if (ariaHidden == 'false'){  
					nextSbl.attr('aria-hidden','false'); 
					nextSbl.css('maxHeight','815px');
					nextSbl.css('transition','max-height 0.25s ease');     
				}else{
					nextSbl.attr('aria-hidden','true');
					nextSbl.css('maxHeight','0px');
					nextSbl.css('transition','max-height 0.25s ease');   
				}
			}
			for(let i=0; i<defaultNotExpand.length; i++){
				let	nextSbl = $("#diagramDiv"+defaultNotExpand[i]);
				let ariaHidden = $("#diagramDiv"+defaultNotExpand[i]).attr('aria-hidden');
				
				if (ariaHidden == 'true'){       
					nextSbl.attr('aria-hidden','false');
					nextSbl.css('maxHeight','815px');
					nextSbl.css('transition','max-height 0.25s ease'); 
				}else{
					nextSbl.attr('aria-hidden','true');
					nextSbl.css('maxHeight','0px');
					nextSbl.css('transition','max-height 0.25s ease');  
				}	
			}
			// console.log(defaultExpand.length+'expandconsole defaultExpand length+defaultNotExpand.length:'+defaultNotExpand.length);	
   		}else{ 		
			// console.log('expandconsole defaultNotExpand length:'+defaultNotExpand.length);	
		    for(let i=0; i<idIndex.length; i++){
				expandBig($("#menuThreeCheck"+idIndex[i]),idIndex[i]);	
			} 
		}

		if($(this).attr('class','menuTwoCheck')){
			// 需要遍历同级的元素，来确定上一级标题是否被选中
			let MenuLOne  = $(this).parent().parent().parent();
			let menuTwoInputS = MenuLOne.find('.menuTwoCheck');
			let menuTwoChecks = MenuLOne.find('.MenuLTwo').find('p').find('input[type=checkbox]:checked');
			let menuTwoNotChecks = MenuLOne.find('.MenuLTwo').find('p').find('input[type=checkbox]:not(:checked)');
			let menuOneCheck = MenuLOne.find('.menuOneCheck');

			if(menuTwoInputS.length === menuTwoChecks.length){
				menuOneCheck.prop("checked","checked");
			}
			if(menuTwoInputS.length !== menuTwoChecks.length){
				menuOneCheck.removeAttr("checked");
			}
		}
		
    });
	let isExpanded = false;
	$(".DiagramTitleOne").click(function(e){
		if (e && e.stopPropagation) {
    		e.stopPropagation();
		} else if (window.event) {
		    window.event.cancelBubble = true;
		}


		let img = $(this).find('.right-img-one').get(0);
		if (img){
			if (isExpanded == false){
				isExpanded = true;
				img.style.animation = "arrowRotateDown 0.25s 1 forwards ease-in";
			}else{
				isExpanded = false;
				img.style.animation = "arrowRotateUp 0.25s forwards ease-out";
			}
		}
		$(this).find('.DiagramTitleTwo').slideToggle(500);

    });

	$(".DiagramTitleTwo").click(function(e){
		if (e && e.stopPropagation) {
    		e.stopPropagation();
		} else if (window.event) {
		    window.event.cancelBubble = true;
		}
		$(this).find('.DiagramTitleThree').slideToggle(500);
    });
	$(".DiagramTitleThree,.DiagramBigDiv").click(function(e){
		if (e && e.stopPropagation) {
    		e.stopPropagation();
		} else if (window.event) {
		    window.event.cancelBubble = true;
		}
    });

	$('.returnToTop').click(function(){
		$('html,body').animate({scrollTop:0},'slow');
	});
	$('.comment-cancel').click(function(){	;
		$(this).parents().find('.create-comment-container').css('display','none');
	});
	$('.close-comment').click(function(){	
		
		$(this).parents().find('.create-comment-container').css('display','none');
	});

	

	$('.comment-confirm').click(function(){	
		var key = $(this).parent().parent().parent().parent().attr('key');
		var commentWord = $(this).parent().parent().find('.comment-word').val();

		var data = {
			'content':commentWord,
			'indicatorId':key
		}
		$.ajax({
			method: "POST",
			url: '/weekly/saveReview',
			data: data
		})
		.done(function( data ) {
			
			getCommentTable(key);
			console.log( "Data " + data );
		})
		.fail(function( jqXHR, textStatus ) {
			console.log( "Request failed: " + textStatus );
		});
		$(this).parent().parent().parent().css('display','none');
		
	});
	// 查询是先post，后get另一个网址来请求数据
	$('.comment-inquery').click(function(){
		var key = $(this).parent().parent().parent().attr('key');
		var startDate = $(this).parent().find('.start-date').val();
		var endDate = $(this).parent().find('.end-date').val();
		
		startDate = startDate.replace(/-/g,'');
		endDate = endDate.replace(/-/g,'');

		/*if(!startDate || !endDate){
			startDate = getFormatTime();
			endDate = getFormatTime();
		}*/
		

		var data = {
			'startDate':startDate,
			'endDate':endDate
		}

		$.ajax({
			method: "get",
			url: '/weekly/review?indicatorId='+key,
			data: data
		})
		.done(function( data ) {
			getTable(key,data);
			
			console.log( "Data " + data );
		})
		.fail(function( jqXHR, textStatus ) {
			console.log( "Request failed: " + textStatus );
		});
		
		
	});

	

function getFormatTime(){
	var myDate = new Date();
	var year = myDate.getFullYear();
	var month = myDate.getMonth()<9 ? '0'+(myDate.getMonth()+1):(myDate.getMonth()+1);
	var date = myDate.getDate()<10 ? '0'+(myDate.getDate()):(myDate.getDate());

	var time = ''+year+month+date;

	return time
}


/**
 * 点评数据显示
 * {"ret":[[20180719,"testabc","admin"],[20180719,"test1","admin"],[20180719,"test","admin"]]}
 * 获取key值，传入url和id中，点评跟winCode和smooth没关系
 * // 查询点评数据：http://localhost/weekly/review?indicatorId=0001
	// 提交（post）点评数据：http://localhost/weekly/saveReview?indicatorId=0001&content=test
 */

function getCommentTable(key){

	let globalDataURL = '';
	if (onlineOrLocal) {
		globalDataURL='../lib/commentA11.json';
	}else{
		globalDataURL='/weekly/review?indicatorId='+key;
	}
	
	$.getJSON(globalDataURL,function (data) {	
		getTable(key,data);
	});
}

function getTable(key,data){
	$('#comment-table'+key).empty();
	let dataObj = [];
	if (onlineOrLocal) {
		dataObj=data.ret; 
	}else{
		let jsonObject =$.parseJSON(data);
		dataObj=jsonObject.ret;			
	}


	var row_obj=$("<tr></tr>");
	var col_td=$("<th></th>");
	col_td.html('日期');row_obj.append(col_td);
	col_td=$("<th></th>");
	col_td.html('点评');row_obj.append(col_td);
	col_td=$("<th></th>");
	col_td.html('点评人');row_obj.append(col_td);

	$('#comment-table'+key).append(row_obj);	
	for (let m = 0; m < dataObj.length; m++) {
		var row_obj2=$("<tr></tr>");
		for (let i = 0; i < dataObj[m].length; i++) {		
			col_td=$("<td align='center' bgcolor='#FFFFFF'></td>");
			col_td.html(dataObj[m][i]);
			row_obj2.append(col_td);				
		}
		$('#comment-table'+key).append(row_obj2);
	}
}
	
getCommentTable(keys.A11);
getCommentTable(keys.A12);
getCommentTable(keys.A21);
getCommentTable(keys.A22);
getCommentTable(keys.A23);
getCommentTable(keys.A24);

getCommentTable(keys.A31);
getCommentTable(keys.A32);

getCommentTable(keys.B11);
getCommentTable(keys.B21);
getCommentTable(keys.B22);
getCommentTable(keys.B23);
getCommentTable(keys.B24);

getCommentTable(keys.B31);
getCommentTable(keys.B32);
getCommentTable(keys.B33);
getCommentTable(keys.B41);

/**
 * Mark:渲染指数列表数据
 */
function getSelectedData(key,className){
	let globalDataURL = '';
	if (onlineOrLocal) {
		if(key==='0001'){
			globalDataURL='../lib/index.json';
		}else{
			globalDataURL='../lib/citicIndex.json';
		}
	}else{
		globalDataURL='/weekly/IndexQuery?indexType='+key;
	}
	
	$.getJSON(globalDataURL,function (data) {	
		let dataObj = [];
		if (onlineOrLocal) {
			dataObj=data.obj; 
		}else{
			let jsonObject =$.parseJSON(data);
			dataObj=jsonObject.obj;			
		}
		for (let m = 0; m < dataObj.length; m++) {
			var option='';
			var optionLeft = "<option value="
			var optionRight = "</option>"
			option = $(optionLeft+dataObj[m][1]+'>'+optionRight);
			option.append(dataObj[m][0]);	
			$(className).append(option);						
		}
		// 默认选中
	
		 $('#diagramDiv7').find($("select option[value='000300.SH']")).attr("selected", "selected");  //A31
		 $('#diagramDiv9').find('.windCode2').find($("option[value='000016.SH']")).attr("selected", "selected");  //B11
	});
}

getSelectedData('0001','.selected-index');
getSelectedData('0002','.selected-citic-index');


