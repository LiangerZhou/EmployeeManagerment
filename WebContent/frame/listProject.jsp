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
<title>项目列表</title>
</head>
<body>
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
			<td align="center" style="font-size: 24px; color: #666">项目管理</td>
		</tr>
		<tr>
			<td align="right"><a
				href="${pageContext.request.contextPath}/project_saveUI.action">添加</a></td>
		</tr>
	</table>
	<br />
	<table cellspacing="0" border="1" class="table1">
		<thead>
			<tr>
				<th style="width: 3%;height: 10px;"><input type="checkbox" /></th>
				<th width="10%">项目名称</th>
				<th width="8%">项目创建日期</th>
				<th width="8%">项目结束日期</th>
				<th width="8%">合同名</th>
				<th width="8%">合同号</th>
				<th width="8%">需求方</th>
				<th width="10%">厂商</th>
				<th width="8%">管理方</th>
				<th width="5%">项目负责人</th>
				<th width="5%">工作类型</th>
				<th width="10%">备注</th>

				<th width="5%">编辑</th>
				<th width="5%">删除</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="list" var="e">
				<tr>
					<td align="center"><input type="checkbox"  value="e.proj_id"/></td>
					<td align="center"><s:property value="#e.proj_name" /></td>
					<td align="center"><s:date format="yyyy-MM-dd" name="#e.proj_cretime" /></td>
					<td align="center"><s:date format="yyyy-MM-dd" name="#e.proj_endTime" /></td>
					<td align="center"><s:property value="#e.contract_name" /></td>
					<td align="center"><s:property value="#e.contract_code" /></td>
					<td align="center"><s:property value="#e.demand_side" /></td>		
					<td align="center"><s:property value="#e.company.cname" /></td>
					<td align="center"><s:property value="#e.qm_side" /></td>
					<td align="center"><s:property value="#e.charge_man" /></td>
					<td align="center"><s:property value="#e.workType" /></td>
					<td align="center"><s:property value="#e.remark" /></td>
					
					<td align="center"><a
						href="${pageContext.request.contextPath}/project_editProj.action?proj_id=<s:property value="#e.proj_id"/>"><img
							src="<%=basePath%>images/编辑.png" /></a></td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/project_delProj.action?proj_id=<s:property value="#e.proj_id"/>"><img
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
							href="${pageContext.request.contextPath }/project_findAll.action?currentPage=1">[首页]</a>&nbsp;&nbsp;
       <a
							href="${pageContext.request.contextPath }/project_findAll.action?currentPage=<s:property value="currentPage-1"/>">[上一页]</a>&nbsp;&nbsp;
   </s:if> <s:if test="currentPage != pageCount">
						<a
							href="${pageContext.request.contextPath }/project_findAll.action?currentPage=<s:property value="currentPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a
							href="${pageContext.request.contextPath }/project_findAll.action?currentPage=<s:property value="pageCount"/>">[尾页]</a>&nbsp;&nbsp;
   </s:if>
			</span></td>
		</tr>
	</table>
	
	 <s:debug></s:debug>
</body>
</html>