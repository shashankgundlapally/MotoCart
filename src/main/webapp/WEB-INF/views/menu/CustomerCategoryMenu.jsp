
<!DOCTYPE html>
<html lang="en">
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<title>Bootstrap Case</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
		
			<div class="navbar-header"></div>
			<ul class="nav navbar-nav dropdown ">
				<li><a href="Home"> <span class="glyphicon glyphicon-home"></span>Home
				</a></li></ul>

	 <!-- <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>


				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Electronics <span class="caret"></span></a>

					<ul class="dropdown-menu">

						<li class="dropdown-submenu"><a class="test" tabindex="-1"
							href="#">Mobile <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Apple</a></li>
								<li><a href="#">Samsung</a></li>

							</ul></li>
						<li><a href="#">Laptop</a></li>
						<li><a href="#">Television</a></li>

					</ul></li>


				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Men<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Foot-wear</a></li>
						<li><a href="#">Clothing</a></li>
						<li><a href="#">Watches</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Books Entertainment<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Books</a></li>
						<li><a href="#">Movies</a></li>
						<li><a href="#">Music</a></li>
						<li><a href="#">Gaming</a></li>
					</ul></li>




			</ul> -->

<ul class="nav navbar-nav">
     <li><a href="#">CATEGORIES  <span class="glyphicon glyphicon-hand-right"></span></a></li>
        </ul>
 
 	<ul class="nav navbar-nav" role="tablist">
 	<c:forEach items="${categoryList}" var="category">
 	<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">${category.name}<span class="caret"></span></a>
 	
 	<ul class="dropdown-menu" role="menu">
 	<c:forEach items="${category.products}" var="product">
 	<li><a href="manage_Products/get/${product.id}">${product.name}</a></li>
 	</c:forEach>
 	</ul></li>
 	</c:forEach>
 	</ul>
 	
        <ul class="nav navbar-nav navbar-right">
     <li><a href="#">${LoginMessage}</a></li></ul>
    
    
    </div>



			<form class="navbar-form navbar-left">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>
			
			<div>
			<p style="color:white">${loginMessage}</p>
			</div>
			<div>

				<%-- <c:if test="${empty loginMessage}"> --%>
                  <% out.println("isAuthenticated()"); %>      
                     			<ul class="nav navbar-nav navbar-right">
					<sec:authorize access="!isAuthenticated()">
					
						<li><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
						<li><a href="Registration"><span class="glyphicon glyphicon-user"></span> Register</a></li>
					 </sec:authorize>
					</ul>


			<%-- 	</c:if> --%>

			</div>
			
			<div>
			 
				
					<ul class="nav navbar-nav navbar-right">
					<sec:authorize access="isAuthenticated()">
						<li><a href="perform_logout"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				
		
					<li class="nav navbar-nav">
						<li><a href="cart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
					</li>
					</sec:authorize>
	</ul>


		


			</div>
		</div>

	</nav>

	<script>
		$(document).ready(function() {
			$('.dropdown-submenu a.test').on("click", function(e) {
				$(this).next('ul').toggle();
				e.stopPropagation();
				e.preventDefault();
			});
		});
	</script>

</body>
</html>