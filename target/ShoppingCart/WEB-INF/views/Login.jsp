<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<div style="background-color:white;">
<table style="background-color: white;" height="100px">
<div>
<h2>This is Login Page</h2>

 <form action="perform_login" method="post">
<tr><td>USER ID:</td><td><input type ="text" name = "name" placeholder="User ID" ></td></tr>
<tr><td>PASSWORD:</td><td><input type ="password" name ="password" placeholder="Password"></td></tr>
<tr><td>LOGIN:<input type ="submit" value="Login"></td><td>&nbsp;&nbsp;&nbsp;&nbsp;RESET:<input type ="Reset" value="reset"></td></tr>

 </form>
 </div>
 </table>
 
 </center>
 
 <!-- <div class="login-page">
  <div class="form">
    <form class="register-form">
      <input type="text" placeholder="UserID" name="id"/>
      <input type="password" placeholder="password" name="password"/>
     
      <button>create</button>
      <p class="message">Already registered? <a href="#">Sign In</a></p>
    </form>
    <form class="login-form" action="validate" method="get">
      <input type="text" placeholder="UserID" name="id"/>
      <input type="password" placeholder="password" name="password"/>
      <button>login</button>
      <p class="message">Not registered? <a href="Registration">Create an account</a></p>
    </form>
  </div>
</div>
 --></body>

</html>