<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Dashboard</title>
    <link rel="stylesheet" href="Resume.css">
</head>
<body>

<header>
    <div id="logo">
        <h2>JOBVERSE</h2>
    </div>
    <nav id="nav">
        <a id="f" href="JS_Dashboard.jsp">HOME</a>
        <a id="s" href="JS_Search.jsp">SEARCH</a>
        <a id="s" href="Resume.jsp">ADD RESUME</a>
    </nav>
    <div id="Log">
        <nav id="pro_nav">
            <div class="dropdown">
                <button class="auth-button">PROFILE</button>
                <div class="dropdown-content">
                	<a href="JS_Account.jsp">SETTINGS</a>
                    <a href="Login.jsp">LOG-OUT</a>
                </div>
            </div>
        </nav>
    </div>
</header>
    
    
    
    <div id="Seeking">
    <div class="container">
        <div class="login-box">
            <h3>RESUME</h3><br>
            <form action="RegController?flag=Resume" method="post" enctype="multipart/form-data">
                <center>
                    <label for="resume" class="upload-button">UPLOAD RESUME</label>
                    <input type="file" id="resume" name="resume" accept="image/*" style="display: none;">
                </center><br>
                <center>
                    <button class="auth-button" type="submit">UPLOAD</button>
                </center>
            </form>
        </div>
    </div>
</div>
    
    


</body>
</html>
