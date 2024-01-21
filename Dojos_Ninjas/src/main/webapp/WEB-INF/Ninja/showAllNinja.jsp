<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>  


		<table class="table table-dark">
  <thead>
    <tr>
      <th>id</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Age</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="ninja" items="${allNinjas}">
    <tr>
      <td><c:out value="${ninja.id }"/></td>
     <td><c:out value="${ninja.first }"/></td>
     <td><c:out value="${ninja.last }"/></td>
     <td><c:out value="${ninja.age }"/></td>
     <td><c:out value="${ninja.dojo.name }"/></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>