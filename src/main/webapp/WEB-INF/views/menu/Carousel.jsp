<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  </style>
</head>
<body>

<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel" width="700" height="300">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
      <li data-target="#myCarousel" data-slide-to="4"></li>
      <li data-target="#myCarousel" data-slide-to="5"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
        <img src="resources\images\carosel1.jpg" alt="car" width="460" height="345">
        <div class="carousel-caption">
          <h3>Which brand are You Looking For in a Car?</h3>
          <p>  </p>
        </div>
      </div>

      <div class="item">
        <img src="resources\images\carosel2.jpg" alt="choosing the right car" width="460" height="345">
        <div class="carousel-caption">
          <h3>choosing the right car</h3>
          <p> </p>
        </div>
      </div>
    
      <div class="item">
        <img src="resources\images\carosel3.jpg" alt="Ask yourself what you need by way of performance, space, etc." width="460" height="345">
        <div class="carousel-caption">
          <h3>Ask yourself what you need by way of performance, space, etc. </h3>
          <p> </p>
        </div>
      </div>


<div class="item">
        <img src="resources\images\carosel4.jpg" alt="Check your budget. " width="460" height="345">
        <div class="carousel-caption">
          <h3>Check your budget.  </h3>
          <p> </p>
        </div>
      </div> 
      
      <div class="item">
        <img src="resources\images\carosel5.jpg" alt="Consider fuel efficiency" width="460" height="345">
        <div class="carousel-caption">
          <h3>Consider fuel efficiency</h3>
          <p> </p>
        </div>
        
      </div>
       <div class="item">
        <img src="resources\images\carosel6.jpg" alt="Check with family members who might be using the car. " width="460" height="345">
        <div class="carousel-caption">
          <h3>Check with family members who might be using the car. </h3>
          <p></p>
        </div>
      
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

</body>
</html>
