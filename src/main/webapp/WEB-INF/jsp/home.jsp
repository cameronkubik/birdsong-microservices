<%-- Include header components --%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<%-- Styling the navbar so that the current page has its appropriate tab highlighted --%>
<style>
    #homeNav {
        background-color: #E1D8C6;
        color: #707070
    }
</style>

<%-- This page/components HTML --%>
<div class = "container" id="welcome">
    <h1>${content.getWelcomeMessage()}</h1>
    <p class="main-text">${content.getSpecialsMessage()}</p>
    <%-- <p class="main-text">${welcomeMessage.getSubHeader()}</p> --%>
    <a class="btn btn-primary" href="/about-us">Learn More</a>
</div>

<div class="container" id="showings">
  <h2>Current Showings</h2>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <%-- Loop through movie list --%>
        <c:set var="index" value="${0}" />
        <c:set var="movieList" value="${content.getNowShowingMovies()}" />
        <c:forEach items="${movieList}" var="movieItem">
            <c:choose>

                <c:when test="${index == 0}">
                    <li data-target="#myCarousel" data-slide-to="${index}" class="active"></li>
                </c:when>

                <c:otherwise>
                    <li data-target="#myCarousel" data-slide-to="${index}"></li>
                </c:otherwise>
            </c:choose>
            <c:set var="index" value="${index + 1}"/>
        </c:forEach>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

        <%-- HTML for each carousel item --%>
        <c:set var="index" value="${0}" />
        <c:forEach items="${movieList}" var="movieItem">
            <c:choose>
                <c:when test="${index == 0}">
                    <div class="item active">
                </c:when>

                <c:otherwise>
                    <div class="item">
                </c:otherwise>
            </c:choose>

                <img src="${movieItem.getEntireImagePath()}">
                <div class="carousel-caption">
                    <h3>${movieItem.getTitle()}</h3>
                    <h5>${movieItem.getOverview()}</h5>
                    <p>Showing Times: 7 PM</p>
                    <p>Screen: 1</p>
					<a class="btn btn-warning" href="https://www.imdb.com">IMBD</a>
                </div>
            </div>
            <c:set var="index" value="${index + 1}"/>
        </c:forEach>
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
