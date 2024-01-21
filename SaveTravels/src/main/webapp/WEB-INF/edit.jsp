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

	<h1>Edit Expense</h1>

<form:form action="/expenses/process/edit/${travel.id}" modelAttribute="travel" method="post">
		<input type="hidden" value="patch" name="_method"/>
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