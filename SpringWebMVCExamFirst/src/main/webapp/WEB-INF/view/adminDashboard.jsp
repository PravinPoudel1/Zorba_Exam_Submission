 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <html>
 <head>

 <h1>Admin Dashboard</h1>

 <h2>Customer Information</h2>
 <table border="1">
     <tr>
         <th>Name</th>
         <th>Email</th>
         <th>Action</th>
     </tr>
     <c:forEach var="customer" items="${customerList}">
         <tr>
             <td>${customer.name}</td>
             <td>${customer.email}</td>
             <td><a href="removeCustomer?id=${customer.id}">Remove</a></td>
         </tr>
     </c:forEach>
 </table>

 <h2>Vendor Information</h2>
 <table border="1">
     <tr>
         <th>Name</th>
         <th>Email</th>
         <th>Action</th>
     </tr>
     <c:forEach var="vendor" items="${vendorList}">
         <tr>
             <td>${vendor.name}</td>
             <td>${vendor.email}</td>
             <td><a href="removeVendor?id=${vendor.id}">Remove</a></td>
         </tr>
     </c:forEach>
 </table>

 <a href="inventoryDetails.jsp">View Inventory Details</a>

   </body>
   </html>