<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Dashboard - Post Job Opening</title>
<link rel="stylesheet" href="e_post.css">
</head>
<body>
	<div id="Nav"><%@ include file="00_Employer_Nav.jsp"%></div>

	<div id="diff">
		<div class="form-container">
			<h1>Create Job Post</h1>
			<form action="RegController?flag=Post" method="post">

				<!-- Job Details Section -->
				<fieldset>
					<legend>Job Details</legend>

					<label for="username">Username:</label> <input type="text"
						id="username" name="Username" placeholder="Enter Username"
						required>

					<!-- Technology -->
					<label for="technology">Technology:</label> <input type="text"
						id="technology" name="technology" placeholder="Enter Technology"
						required>

					<!-- Job Role -->
					<label for="jobRole">Job Role:</label> <input type="text"
						id="jobRole" name="jobRole" placeholder="Enter Job Role" required>

					<!-- Department -->
					<label for="department">Department:</label> <input type="text"
						id="department" name="department" placeholder="Enter Department"
						required>

					<!-- Employment Type -->
					<label for="employmentType">Employment Type:</label> <select
						id="employmentType" name="employmentType" required>
						<option value="full-time">Full-Time</option>
						<option value="part-time">Part-Time</option>
						<option value="contract">Contract</option>
						<option value="temporary">Temporary</option>
						<option value="internship">Internship</option>
					</select>

					<!-- Job Location -->
					<label for="location">Job Location:</label> <input type="text"
						id="location" name="location" placeholder="Enter Job Location"
						required>

					<!-- Experience -->
					<label for="experience">Experience Required (Years):</label> <input
						type="number" id="experience" name="experience"
						placeholder="Enter Experience" required min="0">
				</fieldset>

				<!-- Company Details Section -->
				<fieldset>
					<legend>Company Details</legend>

					<!-- Company Name -->
					<label for="companyName">Company Name:</label> <input type="text"
						id="companyName" name="companyName"
						placeholder="Enter Company Name" required>

					<!-- Company Website -->
					<label for="companyWebsite">Company Website:</label> <input
						type="url" id="companyWebsite" name="companyWebsite"
						placeholder="Enter Company Website" required>

					<!-- Company Address -->
					<label for="companyAddress">Company Address:</label>
					<textarea id="companyAddress" name="companyAddress"
						placeholder="Enter Company Address" required></textarea>

					<!-- Contact Person -->
					<label for="contactPerson">Contact Person:</label> <input
						type="text" id="contactPerson" name="contactPerson"
						placeholder="Enter Contact Person Name" required>

					<!-- Contact Email -->
					<label for="contactEmail">Contact Email:</label> <input
						type="email" id="contactEmail" name="contactEmail"
						placeholder="Enter Contact Email" required>

					<!-- Contact Phone -->
					<label for="contactPhone">Contact Phone:</label> <input type="tel"
						id="contactPhone" name="contactPhone"
						placeholder="Enter Contact Phone" required>
				</fieldset>

				<!-- Job Description Section -->
				<fieldset>
					<legend>Job Description</legend>

					<!-- Job Description -->
					<label for="jobDescription">Job Description:</label>
					<textarea id="jobDescription" name="jobDescription"
						placeholder="Describe the Job" required></textarea>

					<!-- Essential Skills -->
					<label for="essentialSkills">Essential Skills:</label>
					<textarea id="essentialSkills" name="essentialSkills"
						placeholder="List the Essential Skills" required></textarea>

					<!-- Additional Requirements -->
					<label for="additionalRequirements">Additional
						Requirements:</label>
					<textarea id="additionalRequirements" name="additionalRequirements"
						placeholder="Enter Additional Requirements"></textarea>
				</fieldset>

				<!-- Education Section -->
				<fieldset>
					<legend>Education & Qualification</legend>
 
					<!-- Minimum Education -->
					<label for="minEducation">Minimum Education:</label> <input
						type="text" id="minEducation" name="minEducation"
						placeholder="Enter Minimum Education" required>

					<!-- Preferred Qualification -->
					<label for="preferredQualification">Preferred
						Qualification:</label> <input type="text" id="preferredQualification"
						name="preferredQualification"
						placeholder="Enter Preferred Qualification">
				</fieldset>

				<!-- Submission -->
				<button type="submit">Submit Job Post</button>
			</form>
		</div>
	</div>
</body>
</html>
