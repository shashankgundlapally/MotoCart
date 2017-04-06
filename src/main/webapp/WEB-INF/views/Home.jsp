<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>


</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<c:url value="/resources/Styles/Home.css"/>">
<script>
	src = "https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>

	<c:url var="back" value="resources/images/game.jpg"></c:url>
<body style=" background-image: url(${back})">

	<c:if test="${isAdmin!=true}">
		<jsp:include page="menu/CustomerCategoryMenu.jsp"></jsp:include>
		<jsp:include page="menu/Carousel.jsp"></jsp:include>
	</c:if>


	<c:if test="${isAdmin==true}">
		<center>
			<h2>Hello Admin</h2>

		</center>
		<%-- <jsp:include page="Admin/AdminHome.jsp"></jsp:include> --%>
		<jsp:include page="menu/AdminCategoryMenu.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedRegistration==true}">
		<jsp:forward page="Registration.jsp"></jsp:forward>
	</c:if>
	<%-- <c:if test="${isUserClickedLogin}">
		<jsp:include page="Login.jsp"></jsp:include>
		<br>
	</c:if> --%>

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
	<c:choose>
		<c:when test="${Clickedshowproduct}">
			<c:import url="/WEB-INF/views/ShowProduct.jsp"></c:import>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${Clickedcatproduct}">
			<c:import url="/WEB-INF/views/catproducts.jsp"></c:import>
		</c:when>
	</c:choose>



	<c:if test="${isUserClickedCart!=true}">

		<c:forEach items="${productList}" var="product">
			<tr>


				<td>
					<!-- <div class="thumbnail"> -->
					<div class="col-md-4">
						<a href="ShowProduct/${product.id}"> <img height="150px"
							width="150px" alt="${product.id }"
							src="<c:url value="/resources/images/${product.id }.jpg"></c:url>"></a>

						<td><c:url var="action"
								value="addtoCart/${userid}/${product.id}"></c:url> <form:form
								action="${action}" modelAttribute="cart">
								<td id="td1"><c:out value="${product.name}" /><br>
								<td id="td1"><c:out value="${product.price}" /> <input
									type="submit" class="btn btn-primary" value="Add To Cart" /><br>
							</form:form></td> <br>

					</div> <!-- </div> -->

				</td>
			</tr>
		</c:forEach>
	</c:if>

	<!--******************************************************************************************  -->

	<div align="bottom">
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>