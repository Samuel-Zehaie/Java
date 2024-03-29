<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
   <h1 class="mt-4">Fruit Store</h1>

    <table class="table table-bordered table-striped mt-4">
        <thead class="thead-dark">
            <tr>
                <th>Name</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="oneFruit" items="${fruitsFromMyController}">
                <tr>
                    <td><c:out value="${oneFruit.name}" /></td>
                    <td><c:out value="${oneFruit.price}" /></td>
                </tr>
            </c:forEach>
        </tbody>
        
    </table>
</body>
</html>