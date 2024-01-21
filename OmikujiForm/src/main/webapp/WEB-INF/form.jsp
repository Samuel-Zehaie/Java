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
		<form action="/process" method="post">
			<div>
				<label>Hidden input example</label>
				<input type="hidden" value="samuel z" name="name"/>
			</div>
			<div>
				<label>Pick any number from 5 to 25</label>
				<input type="number" name="number">
				<p style="color:red"><c:out value="${error}"/></p>
			</div>
			<div>
				<label>Enter the name of any city</label>
				<input type="text" name="city"> 
			</div>
			<div>
				<label>Enter the name of any real person</label>
				<input type ="text" name="person">
			</div>
			<div>
				<label>Enter professional endeavor or hobby:</label>
				<input type = "text" name="hobby">
			</div>
			<div>
				<label>Enter any type of living thing</label>
				<input type ="text" name="living">
			</div>
			<div>
				<label>Say something nice to someone:</label>
				<textarea name="comment"></textarea>
			</div>
				<p>Send and show a friend</p>
			
			<button>Send</button>
		</form>
</body>
</html>