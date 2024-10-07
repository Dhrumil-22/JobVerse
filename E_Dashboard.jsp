<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="e_dashboard.css">
</head>
<body>


	<div id="Nav"><%@ include file="00_Employer_Nav.jsp"%></div>


<div id="backround">
	<div id="diff">

		<div id="head"><h4>ALL POST</h4></div>
		<div id="cardspace">
		<div id="Seeking">
		
			<c:forEach items="${sessionScope.SearchList}" var="i">
				<div class="card">
					<a href="RegController?flag=emp_jobDetails&&id=${i.id}" id="job-item-link">
						<div class="card-header">
							<div class="job-title">${i.technology}</div>
							<div class="company-name">${i.companyName}</div>
						</div>

						<div class="card-body">
							<div class="experience">
								<span class="icon">&#128187;</span> ${i.experience} Yrs
							</div>
							<div class="salary">
								<span class="icon">&#128181;</span> Not disclosed
							</div>
							<div class="location">
								<span class="icon">&#128205;</span> ${i.location}
							</div>

							<div class="job-description">${i.jobDescription}</div>
							<div class="skills">
								<span>Skills: </span>${i.essentialSkills}
							</div>
						</div>
					</a>
				</div>

			</c:forEach>
		</div>
		</div>
		</div>
</div>
</body>
</html>
