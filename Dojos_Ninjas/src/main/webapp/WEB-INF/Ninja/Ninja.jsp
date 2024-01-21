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

	<h1>New Ninja</h1>
	
    	 <form:form action="/home/ninja/process/create" method="post" modelAttribute="ninja">
	  <div>
	  	<label>First Name: </label>
	  	<form:input type="text" path="first"/>
	  	<form:errors path="first"/>
	  	</div>
	  	<div>
	  	<label>Last Name:</label>
	  	<form:input type="text" path="last"/>
	  	<form:errors path="last"/>
	  	</div>
	  	<div>
	  	<label>age:</label>
	  	<form:input type="number" path="age"/>
	  	<form:errors path="age"/>
	  	</div>
	  	<div>
	  	<label>Dojo:</label>
	  	<form:select  path="dojo">
	  	<c:forEach var="dojo" items="${allDojos }">
	  	<form:option value="${dojo.id}" path="dojo">
	  	<c:out value="${dojo.name }"/>
	  	</form:option>
	  		</c:forEach>
	  	</form:select>
	  	</div>
	  	<button style="color:white; background-color:blue;">Create</button>
	 </form:form>
</body>
</html>