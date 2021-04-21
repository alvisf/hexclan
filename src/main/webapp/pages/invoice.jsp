<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
<div class="row justify-content-center">
    <div class="col-auto">
    <h1 class="display-4">Invoice</h1>
</div>
</div>

	<div class="row justify-content-center"><div class="col-auto"><span class="font-weight-bolder">Customer Name : </span><span>${user.getUname()}</span></div></div>
	<div class="row justify-content-center"><div class="col-auto"><span class="font-weight-bolder">Customer Id : </span><span>${user.getUid()}</span></div></div>
	<div class="row justify-content-center"><div class="col-auto"><span class="font-weight-bolder">Date : </span><span>${date}</span></div></div>
	<div class="row justify-content-center">
    <div class="col-auto">
	<table border="1" class="table table-responsive table-dark">
	<tr>
	<th>Item No</th>
	<th>Item Description</th>
	<th>Item Unit</th>
	<th>Item Price</th>
	<th>Quantity</th>
	</tr>

	<c:forEach items="${items.keySet()}" var="item">
	<tr>
	<td>${item.getItemNo()}</td> 
	<td>${item.getItemDesc()}</td>
	<td>${item.getItemUnit()}</td>
	<td>${item.getItemPrice()}</td>
	<td>${items.get(item)}</td>
	</tr>

	</c:forEach>
		<tr>
		<td></td> 
		<td></td>
		<td>Total</td>
		<td>${total}</td>
		</tr>
	</table>
	</div>
	</div>
	<div class="row justify-content-center">
	
	<form action="confirmorder" method="post">
		<input type="submit" value="Confirm order">	
	</form>
</div>
</body>
</html>
