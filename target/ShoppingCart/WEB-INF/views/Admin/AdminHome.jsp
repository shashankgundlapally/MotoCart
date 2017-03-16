<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is Admin Page</title>
</head>
<body>

	<c:if test="${isUserClickedAdminHome==true}">
	<center>
		<h2>NKART</h2>
		</center>
	<jsp:include page="../menu/AdminCategoryMenu.jsp"></jsp:include>
	</c:if>

<c:if test="${isUserClickedCategories==true||isUserClickedProducts==true||isUserClickedSuppliers==true}">
<jsp:include page="../menu/AdminCategoryMenu.jsp"></jsp:include>
</c:if>
	<c:if test="${isUserClickedCategories==true}">
		<jsp:include page="Category.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedProducts==true}">
		<jsp:include page="Product.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedSuppliers==true}">
		<jsp:include page="Supplier.jsp"></jsp:include>
	</c:if>

	
</body>
</html>