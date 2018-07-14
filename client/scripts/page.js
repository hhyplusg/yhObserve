
import {EventObject,getUrlParams,isEmptyObj} from './api';

	let expanders = document.querySelectorAll('.DiagramTitleThree');
	let expandToggle = function(event){
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
	}



    let diagramTitleThreeTength = expanders.length;
    

	for(let i=1;i<=diagramTitleThreeTength;i++){
		$("#menuThreeSelected"+i).click(function(e) {
			// e.stopPropagation();
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
	$(".DiagramTitleThree").click(function(e){
		e.stopPropagation();
		return false
    });

	//checkbox对应图标展开操作
	// $("input[id^='menuTwoCheck']").each(function(){

	// });
