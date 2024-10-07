<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="emp_post.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

</head>
<body>
	<div id="Nav"><%@ include file="00_Employer_Nav.jsp"%></div>

<div id="backround">
	<div id="diff">
	
	<div id="head"><h4>MY POST</h4></div>
	
	<div id="cardspace">


		<div id="Seeking">
			<c:forEach items="${sessionScope.SearchList1}" var="i">
				<div class="card">
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

					<div class="card-footer">
						<a href="RegController?flag=edit&&id=${i.id}"
							class="icon edit-icon"><span class="icon"><i
								class="fas fa-edit"></i> </span></a>
						<!-- Edit Icon -->
						<a href="RegController?flag=delete&&id=${i.id}"
							class="icon delete-icon"><span class="icon"><i
								class="fa-sharp fa-solid fa-trash"></i></span></a>
						<!-- Delete Icon -->
						<a href="RegController?flag=emp_jobdetailedit&&id=${i.id}"
							class="icon-btn arrow-icon"><span class="icon arrow-icon">&#10148;</span></a>
						<!-- New Arrow Icon -->
					</div>

				</div>

			</c:forEach>
		</div>
		</div>
		</div>
		</div>





</body>
</html>