<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome Mr ${customer.getCustomer_name()}</h1>
		<form  method="get" action="/itemcontrol/add">
	
		
		<input type="submit" value="Add" >
		</form>
		<form  method="get" action="/itemcontrol/editdelete">
	
		
		<input type="submit" value="Edit or delete" >
		</form>
		
		
	
</body>
</html>