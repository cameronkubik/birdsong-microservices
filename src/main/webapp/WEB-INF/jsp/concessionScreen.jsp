<%-- Include header components --%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<%-- This page/components HTML --%>

<div class="container" id="tabs">
  <ul class="nav nav-pills">
    <li class="nav-link active"><a href="#1" data-toggle="pill">Home</a></li>
    <li class="nav-link"><a href="#2" data-toggle="pill">Menu 1</a></li>
    <li class="nav-link"><a href="#3" data-toggle="pill">Menu 2</a></li>
    <li class="nav-link"><a href="#4" data-toggle="pill">Menu 3</a></li>
  </ul>

  <div class="tab-content">
    <div class="tab-pane active" id="1">
        Hello
    </div>
    <div class="tab-pane" id="2">
        <table style="width:100%">
            <tr>
                <th>Item</th>
                <th>Cost</th> 
            </tr>
            <c:forEach items="${testData}" var="SaleItem">
                <c:if test="${SaleItem.getCategoryId()=='1'}">
                <tr>
                    <td><c:out value="${SaleItem.getItem()}"/></td>
                    <td>$<c:out value="${SaleItem.getCost()}"/></td>    
                </tr>
                </c:if>
            </c:forEach>
        </table>
    </div>
    <div class="tab-pane" id="3">
        <table style="width:100%">
            <tr>
                <th>Item</th>
                <th>Cost</th> 
            </tr>
            <c:forEach items="${testData}" var="SaleItem">
                <c:if test="${SaleItem.getCategoryId()=='2'}">
                    <tr>
                        <td><c:out value="${SaleItem.getItem()}"/></td>
                        <td>$<c:out value="${SaleItem.getCost()}"/></td>    
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </div>
    <div class="tab-pane" id="4">
        <table style="width:100%">
            <tr>
                <th>Item</th>
                <th>Cost</th> 
            </tr>
            <c:forEach items="${testData}" var="SaleItem">
                <c:if test="${SaleItem.getCategoryId()=='3'}">
                    <tr>
                        <td><c:out value="${SaleItem.getItem()}"/></td>
                        <td>$<c:out value="${SaleItem.getCost()}"/></td>    
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </div>
  </div>
</div>

<%-- Footer HTML --%>
<%@ include file="common/footer.jspf"%>