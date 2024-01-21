<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>New Dojo</h1>
	
	 <form:form action="/home/dojo/process/create" method="post" modelAttribute="dojo">
	  <div>
	  	<label>Dojo Name: </label>
	  	<form:input type="text" path="name"/>
	  	<form:errors path="name"/>
	  	</div>

	  	<button style="color:white; background-color:blue;">Create</button>
	 </form:form>
</body>
</html>