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
	<spring:form action="submitadminForm" modelAttribute="admin" method="post">
	
		UserName:<spring:input path="uname"/>
		PassWord:<spring:input path="upass"/>
		
		<input type="submit" value="login..">
		
	
		
	</spring:form>
	
</body>
</html>