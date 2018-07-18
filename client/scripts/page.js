
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
		// return false
    });

	$(".DiagramTitleTwo").click(function(e){
		e.stopPropagation();
		$(this).find('.DiagramTitleThree').slideToggle(500);
		// return false
    });
	$(".DiagramTitleThree,.DiagramBigDiv").click(function(e){
		e.stopPropagation();
		// return false
    });

	$('.returnToTop').click(function(){
		$('html,body').animate({scrollTop:0},'slow');
	});

	$('#comment-confirm').click(function(){		
		var key = $(this).parents().find('.DiagramAreaDiv2').attr('key');
		var commentWord = $(this).parentsUntil('comment-box').find('.comment-word').val();
		var time = getFormatTime();
		console.log(time);
		var data = {
			'time':time,
			'commentWord':commentWord
		}
		$.ajax({
			method: "POST",
			url: '/weekly/saveReview?indicatorId='+key+'&content=test',
			data: data
		})
		.done(function( msg ) {
			console.log( "Data " + msg );
		})
		.fail(function( jqXHR, textStatus ) {
			console.log( "Request failed: " + textStatus );
		});
	});
	$('.comment-inquery').click(function(){
		
		var startDate = $(this).parent().find('.start-date').val();
		var endDate = $(this).parent().find('.end-date').val();
		
		startDate = startDate.replace(/-/g,'');
		endDate = endDate.replace(/-/g,'');

		if(!startDate || !endDate){
			startDate = getFormatTime();
			endDate = getFormatTime();
		}
		
		console.log(':'+startDate);
		console.log(':'+endDate);
		var data = {
			'startDate':startDate,
			'endDate':endDate
		}

		$.ajax({
			method: "POST",
			url: '/weekly/review?indicatorId=0001&startDate='+startDate+'&endDate='+endDate,
			data: data
		})
		.done(function( msg ) {
			console.log( "Data " + msg );
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
	// console.log(year+'-'+month+'-'+date);
	return time
}

	// 查询点评数据：http://localhost/weekly/review?indicatorId=0001
	// 提交（post）点评数据：http://localhost/weekly/saveReview?indicatorId=0001&content=test

	// $('#diagramDiv17').click(function(e){
	// 	e.stopPropagation();
	// 	console.log('dsfdsgf');
	// 	$("#ChildDiv").css('display','none');
	// 	return false
	// });


	

	//checkbox对应图标展开操作
	// $("input[id^='menuTwoCheck']").each(function(){

	// });