<%-- Include header components --%>
<%@ include file="admin/header.jspf"%>
<%@ include file="admin/navigation.jspf"%>

    <div class = "container" id="subheader">
        <h1>Subheader</h1>
        <form>
            <div class="form-group">
                <textarea class="form-control" rows="5" id="subheader-edit"></textarea>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>

    <div class = "container" id="body">
        <h1>Body</h1>
        <form>
            <div class="form-group">
                <textarea class="form-control" rows="5" id="body-edit"></textarea>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>

<%-- Footer HTML --%>
<%@ include file="admin/footer.jspf"%>