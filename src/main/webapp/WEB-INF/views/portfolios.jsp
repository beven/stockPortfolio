<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Portfolio Management</title>
</head>
<body>
<h1>Portfolios</h1>
<c:choose>
    <c:when test="${empty portfolios}">
        There are no portfolios configured. Please add a new one below.
    </c:when>
    <c:otherwise>
        <table>
            <tr>
                <td>Name</td>
            </tr>
            <c:forEach var="portfolio" items="${portfolios}">
                <tr>
                    <td><c:out value="${portfolio.name}"/></td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>
<h2>Add Portfolio</h2>
<form:form method="post" action="/portfolios" commandName="portfolioForm">
    <div>
        <form:label path="name">Name</form:label><form:input path="name"/>
        <input value="Submit" type="submit"/>
        <form:errors path="name" cssClass="error" element="div" />
    </div>
</form:form>
</body>
</html>