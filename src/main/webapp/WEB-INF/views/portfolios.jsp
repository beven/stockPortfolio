<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home page</title>
</head>
<body>
    <h1>Portfolios</h1>
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
</body>
</html>