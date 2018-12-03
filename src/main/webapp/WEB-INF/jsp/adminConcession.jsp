<%-- Include header components --%>
<%@ include file="admin/header.jspf"%>
<%@ include file="admin/navigation.jspf"%>

	<script src="DataTables-1.10.18/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="DataTables-1.10.18/js/dataTables.bootstrap.min.js"></script>
	<!-- Bootstrap Date-Picker Plugin -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

	<script>
	$(document).ready( function () {
	    $('#concessionTable').DataTable({
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

	<nav class="navbar">
	  <a href="index.html">Home</a>
	  <a href="boxoffice.html">Box Office</a>
	  <a href="concessions.html">Concessions</a>
	  <a href="aboutus.html">About Us</a>
		<a href="footer.html">Footer</a>
	</nav>

<div class="container" id="concessions">
<h1>Concessions</h1>
<button type="button" class="btn add" data-toggle="modal" data-target="#addModal">Click to Add Item...</button>
<table class="table" id="concessionTable">
<thead>
	<tr>
		<th>Food</th>
		<th>Category</th>
		<th></th>
	</tr>
</thead>
<tbody>
	<tr>
		<td>Food 1</td>
		<td>Category 1</td>
		<td class="buttons"><button type="button" class="btn btn-info" data-toggle="modal" data-target="#editModal">Edit</button><button type="button" class="btn btn-danger">Delete</button></td>
	</tr>
	<tr>
		<td>Food 2</td>
		<td>Category 2</td>
		<td class="buttons"><button type="button" class="btn btn-info" data-toggle="modal" data-target="#editModal">Edit</button><button type="button" class="btn btn-danger">Delete</button></td>
	</tr>
	<tr>
		<td>Food 3</td>
		<td>Category 1</td>
		<td class="buttons"><button type="button" class="btn btn-info" data-toggle="modal" data-target="#editModal">Edit</button><button type="button" class="btn btn-danger">Delete</button></td>
	</tr>
</tbody>
</table>
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
    <label for="name">Name</label>
    <input type="text" class="form-control" id="name">
  </div>
  <div class="form-group">
    <label class="control-label" id="dateLabel" for="date">Price</label>
    <input class="form-control" id="price" name="price">
  </div>
  <div class="form-group">
    <label>Category</label>
		<select>
			<option value="category1">Food</option>
			<option value="category2">Drink</option>
			<option value="category3">Snacks</option>
		</select>
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

<!-- Add Modal -->
<div id="addModal" class="modal fade" role="dialog">
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
    <label for="name">Name</label>
    <input type="text" class="form-control" id="name">
  </div>
  <div class="form-group">
    <label class="control-label" id="dateLabel" for="date">Price</label>
    <input class="form-control" id="price" name="price">
  </div>
  <div class="form-group">
    <label>Category</label>
		<select>
			<option value="category1">Food</option>
			<option value="category2">Drink</option>
			<option value="category3">Snacks</option>
		</select>
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

</div>
</div>
</body>

<%-- Footer HTML --%>
<%@ include file="admin/footer.jspf"%>