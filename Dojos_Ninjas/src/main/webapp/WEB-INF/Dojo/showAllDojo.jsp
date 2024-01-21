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
      <th>Dojo Name</th>
      <th>Dojo Ninjas</th>
      <th>Dojo Numbers</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="dojo" items="${allDojos}">
    <tr>
      <td><c:out value="${dojo.id }"/></td>
     <td><a href="/home/dojo/display/${dojo.id}"><c:out value="${dojo.name }"/></a></td>  
     <td><c:out value="${dojo.ninjas.size() }"/></td>  
    </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>