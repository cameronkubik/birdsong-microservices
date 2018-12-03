<%-- Include header components --%>
<%@ include file="admin/header.jspf"%>
<%@ include file="admin/navigation.jspf"%>

<div class = "container" id="welcome">
    <h1>Welcome</h1>
    <form>
        <div class="form-group">
            <textarea class="form-control" rows="5" id="welcome-edit"></textarea>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

<div class = "container" id="events">
    <h1>Events/Specials</h1>
    <form>
        <div class="form-group">
            <textarea class="form-control" rows="5" id="events-edit"></textarea>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
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
            <tr>
                <td>Black Panther</td>
                <td>Currently Showing</td>
                <td>Screen 1</td>
                <td class="buttons"><button type="button" class="btn btn-info edit" data-toggle="modal" data-target="#editModal">Edit</button><button type="button" class="btn btn-danger">Delete</button></td>
            </tr>
            <tr>
                <td>The Lion King</td>
                <td>Future Showing: 1/30</td>
                <td>Screen 1</td>
                <td class="buttons"><button type="button" class="btn btn-info edit" data-toggle="modal" data-target="#editModal">Edit</button><button type="button" class="btn btn-danger">Delete</button></td>
            </tr>
            <tr>
                <td>Iron Man</td>
                <td>Future Showing: 2/22</td>
                <td>Screen 2</td>
                <td class="buttons"><button type="button" class="btn btn-info edit" data-toggle="modal" data-target="#editModal">Edit</button><button type="button" class="btn btn-danger">Delete</button></td>
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
<%@ include file="admin/footer.jspf"%>