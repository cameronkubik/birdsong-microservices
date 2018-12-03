<%-- Include header components --%>
<%@ include file="admin/header.jspf"%>
<%@ include file="admin/navigation.jspf"%>

<form:form  method="POST" action="/AdminController/postAboutUs" modelAttribute="AboutUsContent">
    <div class = "container" id="subheader">
        <h1>Subheader</h1>
        <form:input path="subheader">
            <div class="form-group">
                <textarea class="form-control" rows="5" id="subheader-edit"></textarea>
            </div>
        </form:input>
    </div>

    <div class = "container" id="body">
        <h1>Body</h1>
        <form:input path="body">
            <div class="form-group">
                <textarea class="form-control" rows="5" id="body-edit"></textarea>
            </div>
        </form:input>
        <button type="submit" value="Submit" class="btn btn-default">Submit</button>
    </div>
</form:form>
<%-- Footer HTML --%>
<%@ include file="admin/footer.jspf"%>