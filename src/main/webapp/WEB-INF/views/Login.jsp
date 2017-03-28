<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<c:url value="/resources/Styles/Home.css"/>">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
	<c:url var="back" value="resources/Images/Login.jpg"></c:url>
<body style=" background-image: url(${back})">
	<center>
		<img class="img-circle"
			src="<c:url value="/resources/Images/background-5.jpg"></c:url>"
			alt="ShoppingCartPic" width="100px" height="80px" align="left">
	</center>
	<div>
		<center>
			<h2 style="color: green; font-family: fantasy;">NKART</h2>
			<h3 style="color: red; font-family: cursive;">Shopping is an art</h3>
		</center>
	</div>
	<jsp:include page="menu/CustomerCategoryMenu.jsp"></jsp:include>
<center>
<div>
<h2>This is Login Page</h2>
<form action="perform_login" method="post">
<table height="100px">
<tr><td>USER NAME:</td><td><input type ="text" name = "j_username" placeholder="User Name" ></td></tr>
<tr><td>PASSWORD:</td><td><input type ="password" name ="j_password" placeholder="Password"></td></tr>
<tr><td>LOGIN:<input type ="submit" value="Login"></td><td>&nbsp;&nbsp;&nbsp;&nbsp;RESET:<input type ="Reset" value="reset"></td></tr>
<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
		<input type="submit" class="btn btn-default" value="Register"> --%>
</table>
</form>
</div>
<p>New User?Register Here<a href="Registration" method="post">Register</a></p> 
 </center>
 

</body>

</html>