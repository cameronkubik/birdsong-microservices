<%-- Include header components --%>
<%@ include file="admin/header.jspf"%>
<%@ include file="admin/navigation.jspf"%>



<div class = "container" id="location">
    <h1>Location</h1>
    <form>
        <div class="form-group">
            <label for="inputAddress">Address</label>
            <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
        </div>
        <div class="form-group">
            <label for="inputAddress2">Address 2</label>
            <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
        </div>
        <div class="form-row">
            <div class="form-group col-md-6" id="city">
                <label for="inputCity">City</label>
                <input type="text" class="form-control" id="inputCity">
            </div>
            <div class="form-group col-md-4">
                <label for="inputState">State</label>
                <select class="form-control bfh-states" data-country="US"></select>
            </div>
            <div class="form-group col-md-2" id="zip">
                <label for="inputZip">Zip</label>
                <input type="text" class="form-control" id="inputZip">
            </div>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

<div class = "container" id="contact">
    <h1>Contacts</h1>
    <form>
        <div class="form-row">
            <div class="form-group col-md-6" id=email>
                <label for="email">Email</label>
                <input type="email" class="form-control" id="inputEmail" aria-describedby="email-input" placeholder="Enter email">
            </div>
            <div class="form-group col-md-6" id=phone>
                <label for="phone">Phone</label>
                <input type="text" class="form-control bfh-phone" id="inputPhone" data-format="+1 (ddd) ddd-dddd">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6" id="twitter">
                <label for="inputTwitter">Twitter</label>
                <input type="text" class="form-control" id="inputTwitter">
            </div>
            <div class="form-group col-md-6">
                <label for="inputFacebook">Facebook</label>
                <input type="text" class="form-control" id="inputFacebook">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6" id="instagram">
                <label for="inputInstagram">Instagram</label>
                <input type="text" class="form-control" id="inputInstagram">
            </div>
            <div class="form-group col-md-6">
                <label for="inputYoutube">Youtube</label>
                <input type="text" class="form-control" id="inputYoutube">
            </div>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

<%@ include file="admin/dependencies.jspf"%>

<script>
    $(document).ready( function () {
        $('#showingTable').DataTable({
            "columnDefs": [
                { "orderable": false, "targets": 2 },
                { "width": "15%", "targets": 2}
            ]
        });

        var date_input=$('input[name="date"]'); //our date input has the name "date"
        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
        var options={
            format: 'mm/dd/yyyy',
            container: container,
            todayHighlight: true,
            autoclose: true,
        };
        date_input.datepicker(options);
    } );
</script>

<%@ include file="admin/footer.jspf"%>