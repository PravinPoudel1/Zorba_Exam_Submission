 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
 <html>
 <head>
     <title>Users Table</title>
 </head>
 <body>
 <table border="1">
     <thead>
     <tr>
         <th>User ID</th>
         <th>User's Full Name</th>
         <th>User Email</th>
         <th>User Mobile</th>
         <th>username</th>
         <th>User Password</th>
         <th>Role</th>
     </tr>
     </thead>
     <tbody>
     <c:forEach var="user" items="${users}">
         <tr>
             <td><a href="${pageContext.request.contextPath}/user/viewUser/${user.userId}">${user.userId}</a></td>
             <td>${user.userFullName}</td>
             <td>${user.userEmail}</td>
             <td>${user.userMobile}</td>
             <td>${user.username}</td>
             <td>${user.userPass}</td>
             <td>
                 <c:forEach var="role" items="${user.roles}">
                     ${role.roleName},
                 </c:forEach>
             </td>
         </tr>
     </c:forEach>
     </tbody>

 </table>