<%-- Include header components --%>
<%@ include file="admin/header.jspf"%>
<%@ include file="admin/navigation.jspf"%>


<div class="container" id="tickets">
	<h1>Tickets</h1>
		<button type="button" class="btn add" data-toggle="modal" data-target="#addModal">Click to Add Ticket...</button>
	<table class="table" id="ticketTable">
		<thead>
			<tr>
				<th>Tickets</th>
				<th>Price</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Adult</td>
				<td>${admission.getAdultTicketPrice()}</td>
				<td class="buttons goRight"><button type="button" class="btn btn-info" data-toggle="modal" data-target="#editModal">Edit</button><button type="button" class="btn btn-danger">Delete</button></td>
			</tr>
			<tr>
				<td>Child</td>
				<td>${admission.getChildTicketPrice()}</td>
				<td class="buttons goRight"><button type="button" class="btn btn-info" data-toggle="modal" data-target="#editModal">Edit</button><button type="button" class="btn btn-danger">Delete</button></td>
			</tr>
			<tr>
				<td>Senior</td>
				<td>${admission.getInfantTicketPrice()}</td>
				<td class="buttons goRight"><button type="button" class="btn btn-info" data-toggle="modal" data-target="#editModal">Edit</button><button type="button" class="btn btn-danger">Delete</button></td>
			</tr>
		</tbody>
	</table>
	</div>

	<div class = "container" id="events">
	<h1 id="hours">Hours of Operation</h1>
	<form>
		<div class="form-row">
			<div class="form-group col-md-6" id="boxOfficeHours">
				<label for="inputBoxOfficeHours">Box Office Opens at</label>
					<div class="input-append bootstrap-timepicker-component">
    			<input class="timepicker-1 input-small" type="text" placeholder="${opHours.getOpenTime()}">
    			<span class="add-on">
        	<i class="icon-time"></i>
    			</span>
					</div>
				</div>
				<div class="form-group col-md-6" id="movieStart">
					<label for="inputMovieStart">Movie Start Time</label>
						<div class="input-append bootstrap-timepicker-component">
						<input class="timepicker-2 input-small" type="text" placeholder="${opHours.getShowingsStartTime()}">
						<span class="add-on">
						<i class="icon-time"></i>
						</span>
						</div>
					</div>
			</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</div>
	</form>

<div class = "container" id="events">
<h1>Announcements</h1>
<form>
<div class="form-group">
	<textarea class="form-control" rows="5" id="announcements-edit">${notice.getMainNotice()}${notice.getSubNotice()}</textarea>
</div>
<button type="submit" class="btn btn-default">Submit</button>
</form>
</div>

<!-- Edit Modal -->
<div id="editModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Edit</h4>
      </div>
      <div class="modal-body">
				<form>
  <div class="form-group">
    <label for="title">Ticket Type/Age Range</label>
    <input type="text" class="form-control" id="type">
  </div>
	<div class="form-group">
    <label for="title">Price</label>
    <input type="text" class="form-control" id="price">
  </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				  <button type="submit" class="btn btn-default">Submit</button>
      </div>
			</form>
    </div>

  </div>
</div>
<%-- 
<!-- Add Modal -->
<div id="addModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
<!-- Modal content-->
<div class="modal-content">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h4 class="modal-title">Add</h4>
	</div>
	<div class="modal-body">
		<form>
<div class="form-group">
<label for="title">Ticket Type/Age Range</label>
<input type="text" class="form-control" id="type">
</div>
<div class="form-group">
<label for="title">Price</label>
<input type="text" class="form-control" id="price">
</div>

	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="submit" class="btn btn-default">Submit</button>
	</div>
	</form>
</div>

</div>
</div> --%>

<%@ include file="admin/dependencies.jspf"%>

<script>
$(document).ready( function () {
    $('#ticketTable').DataTable({
        "columnDefs": [
            { "orderable": false, "targets": 1 },
            { "width": "15%", "targets": 1}
        ]
    });

    $('.timepicker-1').timepicker();
    $('.timepicker-2').timepicker();

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
<%-- Footer HTML --%>
<%@ include file="admin/footer.jspf"%>