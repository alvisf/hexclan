<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="excel" method="get">
  		  <input type="submit"  name="action" value="Excel">
	</form>
	<form action="pdf" method="get">
  		  <input type="submit"  name="action" value="Pdf">
	</form>
	<form action="email" method="get">
  		  <input type="submit"  name="action" value="Email">
	</form>
	<form action="sms" method="get">
  		  <input type="submit"  name="action" value="Sms">
	</form>
</body>
</html>