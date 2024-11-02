<%@page import="java.util.Iterator"%>
<%@page import="servlet_prog.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view product</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
           text-align: center;
           background-color: #A8FBD2 ;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #7BD1A7;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .welcome-message {
            font-size: 18px;
            margin-bottom: 20px;
        }

        .product {
            margin-bottom: 10px;
            padding: 10px;
            background-color: #CEF5ED;
            border-radius: 5px;
            width: 780px;
        }

        .product a {
            text-decoration: none;
            color: #007bff;
            margin-left: 10px;
        }

        .product a:hover {
            text-decoration: underline;
        }

        .menu-link {
            display: inline-block;
            margin-right: 10px;
            text-decoration: none;
            color: #333;
            padding: 8px 16px;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            transition: background-color 0.3s ease;
        }

        .menu-link:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
	<div class="container">
	<%
	try{
		ArrayList<UserBean> al = (ArrayList<UserBean>) session.getAttribute("alist");
		out.println("<p class='welcome-message'>Welcome User :" + "</p><br>");
		if (al.size() == 0) {
			out.println("<p>No user Available...</p><br>");
		} else {
			Iterator<UserBean> it = al.iterator();
			while (it.hasNext()) {
				UserBean ub = (UserBean) it.next();
				out.println("<div class='product'>"+ub.getUname() + "&nbsp&nbsp" + ub.getmid() + "&nbsp&nbsp" + ub.getPwd() + "&nbsp&nbsp"
				+ "<a href='edit?uname=" + ub.getUname() + "'>Edit</a>" + "&nbsp&nbsp"
				+ "<a href='delete?uname=" + ub.getUname() + "'>Delete</a></div><br>");
			}
		}
	}catch(NullPointerException e){
		out.println("Please Login First...<br>");
	}
	%>
	<a href="register.html" class="menu-link">AddUser</a>
	<a href="logout" class="menu-link">Logout</a>
	</div>
</body>
</html>