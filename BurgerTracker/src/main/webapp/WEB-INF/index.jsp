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
	  <h1>Add a Burger:</h1>
	  
	  
	  
	 <form:form action="/burger/process/new" method="post" modelAttribute="burger">
	  <div>
	  	<label>Burger Name: </label>
	  	<form:input type="text" path="burgername"/>
	  	<form:errors path="burgername"/>
	  	</div>
	  	<div>
	  	<label> Restaurant Name:</label>
	  	<form:input type="text" path="restaurantname"/>
	  	<form:errors path="restaurantname"/>
	  	</div>
	  	<div>
	  	<label>Rating:</label>
	  	<form:input type="number" path="rating"/>
	  	<form:errors path="rating"/>
	  	</div>
	  	<div>
	  	<label>Notes:</label>
	  	<form:textarea type="text" path="notes"></form:textarea>
	  	<form:errors path="notes"/>
	  	</div>
	  	<button style="color:white; background-color:blue;">Submit</button>
	 </form:form>
	  
	  
	  
</body>
</html>