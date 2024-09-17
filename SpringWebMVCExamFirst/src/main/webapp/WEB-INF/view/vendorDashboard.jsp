 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
 <html>
 <head>
     <title>Vendor Dashboard</title>
 </head>
 <body>
 <h2>Vendor Dashboard</h2>
 <h3>Hello ${userObj.userFullName},</h3>


 <form action="addInventory" method="post">

   <label for="category">Inventory Category:</label>
   <input type="text" id="category" name="category" required><br><br>

   <label for="name">Inventory Name:</label>
   <input type="text" id="name" name="name" placeholder="e.g., Rice, Soap, Milk" required><br><br>

   <label for="quantity">Inventory Quantity:</label>
   <input type="number" id="quantity" name="quantity" placeholder="Enter quantity" required><br><br>

   <label for="price">Inventory Price (per unit):</label>
   <input type="number" step="0.01" id="price" name="price" placeholder="Enter price per unit" required><br><br>

   <label for="imageUrl">Inventory Image:</label>
   <input type="file" id="imageUrl" name="imageUrl" placeholder="Enter image link" required><br><br>

   <label for="description">Inventory Description:</label>
   <textarea id="description" name="description" rows="4" cols="50" placeholder="Enter product description" required></textarea><br><br>

   <input type="submit" value="Add Inventory">

 </form>



 </body>
 </html>