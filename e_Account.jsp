<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main Page</title>
    <link rel="stylesheet" href="e_account.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    
</head>
<body>
<%@ include file="E_ACP.jsp"%>


<div id="diff">
    <c:forEach items="${sessionScope.E_acc}" var="i">
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
                    
                    
                </div>
            </div>
            <div class="job-seeking-info">
                <div class="label">Industry:</div>
                <div class="content">${i.industry}</div>
                <div class="label">Company Name:</div>
                <div class="content">${i.companyName}</div>
                <div class="label">Current City:</div>
                <div class="content">${i.currentCity}</div>
                <div class="label">Current State:</div>
                <div class="content">${i.currentState}</div>
            </div>
        </div>
    </c:forEach>
</div>



    

</body>
</html>
