<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="content"  value="${pageContext.request.contextPath}"/>

<script type="text/javascript">
	var basePath = 'http://' + location.host + '${content}'; 
	var flag = "false";
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title> 报价 </title>
  <meta charset="utf-8">
  <meta name="Generator" content="EditPlus">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
   <link href='./bootstrap-3.3.7/css/bootstrap-select.min.css' rel='stylesheet'>
   <link href='./bootstrap-3.3.7/css/bootstrap-datetimepicker.min.css' rel='stylesheet'>
   <link rel="stylesheet" href="./bootstrap-3.3.7/css/bootstrap.min.css">
   <link rel="stylesheet" href="bootstrap/plugins/bootstrap-table/bootstrap-table.min.css" />
	<link rel="stylesheet" href="resources/css/AdminLTE.min.css" />
	<link rel="stylesheet" href="resources/css/skins/_all-skins.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	<!-- Ionicons -->
	 <link rel="icon" type="image/png" href="/img/logo002.png" sizes="32x32"> 
	<!--   <link rel="icon" type="image/png" href="https://www.ft.com/__origami/service/image/v2/images/raw/http%3A%2F%2Fstatic.ftchinese.com%2Fimg%2Ffriend-share-icon.jpg?source=ftchinese&amp;width=32&amp;height=32" sizes="32x32">--> 
	<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
	<link rel="stylesheet" href="resources/css/my.css" />
	<link rel="stylesheet" href="bootstrap/plugins/validator/css/bootstrapValidator.min.css" />
	<link rel="stylesheet" type="text/css" href="./sweetAlert/css/sweet-alert.css">
	
	<script src="jquery/jquery-3.3.1.min.js"></script>
   	<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery.serializeJSON.js"></script>
	<script src="bootstrap/plugins/bootstrap-table/bootstrap-table.min.js"></script>
	<script src="bootstrap/plugins/validator/js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="./bootstrap-3.3.7/js/bootstrap-select.min.js"></script>
	<script type="text/javascript" src="./bootstrap-3.3.7/js/moment-with-locales.js"></script>
	<script type="text/javascript" src="./bootstrap-3.3.7/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="./bootstrap-3.3.7/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript" src="./sweetAlert/js/sweet-alert.min.js"></script> 
	<script src="bootstrap/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
 </head>

 <body>
   <jsp:include page="userInfo.jsp"></jsp:include>
 
  <div class="container right-container" >

	<div class="row clearfix">
		<div class="col-xs-12 column center-section">
			<div class="row clearfix  search-section">
				<div class="col-md-12 column">
					<form id="formSearch" class="form-inline" role="form">
						<div class="form-group">
                            <label for="f1">日期</label>
                            <div class='input-group date' id='quoteDateStart'>  
                                <input type='text' name="quoteDateStart" class="form-control"/>  
                                <span class="input-group-addon">  
                                    <span class="glyphicon glyphicon-calendar"></span>  
                                </span>  
                            </div> 
                            &nbsp-&nbsp
                            <div class='input-group date' id='quoteDateEnd'>  
                                <input type='text' class="form-control" name="quoteDateEnd"/>  
                                <span class="input-group-addon">  
                                    <span class="glyphicon glyphicon-calendar"></span>  
                                </span>  
                            </div> 
                        </div>
                        
                        <div class="form-group">
							<label for="f1">询价内容</label>
							<input type="text" class="form-control" id="inquiryContent" placeholder="询价内容" name="inquiryContent"/>
						</div>
						<div class="form-group btn-section">
							<button type="button" id="btn_query" class="btn btn-primary">查询</button>
							<input type="button" value="新增报价"  id="btn"  class="btn btn-success" />
							<input type="button" value="清空"  id="btn_rest"  class="btn btn-warning"/> 
						</div>
					</form>
				</div>
			</div>
			
			<div class="table-section">
                <div class="table-detail-section">
                    <table id="quoteTable">
                     </table>
                </div>
            </div>
			<div id="modal" class="modal fade">
		        <div class="modal-dialog">
		            <div class="modal-content">
		                <div class="modal-header user-header">
		                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		                    <h4 class="modal-title"></h4>
		                </div>
		                <div class="modal-body">
		                	<form id="addQuote">
		                	
		                		<div>
		                			<div class="modal-title-section">
		                				<div class="leftFloat modal-word">报价日期</div> 
		                				<div class="rightFloat modal-input">
											<div class='input-group date' id='quoteDate1' name="quoteDate1" >  
												<input type='text' class="form-control"/>  
												<span class="input-group-addon">  
													<span class="glyphicon glyphicon-calendar"></span>  
												</span>  
											</div> 
										</div>
										<div class="clearFloat"></div>
									</div>
									<div class="modal-title-section">
		                				<div class="leftFloat modal-word">选择机构</div> 
		                				<div class="rightFloat modal-input">
											<select id="slpk" name="ids"  class="selectpicker show-tick show-menu-arrow" multiple data-live-search="true"></select>
										</div>
										<div class="clearFloat"></div>
									</div>
		                			
		                		</div>
		                		 
			                    <table class="table">
											<thead>
												<tr>
													<th>7D</th>
													<th>14D</th>
													<th>1M</th>
													<th>2M</th>
													<th>3M</th>
													<th>6M</th>
													<th>1Y</th>
													<!-- <th>询价内容</th> -->
												</tr>
												<tr>
													<td>
														<div class="form-group">
															<input type="text" name="ratesevenday" size="3"/>
														</div>
													</td>
													<td>
														<div class="form-group">
															<input type="text" name="ratefourteenday" size="3"/>
														</div>
													</td>
													<td>
														<div class="form-group">
															<input type="text" name="rateonemonth" size="3"/>
														</div>
													</td>
													<td>
														<div class="form-group">
															<input type="text" name="ratetwomonth" size="3"/>
														</div>
													</td>
													<td>
														<div class="form-group">
															<input type="text" name="ratethreemonth" size="3"/>
														</div>
													</td>
													<td>
														<div class="form-group">
															<input type="text" name="ratesixmonth" size="3"/>
														</div>
													</td>
													<td>
														<div class="form-group">
															<input type="text" name="oneyear" size="3"/>
														</div>
													</td>
				<!-- 									<td>
														<div class="form-group">
															<input type="text" name="inquiryContent" size="12"/>
														</div>
													</td> -->
													<td style="display: none;">
														<div class="form-group">
															<input type=hidden name="inquiryid" size="10"/>
														</div>
													</td>
												</tr>
											</thead>
										</table>
		                    </form>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
		                    <button type="button" class="btn btn-info submit" id="validateBtn">提交</button>
		                </div>
		            </div><!-- /.modal-content -->
		        </div><!-- /.modal-dialog -->
		    </div><!-- /.modal -->
			
		</div>
		<div class="col-xs-12  column inquiry-record-section">
			<div class="record-section">
			<div class="tabbable" id="tabs-207310">
				<ul class="nav nav-tabs">
					<li>
						 <a id="inquiryRecord" href="#panel-685775" data-toggle="tab">询价记录</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="record-list" id="panel-685775">
					  <form id="formSearchInquiry" class="form-inline" role="form">
							<div class="form-group">日期</div>
							<div class="form-group">
								<div class='input-group date' id='inquiryDateStart' >  
									<input id='inquiryStartDate' type='text' class="form-control" style="width:110px"/>  
									<span class="input-group-addon">  
										<span class="glyphicon glyphicon-calendar"></span>  
									</span>  
								</div> 
								&nbsp-&nbsp
								<div class='input-group date' id='inquiryDateEnd'>  
									<input id='inquiryEndDate' type='text' class="form-control" style="width:110px"/>  
									<span class="input-group-addon">  
										<span class="glyphicon glyphicon-calendar"></span>  
									</span>  
								</div> 
							</div>
							
							<div class="form-group">
							<button type="button" id="btn_queryInquiry" class="btn btn-primary" >查询</button>
							<button class="btn btn-success" type="button" id="refresh" name="refresh" >
								刷新
							</button>
							</div>
						</form>
						
					  <div>  <!-- include table start -->
						<table id="inquiryTable"
							   data-height="600"
                               data-pagination="true"
                               data-side-pagination="client"
                               data-page-number="1"
                               data-page-size="10"
                               data-page-list="[10, 25, 50, 100, All]"
                               data-striped="true"
                               data-show-header="true"
                               data-query-params="queryParamsInquiry"
                               data-toolbar=".toolbar">
				            <thead>
				            <tr>
				                <th data-field="inquirycontent">询价内容</th>
				                <th data-field="id" data-visible="false" id="inquiryid" name="inquiryid"></th>
				                <th data-field="inquirydate" data-formatter="dateFormatter">询价日期</th>
				            </tr>
				            </thead>
				        </table>
					</div>  <!-- include table end -->
					
							</div> <!-- panel-685775 end -->
					
					</div>
				</div>
			</div>
			</div>
		</div>
	</div>
</div>

<script>
		//对Date的扩展，将 Date 转化为指定格式的String
		// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
		// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
		// 例子： 
		// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
		// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
		Date.prototype.Format = function (fmt) { //author: meizz 
		    var o = {
		        "M+": this.getMonth() + 1, //月份 
		        "d+": this.getDate(), //日 
		        "h+": this.getHours(), //小时 
		        "m+": this.getMinutes(), //分 
		        "s+": this.getSeconds(), //秒 
		        "q+": Math.floor((this.getMonth() + 3) / 3),
		        "S": this.getMilliseconds() //毫秒 
		    };
		    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
		    for (var k in o)
		    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		    return fmt;
		}
		var API_URL_Collection = basePath + '/showCollectionList';
		$(function () {  
			$('#quoteDateStart').datetimepicker({ 
				language: 'zh-CN',
				minView: "month",//设置只显示到月份
				format : "yyyy-mm-dd",//日期格式
				autoclose:true,//选中关闭
				//clearBtn:true,
				todayBtn: true,//今日按钮 
				locale: moment.locale('zh-cn'),
				todayHighlight:true,
				pickerPosition:'bottom-left'
			});  
			
			
			$('#quoteDateEnd').datetimepicker({ 
				language: 'zh-CN',
				minView: "month",//设置只显示到月份
				format : "yyyy-mm-dd",//日期格式
				autoclose:true,//选中关闭
				todayBtn: true,//今日按钮 
				locale: moment.locale('zh-cn'),
				todayHighlight:true,
				pickerPosition:'bottom-left'
			});  
			
			var date = new Date();
			$("#quoteDateStart").data("datetimepicker").setDate(date);
			$("#quoteDateEnd").data("datetimepicker").setDate(date);
			
			$('#quoteDate1').datetimepicker({
				language: 'zh-CN',
				minView: "month",//设置只显示到月份
				format : "yyyy-mm-dd",//日期格式
				autoclose:true,//选中关闭
				todayBtn: true,//今日按钮 
				locale: moment.locale('zh-cn'),
				todayHighlight:true,
				pickerPosition:'bottom-left'
			});  
			$("#quoteDate1").data("datetimepicker").setDate(date);

			$('#inquiryDateStart').datetimepicker({
				onClose: function() {  
			        if ($("#inquiryDateStart").val() == "") {  
			            $.datepicker._clearDate(this);  
			        }  
			    },  
				language: 'zh-CN',
				minView: "month",//设置只显示到月份
				format : "yyyy-mm-dd",//日期格式
				autoclose:true,//选中关闭
				todayBtn: true,//今日按钮 
				locale: moment.locale('zh-cn'),
				todayHighlight:true,
				pickerPosition:'bottom-left'
			});  
			
			$('#inquiryDateEnd').datetimepicker({
				language: 'zh-CN',
				minView: "month",//设置只显示到月份
				format : "yyyy-mm-dd",//日期格式
				autoclose:true,//选中关闭
				todayBtn: true,//今日按钮 
				locale: moment.locale('zh-cn'),
				todayHighlight:true,
				pickerPosition:'bottom-left'
			});  
			$("#inquiryDateStart").data("datetimepicker").setDate(date);
			$("#inquiryDateEnd").data("datetimepicker").setDate(date);
			
		    $(".selectpicker").selectpicker({  
		            noneSelectedText : '不选为公开报价'//默认显示内容  
		    });  
		    
		    $(window).on('load', function() {  
	            $('.selectpicker').selectpicker('refresh');  
	            $('.selectpicker').selectpicker('val', '');  
	        }); 
		    
		    loadDropDown();
	        
		}); 
		
		function dateFormatter(value){
			if (value == null) {
                return "";
            }
            var dateVal = value + "";
            var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
            return date.Format("yyyy-MM-dd");
		}
		
		function loadDropDown(){
			var API_URL_Collection = basePath + '/showCollectionList';
			
			//下拉数据加载  
	        $.ajax({  
	            url : API_URL_Collection,
				//method : "GET",
				contentType : "application/json",
				dataType : "json",
				data :  {
					Collection: "",
			    },
				async : false,
	            success : function(data) {//返回list数据并循环获取  
	                var select = $("#slpk"); 
	                $.each(data, function (i, n) { 
	                    select.append("<option value='"+n.id+"'>"  
	                            + n.corpshortname + "</option>"); 
	                  })    
	            }  
	        });  
			
		}
		
		$("#refresh").click(function(){
			$("#inquiryTable").bootstrapTable('refresh', queryParams);
		});
		//
		var $table = $('#quoteTable');
		function initTable() {
			$table.bootstrapTable({
				locale: moment.locale('zh-cn'),
				method: 'post',
				contentType: "application/x-www-form-urlencoded",
		        url: 'equote/equoteS',
		        dataField : "data",
		        toolbar: '#toolbar',    //工具按钮用哪个容器
		        striped: true,
		        height:600,
		        pagination: true,
		        singleSelect: true,
		        pageSize:10,
		        pageNumber:1,      //初始化加载第一页，默认第一页
		        pageList: [10, 20, 50, 100],
		        //search: true, //不显示 搜索框
		        striped: true,//隔行变色
		        strictSearch: true,
		        //showExport: true,//显示导出按钮  
		        showRefresh: true,     //是否显示刷新按钮
		        showToggle:true,     //是否显示详细视图和列表视图的切换按钮
		        cardView: false,     //是否显示详细视图
		        showColumns: true, //不显示下拉框（选择显示的列）
		        sidePagination: "client", //服务端请求
		        queryParams: queryParams,
		        minimunCountColumns: 2,
		        columns: [{
		            field: 'quotedate',
		            title: '报价日期',
		            width: 120,
		            align: 'center',
		            valign: 'top',
		            sortable: false,
		            formatter: function (value, row, index) {
		                if (value == null) {
		                    return "";
		                }
		                var dateVal = value + "";
		                var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
		                return date.Format("yyyy-MM-dd");
		            }
		        },{
		            field: 'ratesevenday',
		            title: '7天',
		            width: 80,
		            align: 'center',
		            valign: 'top',
		            sortable: false
		        },{
		            field: 'ratefourteenday',
		            title: '14天',
		            width: 80,
		            align: 'center',
		            valign: 'top',
		            sortable: false
		        },{
		            field: 'rateonemonth',
		            title: '1月',
		            width: 80,
		            align: 'center',
		            valign: 'top',
		            sortable: false
		        },{
		            field: 'ratetwomonth',
		            title: '2月',
		            width: 80,
		            align: 'center',
		            valign: 'top',
		            sortable: false
		        },{
		            field: 'ratethreemonth',
		            title: '3月',
		            width: 80,
		            align: 'center',
		            valign: 'top',
		            sortable: false
		        },{
		            field: 'ratesixmonth',
		            title: '6月',
		            width: 80,
		            align: 'center',
		            valign: 'top',
		            sortable: false
		        },{
		            field: 'oneyear',
		            title: '1年',
		            width: 80,
		            align: 'center',
		            valign: 'top',
		            sortable: false
		        },{
		            field: 'inquirycontent',
		            title: '询价内容',
		            width: 100,
		            align: 'center',
		            valign: 'top',
		            sortable: false
		        },{
		            field: 'quotetype',
		            title: '报价类型',
		            width: 120,
		            align: 'center',
		            valign: 'top',
		            sortable: false, 
		            formatter:function(value,row,index){
		            	if(null != value && value=='public'){
		            	var e = '广播报价';
		            	}
		            	if(null != value && value=='private'){
	                    var e = '<a id='+row.id+' + onmouseover="showBank(\''+ row.id + '\')" + onmouseout="hideBank(\''+ row.id + '\')">机构报价</a> ';  
		            	}
		            	if(null != value && value=='toInquiry'){
	                    var e = '<a id='+row.id+' onmouseover="showBank(\''+ row.id +'\')" + onmouseout="hideBank(\''+ row.id + '\')">询价报价</a> ';  
		            	}
                        return e;  
                    } 
		          
		        }],
		        formatNoMatches: function(){
		            return "没有相关的匹配结果";
		        },
		        formatLoadingMessage: function(){
		            return "请稍等，正在加载中。。。";
		        },
		        pagination:true,
		        onLoadSuccess:function(){
		        },
		        onLoadError: function () {
		        	 //alert("你没有此模块权限！");
					swal({ 
						  title: "哎呦", 
						  text: "您没有此模块权限，稍后将返回原页面", 
						  type: "error", 
						  showConfirmButton: true 
						},
						function(){ 
			         		window.history.back();
						});
		        }
		        
		    });
			
		}

		//查询参数
		function queryParams(params) {
			var quoteDateStart = $("#quoteDateStart").find("input").val();
			var quoteDateEnd = $("#quoteDateEnd").find("input").val();
			var inquiryContent = $("#inquiryContent").val();
		    return {
		        pageSize: params.limit,
		        currentPage: params.offset/params.limit + 1,
		        inquiryContent:inquiryContent,
		        quoteDateStart:quoteDateStart,
		        quoteDateEnd:quoteDateEnd,
		    };
		}
		
		
		//查询银行参数
		function queryParamsBank() {
		    return {
		        bankName: $("#inquiryBankName").val(),
		    };
		} 
		
		//查询询价参数
		function queryParamsInquiry() {
			var inquiryDateStart =  $("#inquiryStartDate").val();
			var inquiryDateEnd =  $("#inquiryEndDate").val();
		    return {
		    	corpName:"",
		    	inquiryDateStart:inquiryDateStart,
		    	inquiryDateEnd:inquiryDateEnd,
		    };
		} 
		
		$(function() {
			var userInfo = '${userInfo.userloginname }';
			if(userInfo != null && userInfo.length > 0){
				//初始化表格
				initTable();
			}else{
				window.location.href = "${content}/index.jsp";
			}
			
			//查询按钮点击事件
			$("#btn_query").click(function() {
				var queryParams = JSON.stringify($("#formSearch").serializeJSON());
				$table.bootstrapTable('refresh', queryParams);
			});
			
		 	//重置按钮点击事件
			$("#btn_rest").click(function() {
				$("#inquiryContent").val("");
				$("#quoteDateStart").find("input").val("");
				$("#quoteDateEnd").find("input").val("");
			});
		 	
		 	
			//查询银行按钮点击事件
			$("#btn_queryBank").click( function() {
				var queryParams = queryParamsBank();
				$bankTable.bootstrapTable('refresh', queryParams);
			});
			

			//查询询价按钮点击事件
			$("#btn_queryInquiry").click( function() {
				var queryInquiryParams = queryParamsInquiry();
				$inquiryTable.bootstrapTable('refresh', queryInquiryParams);
			});
			
			$inquiryTable.bootstrapTable('refresh', queryParamsInquiry());
		});
		
		var $bankTable = $('#bankTable').bootstrapTable( {url: API_URL_Collection} );
		
		var API_URL_Inquiry = '${content}/inquiry/showInquiryLists';
		var $inquiryTable = $('#inquiryTable').bootstrapTable( 
			 {
				 url: API_URL_Inquiry,
				 formatNoMatches: function(){
				    return "没有相关的匹配结果";
				 },
				 formatLoadingMessage: function(){
				    return "请稍等，正在加载中。。。";
				 } 
			 });
		
		
		$modal = $('#modal').modal( {show: false} );

  //解析报价字符串
 function addQuote(){
     //var dataJson = JSON.stringify($('#addQuote').serializeJSON());
     var dataJson = {};
     $modal.find('input[name]').each(function () {
     	dataJson[$(this).attr('name')] = $(this).val();
     });
     
     var quoteDate1 =  $("#quoteDate1").data("datetimepicker").getDate().Format("yyyy-MM-dd");
     dataJson["quotedate"] = quoteDate1;
     
     var ids =  $("#slpk").val();
     dataJson["ids"] = ids;
     
    /*  var quotetype =  $("#quoteType").val(); */
    if(flag == "false"  &&  (ids == null || ids.length ==0)){
	     dataJson["quotetype"] = "public";
    }else if(flag =="false" && ids.length > 0){
	     dataJson["quotetype"] = "private";
    }else if(flag == "true"){
    	dataJson["quotetype"] = "toInquiry";
    }
 
     $.ajax({
			url : "equote/insert",
			method : "POST",
			contentType : "application/json",
			dataType : "json",
			data : JSON.stringify(dataJson),
			async : false,
			success : function(data) {
				if (data.success) {
					$modal.modal('hide');
					$("#slpk").empty();
	                loadDropDown();
					$("#slpk").selectpicker('refresh');
					$("#quoteTable").bootstrapTable('refresh'); 
	                $('#addQuote').data('bootstrapValidator').resetForm(true);
					flag = "false";
				} else {
					//Dialog.alert("操作失败");
				}
			},
			error : function(XMLHttpRequest, textStatus,
					errorThrown) {
				var result = JSON
						.parse(XMLHttpRequest.responseText);
				box.warnBox({
					//"content" : result.errorMessage
				});
			}
		});
  }
  //当模态框隐藏时，展示所有机构
 $('#modal').on('hidden.bs.modal', function () {
	  // 执行一些动作...
	 $("#slpk").empty();
     loadDropDown();
	 $("#slpk").selectpicker('refresh');
})

 //新增询价
 function addInquiry() {
	 var list= $("#inquiryTable").bootstrapTable('getSelections');
	 var ids = "";
 	  for (var i = 0;i <= list.length; i++ ){
 		var obj = list[i];
 		 for(var j in obj){    
	        var property=obj[j];
	        if(j == 'id' && i != 0 ){
   		        ids = property + "," + ids;  
	        }else if(j == 'id' && i == 0){
	        	ids = property + ids;
	        }
	    }  
 	 } 
 	 //console.log("内容" + $("#message").val());
 	
 	var dataJson = '{"inquirycontent":"' + $("#message").val() + '","ids":"' + ids + '"}';
 	//console.log("json" + dataJson);
     $.ajax({
			url : "equote/insert",
			method : "POST",
			contentType : "application/json",
			dataType : "json",
			data : dataJson,
			async : true,
			success : function(data) {
				if (data.success) {
					//console.log("操作成功");
					$("#bankTable").bootstrapTable('refresh');
				} else {
					//Dialog.alert("操作失败");
				}
			},
			error : function(XMLHttpRequest, textStatus,
					errorThrown) {
				var result = JSON
						.parse(XMLHttpRequest.responseText);
				box.warnBox({
					//"content" : result.errorMessage
				});
			}
		});
  }
  
   var oBtn = document.getElementById('btn');
   //var oDiv = document.getElementById('newAddEquote');
   oBtn.onclick=function(){
	   loadDropDown();
	   $('.selectpicker').selectpicker('val', '');  
	   showModal("新增报价");
   };
   
   function showModal(title, row) {
       row = row || {
           id: '',
           name: '',
           stargazers_count: 0,
           forks_count: 0,
           description: ''
       }; // default row value

       $modal.data('id', row.id);
       $modal.find('.modal-title').text(title);
       for (var name in row) {
           $modal.find('input[name="' + name + '"]').val(row[name]);
       }
       $modal.modal('show');
   }
</script>
<script type="text/javascript">
$(function () {
	$('#addQuote').bootstrapValidator({
	//  live: 'disabled',
	message : 'This value is not valid',
	feedbackIcons: {
		valid : 'glyphicon glyphicon-ok',
		invalid: 'glyphicon glyphicon-remove',
		validating: 'glyphicon glyphicon-refresh'
		},
		fields : {
			corpid : {
				validators : {
					notEmpty : {
						message : '机构不能为空'
					}
				}
			},
			ratesevenday: {
                validators: {
                	 numeric: {
                         message: '只能填写数字'
                     }
                }
            },
			ratefourteenday: {
                validators: {
                	 numeric: {
                         message: '只能填写数字'
                     }
                }
            },
			rateonemonth: {
                validators: {
                	 numeric: {
                         message: '只能填写数字'
                     }
                }
            },
			ratetwomonth: {
                validators: {
                	 numeric: {
                         message: '只能填写数字'
                     }
                }
            },
			ratethreemonth: {
                validators: {
                	 numeric: {
                         message: '只能填写数字'
                     }
                }
            },
			ratesixmonth: {
                validators: {
                	 numeric: {
                         message: '只能填写数字'
                     }
                }
            },
            oneyear: {
                validators: {
                	 numeric: {
                         message: '只能填写数字'
                     }
                }
            },
            inquiryContent: {
                validators: {
                	notEmpty : {
						message : '机构不能为空'
					}
                }
            }
		
		}
	});
});	


</script>
<script type="text/javascript">
	//新增机构用户
	//$("#addQuote").submit(function(ev){ev.preventDefault();});
	$(".submit").on("click", function(){
	
	   var bootstrapValidator = $("#addQuote").data('bootstrapValidator');
	   bootstrapValidator.validate();
	   if(bootstrapValidator.isValid()) {
		   addQuote();
	   }  
	   else return;
	});
	
</script>
<script type="text/javascript">
	
	//询价记录单击事件
	$('#inquiryRecord').click();
	$('#inquiryTable').on(
			'click-cell.bs.table',
			function(field, value, row, element) {
				$("#inquiryContent").val(element['inquirycontent']);
				var queryParams = JSON.stringify($("#formSearch").serializeJSON());
				$table.bootstrapTable('refresh', queryParams);
			});

	$('#inquiryTable').on(
			'dbl-click-cell.bs.table',
			function(field, value, row, element) {

				row = row || {
					id : '',
					name : '',
					stargazers_count : 0,
					forks_count : 0,
					description : ''
				}; // default row value

				$modal.data('id', row.id);
				$modal.find('.modal-title').text("新增报价");
				for ( var name in row) {
					$modal.find('input[name="' + name + '"]').val(row[name]);
				}
				$modal.find('input[name="inquiryid"]').val(element.id);

				$("#slpk").empty();

				$("#slpk").attr("data-live-search", "false");
				$("#slpk").append(
						"<option value='"+element.corpid+"'>"
								+ element.corpshortname + "</option>");
				$("#slpk").selectpicker('refresh');

				$("#slpk").selectpicker('val', element.corpid);

				flag = "true";
				$modal.modal('show');
			});
</script>
<script type="text/javascript">

	//隐藏弹出层
	function hideK() {
		document.getElementById("NG2").style.display = "none";
	}
	//双击查看当前报价的机构
	function showBank(id) {
		var API_URL_Bank = '${content}/equote/corpSelect';
		$.ajax({
			url : API_URL_Bank,
			type : 'post',
			data : {
				id : id
			},
			cache : false,
			success : function(data) {//返回list数据并循环获取  
				var ng = $("#NG2");
				$('#div2 ul li').each(function() {
					$(this).remove();
				});
				$.each(data, function(i, n) {
					ng.append('<li>' + n.corpname + '</li>');
				})
				var position = $('#' + id).offset();
				$("#div2").offset({
					top : position.top + 20,
					left : position.left - 15
				});

				document.getElementById("NG2").style.display = "block";
				$("#NG2").toggleClass("open1");
			}
		});
	}
	function hideBank(id) {
		if (document.getElementById("NG2").style.display == "block") {
			document.getElementById("NG2").style.display = "none";
		}

	}
	
/* 	var screenH=document.body.clientHeight;
	console.log(screenH);
	var searchSectionH= $(".search-section").height();
	var navigationH= $(".navigation").height();
	console.log(searchSectionH);
	var diffH = screenH-searchSectionH-navigationH-80;
	$(".table-section").height(screenH-searchSectionH-navigationH-80); */
	/* $(".table-detail-section").height(screenH-searchSectionH-navigationH-10); */
	/*   $(".fixed-table-container").height(screenH-navigationH-550);   */
	
	/*  $(window).resize(function () {          
		    screenH=document.body.clientHeight;
			 searchSectionH= $(".search-section").height();
			 navigationH= $(".navigation").height();
		     diffH = screenH-searchSectionH-navigationH-80;
		     console.log(diffH);    
	 }); */
	
/* 	 var inquiryTableH = screenH-navigationH-80;
	 $("#inquiryTable").attr('height',300);
	 $(".inquiry-record-section").height(screenH-navigationH);
	 $(".record-section").height(screenH-navigationH-20); */
	 
</script>
</body>
 <!-- 弹出层 -->
<div id="div2">
  <ul class="close1" id="NG2" >
  </ul>
</div>

</html>
