<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>

<h1>Menu List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Name</th><th>Price</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="food" items="${list}"> 
    <tr>
    <td>${food.name}</td>
    <td>${food.price}</td>
    <td><a href="editfood/${food.mobile_number}">Edit</a></td>
    <td><a href="deletefood/${food.mobile_number}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>

</body>
</html>