<%-- Include header components --%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<%-- This page/components HTML --%>
<div class="elementdark">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <p>TODO - image</p> 
                <img src="images/newapp-icon.png" class"img-thumbnail">
            </div>

            <div class="col-md-6">
                <h2>Box Office</h2>
                <p>Office opens at ${opHours.getOpenTime()} PM</p>
                <p>Movie showings start at ${opHours.getShowingsStartTime()} PM</p>
                <h2>Admissions:</h2>
                <p>Adult: ${admission.getAdultTicketPrice()}</p>
                <p>Ages 6 to 11: ${admission.getChildTicketPrice()}</p>
                <p>Ages 5 & under: ${admission.getInfantTicketPrice()}</p>

                <%-- <form class="form-inline" action="/action_page.php">
                    <div class="form-group">
                        <label class="sr-only" for="email">Email address:</label>
                        <input type="email" class="form-control" id="email">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form> --%>
            </div>
        </div>
    </div>
</div>

<%-- Footer HTML --%>
<%@ include file="common/footer.jspf"%>