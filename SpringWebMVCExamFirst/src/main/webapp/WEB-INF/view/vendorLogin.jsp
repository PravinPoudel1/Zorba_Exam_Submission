 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <html>
 <head>
     <title>Vendor Login</title>
 </head>
 <body>
 <form action="vendorLoginController" method="post">

   <label for="username">Username:</label>
   <input type="text"  id="username" name="username" required><br><br>

   <label for="password">Password:</label>
   <input type="password" id="password" name="password" required><br><br>

   <label for="role">Role:</label>
   <input type="text" id="role" name="roleName" value="Vendor" readonly><br><br>

   <input type="submit" value="Submit">
 </form>

 <c:if test="${not empty errorMessage}">
   <p style="color: red;">"${errorMessage}</p>
 </c:if>


 <p>Don't have an account? <a href="user/registerUser">Register here</a></p>

 </body>
 </html>