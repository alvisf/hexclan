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
<style>
</style>
</head>
<body>
<h1>Hello </h1>
<form action="edittedditem" method="post">
	
	<div class="row h-100 justify-content-center align-items-center">
    <div class="col-auto">
   <div class="col-sm text-center"><h1>Update the Item</h1></div><hr>
	<table border="1" class="table w-auto table-responsive" style="color:#800000">
	<tr>
	<th>Shop name</th>
	<th>Item Name</th>
	<th>Item Price</th>
	<th>Choose</th>
	</tr>

	<tr>
	<td><select class="form-control" name=<c:out value="category" />>
	<option value=${item.getItemCategory()}>'${item.getItemCategory()}'</option>
	<option value="jewellery">jewellery</option>
	<option value="grocery">grocery</option>
	<option value="sports">sports</option>
	</select></td>
	<td><span><input type="text" class="form-control" name="ItemName" placeholder='${item.getItemDesc()}' value= '${item.getItemDesc()}' /></span></td>
	<td><span><input type="text" class="form-control" name="itemprice" placeholder='${item.getItemPrice()}' value='${item.getItemPrice()}' /></span></td>
	<td><span><input type="text" class="form-control" name="itemstock" placeholder='${item.getStockQuantity()}' value='${item.getStockQuantity()}' /></span></td>
	
	
	</tr>
		
		</table>
		<input type="hidden" name="id" value='${item.getItemNo()}'>
		<div class="col-sm text-center">
		<input type="submit" value="Update" class="btn btn-danger">
			</div></div>
	</div>
	</form>
</body>
</html>