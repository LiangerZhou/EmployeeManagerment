<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
	<title>登陆</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/main.css">
  </head>  
  <body>
    <div class="headerBar">
	<div class="logoBar login_logo">
		<div class="comWidth">
			<div class="logo fl">
				<a href="#"><img src="${pageContext.request.contextPath}/images/chinamobile.png" alt=""></a>
			</div>
			<h2 class="welcome_title">外援管理系统</h2>
		</div>
	</div>
</div>
<s:form action="user_login" method="post" namespace="/" theme="simple">
<div class="loginBox">
	<h3><s:actionerror/></h3>
	<div class="login_cont">
		<ul class="login">
			<li class="l_tit">用户名</li>
			<li class="mb_10"><input type="text" name="username" class="login_input user_icon"></li>
			<li class="l_tit">密码</li>
			<li class="mb_10"><input type="text" name="password" class="login_input user_icon"></li>
			
			<li><input type="submit" value="" class="login_btn"></li>
		</ul>
	</div>
</div>
</s:form>
  </body>
</html>
