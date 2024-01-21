<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Save Travels</h1>

	<table class="table table-dark">
  <thead>
    <tr>
    
      <th>Expense</th>
      <th>Vendor</th>
      <th>amount</th>
      <th>description</th>
      <th>Actions</th>
      
    </tr>
  </thead>
  <tbody>
  <c:forEach var="travel" items="${allTravel}">
    <tr>
     <td><a href="/expenses/show/${travel.id}"><c:out value="${travel.expense }"/></a></td>
     <td><c:out value="${travel.vendor }"/></td>
     <td><c:out value="${travel.amount }"/></td>
     <td><c:out value="${travel.description}"/></td>
     <td>
    
     <a href="/expenses/edit/${travel.id}" class="btn btn-outline-warning">Edit</a>
     <form action="/expenses/delete/${travel.id }" method="post">
     		<input type="hidden" name="_method" value="Delete"/>
     		<input type="submit" value="delete" class="btn btn-outline-danger"/>
     </form>
   
    </td>
    </c:forEach>
    </table>
    
    <h1>Add an expense:</h1>
    
    <form:form action="/expenses/process/create" modelAttribute="travel" method="post">
		
		<div>
			<form:label path="expense">Expense</form:label>
			<form:input type="text" path="expense"/>
			<form:errors path="expense"/>
		</div>
			<div>
			<form:label path="vendor">vendor</form:label>
			<form:input type="text" path="vendor"/>
			<form:errors path="vendor"/>
		</div>
		<div>
			<form:label path="amount">Amount</form:label>
			<form:input type="text" path="amount"/>
			<form:errors path="amount"/>
		</div>
		<div>
			<form:label path="Description">Description</form:label>
			<form:textarea path="Description"></form:textarea>
			<form:errors path="Description"/>
		</div>
			<button class="btn btn-outline-success">Submit</button>
		</form:form>
    
 

</body>
</html>