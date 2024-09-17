 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <html>
 <head>

 <form action="admin/login" method="post">
     <label for="username">User Name:</label>
     <input type="text" id="username" name="username" required>
     <br>

     <label for="password">Password:</label>
     <input type="password" id="password" name="password" required>
     <br>

     <label for="role">Role:</label>
     <input type="text" id="role" name="role" value="Admin" readonly>
     <br>

     <button type="submit">Login</button>
 </form>



  </body>
  </html>