<%-- Include header components --%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<%-- This page/components HTML --%>
<div class="container">
    Welcome ${testData}!!
</div>
<div class="container">
    Data: movieList = ${movieList}
</div>

<%-- Footer HTML --%>
<%@ include file="common/footer.jspf"%>