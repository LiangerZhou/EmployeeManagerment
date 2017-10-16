<%@ page language="java" import="java.util.*"  contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>任务考核</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/bootstrap-table.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/assessment.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/bootstrap-table-zh-CN.min.js"></script>
</head>
<body>
	<div align="center" style="font-size: 24px; color: #666">任务考核</div>
	<br />
	<div>
	 <s:select id="status" name="company.cid" onchange="submitPage()" headerKey="" headerValue="--全部--" list="#session.clist" listKey="cid" listValue="cname"/>
	 &nbsp;&nbsp;<input type="button" onclick="exportE();" value="考勤表导出">
	</div>
	<br />
	<div class="tableBox">
		<table id="table1"></table>
	</div>
	<br />

</body>
</html>