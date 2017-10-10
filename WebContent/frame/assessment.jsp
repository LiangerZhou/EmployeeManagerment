<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/assessment.js"></script>

<title>任务考核表</title>
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
	<div align="center" style="font-size: 24px; color: #666">任务管理</div>	
	<div id="proForm">
            公司名 &nbsp;<input type="text" name="findname" id="findname" style="width: 120px" > &nbsp; 
            工作范围 &nbsp; 起始日 <input type="date" format="yyyy/MM/dd" id="begintime" /> &nbsp;
            结束日 <input type="date" format="yyyy/MM/dd" id="endtime" />
      <input type="button" onclick="find()" value="查询">
      <input type="button" onclick="export();" value="批量导出"> 
     </div>
	<br />
	<br />
		
	<div align="right">
		<a href="${pageContext.request.contextPath}/assessment_saveUI.action">添加</a>
	</div>
	<br />
	
	<table cellspacing="0" border="1" class="table1">
		<thead>
			<tr>
			<th style="width: 3%;height: 10px;"><input type="checkbox" /></th>
				<th width="25%">工作任务摘要</th>
				<th width="28%">工作开始时间</th>
				<th width="25%">计划完成时间</th>
				<th width="25%">实际完成时间</th>
				<th width="28%">工作量</th>
				<th width="25%">工作量占比</th>
				<th width="25%">工作效率（30分）</th>
				<th width="28%">工作质量（40分）</th>
				<th width="25%">流程规范执行情况（30分）</th>
				<th width="25%">工作任务考核得分</th>
				<th width="25%">工作任务考核得分折算</th>
				<th width="25%">服务质量评审人</th>
				<th width="25%">备注</th>
				<th width="5%">编辑</th>
				<th width="5%">删除</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="list" var="c">
				<tr>
					<td align="center"><input type="checkbox"  value="c.assessment_id"/></td>
					<td align="center"><s:property value="#c.task_name" /></td>
					<td align="center"><s:property value="#c.start_Date" /></td>
					<td align="center"><s:property value="#c.end_Date" /></td>
					<td align="center"><s:property value="#c.real_end_Date" /></td>
					<td align="center"><s:property value="#c.workdays" /></td>
					<td align="center"><s:property value="#c.work_efficiency" /></td>
					<td align="center"><s:property value="#c.work_quality" /></td>
					<td align="center"><s:property value="#c.work_norm" /></td>
					<td align="center"><s:property value="#c.work_score" /></td>
					<td align="center"><s:property value="#c.convert_work_score" /></td>
					<td align="center"><s:property value="#c.qc_man" />></td>
					<td align="center"><s:property value="#c.remark" />></td>
					
					<td align="center"><a
						href="${pageContext.request.contextPath}/task_editById.action?cid=<s:property value="#c.cid"/>"><img
							src="<%=basePath%>images/编辑.png" /></a></td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/task_delete.action?cid=<s:property value="#c.cid"/>"><img
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