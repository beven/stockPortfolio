<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Portfolio Management - Stocks</title>
</head>
<body>
<h1>Stocks</h1>
<c:choose>
    <c:when test="${empty portfolio}">
        This portfolio does not exist - go back and create one first.
    </c:when>
    <c:otherwise>
        <c:choose>
            <c:when test="${empty portfolio.stocks}">
                There are no stocks configured for this portfolio.
            </c:when>
            <c:otherwise>
                <table>
                    <c:forEach items="${portfolio.stocks}" var="stock">
                        <tr>
                            <td>Symbol</td><td><c:out value="${stock.symbol}"/></td>
                            <td>Entry Date</td><td><c:out value="${stock.entryDate}"/></td>
                            <td>Purchase Price</td><td><c:out value="${stock.purchasePrice}"/></td>
                            <td>Exit Date</td><td><c:out value="${stock.exitDate}"/></td>
                            <td>Exit Price</td><td><c:out value="${stock.exitPrice}"/></td>
                            <td>Commission</td><td><c:out value="${stock.commission}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
        <h2>Add Stock</h2>
        <form:form action="stocks" commandName="stockForm" method="post">
            <form:label path="symbol">Symbol</form:label><form:input path="symbol"/>
            <form:label path="entryDate">Entry Date</form:label><form:input path="entryDate"/>
            <form:label path="purchasePrice">Purchase Price</form:label><form:input path="purchasePrice"/>
            <form:label path="exitDate">Exit Date</form:label><form:input path="exitDate"/>
            <form:label path="exitPrice">Exit Price</form:label><form:input path="exitPrice"/>
            <form:label path="commission">Commission</form:label><form:input path="commission"/>
            <form:hidden path="portfolioId"/>
            <input value="Submit" type="submit"/>
            <form:errors path="symbol" cssClass="error" element="div" />
            <form:errors path="entryDate" cssClass="error" element="div" />
            <form:errors path="exitDate" cssClass="error" element="div" />
        </form:form>
    </c:otherwise>
</c:choose>
</body>
</html>