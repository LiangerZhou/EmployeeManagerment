<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<style type="text/css">
.table1 {
	border: 1px solid #ddd;
	width: 95%;
}

thead {
	background-color: lightblue;
}
</style>
</head>
<body>
	<table border="0" width="95%">
		<tr>
			<td align="center" style="font-size: 24px; color: #666">员工管理</td>
		</tr>
		<tr>
			<td align="right"><a
				href="${pageContext.request.contextPath}/employee_saveUI.action">添加</a></td>
		</tr>
	</table>
	<br />
	<table cellspacing="0" border="1" class="table1">
		<thead>
			<tr>
			<th style="width: 3%;height: 10px;"><input type="checkbox" /></th>
				<th width="7%">姓名</th>
				<th width="5%">性别</th>
				<th width="8%">入职日期</th>
				<th width="8%">离职时间</th>
				<th width="5%">外援等级</th>
				<th width="5%">在职状态</th>
				<th width="5%">身份证号</th>
				<th width="5%">工作地点</th>
				<th width="5%">网络账号</th>
				<th width="5%">网络角色</th>
				<th width="15%">所属公司</th>
				
				<th width="5%">编辑</th>
				<th width="5%">删除</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="list" var="e">
				<tr>
					<td align="center"><input type="checkbox"  value="e.eid"/></td>
					<td align="center"><s:property value="#e.ename" /></td>
					<td align="center"><s:property value="#e.sex" /></td>
					<td align="center"><s:date name="#e.joinDate" format="yyyy-MM-dd" /></td>
					<td align="center"><s:date name="#e.leftDate" format="yyyy-MM-dd" /></td>
					<td align="center"><s:property value="#e.e_level" /></td>
					<td align="center"><s:property value="#e.on_off_duty" /></td>
					<td align="center"><s:property value="#e.idCard" /></td>		
					<td align="center"><s:property value="#e.workplace" /></td>
					<td align="center"><s:property value="#e.Net_account" /></td>
					<td align="center"><s:property value="#e.Net_role" /></td>
					<td align="center"><s:property value="#e.company.cname" /></td>
					
					<td align="center"><a
						href="${pageContext.request.contextPath}/employee_edit.action?eid=<s:property value="#e.eid"/>"><img
							src="<%=basePath%>images/编辑.png" /></a></td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/employee_delete.action?eid=<s:property value="#e.eid"/>"><img
							src="<%=basePath%>images/trash.gif" /></a></td>

				</tr>
			</s:iterator>
		</tbody>
	</table>
	<br />


	<table border="0" cellspacing="0" cellpadding="0" width="95%">
		<tr>
			<td align="right"><span>第<s:property value="currentPage" />
					页&nbsp;&nbsp;总 共<s:property value="pageCount" /> 页
			</span>&nbsp;&nbsp; <span>总记录数：<s:property value="totalSize" />
					&nbsp;&nbsp;每页显示:<s:property value="pageSize" />
			</span>&nbsp;&nbsp; <span> <s:if test="currentPage != 1">
						<a
							href="${pageContext.request.contextPath }/employee_findAll.action?currentPage=1">[首页]</a>&nbsp;&nbsp;
       <a
							href="${pageContext.request.contextPath }/employee_findAll.action?currentPage=<s:property value="currentPage-1"/>">[上一页]</a>&nbsp;&nbsp;
   </s:if> <s:if test="currentPage != pageCount">
						<a
							href="${pageContext.request.contextPath }/employee_findAll.action?currentPage=<s:property value="currentPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a
							href="${pageContext.request.contextPath }/employee_findAll.action?currentPage=<s:property value="pageCount"/>">[尾页]</a>&nbsp;&nbsp;
   </s:if>
			</span></td>
		</tr>
	</table>
</body>
</html>