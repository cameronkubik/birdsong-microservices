<%-- Include header components --%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<%-- This page/components HTML --%>

<div class="container" id="tabs">
  <ul class="nav nav-pills">
    <li class="active"><a href="#1" data-toggle="tab">Home</a></li>
    <li><a href="#2" data-toggle="tab">Menu 1</a></li>
    <li><a href="#3" data-toggle="tab">Menu 2</a></li>
    <li><a href="#4" data-toggle="tab">Menu 3</a></li>
  </ul>

  <%-- <div class="tab-content">
    <div class="tab-pane active" id="1">
    </div>
    <div class="tab-pane" id="2">
    </div>
    <div class="tab-pane" id="3">
    </div>
    <div class="tab-pane" id="4">
    </div>
  </div> --%>
    <table style="width:100%">
        <tr>
            <th>Item</th>
            <th>Cost</th> 
        </tr>
        <c:forEach items="${testData}" var="SaleItem">
            <tr>
                <td><c:out value="${SaleItem.getItem()}"/></td>
                <td>$<c:out value="${SaleItem.getCost()}"/></td>    
            </tr>
        </c:forEach>
    </table>
</div>

<%-- Footer HTML --%>
<%@ include file="common/footer.jspf"%>