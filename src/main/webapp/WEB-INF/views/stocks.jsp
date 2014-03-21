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
    <c:when test="${empty stocks}">
        There are no stocks configured for this portfolio.
    </c:when>
    <c:otherwise>
        <c:forEach items="${stocks}" var="stock">
            ${stock}
        </c:forEach>
    </c:otherwise>
</c:choose>
</body>
</html>