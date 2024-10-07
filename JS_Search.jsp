<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Dashboard</title>
    <link rel="stylesheet" href="js_search.css">
</head>
<body>


<header>
    <div id="logo">
        <h2 onclick="window.location.href='JS_Dashboard.jsp'" style="cursor: pointer;">JOBVERSE</h2>
    </div>
   <div id="box_nav">
            <nav id="nav">
				<form action="RegController" method="post">
					<input type="text" id="Search" name="Search" placeholder="Search">
					<input type="hidden" name="flag" value="Search">
					<button type="submit" class="search">SEARCH</button>
					<button type="submit" class="all">SEE ALL</button>
				</form>
            </nav>
        </div>
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

    
    <c:if test="${not empty SearchList}">
    <ul class="job-list">
        <c:forEach var="post" items="${List}">
         <a href="RegController?flag=Details&&id=${post.id}" class="job-item-link">
            <li class="job-item">
                <div class="job">
                    <div class="job-detail">
                        <div class="company"><strong>Company:</strong> ${post.companyName}</div>
                        <div class="skills"><strong>Skills:</strong> ${post.essentialSkills}</div>
                        <div class="description"><strong>Description:</strong> ${post.jobDescription}</div>
                    </div>
                </div>
            </li>
            </a>
        </c:forEach>
    </ul>
</c:if>
<c:if test="${empty SearchList}">
    <p class="no-results">No results found for "${param.Search}".</p>
</c:if>


    


</body>
</html>
