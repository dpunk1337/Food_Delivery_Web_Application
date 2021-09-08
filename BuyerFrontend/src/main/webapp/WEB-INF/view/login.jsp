<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Portal Login</title>
</head>
<body>
<h1>Welcome To Login Page</h1>
<form action="checkCredentials" method="post">

Mobile Number : <input type="number" name="mobile_number" /> <br>
Password <input type="text" name="password" />  <br>
			
<input type="submit" value="login" /><br>
<a href="/signUp">Sign Up</a>
			
</form>
</body>
</html>