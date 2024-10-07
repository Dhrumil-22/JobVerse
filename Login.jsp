<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>

<%@ include file="ACP2.jsp"%>

<div class="container">
    <div class="login-box">
        <h3>Login</h3>
        <form action="RegController" method="post">
            <label for="username">User Name</label>
            <input type="text" id="username" name="UserName" placeholder="Enter your username">

            <label for="password">Password</label>
            <input type="password" id="password" name="Password" placeholder="Enter your password">

            <input type="hidden" name="flag" value="Login">
            <button type="submit" class="login-button">Login</button>
            
            <a href="JS_Register.jsp">Don't have an account? Create Account Here</a>
            <a href="ForgotPass.jsp">Can't remember Password? Forgot Password</a>
        </form>
    </div>
</div>

</body>
</html>
