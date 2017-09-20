<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:95%;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
	<ul>
		<li>
			<c:out value = "woyaochifan" />
		</li>
	</ul>

</body>
</html>