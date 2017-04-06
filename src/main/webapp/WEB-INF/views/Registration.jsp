<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>Registration Page</title>
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
<c:url var="back" value="resources/images/Login.jpg"></c:url>
<body style=" background-image: url(${back})">
	
	</div>
	<jsp:include page="menu/CustomerCategoryMenu.jsp"></jsp:include>
<center>
<h2 style="color: white" > Register here </h2>
</center>

<c:url var="action" value="Registration"></c:url>
<center>
	<form:form action="${action}" method="post" commandName="user">

	
	
	<div class="input-group margin-bottom-sm">
	<table>
			<tr style="color: white" ><td><form:label path="name"><spring:message text="Name" /></form:label></td>
			<td><form:input path="name" required="true" /></td></tr>
		


		
			<tr style="color: white" ><td><form:label path="password"><spring:message text="Password" /></form:label></td>
			<td><form:input path="password" required="true" /></td></tr>
		
		
		
		<tr style="color: white" ><td><form:label path="contact"><spring:message text="Contact" /></form:label></td>
		<td  style="color: white" ><form:input path="contact" required="true" /></td></tr>
		
		
		
		<tr  style="color: white"><td><form:label path="email"><spring:message text="E-mail" /></form:label></td>
		<td  style="color: white" ><form:input path="email" required="true" /></td></tr>
		</table>
		</div>
		
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
		<input type="submit" class="btn btn-default" value="Register">
	</form:form>
	</center>
	<%-- <jsp:include page="Menu/Footer.jsp"></jsp:include> --%>
	
</body>
</html>