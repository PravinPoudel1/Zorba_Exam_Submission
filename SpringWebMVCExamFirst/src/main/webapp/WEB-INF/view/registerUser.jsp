

 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <html>
 <head>
     <title>Registration Page</title>
 </head>
 <body>
 <form action="saveUser" method="post">
     <div>
         <label for="userFullName"> Enter user's Full Name: </label>
         <input name="userFullName" type="text" id="userFullName"/>
     </div>
     <div>
         <label for="userEmail"> Enter user's Email:</label>
         <input name="userEmail" type="text" id="userEmail">
     </div>
     <div>
         <label for="userMobile">Enter user's Phone: </label>
         <input name="userMobile" type="text" id="userMobile">
     </div>
     <div>
         <label for="username">Enter desired username: </label>
         <input name="username" type="text" id="username">
     </div>
     <div>
         <label for="userPass"> Enter desired password: </label>
         <input name="userPass" type="password" id="userPass">
     </div>
     <div>
         <input type="submit" name="submit" value="Submit"/>
     </div>
 </form>
 </body>
 </html>