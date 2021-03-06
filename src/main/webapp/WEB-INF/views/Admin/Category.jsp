<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Page</title>
</head>
<body>
	${Message}
	<center>
		<h2>Enter Category Details</h2>


		
	<c:if test="${empty category.name}">
		<c:url var="addAction" value="/manage_create_category"></c:url>
		</c:if>
		<c:if test="${!empty category.name}">
		<c:url var="addAction" value="/manage_Update_category"></c:url>
		</c:if>
		
		<form:form action="${addAction}" commandName="category" method="post">

			<table border="7">
				<thead>

					<tr>

						<td style="color: red"><form:label path="id">
								<spring:message text="Id" />
							</form:label></td>

						<c:choose>
							<c:when test="${not empty category.id} ">
								<td style="color: red"><form:hidden path="id" readonly="true" editable="false"/></td>
							</c:when>
							<c:otherwise>
								<td style="color: red"><form:hidden path="id" required="true"
										title="id should contain 5 to 20 characters" /></td>
							</c:otherwise>
						</c:choose>
					<tr>
						<td style="color: red"><form:label path="name">
								<spring:message text="Name" />
							</form:label></td>
						<td><form:input path="name" required="true" /></td>
					</tr>

					<tr>
						<td style="color: red"><form:label path="description">
								<spring:message text="Description" />
							</form:label></td>
						<td><form:input path="description" required="true" /></td>
					</tr>

					<tr>
						<td colspan="2"><c:if test="${!empty category.name}">
								<input type="submit"
									value="<spring:message text="Update"/>" />
							</c:if> <c:if test="${empty category.name}">
								<input type="submit"
									value="<spring:message text="Create"/>" />
							</c:if></td>
					</tr>
			</table>
		</form:form>

	</center>


	<center>
		<h2>Available Categories</h2>

		<c:if test="${!empty categoryList}">
			<table class="tg" border="2">
				<thead>
					<tr>
						<td style="color: white">ID</td>
						<td style="color: white">NAME</td>
						<td style="color: white">DESCRIPTION</td>
						<td style="color: white">Action</td>
					</tr>
				</thead>




				<c:forEach var="category" items="${categoryList}">

					<tr>
						<td style="color: white">${category.id}</td>
						<td style="color: white">${category.name}</td>
						<td style="color: white">${category.description}</td>

						<td style="color: white"><a href="manage_Edit_Category/${category.id}">Edit </a>||
							<a href="manage_Delete_Category/${category.id}">Delete</a></td>
					</tr>


				</c:forEach>
			</table>
		</c:if>
	</center>
</body>
</html>













