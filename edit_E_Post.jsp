<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Job Post</title>
    <link rel="stylesheet" href="e_post.css">
</head>
<body>
   <div id="Nav"><%@ include file="00_Employer_Nav.jsp"%></div>

    <!-- Edit Form Container -->
    <div id="diff">
        <div class="form-container">
            <h1>Edit Job Post</h1>

            <!-- Display Messages (Optional) -->
            <c:if test="${not empty message}">
                <div class="message">${message}</div>
            </c:if>

            <!-- Iterate Over Edit List -->
            <c:forEach items="${sessionScope.editList}" var="i">
                <form action="RegController?flag=Update&id=${i.id}" method="post">

                    <!-- Hidden Field for ID (Optional) -->
                    <input type="hidden" name="id" value="${i.id}" />

                    <!-- Job Details Section -->
                    <fieldset>
                        <legend>Job Details</legend>
                        
                        <!-- Username -->
                        <label for="username">Username:</label>
                        <input type="text" id="username" name="username" placeholder="Enter Username" value="${i.username}" required >

                        <!-- Technology -->
                        <label for="technology">Technology:</label>
                        <input type="text" id="technology" name="technology" placeholder="Enter Technology" value="${i.technology}" required>

                        <!-- Job Role -->
                        <label for="jobRole">Job Role:</label>
                        <input type="text" id="jobRole" name="jobRole" placeholder="Enter Job Role" value="${i.jobRole}" required>

                        <!-- Department -->
                        <label for="department">Department:</label>
                        <input type="text" id="department" name="department" placeholder="Enter Department" value="${i.department}" required>

                        <!-- Employment Type -->
                        <label for="employmentType">Employment Type:</label>
                        <select id="employmentType" name="employmentType" required>
                            <option value="full-time" <c:if test="${i.employmentType == 'full-time'}">selected</c:if>>Full-Time</option>
                            <option value="part-time" <c:if test="${i.employmentType == 'part-time'}">selected</c:if>>Part-Time</option>
                            <option value="contract" <c:if test="${i.employmentType == 'contract'}">selected</c:if>>Contract</option>
                            <option value="temporary" <c:if test="${i.employmentType == 'temporary'}">selected</c:if>>Temporary</option>
                            <option value="internship" <c:if test="${i.employmentType == 'internship'}">selected</c:if>>Internship</option>
                        </select>

                        <!-- Job Location -->
                        <label for="location">Job Location:</label>
                        <input type="text" id="location" name="location" placeholder="Enter Job Location" value="${i.location}" required>

                        <!-- Experience -->
                        <label for="experience">Experience Required (Years):</label>
                        <input type="number" id="experience" name="experience" placeholder="Enter Experience" value="${i.experience}" required min="0">
                    </fieldset>

                    <!-- Company Details Section -->
                    <fieldset>
                        <legend>Company Details</legend>

                        <!-- Company Name -->
                        <label for="companyName">Company Name:</label>
                        <input type="text" id="companyName" name="companyName" placeholder="Enter Company Name" value="${i.companyName}" required>

                        <!-- Company Website -->
                        <label for="companyWebsite">Company Website:</label>
                        <input type="url" id="companyWebsite" name="companyWebsite" placeholder="Enter Company Website" value="${i.companyWebsite}" required>

                        <!-- Company Address -->
                        <label for="companyAddress">Company Address:</label>
                        <textarea id="companyAddress" name="companyAddress" placeholder="Enter Company Address" required>${i.companyAddress}</textarea>

                        <!-- Contact Person -->
                        <label for="contactPerson">Contact Person:</label>
                        <input type="text" id="contactPerson" name="contactPerson" placeholder="Enter Contact Person Name" value="${i.contactPerson}" required>

                        <!-- Contact Email -->
                        <label for="contactEmail">Contact Email:</label>
                        <input type="email" id="contactEmail" name="contactEmail" placeholder="Enter Contact Email" value="${i.contactEmail}" required>

                        <!-- Contact Phone -->
                        <label for="contactPhone">Contact Phone:</label>
                        <input type="tel" id="contactPhone" name="contactPhone" placeholder="Enter Contact Phone" value="${i.contactPhone}" required>
                    </fieldset>

                    <!-- Job Description Section -->
                    <fieldset>
                        <legend>Job Description</legend>

                        <!-- Job Description -->
                        <label for="jobDescription">Job Description:</label>
                        <textarea id="jobDescription" name="jobDescription" placeholder="Describe the Job" required>${i.jobDescription}</textarea>

                        <!-- Essential Skills -->
                        <label for="essentialSkills">Essential Skills:</label>
                        <textarea id="essentialSkills" name="essentialSkills" placeholder="List the Essential Skills" required>${i.essentialSkills}</textarea>

                        <!-- Additional Requirements -->
                        <label for="additionalRequirements">Additional Requirements:</label>
                        <textarea id="additionalRequirements" name="additionalRequirements" placeholder="Enter Additional Requirements">${i.additionalRequirements}</textarea>
                    </fieldset>

                    <!-- Education Section -->
                    <fieldset>
                        <legend>Education & Qualification</legend>

                        <!-- Minimum Education -->
                        <label for="minEducation">Minimum Education:</label>
                        <input type="text" id="minEducation" name="minEducation" placeholder="Enter Minimum Education" value="${i.minEducation}" required>

                        <!-- Preferred Qualification -->
                        <label for="preferredQualification">Preferred Qualification:</label>
                        <input type="text" id="preferredQualification" name="preferredQualification" placeholder="Enter Preferred Qualification" value="${i.preferredQualification}">
                    </fieldset>

                    <!-- Submit Button -->
                    <button type="submit">Update Job Post</button>
                </form>
            </c:forEach>
        </div>
    </div>
    
</body>
</html>
