<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dish Edit Form</title>
</head>
<body>
<h2>Edit Dish</h2>
<form:form method="post" action="/RestaurantFrontend/update">
<table>
	<tr>
	<td></td>
	<td><form:hidden path="id"/></td>
	<tr>
	<td></td>
	<td><form:hidden path="name"/></td>
	</tr>
	<tr>
	<td></td>
	<td><form:hidden path="mobile_number"/></td>
	</tr>
	<tr>
	<td>Price</td>
	<td><form:input path="price"/></td>
	</tr>
	<tr>
	<td></td>
	<td><input type="submit" value="update" /></td>
	</tr>
</table>
</form:form>
</body>
</html>