<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="getdateinvoice">
	  <label for="birthday">From:</label>
	  <input type="date" id="birthday" name="startdate">
	
	  <label for="birthday">To:</label>
	  <input type="date" id="birthday" name="enddate">
	
	  <input type="submit">
	</form>


</body>
</html>