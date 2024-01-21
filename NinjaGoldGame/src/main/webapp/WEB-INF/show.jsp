<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Your Gold</h1>
<P><c:out value="${count}"/></P>
<div class="flex" >
	<div class="formSize">
		<form action="/post" method="post">
			<h2>Farm</h2>
			<input type="hidden" value="Farm" name="farm">			
			<p>(earn 10-20 gold)</p>			
			<button>Find Gold!</button>
		</form>
	</div>
	<div class="formSize">
		<form action="/post" method="post">
			<h2>Cave</h2>
			<input type="hidden" value="Cave" name="cave">
			<p>(earn 5-10 gold)</p>		
			<button>Find Gold!</button>
		</form>
	</div>
	<div class="formSize">
		<form action="/post" method="post">
			<h2>House</h2>
			<input type="hidden" value="House" name="house">		
			<p>(earn 2-5 gold)</p>		
			<button>Find Gold!</button>
		</form>
	</div>
	<div class="formSize">
		<form action="/post" method="post">
			<h2>Quest</h2>
			<input type="hidden" value="Quest" name="quest">			
			<p>(earn/takes 0-50 gold)</p>
			<button>Find Gold!</button>
		</form>
	</div>
</div>
	<div class="active">	
		<div>
			<h1>Activities:</h1>
		</div>
		<div>

 
 	<c:forEach var="activity" items="${activities}">
        <p><c:out value="${activity}"></c:out></p>
    </c:forEach>
			
		
		</div>
		
	
	
	</div>	
</body>
</html>