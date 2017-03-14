<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Page</title>
</head>
<body>
	<center>
		<h2>Enter Category Details</h2>
		<form action="create_category" method="post">
		  CATEGORY ID:    <input type="text" name="Category ID"><br>
		CATEGORY NAME:    <input type="text" name="Category Name"><br>
		  DESCRIPTION:    <input type="text" name="Description"><br> <input
				type="submit" value="Submit"> <input type="Reset" value="reset">
		</form>


<center><h2>Categories</h2></center>

		<table border="2">
			<thead>
				<tr>
					<td>ID</td>
					<td>NAME</td>
					<td>DESCRIPTION</td>
					<td>Action</td>
				</tr>
			</thead>
			<c:forEach var="category" items="${categoryList}">

				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td> <a href="<c:url value='/Edit_Category/${category.id}'/>">Edit </a>||
					 <a href="<c:url value='/Delete_Category/${category.id}'/>">Delete</a></td>
				</tr>

			</c:forEach>
		</table>

	</center>
</body>
</html>