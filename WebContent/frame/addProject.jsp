<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>项目添加</title>
</head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666">添加项目</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回 </a>
</td>
</tr>
</table>
<br/>
<br/>
<!-- action对应一个action标签，id对应提交时的对应关系 -->
<s:form id="saveForm" action="project_addProj" method="post" namespace="/" theme="simple">
	<table style="font-size:16px">
		<tr>
		  <td>项目名称：</td>
		  <td><s:textfield name="proj_name"/></td>
		</tr>
		<tr>
		  <td>创建日期：</td>
		  <td><s:textfield name="creTime"/></td>
		  <td>结束日期：</td>
		  <td><s:textfield name="endTime"/></td>
		</tr>
		<tr>
		  <td>项目合同名：</td>
		  <td><s:textfield name="contract_name" /></td>
		  <td>项目合同号：</td>
		  <td><s:textfield  name="contract_code"/></td>
		</tr>
		<tr>
		  <td>需求方：</td>
		  <td><s:textfield name="demand_side"/></td>
		  <td>实施方：</td>
 		  <td><s:select name="company.cid" headerKey="" headerValue="--请选择--" list="list" listKey="cid" listValue="cname"/></td>
		 </tr>
		 <tr>
		 	<td>管理方：</td>
		 	<td><s:textfield name="qm_side"></s:textfield></td>
		 	<td>责任人：</td>
		 	<td><s:textfield name="charge_man"></s:textfield></td>
		 </tr>
		 <tr>
		  <td>工作类型：</td>
		  <td><s:textfield name="workType"/></td> 
		  <td>备注：</td>
		  <td><s:textfield name="remark"/></td> 
		</tr>
	</table>
</s:form>
</body>
</html>