<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Dashboard</title>
    <link rel="stylesheet" href="js_dashboard.css">
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
                	<a href="RegController?flag=JS_acc">SETTINGS</a>
                    <a href="Login.jsp">LOG-OUT</a>
                </div>
            </div>
        </nav>
    </div>
</header>
    
    <div id="Seeking">
    <c:forEach items="${sessionScope.SearchList}" var="i">
        <a href="RegController?flag=Details&&id=${i.id}" class="job-item-link">
            <div class="job-item">
            
                <div class="job-header">
                    <div class="job-title">${i.technology}</div>
                    <div class="company-name">${i.companyName}</div>
                </div>
                
                <div class="job-info">
                    <div class="experience">
                        <span class="icon">&#128187;</span> ${i.experience} Yrs
                    </div>
                    <div class="salary">
                        <span class="icon">&#128181;</span> Not disclosed
                    </div>
                    <div class="location">
                        <span class="icon">&#128205;</span> ${i.location}
                    </div>
                </div>
                
                <div class="job-description">
                    <div class="description">${i.jobDescription}</div>
                    <div class="skills">
                        <span>Skills: </span>${i.essentialSkills}
                    </div>
                </div>
                
            </div>
        </a>
    </c:forEach>
    </div>

</body>
</html>
