<%-- Include header components --%>
<%@ include file="admin/header.jspf"%>
<%@ include file="admin/navigation.jspf"%>

<form:form method="POST" action="/admin/post-about-us" modelAttribute="aboutUsContent">
    
    <div class = "container" id="headerContainer">
        <form:label path="header">Header</form:label>
        <form:input path="header"/>
    </div>

    <div class = "container" id="subheaderContainer">
        <form:label path="subHeader">Subheader</form:label>
        <form:input path="subHeader"/>
    </div>

    <div class = "container" id="bodyContainer">
        <form:label path="body">Body</form:label>
        <form:input path="body"/>
    </div>
    <input type="submit" value="Submit"/>
</form:form>
<%-- Footer HTML --%>
<%@ include file="admin/dependencies.jspf"%>
<%@ include file="admin/footer.jspf"%>