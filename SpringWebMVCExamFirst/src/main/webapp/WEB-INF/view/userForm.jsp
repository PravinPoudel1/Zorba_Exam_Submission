<%--
  Created by IntelliJ IDEA.
  User: poude
  Date: 9/8/2024
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
  <head>
    <title>Register User</title>
  </head>
  <body>

    <form action="saveUserData" method="post">
      <div>
        <label for="Name"> Name </label>
        <input name="Name" type="text" id="Name" placeholder = "Enter your Full Name">
      </div>
      <div>
        <label for="email"> Email </label>
        <input name="email" type="email" id="email" placeholder = "Enter your Email">
      </div>
      <div>
        <label for="mobile"> Mobile </label>
        <input name="userMobile" type="tel" id="mobile" placeholder = "Enter your Mobile">
      </div>
      <div>
        <label for="userName"> UserName </label>
        <input name="userName" type="text" id="userName" placeholder = "Enter your Username">
      </div>
      <div>
        <label for="password"> Password </label>
        <input name="userPassword" type="password" id="password" placeholder = "Enter your Password">
      </div>
      <div>
        <input type="submit" name="submit" value="Submit"/>
      </div>
    </form>
  </body>
</html>
