<%-- Include header components --%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<%-- Styling the navbar so that the current page has its appropriate tab highlighted --%>
<style>
#concessionNav{
  background-color: #E1D8C6;
  color: #707070
}
</style>

<%-- This page/components HTML --%>
<h1 class="concessionTitle">Concessions</h1>
<div class="food-table" id="2">
    <h2 class="concessionTitle">Food</h2>
    <table>
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
    <h2 class="concessionTitle">Drinks</h2>
    <table>
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
    <h2 class="concessionTitle">Snacks</h2>
    <table>
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
