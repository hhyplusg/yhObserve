
import {EventObject,getUrlParams,isEmptyObj} from './api';

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
// "A11":{"indicatorId":"0001","windCode":[],"smooth":[] },

let onlineOrLocal=false;  
if (window.location.href=='http://localhost:3000/observesystem.html') {onlineOrLocal=true;}

	let expanders = document.querySelectorAll('.DiagramTitleThree');
	

	const expandToggle = function(event){
		let ariaExpanded= this.getAttribute('aria-expanded');
		let img = $(this).find('.right-img-three').get(0);
		let nextSbl = this.nextElementSibling;
		let id= this.getAttribute('id').replace('diagramThree','');	
		console.log(id);
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
					let id= ele.getAttribute('id').replace('diagramThree','');	
					let menuThreeCheck = $("#menuThreeCheck"+id);
					menuThreeCheck.attr('checked',true);
					// menuThreeCheck.prop("checked","checked");
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

	function defaultSelected(){

	}


    let diagramTitleThreeTength = expanders.length;
    

	for(let i=1;i<=diagramTitleThreeTength;i++){
		$("#menuThreeSelected"+i).click(function(e) {
			$("html, body").animate({
				scrollTop: $("#diagramThree"+i).offset().top 
			}, {duration: 500,easing: "swing"});
            // console.log($("#diagramThree"+i).offset().top );	
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
        // $(".create-comment-container").css('display','none');
		$(this).parent().parent().parent().css('display','none');
    });
    $(".create-comment-btn").click(function(){
		$(this).parent().parent().parent().find('.create-comment-container').css('display','block');
        // $(".create-comment-container").css('display','block');
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
		console.log('#comment-confirm')	;
		var key = $(this).parents().find('.DiagramAreaDiv2').attr('key');
		var commentWord = $(this).parentsUntil('.comment-box').find('.comment-word').val();
		var time = getFormatTime();
		console.log(time);
		var data = {
			'content':commentWord,
			'indicatorId':key
		}
		$.ajax({
			method: "POST",
			url: '/weekly/saveReview',
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
	});
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
			// $('.selected-index').append(option);
		}
	});
}

getSelectedData('0001','.selected-index');
getSelectedData('0002','.selected-citic-index');


	//checkbox对应图标展开操作
	// $("input[id^='menuTwoCheck']").each(function(){

	// });