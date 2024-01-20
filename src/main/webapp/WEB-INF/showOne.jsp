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
	<h1>one Burger</h1>
	
		<p>Burger name:<c:out value="${oneBurger.burgername }"/></p>
		<p>restaurant name::<c:out value="${oneBurger.restaurantname }"/></p>
		<p>rating:<c:out value="${oneBurger.rating}"/></p>
		<p>notes:<c:out value="${oneBurger.notes }"/></p>
</body>
</html>