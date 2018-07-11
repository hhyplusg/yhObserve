//  export default function test(){
//     console.log('test');
// }

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


	//checkbox对应图标展开操作
	// $("input[id^='menuTwoCheck']").each(function(){
	//       $(this).click(function(){
	//      	var currentID=$(this).attr('id');
	// 		var idNUM=currentID.substring(12,currentID.length);
	// 		//找到对应要操作的图标div
	// 		//设置图标的展开状态
	// 	});
	// });

	// $("input[id^='menuThreeCheck']").each(function(){
	// 	$(this).click(function(){
	// 		var currentID=$(this).attr('id');
	// 		var idNUM=currentID.substring(14,currentID.length);
	// 		var currentState=$(this).attr('checked');
	// 		if (currentState) {
	// 			console.log("转换check状态为————1——");
	// 			$(this).attr('checked',false); 
	// 		}else{
	// 			console.log("转换check状态为————2——");
	// 			$(this).attr('checked',true); 

				//设置图标的展开状态
				// var setDivShow=document.getElementById("diagramDiv1");
				// let ariaExpanded= setDivShow.getAttribute('aria-expanded');
				// // let priviousDiv= setDivShow.previousElementSibling;
				// let priviousDiv=$("#diagramDiv1").prev();
				// let img=priviousDiv.find('.right-img-three').get(0);
		        // // let img = $("#diagramDiv1").find('.right-img-three').get(0);
		        // console.log("---=\n");
		        // console.log(img);
		        // let nextSbl = setDivShow;
		        // if (img){
		        //     if (ariaExpanded == 'false'){ console.log("进入img判断");
		        //         setDivShow.setAttribute('aria-expanded','true'); 
		        //         img.style.animation = "arrowRotateDown 0.25s 1 forwards ease-in";
		        //     }else{console.log("进入img判断2222");
		        //         setDivShow.setAttribute('aria-expanded','false');
		        //         img.style.animation = "arrowRotateUp 0.25s forwards ease-out";
		        //     }
		        // }
		        // if (nextSbl){
		        // 	let ariaHidden = nextSbl.getAttribute('aria-hidden');
		        //     if (ariaHidden == 'true'){       
		        //         nextSbl.setAttribute('aria-hidden','false'); 
		        //         nextSbl.style.maxHeight = '715px';
		        //         nextSbl.style.transition = "max-height 0.25s ease";
		        //     }else{
		        //         nextSbl.setAttribute('aria-hidden','true');
		        //         nextSbl.style.maxHeight = '0px';
		        //         nextSbl.style.transition = "max-height 0.25s ease";

		        //     }
		        // }
			// }
	// 	});
	// });

	for(let i=1;i<6;i++){
		$("#menuThreeSelected"+i).click(function() {
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
