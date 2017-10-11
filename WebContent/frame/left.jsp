<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../dtree/dtree.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../dtree/dtree.js"></script>
</head>

<body bgColor=#DDF0FB leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<table width="90%" border="0" cellspacing="1" cellpadding="2" align="center">
<div class="dtree">
  <script type="text/javascript">
    d=new dTree('d');

    d.add('01','-1','外援管理系统');
    d.add('0101','01','外援信息管理');
    d.add('010101','0101','人员管理','${pageContext.request.contextPath }/employee_findAll.action?currentPage=1','','right');
    d.add('010102','0101','厂商管理','${pageContext.request.contextPath }/company_findAll.action?currentPage=1','','right');
    d.add('010103','0101','任务管理','${pageContext.request.contextPath }/task_findAll.action?currentPage=1','','right');
    d.add('0102','01','外援考勤管理','${pageContext.request.contextPath }/employee_attend.action?currentPage=1','','right');
    d.add('0103','01','外援考核管理','${pageContext.request.contextPath }/task_assessment.action?currentPage=1','','right');
    document.write(d);
  </script>
</div>
</table>

</body>
</html>
