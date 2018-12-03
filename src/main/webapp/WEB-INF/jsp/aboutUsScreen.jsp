<%-- Include header components --%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

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
