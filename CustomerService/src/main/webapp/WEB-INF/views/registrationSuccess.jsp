
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.Admin" %>
<%@ page import="com.entity.Account" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration successful</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffffff;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #eff5f8;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
        }
        h1 {
            color: #721c24;
            margin-bottom: 20px;
        }
        p {
            font-size: 16px;
            color: #721c24;
            margin-bottom: 30px;
        }
        a {
            display: inline-block;
            padding: 10px 15px;
            border-radius: 5px;
            text-decoration: none;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }
        .back-link {
            background-color:#0056b3;
            color: #eff5f8;
        }
        
    </style>
</head>
<body>
    <div class="container">
        <h3>Registration Successful</h3>
<a class="back-link" href="${pageContext.request.contextPath}/customers/home">Login Page</a>
    </div>
</body>
</html>

