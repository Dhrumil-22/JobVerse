<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main Page</title>
    <link rel="stylesheet" href="e_privacy.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
 
</head>
<body>

   <%@ include file="E_ACP.jsp"%>

    <div id="diff">
    
    <div class="container">
    <div class="login-box">
        <h3>Reset Password</h3>
        <form action="RegController" method="post">
            <label for="username">User Name</label>
            <input type="text" id="username" name="UserName" placeholder="Enter your username">

            <label for="location">Your BestFriend Name</label>
            <input type="text" id="location" name="Bestf" placeholder="This is for Security Purpose">

            <input type="hidden" name="flag" value="Check">
            <button type="submit" class="login-button">Reset Now</button>

           
        </form>       
    </div>
    
    <div id="number">
    
    	<div id="content">
			<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="#151717" class="bi bi-1-circle-fill" viewBox="0 0 16 16">
 			 <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0M9.283 4.002H7.971L6.072 5.385v1.271l1.834-1.318h.065V12h1.312z" />
			</svg>
		</div>
		
		<div id="content3">
			<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="#80898b" class="bi bi-2-circle-fill" viewBox="0 0 16 16">
  				<path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0M6.646 6.24c0-.691.493-1.306 1.336-1.306.756 0 1.313.492 1.313 1.236 0 .697-.469 1.23-.902 1.705l-2.971 3.293V12h5.344v-1.107H7.268v-.077l1.974-2.22.096-.107c.688-.763 1.287-1.428 1.287-2.43 0-1.266-1.031-2.215-2.613-2.215-1.758 0-2.637 1.19-2.637 2.402v.065h1.271v-.07Z"/>
			</svg>
		</div>
	</div>


</div>
		
	</div>

</body>
</html>
