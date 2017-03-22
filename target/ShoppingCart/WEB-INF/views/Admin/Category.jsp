<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
     pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en-US">
<head><title>Category</title>
</head>
<style>
body  {
   
    background-color: #ffe6e6  ;
}
</style>

<body><center>
  <c:url var="addAction" value="create_category" ></c:url>

<form:form action="${addAction}" modelAttribute="category" id="btn-add">
   <h3>
                    <c:if test="$(category.id==0}">
		       Add New Item
	            </c:if>
	            <c:if test="${!empty category.id}">
	            
		      Update Item for Category List ID <c:out value="${category.id}"/> 
		      <form:hidden path="id"/>
	            </c:if>
	    
    </h3>     
	  <table>
	  
	  <tr>  <c:if test="${category.id!=0}">
	  <td> Id:</td> <td><form:input  path="id"/></td> 
	   </c:if>
	    <tr> <td>  Name:</td> <td><form:input  path="name"/></td> 
	    <tr> <td> Description:</td> <td><form:input path="description"/> </td> 
	     
		
  
	    <tr> <td colspan="2">
    	        <c:if test="${category.id==0}">
			      <input type="submit" value="Add" id="btn-add"> 
	         </c:if>
	         <c:if test="${category.id!=0}">
			      <input type="submit" value="Update" id="btn-update"> 
	         </c:if>
		</td> 
		<tr> <td colspan="2" class="success-msg">
		   <c:out value="${msg}"/>
		</td> 
	  </table>
	  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Category ID</th>
        <th>Category  Name</th>
        <th>Category  DESCRIPTION</th>
          <th>Action</th>
        
      </tr>
    </thead>
    	      <c:forEach var="category" items="${categoryList}">
		      <tr>
		                 <td> <c:out value="${category.id}"/> </td>
		                 <td> <c:out value="${category.name}"/> </td>
				 <td> <c:out value="${category.description}"/> </td>
				
				
				 <td> <a href="Delete_Category/${category.id}">Delete </a> |
				     <a href="Edit_Category/${category.id}">Edit</a> 
				 </td>
		      </tr>
	      </c:forEach>
          </table> 
         
 </form:form>
  </center>
</body>
</html>


 --%>
 
 
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Page</title>
</head>
<body>
	<center>
		<h2>Enter Category Details</h2>


		<form action="manage_create_category" method="post">
			<table>
				<tr>
					<td>CATEGORY ID:</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>CATEGORY NAME:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>DESCRIPTION:</td>
					<td><input type="text" name="description"></td>
				</tr>
			</table>
			<input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="Reset" value="reset">
		</form>
		
		
		

		<center>
			<h2>Categories</h2>
		</center>

		<table border="2">
			<thead>
				<tr>
					<td>ID</td>
					<td>NAME</td>
					<td>DESCRIPTION</td>
					<td>Action</td>
				</tr>
			</thead>
			
			
		
		
			<c:forEach var="category" items="${categoryList}">

				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					 
					<td><a href="manage_Edit_Category/${category.id}">Edit </a>|| <a
						href="manage_Delete_Category/${category.id}">Delete</a></td>
				</tr>
				

			</c:forEach>
		</table>

	</center>
</body>
</html>

 
 
 
 





