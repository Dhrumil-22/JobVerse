<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Dashboard</title>
    <link rel="stylesheet" href="JobDetail.css">
</head>
<body>


<header>
    <div id="logo">
        <h2>JOBVERSE</h2>
    </div>
    <nav id="nav">
        <a id="f" href="RegCOntroller?flag=Js_Dash">HOME</a>
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
    <c:forEach items="${sessionScope.DetailList}" var="i">
        <div class="job-item">
        
           <div class="job">
            <div class="job-header">
                <div class="job-title">${i.technology}</div>
                <div class="company-name">${i.companyName}</div>
			</div>
		
			<div class="Button-up">
				<a class="Apply" href="RegController?flag=Apply&&un=${i.username}">APPLY NOW</a> 
		
			</div>
        </div>

				<div class="job-info">

					<div class="label">Experience:</div>
					<div class="content">${i.experience} Yrs</div>

					<div class="label">Salary:</div>
					<div class="content">Not disclosed</div>

					<div class="label">Location:</div>
					<div class="content">${i.location}</div>

					<div class="label">Employment Type:</div>
					<div class="content">${i.employmentType}</div>

					<div class="section"></div>
				</div>

				<div class="company-details">

					<div class="label">Address:</div>
					<div class="content">${i.companyAddress}</div>

					<div class="label">Contact Person:</div>
					<div class="content">${i.contactPerson}</div>

					<div class="label">Email:</div>
					<div class="content">${i.contactEmail}</div>

					<div class="label">Phone:</div>
					<div class="content">${i.contactPhone}</div>

					<div class="label">Website:</div>
					<div class="content"><a href="${i.companyWebsite}">${i.companyWebsite}</a></div>
					
					<div class="section"></div>
				</div>

				<div class="job-description">
                
                    <div class="label">Description:</div>
                    <div class="content">${i.jobDescription}</div>
               
                    <div class="label">Skills:</div>
                    <div class="content">${i.essentialSkills}</div>
               
                    <div class="label">Additional Requirements:</div>
                    <div class="content">${i.additionalRequirements}</div>
                
                    <div class="label">Minimum Education:</div>
                    <div class="content">${i.minEducation}</div>
               
                    <div class="label">Preferred Qualification:</div>
                    <div class="content">${i.preferredQualification}</div>
                
            		
				</div>
        </div>
    </c:forEach>
</div>

</body>
</html>
