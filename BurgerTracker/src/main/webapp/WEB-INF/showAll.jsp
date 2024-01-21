<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Burger Tracker</h1>
	    

	
	<table>
		<thead>
			<tr>
				<th>Burger Name</th>
				<th>Restaurant Name</th>
				<th>rating</th>
				<th>notes</th>
			<tr>
		</thead>
		    <c:forEach var="burgers" items="${allburgers}">
		<tbody>
			<tr>
		  		<td><c:out value="${burgers.burgername}"/></td>
          		<td><c:out value="${burgers.restaurantname}"/></td>
          		<td><c:out value="${burgers.rating}"/></td>
          		<td><c:out value="${burgers.notes}"/></td>
          	</tr>
		</tbody>
			</c:forEach>
	</table>
	
	
</body>
</html>