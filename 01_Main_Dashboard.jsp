<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Dashboard</title>
    <link rel="stylesheet" href="01_Main_Dashboard.css">
</head>
<body>
    <%@ include file="ACP2.jsp"%>
	
	<div id="Seeking">
     <c:forEach items="${postList}" var="i">
        <a href="Login.jsp" class="job-item-link">
            
            	<div class="job-item">
            		<div class="job-header">
            			<div class="job-title">${i.technology}</div>
            			<div class="company-name">${i.companyName}</div>
            		</div>
            		<div class="job-info">
            			<div class="experience">
            				<span class="icon">&#128187;</span>
            				${i.experience} Yrs
            			</div>
            			<div class="salary">
            				<span class="icon">&#128181;</span>
            				Not disclosed
            			</div>
            			<div class="location">
            				<span class="icon">&#128205;</span>
            				${i.location}
            			</div>
            		</div>
            		<div class="job-description">
            			<div class="description">
            				${i.jobDescription}
            			</div>
            			<div class="skills">
            				<span>Skills:</span>
            				${i.essentialSkills}
            			</div>
            		</div>
            </div>
        </a>
    </c:forEach>
</div>

</body>
</html>
