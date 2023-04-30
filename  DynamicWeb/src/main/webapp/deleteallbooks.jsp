<%@page import="ua.com.foxminded.dynamicweb.DatabaseFacade"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	DatabaseFacade.deleteAllBooks();	
response.sendRedirect("index.jsp");
	%>
	


</body>
</html>