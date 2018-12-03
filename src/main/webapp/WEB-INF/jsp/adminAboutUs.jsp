<%-- Include header components --%>
<%@ include file="admin/header.jspf"%>
<%@ include file="admin/navigation.jspf"%>

<style>
#adminAboutUs{
  background-color: #E1D8C6;
  color: #707070
}
</style>

<form:form method="POST" action="/admin/post-about-us" modelAttribute="aboutUsContent">

    <h1>Header</h1>
    <div class = "container" id="headerContainer">
        <%-- <form:label path="header"><h1>Header</h1></form:label> --%>
        <form:textarea path="header" rows="5"/>
    </div>
    <h1>Subheader</h1>
    <div class = "container" id="subheaderContainer">
        <%-- <form:label path="subHeader"><h1>Subheader</h1></form:label> --%>
        <form:textarea path="subHeader" rows="5"/>
    </div>
    <h1>Body</h1>
    <div class = "container" id="bodyContainer">
        <%-- <form:label path="body"><h1>Body</h1></form:label> --%>
        <form:textarea path="body" rows="5"/>
    </div>
    <input id="submitAbout" type="submit" value="Submit"/>
</form:form>
<%-- Footer HTML --%>
<%@ include file="admin/dependencies.jspf"%>
<%@ include file="admin/footer.jspf"%>
