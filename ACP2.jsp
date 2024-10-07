<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="ACP2.css">
</head>
<body>
	<header>
    <div id="logo">
        <h2>JOBVERSE</h2>
    </div>
    <nav id="nav">
            <a id="f" href="RegController">HOME</a>
            <a id="s" href="Login.jsp">SEARCH</a>
            <a id="t" href="Login.jsp">SETTINGS</a>
    </nav>
    <div id="Log">
        <nav id="pro_nav">
        	<button onclick="window.location.href='Login.jsp'" style="cursor: pointer;" class="auth-button dropbtn" >LOGIN</button>
            <div class="dropdown">
                <button class="auth-button dropbtn">REGISTER</button>
                <div class="dropdown-content">
                    <a href="E_Register.jsp">EMPLOYER</a>
                    <a href="JS_Register.jsp">JOB SEEKER</a>
                </div>
            </div>
        </nav>
    </div>
</header>
</body>
</html>
