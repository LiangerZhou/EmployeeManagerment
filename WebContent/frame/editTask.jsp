<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>任务编辑</title>
</head>
<body>
<table border="0" width="98%">
<tr>
<td align="center" style="font-size:24px; color:#666">编辑任务</td>
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
<s:form id="saveForm" action="task_updateTask" method="post" namespace="/" theme="simple">
<s:hidden name="task_id" value="%{model.task_id}"></s:hidden>
	<table style="font-size:16px">
		<tr>
		  <td>任务名称：</td>
		  <td><s:textfield name="task_name" value="%{model.task_name}"/></td>
		  <td>任务开始时间：</td>
		  <td><s:textfield format="yyyy-MM-dd" name="task_creTime" value="%{model.task_creTime}"/></td>
		  <td>计划完成时间：</td>
		  <td><s:textfield name="task_endTime" value="%{model.task_endTime}"/></td>
		</tr>
		<tr>
		  <td>实际完成时间：</td>
		  <td><s:textfield name="real_endTime" value="%{model.real_endTime}"/></td>
		  <td>工作量：</td>
		  <td><s:textfield name="workdays"  value="%{model.workdays}"/></td>
		</tr>
		<tr>
		  <td>工作效率(0~30)：</td>
		  <td><s:textfield name="work_efficiency" value="%{model.work_efficiency}"/></td>
		  <td>工作质量(0~40)：</td>
		  <td><s:textfield name="work_quality" value="%{model.work_quality}"/></td>
		  <td>流程规范执行情况(0~30)：</td>
		  <td><s:textfield name="work_norm" value="%{model.work_norm}"/></td>
		 </tr>
		 <tr>
		  <td>工作任务考核得分：</td>
		  <td><s:textfield name="work_score" value="%{model.work_score}"/></td>
		  <td>归属预算名称：</td>
		  <td><s:textfield name="budget_name" value="%{model.budget_name}"/></td>
		 </tr>
		 <tr>
	 	  <td>归属科室/业务线：</td>
	 	  <td><s:textfield name="qm_side" value="%{model.qm_side}"></s:textfield></td>
<%-- 	 	  <td>实施人：</td>
	 	  <td><s:checkboxlist name="emps.eid" list="#session.elist" listKey="eid" listValue="ename" label="--请选择--"></s:checkboxlist>
		  </td> --%>
		  <%-- <td><s:select name="emps.eid" value="%{model.emps[0].eid}" headerKey="" headerValue="--请选择--" list="#session.elist" listKey="eid" listValue="ename"/></td> --%>
	 	  <td>服务质量评审人：</td>
	 	  <td><s:textfield name="charge_man" value="%{model.charge_man}"></s:textfield></td>
	 	  <td>工作类型：</td>
		  <td><s:textfield name="workType" value="%{model.workType}"/></td> 
		</tr>
		<%-- <tr>
		  
		  <td>备注：</td>
		  <td><s:textfield name="remark" value="%{model.remark}"/></td> 
		</tr> --%>
	</table>
</s:form>
</body>
</html>