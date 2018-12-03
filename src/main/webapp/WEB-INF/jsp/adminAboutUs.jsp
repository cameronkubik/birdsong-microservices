<%-- Include header components --%>
<%@ include file="admin/header.jspf"%>
<%@ include file="admin/navigation.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST" action="/adminController/postAdminAboutUs" modelAttribute="AboutUsContent">
    <div class = "container" id="subheader">
        <h1>Subheader</h1>
            <div class="form-group">
                <form:textarea path="subheader"></form:textarea>
            </div>
    </div>

    <div class = "container" id="body">
        <h1>Body</h1>
            <div class="form-group">
                <form:textarea path="body"></form:textarea>
            </div>
        <input type="submit" value="Submit" />
    </div>
</form:form>
<%-- Footer HTML --%>
<%@ include file="admin/footer.jspf"%>