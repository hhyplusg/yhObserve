<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="content"  value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	var basePath = 'http://' + location.host + '${content}'+ "/syscorpinforManager";
	var projectPath = 'http://' + location.host + '${content}'; 
</script>
<html>
<head>
</head>
<body>

	 <div class="navigation">
	    <div class="">
	        <div class="logo">
	            <span class="logoImg"></span>
	            <label id="page-title">向银行询价</label>
	        </div>
	        
	    </div>
	    <div class="hover-cls">
	        <div class="manager-section">
	                <label  class="manager"></label>
	                <label id="userInfo"></label>
	                <label id="triangle-down"></label>
	        </div>
	
	   		<ul class="drop-down" id="user" >
	   			<li>
	   				<a href="#" id="editPassword">修改密码</a>
	   			</li>
	   			<li class="divider">
	   			</li>
	   			<li>
	   				<a href="#" id="loginOut">注销登录</a>
	   			</li>
	   		</ul>
	
	    </div>
	 </div>
	  
	<dir class="container"> 
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header user-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">修改密码</h4>
                </div>
                <div class="modal-body">
               		<form id="changePwdForm">
						<div class="form-group">
	                        <input type="hidden" name="id"  value="${userInfo.id}" class="form-control">
	                    </div>
	                    <div class="form-group">
	                        <label for="oldPassword">原密码</label>
	                        <input type="password" name="oldPassword" class="form-control" id="oldPassword" placeholder="请输入原密码">
	                    </div>
	                    <div class="form-group">
	                        <label for="password">新密码</label>
	                        <input type="password" name="password" class="form-control" id="password" placeholder="请输入新密码">
	                    </div>
	                    <div class="form-group">
	                        <label for="confirmPassword">确认密码</label>
	                        <input type="password" name="confirmPassword" class="form-control" id="confirmPassword" placeholder="请再次输入新密码">
	                    </div>
		             </form>
	            </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal"></span>关闭</button>
                    <button type="button" id="btn_submit" class="btn btn-info" ></span>确定</button>
                </div>
            </div>
        </div>
    </div>
	</dir>
</body>
<script type="text/javascript">
	
	$("#loginOut").click(function(){
		$.ajax({
			url: basePath+"/loginOut",
			type: 'POST',
			success: function(){
				window.location.href = projectPath+"/index.jsp";
			}
		});
	});
	$(function(){
		var pathName = location.pathname;
		if(pathName.indexOf('inquiry')>=0){
			$("#page-title").text('向银行询价');
		}else if(pathName.indexOf('equote')>=0){
			$("#page-title").text('向机构报价');
		}else if(pathName.indexOf('manager')>=0){
			$("#page-title").text('用户管理');
		}
		
		var userInfo = '${userInfo.corpname }';
		if(userInfo != null && userInfo.length > 0){
			$("#userInfo").text('欢迎您，'+'${userInfo.corpname }');
			//$("#userOperation").show();
		}else{
			$("#user").empty();
			$("#user").append("<div class='col-lg-5  pull-right'><a style='text-align: right;margin-top:25px;margin-right:50px;' class='pull-right' href=${content }/index.jsp><strong  > 去 登  录 </strong> </a></div>");
		}
	});
	$("#editPassword").click(function(){
		$("#myModalLabel").text("修改密码");
		$('#myModal').modal();
	});
	
	var id = ${userInfo.id};
	$('#changePwdForm').bootstrapValidator({
		//  live: 'disabled',
		message : '值',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			oldPassword : {
				validators : {
					remote : {
						url : basePath + '/checkPassword',
						data : {
							id : id
						},
						message : '输入的旧密码有误'
					}
				}
			},
			password : {
				validators : {
					notEmpty : {
						message : '密码不能为空'
					},
					regexp : {
						regexp : /^[a-zA-Z0-9_\.]+$/,
						message : '密码只能包含大写、小写、数字和下划线'
					}
				}
			},
			confirmPassword : {
				validators : {
					identical : {
						field : 'password',
						message : '两次输入密码不一致'
					}
				}
			}
		}
	});

	function editPassword() {
		var $myModal = $('#myModal').modal({
			show : false
		});
		var row = {};
		$myModal.find('input[name]').each(function() {
			row[$(this).attr('name')] = $(this).val();
		});
		$.ajax({
			url : basePath + '/editPassword',
			type : 'post',
			contentType : 'application/json;charset=utf-8',
			data : JSON.stringify(row),
			success : function() {
				$myModal.modal('hide');
				alert('密码修改成功，请重新登录!', 'success');
				//$('form').data('bootstrapValidator').resetForm(true);
				$("#loginOut").click();
			},
			error : function() {
				$myModal.modal('hide');
				alert('修改密码失败!', 'danger');
			}
		});
	}
	
	//新增机构用户
	//$("form").submit(function(ev){ev.preventDefault();});
	$("#btn_submit").on("click", function(){
	
	   var bootstrapValidator = $("#changePwdForm").data('bootstrapValidator');
	   bootstrapValidator.validate();
	   if(bootstrapValidator.isValid())
		   editPassword();
	   else {
		   return;
	   };
	});
</script>	
</html>