<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head></head>
<body>
	<table border="0" width="95%">
		<tr>
			<td align="center" style="font-size: 24px; color: #666">外援公司添加</td>
		</tr>
		<tr>
			<td align="right"><a
				href="javascript:document.getElementById('saveForm').submit()">保存</a>
				&nbsp;&nbsp; <a href="javascript:history.go(-1)">退回 </a></td>
		</tr>
	</table>
	<br />
	<br />
	<!-- action对应一个action标签，id对应提交时的对应关系 -->
	<s:form id="saveForm" action="company_saveInfo" method="post" namespace="/" theme="simple">
		<table style="font-size: 16px" align=center>
			<tr>
				<td>外援公司简称：</td>
				<td><s:textfield name="cname" /></td>
			</tr>
			<tr>
				<td>外援公司全称：</td>
				<td><s:textfield rows="5" cols="50" name="cdesc"></s:textfield></td>
			</tr>
			<tr>
				<td>合同名称：</td>
				<td><s:textfield rows="5" cols="50" name="contract_name"></s:textfield></td>
			</tr>
			<tr>
				<td>合同编号：</td>
				<td><s:textfield rows="5" cols="50" name="contract_code"></s:textfield></td>
			</tr>
			
		</table>
	</s:form>
</body>
</html>
