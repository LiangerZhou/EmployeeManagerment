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
<title>任务列表</title>

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
			<td align="center" style="font-size: 24px; color: #666">任务管理</td>
		</tr>
		<tr>
			<td align="right"><a
				href="${pageContext.request.contextPath}/task_saveUI.action">添加</a></td>
		</tr>
	</table>
	<br />
	<table cellspacing="0" border="1" class="table1">
		<thead>
			<tr>
				<th style="width: 3%;height: 10px;"><input type="checkbox" /></th>
				<th width="10%">任务名称</th>
				<th width="8%">任务开始时间</th>
				<th width="8%">计划完成时间</th>
				<th width="8%">实际完成时间</th>
				<th width="8%">工作量</th>
				<th width="8%">工作效率（30分）</th>
				<th width="10%">工作质量（40分）</th>
				<th width="8%">流程规范执行情况（30分）</th>
				<th width="5%">工作任务考核得分</th>
				<th width="5%">服务质量评审人</th>
				<th width="5%">工作类型</th>
				<th width="10%">备注</th>
				
				<th width="5%">编辑</th>
				<th width="5%">删除</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="list" var="e">
				<tr>
					<td align="center"><input type="checkbox"  value="#e.task_id"/></td>
					<td align="center"><s:property value="#e.task_name" /></td>
					<td align="center"><s:date format="yyyy-MM-dd" name="#e.task_cretime" /></td>
					<td align="center"><s:date format="yyyy-MM-dd" name="#e.task_endTime" /></td>
					<td align="center"><s:date format="yyyy-MM-dd" name="#e.real_endTime" /></td>
					<td align="center"><s:property value="#e.workdays" /></td>
					<td align="center"><s:property value="#e.work_efficiency" /></td>
					<td align="center"><s:property value="#e.work_quality" /></td>		
					<td align="center"><s:property value="#e.work_norm" /></td>
					<td align="center"><s:property value="#e.work_score" /></td>
					<td align="center"><s:property value="#e.charge_man" /></td>
					<td align="center"><s:property value="#e.workType" /></td>
					<td align="center"><s:property value="#e.remark" /></td>
					
					<td align="center"><a
						href="${pageContext.request.contextPath}/task_editTask.action?task_id=<s:property value="#e.task_id"/>"><img
							src="<%=basePath%>images/编辑.png" /></a></td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/task_delTask.action?task_id=<s:property value="#e.task_id"/>"><img
							src="<%=basePath%>images/trash.gif" /></a></td>

				</tr>
			</s:iterator>
		</tbody>
	</table>
	<br />


	<table border="0" cellspacing="0" width="95%">
		<tr>
			<td align="right"><span>第<s:property value="currentPage" />
					页&nbsp;&nbsp;总 共<s:property value="pageCount" /> 页
			</span>&nbsp;&nbsp; <span>总记录数：<s:property value="totalSize" />
					&nbsp;&nbsp;每页显示:<s:property value="pageSize" />
			</span>&nbsp;&nbsp; <span> <s:if test="currentPage != 1">
						<a
							href="${pageContext.request.contextPath }/task_findAll.action?currentPage=1">[首页]</a>&nbsp;&nbsp;
       <a
							href="${pageContext.request.contextPath }/task_findAll.action?currentPage=<s:property value="currentPage-1"/>">[上一页]</a>&nbsp;&nbsp;
   </s:if> <s:if test="currentPage != pageCount">
						<a
							href="${pageContext.request.contextPath }/task_findAll.action?currentPage=<s:property value="currentPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a
							href="${pageContext.request.contextPath }/task_findAll.action?currentPage=<s:property value="pageCount"/>">[尾页]</a>&nbsp;&nbsp;
   </s:if>
			</span></td>
		</tr>
	</table>
</body>
</html>