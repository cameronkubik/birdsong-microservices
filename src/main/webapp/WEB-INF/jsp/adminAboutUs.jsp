<%-- Include header components --%>
<%@ include file="admin/header.jspf"%>
<%@ include file="admin/navigation.jspf"%>
<form:form method="POST" action="/adminController/postAdminAboutUs" modelAttribute="AboutUsContent">
    <div class = "container" id="subheader">
        <h1>Subheader</h1>
            <div class="form-group">
                <form:textarea path="subheader" class="form-control" rows="5" id="subheader-edit"></textarea>
            </div>
    </div>

    <div class = "container" id="body">
        <h1>Body</h1>
            <div class="form-group">
                <form:textarea path="body" class="form-control" rows="5" id="body-edit"></textarea>
            </div>
        <input type="submit" value="Submit"/>
    </div>
</form:form>
<%-- Footer HTML --%>
<%@ include file="admin/footer.jspf"%>