<%-- Include header components --%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<%-- This page/components HTML --%>
<div class = "container" id="welcome">
    <h1>${welcomeMessage.getHeader()}</h1>
    <p>We're glad you're here!</p>
    <p class="main-text">${welcomeMessage.getSubHeader()}</p>
    <a class="btn btn-primary" href="/about-us">Learn More</a>
</div>

<div class="container" id="showings">
  <h2>Current Showings</h2>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <%-- Loop through movie list --%>
        <c:set var="index" value="${0}" />
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
                    <div class="carousel-item active">
                </c:when>

                <c:otherwise>
                    <div class="carousel-item">
                </c:otherwise>
            </c:choose>

                <img src="${movieItem.getEntireImagePath()}">
                <div class="carousel-caption">
                    <h3>${movieItem.getTitle()}</h3>
                    <h5>${movieItem.getOverview()}</h5>
                    <p>Showing Times: TODO!!</p>
                    <p>Screen: TODO!!</p>
					<a class="btn btn-warning" href="https://www.imdb.com">IMBD</a>
                </div>
            </div>
            <c:set var="index" value="${index + 1}"/>
        </c:forEach>
    </div>

    <!-- Left and right controls -->
    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
    </a>

  </div>
</div>

<%-- Footer HTML --%>
<%@ include file="common/footer.jspf"%>
