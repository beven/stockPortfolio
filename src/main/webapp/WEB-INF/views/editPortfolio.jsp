<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Portfolio Management - Update</title>
</head>
<body>
<h1>Update Portfolio</h1>
<form:form action="/portfolios-edit" commandName="portfolioForm" method="post">
    <form:label path="name">Name</form:label><form:input path="name"/>
    <form:hidden path="id"/>
    <input value="Update" type="submit"/>
    <form:errors path="name" cssClass="error" element="div" />
</form:form>
</body>
</html>