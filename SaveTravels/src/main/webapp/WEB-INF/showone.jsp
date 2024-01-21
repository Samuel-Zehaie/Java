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
		<h1>Show One Travel</h1>
		
		<p>Travel Id:<c:out value="${travel.id}"/></p>
		<p>Expense:<c:out value="${travel.expense}"/></p>
		<p>Vendor:<c:out value="${travel.vendor}"/></p>
		<p>Description:<c:out value="${travel.description}"/></p>
		
</body>
</html>