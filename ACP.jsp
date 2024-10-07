<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="ACP.css">
</head>
<body>
	<header>
    <div id="logo">
        <h2>JOBVERSE</h2>
    </div>
    <nav id="nav">
        <a href="JS_Dashboard.jsp">HOME</a> 
        <a href="RegController?flag=JS_acc">ACCOUNT</a>
        <a href="JS_Privacy.jsp">PRIVACY</a>
        <a href="JS_Help.jsp">ABOUT US</a>
    </nav>
    <div id="Log">
        <nav id="pro_nav">
            <div class="dropdown">
                <button class="auth-button">PROFILE</button>
                <div class="dropdown-content">
                    <a href="Login.jsp">LOG-OUT</a>
                </div>
            </div>
        </nav>
    </div>
</header>
</body>
</html>
