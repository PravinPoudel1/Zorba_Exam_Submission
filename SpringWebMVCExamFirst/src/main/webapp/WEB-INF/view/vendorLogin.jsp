<%--
  Created by IntelliJ IDEA.
  User: poude
  Date: 9/8/2024
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>vendorLogin</title>
</head>
<body>

<h2>Vendor Login</h2>
<%--@elvariable id="vendor" type="com.springmvcexam"--%>
<form:form modelAttribute="vendor" action="login" method="post">
    <form:label path="username">Username: </form:label>
    <form:input path="username"/><br>

    <form:label path="password">Password: </form:label>
    <form:password path="password"/><br>

    <form:label path="role">Role: </form:label>
    <form:input path="role" value="Vendor" readonly="true"/><br>

    <input type="submit" value="Login"/>
</form:form>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

</body>
</html>
