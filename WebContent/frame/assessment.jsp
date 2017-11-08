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
	<div align="center" style="font-size: 24px; color: #666">任务考核</div>
	<br />
	<div>
	 &nbsp;&nbsp;<s:select id="status" name="company.cid" onchange="submitPage()" headerKey="" headerValue="--全部--" list="#session.clist" listKey="cid" listValue="cname"/>
	 &nbsp;&nbsp;<input type="button" onclick="exportAss()" value="考核表导出">
	 &nbsp;&nbsp;<input type="button" onclick="exportMid()" value="中间表导出">
	 &nbsp;&nbsp;<input type="button" onclick="exportContract()" value="合同台账导出">
	</div>
	<br />
	<div class="table-responsive">
		<table data-show-refresh="true" data-page-size="5" data-toggle="table" id="taskTable" class="taskTable" data-height="80%" data-pagination="true" data-search="true">
		<thead>
			<tr>
				<th data-field="task_id" data-checkbox="true"></th>
				<th data-field="task_name" data-align="right">任务名称</th>
				<th data-field="task_creTime" data-align="right">任务开始时间</th>
				<th data-field="task_endTime" data-align="right">计划完成时间</th>
				<th data-field="real_endTime" data-align="right">实际完成时间</th>
				<th data-field="workdays" data-align="right">工作量</th>
				<th data-field="work_efficiency" data-align="right">工作效率（30分）</th>
				<th data-field="work_quality" data-align="right">工作质量（40分）</th>
				<th data-field="work_norm" data-align="right">流程规范执行情况（30分）</th>
				<th data-field="work_score" data-align="right">工作任务考核得分</th>
				<th data-field="charge_man" data-align="right">服务质量评审人</th>
				<th data-field="workType" data-align="right">工作类型</th>
				<th data-field="remark" data-align="right">备注</th>
			</tr>
		</thead>	
	 	<%-- <tbody>
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
				</tr>
			</s:iterator>
		</tbody> --%>
	</table>
	<br />
<%-- 
	<table >
		<tr>
			<td align="right"><span>第<s:property value="currentPage" />
					页&nbsp;&nbsp;总 共<s:property value="pageCount" /> 页
			</span>&nbsp;&nbsp; <span>总记录数：<s:property value="totalSize" />
					&nbsp;&nbsp;每页显示:<s:property value="pageSize" />
			</span>&nbsp;&nbsp; <span> <s:if test="currentPage != 1">
						<a
							href="${pageContext.request.contextPath }/task_assessment.action?currentPage=1">[首页]</a>&nbsp;&nbsp;
       <a
							href="${pageContext.request.contextPath }/task_assessment.action?currentPage=<s:property value="currentPage-1"/>">[上一页]</a>&nbsp;&nbsp;
   </s:if> <s:if test="currentPage != pageCount">
						<a
							href="${pageContext.request.contextPath }/task_assessment.action?currentPage=<s:property value="currentPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a
							href="${pageContext.request.contextPath }/task_assessment.action?currentPage=<s:property value="pageCount"/>">[尾页]</a>&nbsp;&nbsp;
   </s:if>
			</span></td>
		</tr>
	</table>  --%>
	</div> 
	<br />

</body>
</html>