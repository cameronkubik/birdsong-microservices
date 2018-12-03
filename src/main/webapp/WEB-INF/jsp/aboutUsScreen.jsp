<%-- Include header components --%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<%-- Styling the navbar so that the current page has its appropriate tab highlighted --%>
<style>
#aboutusNav{
  background-color: #E1D8C6;
  color: #707070
}
</style>

<%-- This page/components HTML --%>
<div class="container" id="aboutUs">
    <h1 id="aboutUsTitle">
        ${content.getHeader()}
    </h1>
    <h2>
        ${content.getSubHeader()}
    </h2>
    <h3>
        ${content.getBody()}
    </h3>
</div>

<%-- Footer HTML --%>
<%@ include file="common/footer.jspf"%>
