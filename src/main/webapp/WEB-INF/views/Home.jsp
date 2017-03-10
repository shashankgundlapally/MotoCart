<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NKART Home Page</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
	<center>
		<h2>NKART</h2>
		<h3>hello this is home page</h3>

		${successMessage}<br>${role}<br> ${errorMessage}<br>
		${loginMessage}
	</center>
	<hr>
	<c:if test="${isAdmin!=true}">
		<jsp:include page="menu/CustomerCategoryMenu.jsp"></jsp:include>
	</c:if>


	<%-- <c:if test="${isAdmin==true}">
		<jsp:include page="Admin/AdminHome.jsp"></jsp:include>
	</c:if> --%>
	<c:if test="${isAdmin==true}">
		<center>
			<h2>Hello Admin</h2>
		</center>
		<jsp:include page="Admin/AdminHome.jsp"></jsp:include>
		<jsp:include page="menu/AdminCategoryMenu.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedLogin==true}">
		<jsp:include page="Login.jsp"></jsp:include>
		<br>
	</c:if>

	<c:if test="${not empty errorMessage }">
		<jsp:include page="Login.jsp"></jsp:include>
		<br>
	</c:if>



	<c:if test="${isUserClickedRegister==true}">
		<jsp:include page="Registration.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedCart == true}">
	<jsp:include page="Cart.jsp"></jsp:include>
	</c:if>



	<!-- <script>
		$(document).ready(function() {
			$('.dropdown-submenu a.test').on("click", function(e) {
				$(this).next('ul').toggle();
				e.stopPropagation();
				e.preventDefault();
			});
		});
	</script> -->
</body>
</html>