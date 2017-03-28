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
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
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
        <img src="resources/Images/carosel1.jpg" alt="Lie of Pi" width="460" height="345">
        <div class="carousel-caption">
          <h3>Life of Pi</h3>
          <p>Pi Patel finds a way to survive in a lifeboat that is adrift in the middle of nowhere. His fight against the odds is heightened by the company of a hyena and a male Bengal tiger.</p>
        </div>
      </div>

      <div class="item">
        <img src="resources/Images/carosel2.jpg" alt="Captain America:Civil War" width="460" height="345">
        <div class="carousel-caption">
          <h3>Captain America:Civil War</h3>
          <p>Political pressure mounts to install a system of accountability when the actions of the Avengers lead to collateral damage. The new status quo deeply divides members of the team. Captain America (Chris Evans) believes superheroes should remain free to defend humanity without government interference. Iron Man (Robert Downey Jr.) sharply disagrees and supports oversight. As the debate escalates into an all-out feud, Black Widow (Scarlett Johansson) and Hawkeye (Jeremy Renner) must pick a side.</p>
        </div>
      </div>
    
      <div class="item">
        <img src="resources/Images/carosel4.jpg" alt="Bahubali:The Beginning" width="460" height="345">
        <div class="carousel-caption">
          <h3>Bahubali:The Beginning </h3>
          <p>In the kingdom of Mahishmati, while pursuing his love, Shivudu learns about the conflict-ridden past of his family and his legacy. He must now prepare himself to face his new-found archenemy.</p>
        </div>
      </div>

      <div class="item">
        <img src="resources/Images/carosel5.jpg" alt="Rise of The Tomb Raider" width="460" height="345">
        <div class="carousel-caption">
          <h3>Rise of The Tomb Raider</h3>
          <p>Rise of the Tomb Raider is an action-adventure video game developed by Crystal Dynamics and published by Square Enix. It is the sequel to the 2013 video game Tomb Raider, a reboot of the Tomb Raider franchise.</p>
        </div>
      </div>
       <div class="item">
        <img src="resources/Images/carosel6.jpg" alt="Assassin's Creed II" width="460" height="345">
        <div class="carousel-caption">
          <h3>Assassin's Creed II</h3>
          <p>Assassin's Creed II is a 2009 action-adventure video game developed by Ubisoft Montreal and published by Ubisoft.</p>
        </div>
      </div>
       <div class="item">
        <img src="resources/Images/carosel7.jpg" alt="Hitman" width="460" height="345">
        <div class="carousel-caption">
          <h3>Hitman</h3>
          <p>Hitman is an episodic stealth video game developed by IO Interactive and published by Square Enix for Microsoft Windows, PlayStation 4, and Xbox One. A port for Linux, developed and published by Feral Interactive, was released on 16 February 2017</p>
        </div>
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
