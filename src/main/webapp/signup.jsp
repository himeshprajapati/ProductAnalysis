<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<style>
/* CSS styles */
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
}

.container {
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
	margin-bottom: 20px;
}

label {
	display: block;
	margin-bottom: 10px;
}

input[type="text"], input[type="email"], input[type="password"] {
	width: 100%;
	padding: 10px;
	border-radius: 5px;
	border: 1px solid #ccc;
}

input[type="submit"] {
	display: block;
	width: 100%;
	padding: 10px;
	margin-top: 20px;
	background-color: #4CAF50;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.error-message {
	color: red;
	margin-top: 5px;
}

.login-button {
	display: block;
	width: 100%;
	padding: 10px;
	margin-top: 20px;
	background-color: #4CAF50;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.login-button {
	background-color: #ccc;
}




</style>
<script>
	// JavaScript code
	window.onload = function() {
		var signupForm = document.getElementById('signupForm');
		signupForm.onsubmit = function() {
			var password = document.getElementById('password').value;
			var confirmPassword = document.getElementById('confirmPassword').value;

			if (password !== confirmPassword) {
				var errorDiv = document.getElementById('errorDiv');
				errorDiv.innerHTML = 'Passwords do not match';
				return false; // Prevent form submission
			}

			// Perform additional form validation or other actions if needed
		};
	};
</script>
</head>
<body>
	<div class="container">
		<h1>Signup</h1>
		<form id="signupForm" method="post" action="registration">
			<label for="username">Fullname:</label> <input type="text"
				id="fullname" name="fullname" required><br>
			<br> <label for="email">Email:</label> <input type="email"
				id="email" name="email" required><br>
			<br> <label for="password">Password:</label> <input
				type="password" id="password" name="pass" required><br>
			<br> <label for="confirmPassword">Confirm Password:</label> <input
				type="password" id="confirmPassword" name="cpass" required><br>
			<div id="errorDiv" class="error-message"></div>
			<br> <input type="submit" value="Signup">
			<button class="login-button"
				onclick="window.location.href='index.jsp'">Login</button>
			
			

		</form>
		 <h2><%
    if(null!=request.getAttribute("Success"))
    {
        out.println(request.getAttribute("Success"));
    }
%></h2>
	</div>
</body>
</html>
