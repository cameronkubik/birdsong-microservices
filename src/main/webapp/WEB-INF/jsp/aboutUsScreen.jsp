<%-- Include header components --%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<%-- This page/components HTML --%>
<div class="container">
    <h1>
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