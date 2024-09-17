<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Add Role</title>
</head>
<body>

<h2>Welcome, ${userObj.userFullName},</h2>
<br>
<table border="1">
  <tr>
    <th>Role ID</th>
    <th>Role</th>
    <th>Action</th>
  </tr>
  <c:forEach var="role" items="${userObj.roles}">
    <tr>
      <td>${role.roleId}</td>
      <td>${role.roleName}</td>
      <td>
        <a href="${pageContext.request.contextPath}/user/removeRole/${role.roleId}/${userObj.userId}">Remove</a>
      </td>
    </tr>
  </c:forEach>
</table>

<br><hr><br>
<h3>Add Role</h3>
<form action="${pageContext.request.contextPath}/user/updateUser" method="post">
  <input type="hidden" name="userId" value="${userObj.userId}">

  <label for="role">Select Role:</label>
  <select name = "role" id="role">
    <option value="admin">Admin</option>
    <option value="user">User</option>
    <option value="vendor">Vendor</option>
  </select>

  <input type="submit" value="Submit"/>
</form>

</body>
</html>
