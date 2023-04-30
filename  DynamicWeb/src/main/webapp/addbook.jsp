<%@page import="ua.com.foxminded.dynamicweb.DatabaseFacade"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book page</title>
</head>
<body>


<%
	String name = request.getParameter("name");
	if (name != null && !name.isEmpty()) {
		DatabaseFacade.addBook(name);
	}
	response.sendRedirect("index.jsp");
%>

</body>
</html>