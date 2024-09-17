<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

  <html>
  <head>
    <title>Upload Inventory Image</title>
    </head>
    <body>

    <form method="POST" enctype="multipart/form-data" action="/uploadImage/${itemId}">
        <label for="image">Upload Image:</label>
        <input type="file" name="image" />
        <button type="submit">Upload</button>
    </form>




    </body>
    </html>

