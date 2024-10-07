<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="00_Employer_Nav.css">
</head>
<body>


<header>
    <div id="logo">
        <h2>JOBVERSE</h2>
    </div>
    <nav id="nav">
        <a id="f" href="RegController?flag=E_Post">HOME</a> 
				<a id="s" href="E_Post.jsp">ADVERTIES</a> 
				<a href="RegController?flag=Seepost" id="acc">MY POST</a>
				<a id="s" href="RegController?flag=notification">NOTIFICATION</a>
    </nav>
    <div id="Log">
        <nav id="pro_nav">
            <div class="dropdown">
					<button class="auth-button dropbtn">PROFILE</button>
					<div class="dropdown-content">
						<a href="RegController?flag=E_acc">SETTINGS</a> 
						<a href="Login.jsp">LOG-OUT</a>
					</div>
				</div>
        </nav>
    </div>
</header>


</body>
</html>
