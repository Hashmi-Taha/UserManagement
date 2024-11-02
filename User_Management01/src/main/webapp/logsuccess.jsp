<%@page import="servlet_prog.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	UserBean ub = (UserBean) application.getAttribute("ubean");
	out.println("welcome user :" + ub.getUname() + "<br>");
	%>
	<a href="view">View Profile</a>
	<a href="log">LogOut</a>
</body>
</html>