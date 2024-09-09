<%--
  Created by IntelliJ IDEA.
  User: poude
  Date: 9/8/2024
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
  <head>
    <title>List of Users</title>
  </head>
  <body>

    <u><h2>List of Users</h2></u>
    <table border = "1">
      <head>
        <tr>
          <th>UserID</th>
          <th>Name</th>
          <th>UserEmail</th>
          <th>UserMobile</th>
          <th>UserName</th>
          <th>UserPassword</th>
        </tr>
      </head>
      <body>
      <c:forEach var = "user" items = "${userModels}">

      <tr>
        <td>
          <a href="http://localhost:8080/SpringMVCApplication/user/getUserById/${user.userId}">
              <c:out value="${user.userId}"/>
        </td>
        </a>
        <td><c:out value="${user.Name}"/></td>
        <td><c:out value="${user.userEmail}"/></td>
        <td><c:out value="${user.userMobile}"/></td>
        <td><c:out value= "${user.userName}"/></td>
        <td><c:out value="${user.userPassword}"/></td>

      </tr>

      </c:forEach>

  </body>
  </table>
  </body>
</html>
