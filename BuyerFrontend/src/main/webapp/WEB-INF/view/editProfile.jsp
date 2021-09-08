<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Profile</h1>
<form:form action="updateProfile" method="POST">
	<table>
		<tr>
			<td></td>
			<td><form:hidden path="mobileNumber"/></td>
		</tr>
		<tr>
			<td>Enter Name :</td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>Enter City :</td>
			<td><form:input path="city"/></td>
		</tr>
		<tr>
			<td>Enter Address :</td>
			<td><form:input path="address"/></td>
		</tr>
			<td></td>
			<td><form:hidden path="password"/><input type="submit" value="Save Changes"/></td>
		</tr>
	</table>
</form:form>
</body>
</html>