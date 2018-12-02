<%-- Include header components --%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<%-- This page/components HTML --%>
<c:forEach items="${testData}" var="SaleItem">
    <tr>
        <td>Item ID: <c:out value="${SaleItem.getItemId()}"/></td>
        <td>Item Name: <c:out value="${SaleItem.getItem()}"/></td>  
    </tr>
</c:forEach>

<%-- Footer HTML --%>
<%@ include file="common/footer.jspf"%>