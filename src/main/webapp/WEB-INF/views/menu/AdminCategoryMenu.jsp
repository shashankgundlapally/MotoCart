<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Category</title>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">MotoCart</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="AdminHome"> <span class="glyphicon glyphicon-home"></span>Home</a></li>
      <li><a href="manage_Category">Categories</a></li>
      <li><a href="manage_Products">Products</a></li>
      <li><a href="manage_Suppliers">Suppliers</a></li>
      </ul>
      </div>
    
			<div>
			<p style="color:white" align="center">${loginMessage}</p>
			</div>
     
      <div> 
      
	<ul class="nav navbar-nav navbar-right">
	<sec:authorize access="isAuthenticated()">
		<li><a href="perform_logout"> <span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
		</sec:authorize>
	</ul>
	
	</div>
    
  </div>
</nav>

</body>
</html>