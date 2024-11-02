<%@page import="servlet_prog.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        a {
            display: inline-block;
            padding: 10px 20px;
            text-decoration: none;
            color: #333;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-right: 10px;
        }

        a:hover {
            background-color: #f0f0f0;
        }
    </style>
</head>
<body>
	<%
	try{
	String m = (String) request.getAttribute("taha");
	out.print(m);
	}catch(Exception e){
		out.println("You Have Logged Out Already...<br>");
	}
	%>
	<form action="update" method="post">
			 <input type="email" name="mid" placeholder="Enter new MailId"><br>
				<input type="submit" value="Update Profile">
	</form>
	<a href="register.html">Add-User</a>
	<a href="view">View-Profile</a>
	<a href="logout">Logout</a>
</body>
</html>