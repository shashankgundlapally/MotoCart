<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Page</title>
</head>
<body>
	<center>
		<h2>Enter Supplier Details</h2>
		<form action="">
			SUPPLIER ID:<input type="text" name="Supplier ID"><br>
			SUPPLIER NAME:<input type="text" name="Supplier Name"><br>
			ADDRESS:<input type="text" name="Address"><br> <input
				type="submit" value="Submit"> <input type="Reset"
				value="reset">
		</form>
	</center>

	<center>
		<h2>Suppliers</h2>
		<table border="2">
			<thead>
				<tr>
					<td>ID</td>
					<td>NAME</td>
					<td>ADDRESS</td>
					<td>ACTION</td>
				</tr>
			</thead>
			<c:forEach var="supplier" items="${supplierList}">
				<tr>
					<td>${supplier.id}</td>
					<td>${supplier.name}</td>
					<td>${supplier.address}</td>
					<td><a href="/Edit_Category">Edit </a>|| <a
						href="/Delete_Category">Delete</a></td>
					<td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>