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
	<h1>All Books</h1>
	<c:forEach var="book" items="${allbooks}">
		<p> Book Title: <c:out value="${book.title}"/></p>
		<p> Book Description : <c:out value="${book.description}"/></p>
		<p> Book language: <c:out value="${book.lang}"/></p>
		<p> Book Number of Pages: <c:out value="${book.numofpages}"/></p>
		</c:forEach>
		
		
		
		
</body>
</html>