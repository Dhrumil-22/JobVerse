<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Job-Seeker Register</title>
    <link rel="stylesheet" href="js_register.css">
</head>
<body>

<header>
    <div id="logo">
        <h2>JOBVERSE</h2>
    </div>
    <div id="Log">
        <nav id="pro_nav">
            <div class="dropdown">
                <a id="f" href="Login.jsp">Already Registered? Login here</a>
            </div>
        </nav>
    </div>
</header>

<div class="container">
    <div class="register-box">
        <div class="dropdown">
            <button class="dropdown-button">JOB-SEEKER REGISTER<span class="arrow">&#9662;</span></button>
            <div class="dropdown-content">
                <a href="E_Register.jsp">EMPLOYER</a>
            </div>
        </div>
        <form action="RegController?flag=Job-seeker" method="post" enctype="multipart/form-data">
        
         	<label for="profilePic">Profile Picture</label>
            <input type="file" id="profilePic" name="profilePic" accept="image/*"><br>
        
            <label for="firstName">First Name</label>
            <input type="text" id="firstName" name="JS_FirstName" placeholder="Enter your first name">

            <label for="lastName">Last Name</label>
            <input type="text" id="lastName" name="JS_LastName" placeholder="Enter your last name">

            <label for="email">Email</label>
            <input type="email" id="email" name="JS_Email" placeholder="Enter your email">

            <label for="username">User Name</label>
            <input type="text" id="username" name="JS_UserName" placeholder="Choose a username">

            <label for="password">Password</label>
            <input type="password" id="password" name="JS_Password" placeholder="Enter a password">

            <label for="education">Education</label>
            <input type="text" id="education" name="JS_Education" placeholder="Your highest qualification" list="education-options">
            <datalist id="education-options">
                <option value="Pursuing Diploma">
                <option value="Graduate from Diploma">
                <option value="Pursuing Degree">
                <option value="Graduate from Degree">
            </datalist>
            
            <label for="location">Your BestFriend Name</label>
            <input type="text" id="location" name="JS_Bestf" placeholder="This is for Security Purpose">
            

            <label for="location">Current City</label>
            <input type="text" id="location" name="JS_CurrentCity" placeholder="Current city where you live">

            <label for="state">Current State</label>
            <input type="text" id="state" name="JS_CurrentState" placeholder="Current state where you live">

			<!-- New field for profile picture upload -->
           

            <input type="hidden" name="flag" value="Job-seeker">
            <button type="submit" class="register-button">Register</button>
        </form>
    </div>
</div>

</body>
</html>
