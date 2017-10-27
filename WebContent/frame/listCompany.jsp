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
	width: 99%;
}

thead {
	background-color: lightblue;
}
</style>
</head>
<body>
	<table border="0" width="98%">
		<tr>
			<td align="center" style="font-size: 24px; color: #666">外援公司</td>
		</tr>
		<tr>
			<td align="right"><a
				href="${pageContext.request.contextPath}/company_saveUI.action">添加</a></td>
		</tr>
	</table>
	<br />
	<table cellspacing="0" border="2" class="table1">
		<thead>
			<tr>
			<th style="width: 3%;height: 10px;"><input type="checkbox" /></th>
				<th width="10%">外援公司简称</th>
				<th width="25%">外援公司全称</th>
				<th width="28%">合同名称</th>
				<th width="25%">合同编号</th>
				<th width="5%">编辑</th>
				<th width="5%">删除</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="list" var="c">
				<tr>
					<td align="center"><input type="checkbox"  value="#c.cid"/></td>
					<td align="center"><s:property value="#c.cname" /></td>
					<td align="center"><s:property value="#c.cdesc" /></td>
					<td align="center"><s:property value="#c.contract_name" /></td>
					<td align="center"><s:property value="#c.contract_code" /></td>
					
					<td align="center"><a
						href="${pageContext.request.contextPath}/company_editById.action?cid=<s:property value="#c.cid"/>"><img
							src="<%=basePath%>images/编辑.png" /></a></td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/company_delete.action?cid=<s:property value="#c.cid"/>"><img
							src="<%=basePath%>images/trash.gif" /></a></td>

				</tr>
			</s:iterator>
		</tbody>
	</table>
	<br />


	<table border="0" cellspacing="0" cellpadding="0" width="98%">
		<tr>
			<td align="right"><span>第&nbsp;<s:property value="currentPage" />
					页&nbsp;&nbsp;&nbsp;总共&nbsp;<s:property value="pageCount" />&nbsp;页
			</span>&nbsp;&nbsp;<span>总记录数：<s:property value="totalSize" />
					&nbsp;&nbsp;每页显示：<s:property value="pageSize" />
			</span>&nbsp;&nbsp; <span> <s:if test="currentPage != 1">
						<a
							href="${pageContext.request.contextPath }/company_findAll.action?currentPage=1">[首页]</a>&nbsp;&nbsp;
       <a
							href="${pageContext.request.contextPath }/company_findAll.action?currentPage=<s:property value="currentPage-1"/>">[上一页]</a>&nbsp;&nbsp;
   </s:if> <s:if test="currentPage != pageCount">
						<a
							href="${pageContext.request.contextPath }/company_findAll.action?currentPage=<s:property value="currentPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a
							href="${pageContext.request.contextPath }/company_findAll.action?currentPage=<s:property value="pageCount"/>">[尾页]</a>&nbsp;&nbsp;
   </s:if>
			</span></td>
		</tr>
	</table>
</body>
</html>