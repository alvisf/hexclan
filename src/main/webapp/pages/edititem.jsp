<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
	integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o"
	crossorigin="anonymous"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
<link
	href="https://fonts.googleapis.com/css?family=Cabin|Roboto:400,700|Roboto+Condensed:400,700"
	rel="stylesheet">

<style>
body {
  background-image: url(./assets/bg3.jpeg);
  background-repeat: no-repeat;
  background-size: cover;
}

.edit-form {
	padding: 50px 0;
}

.edit-form form {
	background-color: #fff;
	max-width: 600px;
	margin: auto;
	padding: 50px 70px;
	border-radius: 30px;
	box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.5);
	font-family: "Cabin", Sans-Serif;
	font-size: 16px;
}

.edit-form .form-icon {
	text-align: center;
	background-color: #031729;
	border-radius: 50%;
	font-size: 40px;
	color: white;
	width: 100px;
	height: 100px;
	margin: auto;
	margin-bottom: 50px;
	line-height: 100px;
}

.edit-form .item {
	border-radius: 20px;
	margin-bottom: 25px;
	padding: 7px 20px;
}

.edit-form .main-button {
	border-radius: 30px;
	padding: 10px 20px;
	font-size: 18px;
	font-family: "Roboto Condensed", Sans-Serif;
	background-color: #031729;
	border: none;
	color: white;
	margin-top: 20px;
}

.edit-form .alternate {
	border-radius: 30px;
	padding: 10px 20px;
	font-size: 18px;
	font-family: "Roboto Condensed", Sans-Serif;
	background-color: #dfa01e;
	border: none;
	color: white;
	margin-top: 20px;
}

.logout {
	border-radius: 30px;
	padding: 10px 20px;
	font-family: "Roboto Condensed", Sans-Serif;
	font-size: 18px;
	background-color: #dfa01e;
	border: none;
	color: white;
	margin-top: 20px;
}

.form-icon {
	text-align: center;
	font-family: "Cabin", Sans-Serif;
	font-size: 16px;
	color: white;
	margin: auto;
}

h3, span {
	font-family: "Roboto Condensed", Sans-Serif;
	font-weight: bold;
}


</style>
<meta charset="ISO-8859-1">
<title>Edit Item</title>
</head>
<body>
	<nav
		class="navbar navbar-dark bg-dark navbar-expand-lg justify-content-between">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="container-fluid collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="navbar-brand" href="#">
						<!-- <img src="./assets/logo.png" alt="" width="50%" class="d-inline-block align-top" /> -->
						<span class="text-center" style="color: #dfa01e">ONE STOP</span> <span
						class="text-center"> SHOP</span> <span class="sr-only">(current)</span>
				</a></li>
			</ul>
			<spring:form class="form-inline my-2 my-lg-0 ">
			<p class="mr-sm-2 form-icon">
				<span><i class="icon icon-user"></i>
				</span>&nbsp;
				Welcome, <%=session.getAttribute("username")%>!&nbsp;
			</p>
				<button class="btn logout my-2 my-sm-0" type="submit">Logout</button>
			</spring:form>
		</div>
	</nav>
	<div class="edit-form">
		<spring:form modelAttribute="itemmodel" method="post" action="edittedditem">
		<h3 class="text-center">EDIT ITEM</h3>
			<div class="form-group">
				Item Name:<spring:input path="itemDesc" type="text" class="form-control item"
					placeholder="Product Name" required="required" value='${item.getItemDesc()}'/>
			</div>
			<div class="form-group">
				Item Quantity:<spring:input path="stockQuantity" type="text" class="form-control item"
					placeholder="Product Quantity" required="required" value='${item.getStockQuantity()}'  />
			</div>
			<div class="form-group">
				Item Price:<spring:input path="itemPrice" type="text" class="form-control item"
					placeholder="Product Price" required="required" value='${item.getItemPrice()}' />
			</div>
			<div class="form-group">
				Item Unit:<spring:input path="itemUnit" type="text" class="form-control item"
					placeholder="Product Unit" required="required" value='${item.getItemUnit()}'  />
			</div>
			<div class="form-group">
				Image URL:<spring:input path="imgurl" type="text" class="form-control item"
					placeholder="Image URL" required="required" value='${item.getImgurl()}' />
			</div>
			<div class="form-group">
				<spring:input  path="itemNo" type = "hidden" class="form-control item"
					placeholder="Item Number" required="required" value='${item.getItemNo()}' />
			</div>
			<div class="form-group">
                <spring:select class="form-control item" path="itemCategory">
                    <spring:option value='${item.getItemCategory()}' label='${item.getItemCategory()}' />
                    <spring:option value="grocery" label="Grocery Shop" />
                    <spring:option value="clothing" label="Apparel Shop" />
                    <spring:option value="jewellery" label="jewellery Shop" />
                </spring:select>
            </div>
			<div class="form-group">
				
				<button type="submit" class="btn btn-block my-2 my-sm-0 main-button">Edit</button>
			</div>
		</spring:form>
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
</body>
</html>