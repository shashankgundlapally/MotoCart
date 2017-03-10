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
PRODUCT ID:<input type ="text" name = "Product ID"><br>
PRODUCT NAME:<input type="text" name="Product Name"><br>
PRICE:<input type="text" name="Price"><br>
CATEGORY ID:<input type ="option" name = "Category ID">
<select>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
</select>
<br>
SUPPLIER ID:<input  list ="down" type ="text" name = "Supplier ID"><br>
<input type ="submit" value="Submit">
<input type ="Reset" value="reset">
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