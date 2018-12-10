<%-- Include header components --%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<%-- Styling the navbar so that the current page has its appropriate tab highlighted --%>
<style>
#boxofficeNav{
  background-color: #E1D8C6;
  color: #707070
}
</style>

<%-- This page/components HTML --%>
<div class="elementdark">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <img src="images/boxoffice.jpeg" class= "img-thumbnail">
            </div>
            <c:set var="admission" value="${content.getAdmission()}" />
            <c:set var="opHours" value="${content.getOperationHours()}" />
            <div class="col-md-6" id="boxOffice">
                <h1>BOX OFFICE</h1>
                <p>Office opens at ${opHours.getOpenTime()} PM<br>Movie showings start at ${opHours.getShowingsStartTime()} PM</p>
                <h2>Admissions:</h2>
                Adult: ${admission.getAdultTicketPrice()}<br>
                Ages 6 to 11: ${admission.getChildTicketPrice()}<br>
                Ages 5 & under: ${admission.getInfantTicketPrice()}</p>
            </div>
        </div>
    </div>
</div>

<%-- Footer HTML --%>
<%@ include file="common/footer.jspf"%>