<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
 <link rel="stylesheet" href="../../resources/Login/css/style.css">
 
<link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
	<c:url var="back" value="resources/images/Login.jpg"></c:url>
<body style=" background-image: url(${back})">

	<center>
		<img class="img-circle"
			src="<c:url value="resources/images/CARlogo1.jpg"></c:url>"
			alt="ShoppingCartPic" width="100px" height="80px" align="left">
	</center>
	<div>
		<center>
			<h2 style="color: white; font-family: fantasy;" align="right" > Moto Cart </h2>
			<h3 style="color: red; font-family: cursive;"  align="right" > Deals like never before </h3>
		</center>
	</div>
	<jsp:include page="menu/CustomerCategoryMenu.jsp"></jsp:include>
<center>
<div>
<h2 style="font-size: 40px; color:cyan">Login to the Automobile World</h2>

<form action="perform_login" method="post" id="login">
<table height="100px">
<tr><td>USER NAME:</td><td><input type ="text" name = "j_username" placeholder="User Name" ></td></tr>
<tr><td>PASSWORD:</td><td><input type ="password" name ="j_password" placeholder="Password"></td></tr>
<tr><td>LOGIN:<input type ="submit" value="Login"></td><td>&nbsp;&nbsp;&nbsp;&nbsp;RESET:<input type ="Reset" value="reset"></td></tr>

</table>
</form> 
<p> Not  registered? <a href="Registration" method="post"> Create account Here </a></p> 

<%-- <div class="container">
	<section id="content">
		<form action="perform_login" method="post" id="login">
			<h1>Login Form</h1>
			<div>
				<input type="text"  name="j_username" placeholder="Username" required="true" id="username" />
			</div>
			<div>
				<input type="password" name=""placeholder="Password" required="true" id="password" />
			</div>
			<div>
				<input type="submit" value="Log in" />
				<a href="#">Lost your password?</a>
				<a href="Registration">Register</a>
			</div>
		</form><!-- form -->
		<div class="button">
			<a href="#">Download source file</a>
		</div><!-- button -->
	</section><!-- content -->
</div><!-- container -->

  
    <script src="resources/Login/js/index.js"></script>
 --%>
 
 </div>
</center> 
</body>


</html>

