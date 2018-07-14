
import {EventObject,getUrlParams,isEmptyObj} from './api';

	let expanders = document.querySelectorAll('.DiagramTitleThree');
	

	const expandToggle = function(event){
		let ariaExpanded= this.getAttribute('aria-expanded');
		let img = $(this).find('.right-img-three').get(0);
		let nextSbl = this.nextElementSibling;
		if (img){
			if (ariaExpanded == 'false'){
				this.setAttribute('aria-expanded','true'); 
				img.style.animation = "arrowRotateDown 0.25s 1 forwards ease-in";
			}else{
				this.setAttribute('aria-expanded','false');
				img.style.animation = "arrowRotateUp 0.25s forwards ease-out";
			}
		}

		if (nextSbl){
			let ariaHidden = nextSbl.getAttribute('aria-hidden');
			if (ariaHidden == 'true'){       
				nextSbl.setAttribute('aria-hidden','false'); 
				nextSbl.style.maxHeight = '715px';
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
	                ele.setAttribute('aria-expanded','true'); 
	                img.style.animation = "arrowRotateDown 0.25s 1 forwards ease-in";
	            }else{
	                ele.setAttribute('aria-expanded','false');
	                img.style.animation = "arrowRotateUp 0.25s forwards ease-out";
	            }
	        }
	        if (nextSbl){
	        	let ariaHidden = nextSbl.getAttribute('aria-hidden');
	            if (ariaHidden == 'false'){       
	                nextSbl.setAttribute('aria-hidden','false'); 
	                nextSbl.style.maxHeight = '715px';
	                nextSbl.style.transition = "max-height 0.25s ease";
	            }else{
	                nextSbl.setAttribute('aria-hidden','true');
	                nextSbl.style.maxHeight = '0px';
	                nextSbl.style.transition = "max-height 0.25s ease";
	            }
	        }
		}
	}


    let diagramTitleThreeTength = expanders.length;
    

	for(let i=1;i<=diagramTitleThreeTength;i++){
		$("#menuThreeSelected"+i).click(function(e) {
			let menuThreeCheck = $("#menuThreeCheck"+i);
			let currentState = menuThreeCheck.attr('checked');
			if (currentState) {
				menuThreeCheck.attr('checked',false); 
			}else{
				menuThreeCheck.attr('checked',true);
			}

			$("html, body").animate({
				scrollTop: $("#diagramThree"+i).offset().top 
			}, {duration: 500,easing: "swing"});
            // console.log($("#diagramThree"+i).offset().top );

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
				nextSbl.style.maxHeight = '715px';
				nextSbl.style.transition = "max-height 0.25s ease";
			}else{
				nextSbl.setAttribute('aria-hidden','true');
				nextSbl.style.maxHeight = '0px';
				nextSbl.style.transition = "max-height 0.25s ease";
			}			
		});
	}

    $(".comment-page-btn").click(function(){
        $("#create-comment-container").css('display','none');
    });
    $(".create-comment-btn").click(function(){
        $("#create-comment-container").css('display','block');
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
    });
	let isExpanded = false;
	$(".DiagramTitleOne").click(function(e){
		e.stopPropagation();
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
		// console.log('.DiagramTitleOne');
		return false
    });

	$(".DiagramTitleTwo").click(function(e){
		e.stopPropagation();
		$(this).find('.DiagramTitleThree').slideToggle(500);
		return false
    });
	$(".DiagramTitleThree,.DiagramBigDiv").click(function(e){
		e.stopPropagation();
		return false
    });

	$('.returnToTop').click(function(){
		$('html,body').animate({scrollTop:0},'slow');
	});

	// $('#diagramDiv17').click(function(e){
	// 	e.stopPropagation();
	// 	console.log('dsfdsgf');
	// 	$("#ChildDiv").css('display','none');
	// 	return false
	// });


	

	//checkbox对应图标展开操作
	// $("input[id^='menuTwoCheck']").each(function(){

	// });
$(function(){
// 反转图
function drawChart6(){
	console.log("开始drawChart-6-");


		// (function(H) {
  //   H.wrap(H.Series.prototype, 'drawGraph', function(proceed) {

  //     // Now apply the original function with the original arguments, 
  //     // which are sliced off this function's arguments
  //     proceed.apply(this, Array.prototype.slice.call(arguments, 1));

  //     var arrowLength = 20,
  //       arrowWidth = 10,
  //       series = this,
  //       data = series.data,
  //       len = data.length,
  //       segments = data,
  //       lastSeg = segments[segments.length - 1],
  //       path = [];

  //       console.log("lastSeg----\n");
  //       console.log(lastSeg);


  //     var lastPoint = null;
  //     var nextLastPoint = null;
    
  //     if (lastSeg.y === 0) {
  //       lastPoint = segments[segments.length - 2];
  //       nextLastPoint = segments[segments.length - 1];
  //     } else {
  //       lastPoint = segments[segments.length - 1];
  //       nextLastPoint = segments[segments.length - 2];
  //     }

  //     var angle = Math.atan((lastPoint.plotX - nextLastPoint.plotX) /
  //       (lastPoint.plotY - nextLastPoint.plotY));

  //     if (angle < 0) angle = Math.PI + angle;

  //     path.push('M', lastPoint.plotX, lastPoint.plotY);

  //     if (lastPoint.plotX > nextLastPoint.plotX) {
  //       path.push(
  //         'L',
  //         lastPoint.plotX + arrowWidth * Math.cos(angle),
  //         lastPoint.plotY - arrowWidth * Math.sin(angle)
  //       );
  //       path.push(
  //         lastPoint.plotX + arrowLength * Math.sin(angle),
  //         lastPoint.plotY + arrowLength * Math.cos(angle)
  //       );
  //       path.push(
  //         lastPoint.plotX - arrowWidth * Math.cos(angle),
  //         lastPoint.plotY + arrowWidth * Math.sin(angle),
  //         'Z'
  //       );
  //     } else {
  //       path.push(
  //         'L',
  //         lastPoint.plotX - arrowWidth * Math.cos(angle),
  //         lastPoint.plotY + arrowWidth * Math.sin(angle)
  //       );
  //       path.push(
  //         lastPoint.plotX - arrowLength * Math.sin(angle),
  //         lastPoint.plotY - arrowLength * Math.cos(angle)
  //       );
  //       path.push(
  //         lastPoint.plotX + arrowWidth * Math.cos(angle),
  //         lastPoint.plotY - arrowWidth * Math.sin(angle),
  //         'Z'
  //       );
  //     }

  //     series.chart.renderer.path(path)
  //       .attr({
  //         fill: series.color
  //       })
  //       .add(series.group);

  //   });
  // }(Highcharts));
	


	var chart = Highcharts.chart('showDiagram16', {
	    chart: {
	        type: 'spline',
	        inverted: false,
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

drawChart6(); // 反转图 
});