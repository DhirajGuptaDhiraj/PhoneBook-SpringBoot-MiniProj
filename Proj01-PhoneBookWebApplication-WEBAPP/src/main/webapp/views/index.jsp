<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
	<h2>Contact Info Form</h2>
	
	<font color='green'>${succMsg}</font>
	<font color='red'>${errMsg}</font>
	<form:form action="saveContact" method="POST" modelAttribute="contact">
		<table>
			<tr>
				<td>Contact Name</td>
				<td><form:input path="cname" /></td>
				<form:hidden path="cid"/>
			</tr>
			<tr>
				<td>Contact Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td><form:input path="cnum" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="saveContact" /></td>
			</tr>
		</table>
	</form:form>
	<a href="viewContacts">View All Contacts</a>
</body>
</html>