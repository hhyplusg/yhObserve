<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="content"  value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	var projectPath = 'http://' + location.host + '${content}'; 
	var basePath = 'http://' + location.host + '${content}' + "/syscorpinforManager"; 
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head >  
		<title>用户登录</title>
		<link rel="stylesheet" href="${content }/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="${content }/bootstrap/plugins/bootstrap-table/bootstrap-table.css">
		<link rel="stylesheet" href="${content }/bootstrap/plugins/validator/css/bootstrapValidator.min.css">
		<link rel="stylesheet" href="${content }/bootstrap-3.3.7/css/login.css">
		<script src="${content }/jquery/jquery-3.3.1.min.js"></script>
		<script src="${content }/bootstrap-3.3.7/js/bootstrap.min.js"></script>
		<script src="${content }/bootstrap/plugins/bootstrap-table/bootstrap-table.js"></script>
		<script src="${content }/bootstrap/js/ga.js"></script>
		<script src="${content }/bootstrap/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
		<script src="${content }/bootstrap/plugins/validator/js/bootstrapValidator.min.js"></script>
		<script src="${content }/bootstrap/plugins/validator/js/language/zh_CN.js"></script>
	</head>
	<body>
	<div class="logo">
	    <span class="logoImg"></span>
	</div>
	<div class="login-container">
	    <div class="row content-section">
	        <div class="inner-section">
	            <form  action="/login" method="post" id="">
	                <div class = "title-section">存款业务询报价系统</div>
	                <div class="input-section">
	                  
	                    <input type="text" class="username"  id="userloginname"  maxLength="12" name="userloginname"  placeholder="用户名"> 
	                    <div class="error-hint" id="user-error"></div>
	                </div>
	                <div class="input-section">
	                
	                    <input  type="password" class="password"  maxLength="12" id="password"  name="password" placeholder="密　码">
	                    <i class="fa fa-lock"></i>
	                    <a href="#" class="fa fa-question-circle"></a>
	                    <div class="error-hint" id="pw-error"></div>
	                </div>
	                <div class = "input-section">
			            <input type="checkbox" id="remember"  name="remember" checked>
			            <label for="remember">记住账号</label>
			        </div>
			        <button class="login-btn" type="submit" id="login">登录</button>

	            </form>
	        </div>
	    </div>
	</div>
	</body>
<script type="text/javascript">
var hasUsername = false;
var hasPassword = false;
function verifyUser() {
    var username = $('.username').val();
    var regexp =/^[a-zA-Z0-9_\.]+$/;
    if (!username){
        
        $('#user-error').html('用户名不能为空');
        $("#user-error").show();
    }else{
        if(!regexp.test(username)){
            $('#user-error').html('用户名只能包含大小写、数字和下划线');
            $("#user-error").show();

        }else{
            $("#user-error").hide();
            hasUsername = true;
        }
    }  
}
function verifyPassword() {
    var password = $('.password').val();
    if (!password){
        $('#pw-error').html('密码不能为空');
        $("#pw-error").show();
    }else{
        $("#pw-error").hide();
        hasPassword = true;
    }  
}
    
$(".username").blur(function(){
  verifyUser();
});
$(".password").blur(function(){
  verifyPassword();
});
</script>
<script type="text/javascript">
$("form").submit(function(ev){ev.preventDefault();});
$("#login").on("click", function(){
	  login();
});
function login(){
	verifyUser();
	verifyPassword();
	var row = {};
    $('.row').find('input[name]').each(function () {
          row[$(this).attr('name')] = $(this).val();
    });
	$.ajax({
        url: basePath+'/login',
        type: 'POST',
        contentType: 'application/json;charset=utf-8',
        data:  JSON.stringify(row),
        success: function (data) {
        	if(data.page == "1"){
        		 window.location.href = projectPath + "/equote.jsp";
        	}else if(data.page == "2" ){
        		window.location.href = projectPath + "/inquiry.jsp";
        	}else if(data.page == "3"){
        		window.location.href = projectPath + "/manager.jsp";
        	}else{
        		if(hasPassword && hasUsername){
        			$('#pw-error').html('用户名或密码有误，请核对');
                    $("#pw-error").show();
        		}
        		
        	}
        },
        error: function () {
        }
    });
};

</script>
</html>