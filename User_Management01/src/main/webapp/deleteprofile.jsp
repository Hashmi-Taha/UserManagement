<%@page import="servlet_prog.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
        /* Define your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 960px;
            margin: 0 auto;
            padding: 20px;
        }

        .navigation {
            margin-bottom: 20px;
        }

        .navigation a {
            text-decoration: none;
            color: #333;
            margin-right: 10px;
        }

        .navigation a:hover {
            color: #666;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
        String m = (String) request.getAttribute("bt");
        out.println("User Deleted :" + "<br>");
        out.println(m);
        %>
        <div class="navigation">
            <a href="register.html">Add-Profile</a>
            <a href="view">View-Profile</a>
            <a href="logout">Logout</a>
        </div>
    </div>
</body>
</html>