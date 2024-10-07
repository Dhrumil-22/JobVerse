<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Dashboard</title>
    <link rel="stylesheet" href="post.css">
</head>
<body>

    <div id="dash_main">
		<div id="logo">
			<h2>JOBVERSE</h2>
		</div>

		<div id="box_nav">
			<nav id="nav">
				<a href="RegController?flag=E_Post">HOME</a> 
			</nav>
		</div>

		<div id="Log">
			<nav id="pro_nav">
				<div class="dropdown">
					<button class="auth-button dropbtn">PROFILE</button>
					<div class="dropdown-content">
						<a href="JS_Account.jsp">SETTINGS</a> 
						<a href="Login.jsp">LOG-OUT</a>
					</div>
				</div>
			</nav>
		</div>
    </div> 
	</div>
    
  
    <div id="diff">
		<div id="side-bar">
			<nav id="side_nav">
				<a href="RegController?flag=epost" id="post">MY POST</a>
				<!-- <a href="JS_Privacy.jsp">PRIVACY</a>
                <a href="JS_Help.jsp">HELP</a> -->
			</nav>
		</div>
   
   
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
</div>
   
   
   
</body>
</html>
