<%--
  Created by IntelliJ IDEA.
  User: poude
  Date: 9/8/2024
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Inventory</title>
</head>
<body>
<h2>Add Inventory</h2>
<form:form modelAttribute="inventory" action="saveInventory" method="post" enctype="multipart/form-data">
    <form:label path="category">Inventory Category: </form:label>
    <form:input path="category"/><br>

    <form:label path="name">Inventory Name: </form:label>
    <form:input path="name"/><br>

    <form:label path="quantity">Inventory Quantity: </form:label>
    <form:input path="quantity"/><br>

    <form:label path="price">Inventory Price (per unit): </form:label>
    <form:input path="price"/><br>

    <form:label path="image">Inventory Image: </form:label>
    <input type="file" name="image"/><br>

    <form:label path="description">Inventory Description: </form:label>
    <form:textarea path="description"/><br>

    <input type="submit" value="Save"/>
</form:form>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
</body>
</html>
