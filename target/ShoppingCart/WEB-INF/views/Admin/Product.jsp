<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
</head>
<body>
	<center>
		<h2>Enter Product Details</h2>
		<table>
			<tr>
				<td>PRODUCT ID:</td>
				<td><input type="text" name="Product ID"></td>
			</tr>
			<tr>
				<td>PRODUCT NAME:</td>
				<td><input type="text" name="Product Name"></td>
			</tr>
			<tr>
				<td>PRICE:</td>
				<td><input type="text" name="Price"></td>
			</tr>
			<tr>
				<td>CATEGORY ID:</td>
				<td><input type="text" name="Category ID"></td>
			</tr>

			<tr>
				<td>SUPPLIER ID:</td>
				<td><input type="text" name="Supplier ID"></td>
			</tr>
		</table>
		<input type="submit" value="Submit"> <input type="Reset"
			value="reset">
	</center>

	<center>
		<h2>products</h2>
		<table border="2">
			<thead>
				<tr>
					<td>ID</td>
					<td>NAME</td>
					<td>DESCRIPTION</td>
					<td>CATEGORY_ID</td>
					<td>SUPPLIER_ID</td>
					<td>ACTION</td>
				</tr>
			</thead>
			<c:forEach var="product" items="${productList}">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.category_id}</td>
					<td>${product.supplier_id}</td>
					<td><a href="/Edit_Supplier">Edit </a>|| <a
						href="/Delete_Supplier">Delete</a></td>
					<td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>