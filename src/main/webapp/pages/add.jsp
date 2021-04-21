<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
<style>
</style>
</head>
<body>
<h1>Hello </h1>
<spring:form modelAttribute="item"  method="post" action="submitadd">
			<h2 class="text-center">Register</h2>
			<div class="form-group">
				<spring:input path="itemDesc" type="text" class="form-control"
					placeholder="Itemname" required="required" />
			</div>
			<div class="form-group">
				<spring:input path="itemCategory" type="text" class="form-control"
					placeholder="Shop name" required="required" />
			</div>
			<div class="form-group">
				<spring:input path="itemPrice" type="Number" class="form-control"
					placeholder="Price" required="required" />
			</div>
			<div class="form-group">
				<spring:input path="stockQuantity" type="text" class="form-control"
					placeholder="Stock" required="required" />
			</div>
			<div class="form-group">
				<spring:input path="itemUnit" type="text" class="form-control"
					placeholder="Units" required="required" />
			</div>
			<div class="form-group">
				<spring:input path="imgurl" type="text" class="form-control"
					placeholder="Image" required="required" />
			</div>
		
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block">Add</button>
			</div>
		</spring:form>
</body>
</html>