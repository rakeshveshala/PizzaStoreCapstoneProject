<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.Admin" %>
<%@ page import="com.entity.Account" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>start</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color:#ffffff ;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color:#86acbf;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
        }
        h1 {
            color: #031211;
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
            background-color: #0056b3;
            color: #ffffff;
        }
        
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome To Pizza Store</h1>
        
<a class="back-link" href="${pageContext.request.contextPath}/admin/home">Login/Register</a>
    </div>
</body>
</html>
