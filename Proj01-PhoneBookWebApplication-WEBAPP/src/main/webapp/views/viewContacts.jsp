<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function deleteConfirm(){
	 confirm("Are You Sure, You Want To Delete");
}
</script>
</head>
<body>
	<h2>View Contacts Here</h2>
	<a href="/">+Add New Contacts</a>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Contact Number</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${contacts}" var="contact">

			<tr>
				<td>${contact.cname}</td>
				<td>${contact.email}</td>
				<td>${contact.cnum}</td>
				<td><a href="editContact?cid=${contact.cid}">Edit</a> 
				<a href="deleteContact?cid=${contact.cid}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>