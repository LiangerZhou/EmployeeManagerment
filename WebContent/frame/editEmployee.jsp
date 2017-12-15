<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="0" width="95%">
		<tr>
			<td align="center" style="font-size: 24px; color: #666">外援信息修改</td>
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
	<s:form id="saveForm" action="employee_update" method="post"
		namespace="/" theme="simple">
		<s:hidden name="eid" value="%{model.eid}"></s:hidden>
		<table style="font-size: 16px" align="center">
			<tr>
				<td>员工姓名：</td>
				<td><s:textfield name="ename" value="%{model.ename}" /></td>
				<td>性别：</td>
				<td><s:radio list="{'男','女'}" name="sex" value="%{model.sex}" /></td>
			</tr>
			<tr>
				<td>入职日期：</td>
				<td><s:textfield name="joinDate" format="yyyy-MM-dd"
						value="%{model.joinDate}" /></td>
				<td>离职日期：</td>
				<td><s:textfield name="leftDate" format="yyyy-MM-dd"
						value="%{model.leftDate}" /></td>
			</tr>
			<tr>
				<td>外援等级：</td>
				<td><s:select list="{'低级','中级','高级'}" theme="simple"
						name="e_level" value="%{model.e_level}" /></td>
				<td>在职状态：</td>
				<td><s:select list="{'是','否'}" name="on_off_duty"
						value="%{model.on_off_duty}" /></td>
			</tr>
			<tr>
				<td>身份证号：</td>
				<td><s:textfield name="idCard" value="%{model.idCard}" /></td>
				<td>电话：</td>
				<td><s:textfield name="telephone" value="%{model.telephone}" /></td>
				<td>工作地点：</td>
				<td><s:textfield name="workplace" value="%{model.workplace}" /></td>
			</tr>
			<tr>
				<td>网络账号：</td>
				<td><s:textfield name="Net_account"
						value="%{model.Net_account}"></s:textfield></td>
				<td>网络角色：</td>
				<td><s:textfield name="Net_role" value="%{model.Net_role}"></s:textfield></td>
			</tr>
			<tr>
				<td>所属公司：</td>
				<td><s:select name="company.cid" value="%{model.company.cid}"
						headerKey="" headerValue="--请选择--" list="#session.list"
						listKey="cid" listValue="cname" /></td>
				<td>单价：</td>
				<td><s:textfield name="Price" value="%{model.Price}"></s:textfield></td>
			</tr>
			<tr>
				<td>所属任务：</td>
				<td><s:select name="task.task_id" value="%{model.task.task_id}"
						headerKey="" headerValue="--请选择--" list="#session.tList"
						listKey="task_id" listValue="task_name" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>