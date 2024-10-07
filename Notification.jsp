<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="Notification.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

</head>
<body>
	<div id="Nav"><%@ include file="00_Employer_Nav.jsp"%></div>
	
<div id="backround">

	<div id="diff">

		<div id="head"><h4>NOTIFICATION</h4></div>
<div id="cardspace">
		<div id="vicharvanuBaki"></div>

		<div id="Seeking">
			<c:forEach items="${sessionScope.ApplytList}" var="i">

				<div class="content-area">
            <div class="profile-container">
                <div class="profile-picture">
                    <c:choose>
                        <c:when test="${i.profilePic != null}">
                            <img src="Image/profile_pic_${i.id}.jpg" alt="Profile Picture" />
                        </c:when>
                        <c:otherwise>
                            <img src="Image/predefinedImage.jpg" alt="Default Profile Picture" />
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="profile-info">
                    <div class="name">${i.firstName} ${i.lastName}</div>
                    <div class="content"><i class="fa-solid fa-user"></i> ${i.userName}</div>
                    <div class="content"><i class="fas fa-envelope"></i> ${i.email}</div>
                    
                    <c:choose>
                        <c:when test="${i.resume != null}">
                            <a href="Image/resume_${i.id}.jpg" target="_blank">View Resume</a>
                        </c:when>
                        <c:otherwise>
                            <span>No Resume Available</span>
                        </c:otherwise>
                    </c:choose>
                    
                   
                </div>
            </div>

					<div id="Seeking2">

						<div class="job-info">
							<div class="label">Education:</div>
							<div class="content">${i.education}</div>

							<div class="label">Current City:</div>
							<div class="content">${i.currentCity}</div>

							<div class="label">Current State:</div>
							<div class="content">${i.currentState}</div>
						</div>

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
							
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		</div>

		<div id="vicharvanuBaki"></div>
	</div>
	</div>










</body>
</html>