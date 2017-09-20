<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
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

   .tr_odd  
   {  
     background: #EBF2FE;  
   }  
   .tr_even  
   {  
     background: #B4CDE6;  
   }  
   .tab_body  
   {  
     text-align: center;  
   } 
   
</style>
<!-- 
	绝对路径：
		/  根目录，指向网站根目录

	相对路径：
		./  当前目录
		../ 当前所在目录的父目录
 -->

<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/attendance.js"></script>

</head>
<body>
	 <div align="center" style="font-size: 24px; color: #666">考勤管理</div>
        <form action="${pageContext.request.contextPath}/employee_findByName.action" id="proForm" method="post">
            外援姓名 &nbsp;<input type="text" name="findname" id="findname" style="width: 120px" > &nbsp; 
        <input type="submit" value="查询">
        </form>
        
        
            工作周期 &nbsp; 起始日 <input type="date" format="yyyy/MM/dd" id="begintime" /> &nbsp;
            结束日 <input type="date" format="yyyy/MM/dd" id="endtime" />
      <input type="button" onclick="attend();" value="批量导出"> 
      
	<br />
	<br />
	<table cellspacing="0" border="1" class="table1">
		<thead>
			<tr style="background: #CCCCCC;text-align: center;">
			<th style="width: 5%;height: 10px;"><input type="checkbox"  id="ckb_head"/></th>
				<th width="10%">员工姓名</th>
				<th width="10%">外援等级</th>
				<th width="35%">所属公司</th>
				<th width="35%">所属项目</th>
				
				<th width="5%">导出</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="list" var="e">
				<tr class = "tab_body">
					<td align="center"><input type="checkbox" name="ckb" value="<s:property value="#e.eid" />"/></td>
					<td align="center"><s:property value="#e.ename" /></td>
					<td align="center"><s:property value="#e.e_level" /></td>
					
					<td align="center"><s:property value="#e.company.cname" /></td>
					<td align="center"><s:property value="#e.project.proj_name" /></td>
					
					<td align="center"><a href="${pageContext.request.contextPath}/employee_exportExcel.action?eid=<s:property value="#e.eid"/>">
							<img src="<%=basePath%>images/导出Excel.png" /></a>
					</td>
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
							href="${pageContext.request.contextPath }/employee_attend.action?currentPage=1">[首页]</a>&nbsp;&nbsp;
       <a
							href="${pageContext.request.contextPath }/employee_attend.action?currentPage=<s:property value="currentPage-1"/>">[上一页]</a>&nbsp;&nbsp;
   </s:if> <s:if test="currentPage != pageCount">
						<a
							href="${pageContext.request.contextPath }/employee_attend.action?currentPage=<s:property value="currentPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a
							href="${pageContext.request.contextPath }/employee_attend.action?currentPage=<s:property value="pageCount"/>">[尾页]</a>&nbsp;&nbsp;
   </s:if>
			</span></td>
		</tr>
	</table>
</body>
</html>