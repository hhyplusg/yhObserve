<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="content"  value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	var basePath = 'http://' + location.host + '${content}'; 
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title> 询价 </title>
  <meta charset="utf-8">
  <meta name="Generator" content="EditPlus">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <link rel="icon" type="image/png" href="/img/logo002.png" sizes="32x32">
  <link href='./bootstrap-3.3.7/css/bootstrap-select.min.css' rel='stylesheet'>
  <link href='./bootstrap-3.3.7/css/bootstrap-datetimepicker.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="./bootstrap-3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="bootstrap/plugins/bootstrap-table/bootstrap-table.min.css" />
	<link rel="stylesheet" href="resources/css/AdminLTE.min.css" />
	<link rel="stylesheet" href="resources/css/skins/_all-skins.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	<!-- Ionicons -->
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
 
  <div class="container  right-container">

	<div class="row clearfix">
		<div class="col-xs-12 column center-section fullHeight" id="fullHeight">
			<div class="row clearfix search-section">
				<div class="col-md-12 column">
					<form id="formSearch" class="form-inline" role="form">
						<div class="form-group">
							<label for="f1">银行名称</label>
							<input type="text" class="form-control bankName" id="bankName" placeholder="银行名称"/>
						</div>
						
						<div class="inquiry-content form-group">
							<label for="inquiryContent">询价内容</label>
							<input type="text" class="form-control inquiryContent" id="inquiryContent" placeholder="询价内容" name="inquiryContent"/>
						
						</div>
						
						<div class="form-group">
							<label for="f1">日期</label>
							<div class='input-group date' id='quoteDateStart'>  
								<input type='text' class="form-control quoteDate"/>  
								<span class="input-group-addon">  
									<span class="glyphicon glyphicon-calendar"></span>  
								</span>  
							</div> 
							&nbsp-&nbsp
							<div class='input-group date' id='quoteDateEnd'>  
								<input type='text' class="form-control quoteDate"/>  
								<span class="input-group-addon">  
									<span class="glyphicon glyphicon-calendar"></span>  
								</span>  
							</div> 
						</div>
						
						<div class="form-group btn-section">
							<button type="button" id="btn_query" class="btn btn-primary" >查询</button>
							<input type="button" value="新增报价"  id="add"  class="btn btn-success" />
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
		        <div class="modal-dialog" >
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
											<select id="slpk" name="corpid" class="selectpicker" data-live-search="true" multiple></select>
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
												</tr>
												
											</thead>
										</table>
		                    </form>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
		                    <button type="button" class="btn btn-info submit" id="addSubmitBtn">提交</button>
		                </div>
		            </div><!-- /.modal-content -->
		        </div><!-- /.modal-dialog -->
		    </div><!-- /.modal -->
			<br>
		</div>
		<div class="col-xs-12  column inquiry-record-section fullHeight" id="fullHeight1">
		  <div class="record-section">
			<div class="tabbable" id="tabs-207310">
				<ul class="nav nav-tabs">
					<li>
						 <a href="#panel-685775" data-toggle="tab">询价记录</a>
					</li>
					<li class="active">
						 <a href="#panel-703226" data-toggle="tab">我要询价</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="record-list tab-pane" id="panel-685775">
						<form id="formSearchInquiry" class="form-inline" role="form">
						    <div class="form-group">日期</div>
							<div class="form-group">
								<div class='input-group date' id='inquiryDateStart' name='inquiryDateStart'>  
									<input type='text' class="form-control" style="width:110px"/>  
									<span class="input-group-addon">  
										<span class="glyphicon glyphicon-calendar"></span>  
									</span>  
								</div> 
								&nbsp-&nbsp
								<div class='input-group date' id='inquiryDateEnd'>  
									<input type='text' class="form-control" style="width:110px"/>  
									<span class="input-group-addon">  
										<span class="glyphicon glyphicon-calendar"></span>  
									</span>  
								</div> 
							</div>
							<div class="form-group">
							<button type="button" id="btn_queryInquiry" class="btn btn-primary">查询</button>
							<button class="btn btn-success" type="button" id="refresh" name="refresh" >刷新</button>
							</div>
					    </form>
					    <div>
						
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
					                <th data-field="inquiryTarget"
					                    data-align="left"
					                    data-visible="false" 
					                    data-formatter="actionFormatter"
					                    data-events="actionEvents">询价对象</th>
					                <th data-field="inquirydate" data-formatter="dateFormatter">询价日期</th>
					            </tr>
					            </thead>
					        </table>
					    </div>
					</div>
					<div class="record-list tab-pane active" id="panel-703226">
						<form role="form" id="addInquiry">
							<div class="form-group">
								<label for="message">询价信息</label><input type="text" class="form-control" id="message" />
								<span id="errorMessage" style="display: none;"><font color='red'>询价信息不能为空</font></span>
							</div>
							<div class="form-group" >
								<label for="">询价银行：</label>
								<!-- <input type="text" class="form-control" id="inquiryBankName" placeholder="询价银行" style="width:150px"/> -->
								<div class="form-group">
									<select id="inquiryBankName" name="inquiryBankName"  class="selectpicker show-tick show-menu-arrow" multiple data-live-search="true" >
									</select>
								</div>
							</div>
							<button type="button" class="btn btn-info submit" id="insertQuiery" >提交</button>
						</form>
					</div>
				</div>
				</div>
			</div>
		  <div class="clearfloat"></div>
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
	Date.prototype.Format = function(fmt) { //author: meizz 
		var o = {
			"M+" : this.getMonth() + 1, //月份 
			"d+" : this.getDate(), //日 
			"h+" : this.getHours(), //小时 
			"m+" : this.getMinutes(), //分 
			"s+" : this.getSeconds(), //秒 
			"q+" : Math.floor((this.getMonth() + 3) / 3),
			"S" : this.getMilliseconds()
		//毫秒 
		};
		if (/(y+)/.test(fmt))
			fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		for ( var k in o)
			if (new RegExp("(" + k + ")").test(fmt))
				fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
						: (("00" + o[k]).substr(("" + o[k]).length)));
		return fmt;
	}
	var API_URL_Bank = basePath + '/showBankList';

	//左边日期控件
	$('#quoteDateStart').datetimepicker({
		language : 'zh-CN',
		minView : "month",//设置只显示到月份
		format : "yyyy-mm-dd",//日期格式
		autoclose : true,//选中关闭
		todayBtn : true,//今日按钮 
		locale : moment.locale('zh-cn'),
		todayHighlight : true,
		pickerPosition : 'bottom-left'
	});

	$('#quoteDateEnd').datetimepicker({
		language : 'zh-CN',
		minView : "month",//设置只显示到月份
		format : "yyyy-mm-dd",//日期格式
		autoclose : true,//选中关闭
		todayBtn : true,//今日按钮 
		locale : moment.locale('zh-cn'),
		todayHighlight : true,
		pickerPosition : 'bottom-left'
	});

	var date = new Date();
	$("#quoteDateStart").data("datetimepicker").setDate(date);
	$("#quoteDateEnd").data("datetimepicker").setDate(date);

	// 右边日期控件
	$('#inquiryDateStart').datetimepicker({
		language : 'zh-CN',
		minView : "month",//设置只显示到月份
		format : "yyyy-mm-dd",//日期格式
		autoclose : true,//选中关闭
		todayBtn : true,//今日按钮 
		locale : moment.locale('zh-cn'),
		todayHighlight : true,
		pickerPosition : 'bottom-left'
	});

	$('#inquiryDateEnd').datetimepicker({
		language : 'zh-CN',
		minView : "month",//设置只显示到月份
		format : "yyyy-mm-dd",//日期格式
		autoclose : true,//选中关闭
		todayBtn : true,//今日按钮 
		locale : moment.locale('zh-cn'),
		todayHighlight : true,
		pickerPosition : 'bottom-left'
	});
	$("#inquiryDateStart").data("datetimepicker").setDate(date);
	$("#inquiryDateEnd").data("datetimepicker").setDate(date);

	//刷新按钮
	$("#refresh").click(function() {
		$("#inquiryTable").bootstrapTable('refresh', queryParams);
	});

	$('#quoteDate1').datetimepicker({
		language : 'zh-CN',
		minView : "month",//设置只显示到月份
		format : "yyyy-mm-dd",//日期格式
		autoclose : true,//选中关闭
		todayBtn : true,//今日按钮 
		locale : moment.locale('zh-cn'),
		todayHighlight : true,
		pickerPosition : 'bottom-left'
	});
	$("#quoteDate1").data("datetimepicker").setDate(date);

	$(".selectpicker").selectpicker({
		noneSelectedText : '请选择'//默认显示内容  
	});

	$(window).on('load', function() {
		$('.selectpicker').selectpicker('refresh');
		$('.selectpicker').selectpicker('val', '');
	});

	function dateFormatter(value) {
		if (value == null) {
			return "";
		}
		var dateVal = value + "";
		var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(
				")/", ""), 10));
		return date.Format("yyyy-MM-dd");
	}
	//
	var $table = $('#quoteTable');
	function initTable() {
		$table.bootstrapTable({
			method : 'post',
			contentType : "application/x-www-form-urlencoded",
			url : 'equote/equoteM',
			dataField : "data",
			toolbar : '#toolbar', //工具按钮用哪个容器
			striped : true,
			height : 600,
			pagination : true,
			singleSelect : true,
			pageNumber : 1, //初始化加载第一页，默认第一页
			pageList : [ 10, 50, 100, 200, 500 ],
			//search: true, //不显示 搜索框
			striped : true,//隔行变色
			strictSearch : true,
			//showExport: true,//显示导出按钮  
			showRefresh : true, //是否显示刷新按钮
			showToggle : true, //是否显示详细视图和列表视图的切换按钮
			cardView : false, //是否显示详细视图
			showColumns : true, //不显示下拉框（选择显示的列）
			sidePagination : "client", //服务端请求
			queryParams : queryParams,
			minimunCountColumns : 2,
			columns : [
					{
						field : 'quotedate',
						title : '报价日期',
						width : 110,
						align : 'center',
						valign : 'top',
						sortable : true,
						formatter : function(value, row, index) {
							if (value == null) {
								return "";
							}
							var dateVal = value + "";
							var date = new Date(parseInt(dateVal.replace(
									"/Date(", "").replace(")/", ""), 10));
							return date.Format("yyyy-MM-dd");
						}
					}, {
						field : 'bjcorpname',
						title : '报价银行',
						width : 100,
						align : 'center',
						valign : 'top',
						sortable : false
					}, {
						field : 'quotetype',
						title : '报价类型',
						width : 100,
						align : 'center',
						valign : 'top',
						sortable : false,
						formatter : function(value, row, index) {
							if (null != value && value == 'public') {
								var e = '广播报价';
							} else if (null != value && value == 'private') {
								//var e = '<a id='+row.id+' + onclick="showBank(\''+ row.id + '\')">机构报价</a> ';  
								var e = '机构报价';
							} else if (null != value && value == 'toInquiry') {
								//var e = '<a id='+row.id+' onclick="showBank(\''+ row.id +'\')">询价报价</a> ';  
								var e = '询价报价';
							} else if (null != value && value == 'corpAdd') {
								//var e = '<a id='+row.id+' onclick="showBank(\''+ row.id +'\')">机构补录</a> '; 
								var e = '机构补录';
							}
							return e;
						}
					}, {
						field : 'ratesevenday',
						title : '7天',
						width : 80,
						align : 'center',
						valign : 'top',
						sortable : false
					}, {
						field : 'ratefourteenday',
						title : '14天',
						width : 80,
						align : 'center',
						valign : 'top',
						sortable : false
					}, {
						field : 'rateonemonth',
						title : '1月',
						width : 80,
						align : 'center',
						valign : 'top',
						sortable : false
					}, {
						field : 'ratetwomonth',
						title : '2月',
						width : 80,
						align : 'center',
						valign : 'top',
						sortable : false
					}, {
						field : 'ratethreemonth',
						title : '3月',
						width : 80,
						align : 'center',
						valign : 'top',
						sortable : false
					}, {
						field : 'ratesixmonth',
						title : '6月',
						width : 80,
						align : 'center',
						valign : 'top',
						sortable : false
					}, {
						field : 'oneyear',
						title : '1年',
						width : 80,
						align : 'center',
						valign : 'top',
						sortable : false
					}, {
						field : 'inquirycontent',
						title : '询价内容',
						width : 100,
						align : 'center',
						valign : 'top',
						sortable : false
					} ],
					formatNoMatches: function(){
			            return "没有相关的匹配结果";
			        },
			        formatLoadingMessage: function(){
			            return "请稍等，正在加载中。。。";
			        },
			onLoadSuccess : function() {
			},
			onLoadError : function() {

			}
		});
	}

	//查询参数
	function queryParams(params) {
		var quoteDateStart = $("#quoteDateStart").find("input").val();
		var quoteDateEnd = $("#quoteDateEnd").find("input").val();
		var inquiryContent = $("#inquiryContent").val();
		return {
			pageSize : params.limit,
			currentPage : params.offset / params.limit + 1,
			bankName : $("#bankName").val(),
			quoteDateStart : quoteDateStart,
			quoteDateEnd : quoteDateEnd,
			inquiryContent : inquiryContent,
		};
	}

	//查询银行参数
	function queryParamsBank() {
		return {
			bankName : $("#inquiryBankName").val(),
		};
	}

	//查询询价参数
	function queryParamsInquiry(params) {
		var inquiryDateStart = $("#inquiryDateStart").find("input").val();
		var inquiryDateEnd = $("#inquiryDateEnd").find("input").val();
		return {
			corpName : "",
			inquiryDateStart : inquiryDateStart,
			inquiryDateEnd : inquiryDateEnd,
		};
	}

	$(function() {
		var userInfo = '${userInfo.userloginname }';
		if (userInfo != null && userInfo.length > 0) {
			//初始化表格
			initTable();
		} else {
			window.location.href = "${content}/index.jsp";
		}
		
	});
	
	//加载询价银行数据：新增报价页面和我要询价页面  
	$.ajax({
		url : API_URL_Bank,
		//method : "GET",
		contentType : "application/json",
		dataType : "json",
		data : {
			bankName : "",
		},
		type : 'get',
		async : false,
		success : function(data) {//返回list数据并循环获取  
			// 新增报价页面,询价银行数据
			var selectInquiryBankName = $("#inquiryBankName");
			$.each(data, function(i, n) {
				selectInquiryBankName.append("<option value='" + n.id + "'>" + n.corpshortname + "</option>");
			});
			// 我要询价页面,询价银行数据
			var selectSlpk = $("#slpk");
			$.each(data, function(i, n) {
				selectSlpk.append("<option value='" + n.id + "'>" + n.corpshortname + "</option>");
			})
		},
		error : function() {
			swal({
				title : "没有权限",
				text : "您没有此模块权限，请联系管理员",
				type : "error",
				showConfirmButton : true
			}, function() {
				window.history.back();
			});
		}
	});
	
	//查询按钮点击事件
	$("#btn_query").click(function() {
		$table.bootstrapTable('refresh', queryParams);
	});

	//重置按钮点击事件
	$("#btn_rest").click(function() {
		$("#bankName").val("");
		$("#inquiryContent").val("");
		$("#quoteDateStart").find("input").val("");
		$("#quoteDateEnd").find("input").val("");
	});

	//查询询价按钮点击事件
	$("#btn_queryInquiry").click(function() {
		var queryInquiryParams = queryParamsInquiry();
		$inquiryTable.bootstrapTable('refresh', queryInquiryParams);
	});

	var API_URL_Inquiry = '${content}/inquiry/showInquiryList';
	var $inquiryTable = $('#inquiryTable').bootstrapTable({
		url : API_URL_Inquiry,
		formatNoMatches: function(){
		    return "没有相关的匹配结果";
		  },
		  formatLoadingMessage: function(){
		    return "请稍等，正在加载中。。。";
		  }
	});

	$modal = $('#modal').modal({
		show : false
	});

	//解析报价字符串
	function addQuote() {
		//var dataJson = JSON.stringify($('#addQuote').serializeJSON());
		var dataJson = {};
		$modal.find('input[name]').each(function() {
			dataJson[$(this).attr('name')] = $(this).val();
		});

		var quoteDate1 = $("#quoteDate1").data("datetimepicker").getDate().Format("yyyy-MM-dd");
		dataJson["quotedate"] = quoteDate1;

		var ids = $("#slpk").val();
		dataJson["ids"] = ids;

		$.ajax({
			url : "equote/insertByCorp",
			method : "POST",
			contentType : "application/json",
			dataType : "json",
			data : JSON.stringify(dataJson),
			async : false,
			success : function(data) {
				if (data.success) {
					$modal.modal('hide');
					$("#quoteTable").bootstrapTable('refresh');
					$('#addQuote').data('bootstrapValidator').resetForm(true);
				} else {

				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				var result = JSON.parse(XMLHttpRequest.responseText);
				box.warnBox({
				//"content" : result.errorMessage
				});
			}
		});
	}

	//新增询价
	function addInquiry() {
		console.log("调用开始：");
		//获取用户选择银行
		var ids = $("#inquiryBankName").val();
		console.info(ids);
		var dataJson = '{"inquirycontent":"' + $("#message").val()
				+ '","ids":"' + ids + '"}';
		// dataJson["ids"] = ids;
		console.log("json" + dataJson);
		$.ajax({
			url : "inquiry/insert",
			method : "POST",
			contentType : "application/json",
			dataType : "json",
			data : dataJson,
			async : true,
			success : function(data) {
				if (data.success) {
					console.log("操作成功");
					//$("#bankTable").bootstrapTable('refresh');
					$("#inquiryTable").bootstrapTable('refresh');
					$('.selectpicker').selectpicker('val', '');
					$("#message").val('');
				} else {
					//Dialog.alert("操作失败");
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				var result = JSON.parse(XMLHttpRequest.responseText);
				box.warnBox({
				//"content" : result.errorMessage
				});
			}
		});
	}

	$("#add").click(function() {
		$('.selectpicker').selectpicker('val', '');
		showModal("新增报价");
	});
	
	function showModal(title, row) {
		row = row || {
			id : '',
			name : '',
			stargazers_count : 0,
			forks_count : 0,
			description : ''
		}; // default row value

		$modal.data('id', row.id);
		$modal.find('.modal-title').text(title);
		for ( var name in row) {
			$modal.find('input[name="' + name + '"]').val(row[name]);
		}
		$modal.modal('show');
	}
	
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
	
	$("#message").blur(function(){
		var message=$("#message").val();
		if(message.length == 0){
			$("#errorMessage").show();
		}else{
			$("#errorMessage").hide();
		}
	});
	
	//新增机构用户
	//$("#addQuote").submit(function(ev){ev.preventDefault();});
	$("#addSubmitBtn").on("click", function(){
	   var bootstrapValidator = $("#addQuote").data('bootstrapValidator');
	   bootstrapValidator.validate();
	   if(bootstrapValidator.isValid()) {
		   addQuote();
	   } else {
		   return;
	   }
	});
	
	//$("#addInquiry").submit(function(ev){ev.preventDefault();});
	$("#insertQuiery").on("click", function() {
		var inquiryBankName = $("#inquiryBankName").val();
		var message = $("#message").val();
		if (message.length > 0) {
			addInquiry();
		} else {
			return;
		}
	});

	//询价对象
	function actionFormatter(row, index) {
		return '<a id=1 + onclick="showBank(1)">机构报价</a> ';
	}

	//双击查看当前报价的机构
	function showBank(id) {
		$.ajax({
			url : '${content}/equote/corpSelect',
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
					left : position.left
				});
				if (document.getElementById("NG2").style.display == "none") {
					document.getElementById("NG2").style.display = "block";
					$("#NG2").toggleClass("open1");
				} else if (document.getElementById("NG2").style.display == "block") {
					document.getElementById("NG2").style.display = "none";
				} else {
					$("#NG2").toggleClass("open1");
				}
			}
		});
	}
	
	$('#inquiryTable').on('click-cell.bs.table',
		function(field, value, row, element) {
			$("#inquiryContent").val(element['inquirycontent']);
			$table.bootstrapTable('refresh', queryParams);
		}
	);
	
	var screenH=document.body.clientHeight;
	console.log(screenH);
	$("#fullHeight").height(screenH-40); 
	$("#fullHeight1").height(screenH-40);
	$('#fullHeight1').attr('height',screenH);
	$('#fullHeight1').attr('background','red');
	
	var searchSectionH= $(".search-section").height();
	console.log(searchSectionH);
	
</script>
 </body>
</html>
