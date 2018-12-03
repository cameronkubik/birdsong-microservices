<%-- Include header components --%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<%-- This page/components HTML --%>
<h1>Concessions</h1>
<div class="food-table" id="2">
    <h1>Food</h1>
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
<div class="drinks-table" id="3">
    <h1>Drinks</h1>
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
<div class="snacks-table" id="4">
    <h1>Snacks</h1>
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


<%-- Footer HTML --%>
<%@ include file="common/footer.jspf"%>