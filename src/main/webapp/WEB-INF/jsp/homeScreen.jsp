<%-- Include header components --%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<%-- This page/components HTML --%>

<div class = "container" id="welcome">
    <h1>${welcomeMessage.getHeader()}</h1>
    <p>We're glad you're here!</p>
    <p class="main-text">
        Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus.
    </p>
    <button type="button" class="btn btn-primary">Learn More</button>
</div>

<div class="container">
  <h2 style="text-align: center; color: white;">Current Showings</h2>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="item active">
        <img src="https://www.webdesignerdepot.com/cdn-origin/uploads/2011/02/jurassicpark.jpg" alt="Jurassic Park" style="width:100%;">
        <div class="carousel-caption">
          <h3>Jurassic Park</h3>
          <p>Show Times</p>
					<p>Dates</p>
					<p>Screen 1 </p>
					<button type="button" class="btn btn-warning">IMDB</button>
        </div>
      </div>

      <div class="item">
        <img src="https://images-na.ssl-images-amazon.com/images/I/71rZtELyYzL._SL1200_.jpg" alt="Star Wars: The Force Awakens" style="width:100%;">
        <div class="carousel-caption">
          <h3>Star Wars: The Force Awakens</h3>
          <p>Show Times</p>
					<p>Dates</p>
					<p>Screen 1</p>
					<button type="button" class="btn btn-warning">IMBD</button>
        </div>
      </div>

      <div class="item">
        <img src="http://www.impawards.com/2018/posters/black_panther_ver21.jpg" alt="Black Panther" style="width:100%;">
        <div class="carousel-caption">
          <h3>Black Panther</h3>
          <p>Showtimes</p>
					<p>Dates</p>
					<p>Screen 2</p>
					<button type="button" class="btn btn-warning">IMBD</button>
        </div>
      </div>

    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<%-- Footer HTML --%>
<%@ include file="common/footer.jspf"%>