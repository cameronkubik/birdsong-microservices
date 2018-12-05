<%-- Include header components --%>
<%@ include file="admin/header.jspf"%>
<%@ include file="admin/navigation.jspf"%>

<style>
#adminHome{
  background-color: #E1D8C6;
  color: #707070
}
</style>

<div class = "container" id="welcome">
    <div class="form-group">
        <form:form method="POST" action="/admin/post-home" modelAttribute="homeContent"> 
            <div class="container">   
                <h1>Welcome</h1>
                <form:textarea path="welcomeMessage" name="welcomeMessage" rows="3"/>
            </div>
            <div class="container">   
                <h1>Special Events/Announcements</h1>
                <form:textarea path="specialsMessage" name="specialsMessage" rows="2"/>
            </div>
            <input id="submitHome" type="submit" value="Submit" class="btn btn-default"/>
        </form:form>
    </div>
</div>

<div class="container" id="showings">
    <h1>Showings</h1>
    <button type="button" class="btn add" data-toggle="modal" data-target="#addModal">Click to Add Movie...</button>
    <table class="table" id="showingTable">
        <thead>
            <tr>
                <th>Movie</th>
                <th>Status</th>
                <th>Screen</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:set var="movieList" value="${homeContent.getNowShowingMovies()}" />
            <c:forEach items="${movieList}" var="movieItem">
                <tr>
                    <td>${movieItem.getTitle()}</td>
                    <td>${movieItem.getShowingStatus()}</td>
                    <td>Screen 1</td>
                    <td class="buttons">
                        <button type="button" class="btn btn-info edit" data-toggle="modal" data-target="#editModal">Edit</button>
                        <button type="button" class="btn btn-danger">Delete</button>
                    </td>
                </tr>
            </c:forEach>
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
                        <label for="title">Search for Title</label>
                        <input type="text" class="form-control" id="title">
                    </div>
                    <div class="form-group">
                        <label for="showing">Current or Future Showing?</label>
                        <div class="radio">
                            <label><input type="radio" name="showing" class="current">Currently Showing</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="showing" class="future">Future Showing</label>
                        </div>
                    </div>
                    <div class="form-group date">
                        <label class="control-label" id="dateLabel" for="date">Date:</label>
                        <input class="form-control" name="date" placeholder"MM/DD/YYY" type="text">
                    </div>
                    <div class="form-group">
                        <label>Screen</label>
                            <select>
                                <option value="screen1">Screen 1</option>
                                <option value="screen2">Screen 2</option>
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
                        <label for="title">Search for Title</label>
                        <input type="text" class="form-control" id="title">
                    </div>
                    <div class="form-group">
                        <label for="showing">Current or Future Showing?</label>
                        <div class="radio">
                            <label><input type="radio" name="showing" class="current">Currently Showing</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="showing" class="future">Future Showing</label>
                        </div>
                    </div>
                    <div class="form-group date">
                        <label class="control-label" id="dateLabel" for="date">Date:</label>
                        <input class="form-control" name="date" placeholder"MM/DD/YYY" type="text">
                    </div>
                    <div class="form-group">
                        <label>Screen</label>
                        <select>
                            <option value="screen1">Screen 1</option>
                            <option value="screen2">Screen 2</option>
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

<%-- Footer HTML --%>
<%@ include file="admin/dependencies.jspf"%>

<script>
    $(document).ready( function () {
        $('#showingTable').DataTable({
            "columnDefs": [
                { "orderable": false, "targets": 2 },
                { "width": "15%", "targets": 2}
            ]
        });

        var date_input = $('input[name="date"]'); //our date input has the name "date"
        var container = $('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
        var options = {
            format: 'mm/dd/yyyy',
            container: container,
            todayHighlight: true,
            autoclose: true,
        };
        date_input.datepicker(options);
    });
</script>

<%@ include file="admin/footer.jspf"%>
