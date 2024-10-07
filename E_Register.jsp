<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employer Register</title>
    <link rel="stylesheet" href="e_register.css">
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
            <button class="dropdown-button">EMPLOYER REGISTER<span class="arrow">&#9662;</span></button>
            <div class="dropdown-content">
                <a href="JS_Register.jsp">JOB-SEEKER</a>
            </div>
        </div>
        
        <!-- Modify the form to allow file uploads -->
        <form action="RegController?flag=Employer" method="post" enctype="multipart/form-data">
        
        <!-- New field for profile picture upload -->
            <label for="profilePic">Profile Picture</label>
            <input type="file" id="profilePic" name="profilePic" accept="image/*"><br>
        
        
            <label for="firstName">First Name</label>
            <input type="text" id="firstName" name="E_FirstName" placeholder="Enter your first name">

            <label for="lastName">Last Name</label>
            <input type="text" id="lastName" name="E_LastName" placeholder="Enter your last name">

            <label for="email">Email</label>
            <input type="email" id="email" name="E_Email" placeholder="Enter your email">

            <label for="username">User Name</label>
            <input type="text" id="username" name="E_UserName" placeholder="Choose a username">

            <label for="password">Password</label>
            <input type="password" id="password" name="E_Password" placeholder="Enter a password">

            <label for="bestFriend">Your Best Friend's Name</label>
            <input type="text" id="bestFriend" name="E_Bestf" placeholder="This is for Security Purpose">

            <label for="industry">Industry</label>
            <input type="text" id="industry" name="E_Industry" placeholder="Your industry">

            <label for="companyName">Company Name</label>
            <input type="text" id="companyName" name="E_CompanyName" placeholder="Your company name">

            <label for="currentCity">Current City</label>
            <input type="text" id="currentCity" name="E_CurrentCity" placeholder="Current city where you live">

            <label for="currentState">Current State</label>
            <input type="text" id="currentState" name="E_CurrentState" placeholder="Current state where you live">

            

            <input type="hidden" name="flag" value="Employer">
            <button type="submit" class="register-button">Register</button>
        </form>
    </div>
</div>

</body>
</html>
