<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style>
body {
    font-family: "Lato", sans-serif;
}



.main-head{
    height: 150px;
    background: #FFF;
   
}

.sidenav {
    height: 100%;
    background-color: #000;
    overflow-x: hidden;
    padding-top: 20px;
}


.main {
    padding: 0px 10px;
}

@media screen and (max-height: 450px) {
    .sidenav {padding-top: 15px;}
}

@media screen and (max-width: 450px) {
    .login-form{
        margin-top: 10%;
    }

    .register-form{
        margin-top: 10%;
    }
}

@media screen and (min-width: 768px){
    .main{
        margin-left: 40%; 
    }

    .sidenav{
        width: 40%;
        position: fixed;
        z-index: 1;
        top: 0;
        left: 0;
    }

    .login-form{
        margin-top: 80%;
    }

    .register-form{
        margin-top: 20%;
    }
}


.login-main-text{
    margin-top: 20%;
    padding: 60px;
    color: #fff;
}

.login-main-text h2{
    font-weight: 300;
}

.btn-black{
    background-color: #000 !important;
    color: #fff;
}
 .button {display: inline;
            padding: 12px 20px;
            border-radius: 5px;
            margin: -14px 93px; /* Space between buttons */
            text-decoration: none;
            font-size: 16px;
            font-weight: 500;
            color: #000000; /* Text color for contrast */    
            width: 140px;
            height: 50px;
            line-height: 50px;  
            
        }
        .button:hover {
            background-color: #bfcbd7; 
            text-decoration: none;
        }
        .admin-login {
            background-color: #c7e3e7; 
           
        }
        .customer-login {
            background-color: #c7e3e7; 
            
        }
        .register-customer {
            background-color: #c7e3e7; 
            
        }
        .register-admin {
            background-color: #c7e3e7; 
            
        }
        @media (max-width: 768px) {
            .container {
                flex-direction: column; 
                width: 90%;
                padding: 20px;
            }
            .button {
                width: 100%;
                box-sizing: border-box;
                margin-bottom: 10px; /* Space between buttons in column layout */
                width: 100%;
  table-layout: fixed;
  border-collapse: collapse;
            }
</style>
</head>
<body>
    <div class="sidenav">
        <div class="login-main-text">
            <h2>Welcome To Pizza Store</h2>
            <p>Login or register from here to access.</p>
        </div>
    </div>
    <div class="main">
        <div class="col-md-6 col-sm-12">
            <div class="login-form">
                <a href="${pageContext.request.contextPath}/customers/adminlogin" class="button admin-login">AdminLogin</a>
        <a href="${pageContext.request.contextPath}/customers/login" class="button customer-login">CustomerLogin</a>
        <a href="${pageContext.request.contextPath}/customers/register" class="button register-customer">CustomerRegister</a>
            </div>
        </div>
    </div>
</body>
</html>