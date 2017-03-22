<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is Admin Page</title>
<style>
body {
    background-image: url("resources/Images/background-1.jpg");
}
</style>
</head>
<body>
<script>
document.body.style.backgroundImage="url('resources/Images/blue_background.jpg')"
</script>
<img class="img-circle"  src="<c:url value="/resources/Images/background-5.jpg"></c:url>" alt="ShoppingCartPic" width="100px" height="100px" align="left" > 
<center>
	<%-- <img src="<c:url value="/resources/Images/custom-shopping-cart.png"></c:url>" alt="ShoppingCartPic" width="100px" height="100px" align="left"><br> --%>
		<h2 style="color:green; font-family: fantasy;">NKART</h2>
		<h3 style="color:red;font-family:cursive;">Shopping is an art</h3>
		</center><br>

	<c:if test="${isUserClickedAdminHome==true}">
	
	<jsp:include page="../menu/AdminCategoryMenu.jsp"></jsp:include>
	</c:if>

<%-- <c:if test="${isUserClickedCategories==true||isUserClickedProducts==true||isUserClickedSuppliers==true}">
<jsp:include page="../menu/AdminCategoryMenu.jsp"></jsp:include>
</c:if> --%>
	<c:if test="${isUserClickedCategories==true}">
	<jsp:include page="../menu/AdminCategoryMenu.jsp"></jsp:include>
		<jsp:include page="Category.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedProducts==true}">
	<jsp:include page="../menu/AdminCategoryMenu.jsp"></jsp:include>
		<jsp:include page="Product.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedSuppliers==true}">
	<jsp:include page="../menu/AdminCategoryMenu.jsp"></jsp:include>
		<jsp:include page="Supplier.jsp"></jsp:include>
	</c:if>

	
</body>
</html>