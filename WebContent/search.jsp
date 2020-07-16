<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>You have Successfully Logged in</h1>
${name}<br>
${mobile}<br>
${Age } <br>
${location }<br>
${date }<br>

<h3 style="color:green"><c:if test="${name!=null}">
Name is valid
</c:if>
</h3>
	<h1>Search Railways here</h1>
	<form action="search.do" method="post">
		Search Train by City Name : <select name="city">
			<c:forEach items="${cityname}" var="trains">
				<option value="${trains}">${trains}</option>
			</c:forEach>
		</select>
		<button type="submit">search</button>
	</form>
</body>
</html>