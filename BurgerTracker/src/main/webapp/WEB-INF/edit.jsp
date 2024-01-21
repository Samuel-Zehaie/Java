<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Burger</h1>
	
	<form:form action="/burger/process/edit/${burger.id}" method="post" modelAttribute="burger">
	  <input type="hidden" name="_method" value="patch"/>
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