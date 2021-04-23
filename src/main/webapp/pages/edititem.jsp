<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>

<head>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
		integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o"
		crossorigin="anonymous"></script>
	<link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css"
		rel="stylesheet" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css"
		href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons">
	<link href="https://fonts.googleapis.com/css?family=Anton|Signika:300" rel="stylesheet">
	<title>Home</title>
	<style>
		:root {
			--input-padding-x: 1.5rem;
			--input-padding-y: 0.75rem;
		}

		body {
			font-family: 'Signika', Sans-Serif;
			background-color: #fff;
		}

		h1 {
			font-family: 'Anton', Sans-Serif;
		}

		.brand-text {
			font-family: 'Anton', Sans-Serif;
			font-size: 25px;
		}

		.accent-color {
			color: #2D4A6B;
		}

		.main-heading {
			font-weight: bold;
		}

		.btn-main {
			font-family: 'Signika', Sans-Serif;
			font-size: 1rem;
			letter-spacing: 0.05rem;
			padding: 0.75rem 1rem;
			border-radius: .25rem;
			color: white;
			background-color: #2D4A6B;
		}

		.btn-main:hover {
			color: white;
			background-color: #5389A8;
		}

		.btn .material-icons {
			position: relative;
			display: inline-block;
			top: 0;
			margin-top: -1.2em;
			margin-bottom: -1em;
			font-size: 1.1rem;
			vertical-align: middle;
		}

		.btn.btn-sm {
			border-radius: 3px !important;
		}

		.btn.btn-just-icon.btn-sm {
			height: 30px;
			min-width: 30px;
			width: 30px;
		}

		.btn.btn-just-icon {
			font-size: 24px;
			height: 41px;
			min-width: 41px;
			width: 41px;
			padding: 0 !important;
			overflow: hidden;
			position: relative;
			line-height: 41px;
		}

		.btn.btn-just-icon.btn-round {
			border-radius: 50% !important;
		}

		.btn.btn-link {
			background: transparent;
			box-shadow: none;
			color: #999;
		}

		.btn.btn-success {
			color: #fff !important;
			background-color: #4caf50 !important;
			border-color: #4caf50;
			box-shadow: 0 2px 2px 0 rgba(76, 175, 80, .14),
				0 3px 1px -2px rgba(76, 175, 80, .2),
				0 1px 5px 0 rgba(76, 175, 80, .12) !important;
		}

		.btn.btn-success:hover {
			box-shadow: 0 14px 26px -12px rgba(76, 175, 80, .42),
				0 4px 23px 0 rgba(0, 0, 0, .12),
				0 8px 10px -5px rgba(76, 175, 80, .2) !important;
			background: #47a44b !important;
		}

		.btn.btn-success.btn-link {
			background-color: transparent !important;
			color: #4caf50 !important;
			box-shadow: none !important;
		}

		.btn.btn-danger {
			color: #fff !important;
			background-color: #f44336 !important;
			border-color: #f44336;
			box-shadow: 0 2px 2px 0 rgba(244, 67, 54, .14),
				0 3px 1px -2px rgba(244, 67, 54, .2),
				0 1px 5px 0 rgba(244, 67, 54, .12) !important;
		}

		.btn.btn-danger:hover {
			box-shadow: 0 14px 26px -12px rgba(244, 67, 54, .42),
				0 4px 23px 0 rgba(0, 0, 0, .12),
				0 8px 10px -5px rgba(244, 67, 54, .2) !important;
			background-color: #f33527 !important;

		}

		.btn.btn-danger.btn-link {
			background-color: transparent !important;
			color: #f44336 !important;
			box-shadow: none !important;
		}

		.btn.btn-just-icon .material-icons {
			margin-top: 0;
			position: absolute;
			width: 100%;
			transform: none;
			left: 0;
			top: 0;
			height: 100%;
			line-height: 41px;
			font-size: 20px;
		}

		.btn.btn-just-icon.btn-sm .material-icons {
			font-size: 17px;
			line-height: 29px;
		}

		.logout {
			font-family: 'Signika', Sans-Serif;
			font-size: 0.8rem;
			letter-spacing: 0.05rem;
			padding: 0.5rem;
			border-radius: .25rem;
			color: white;
			background-color: #2D4A6B;
			text-transform: uppercase;
		}

		.logout:hover {
			color: white;
			background-color: #5389A8;
		}

		.nav-username {
			font-family: 'Signika', Sans-Serif;
			text-align: center;
			font-size: 16px;
			font-weight: bolder;
			margin: auto;
		}

		.add-form {
			font-family: 'Signika', Sans-Serif;
			padding: 50px 0;
			background-color: #F1F1E6;
			max-width: 600px;
			margin: auto;
			padding: 50px 70px;
			border-radius: .25rem;
			box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.25);
			font-family: "Cabin", Sans-Serif;
			font-size: 16px;
		}
	</style>
	<meta charset="ISO-8859-1">
	<title>Edit Item</title>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light">
		<a class="navbar-brand brand-text" href="home"><span class="accent-color">One Stop</span> Shop</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Products</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0" action="logout">
				<p class="mr-sm-2 nav-username pr-2">Hey, ${user.getUname()}</p>
				<button class="btn logout my-2 my-sm-0" type="submit">Logout</button>
			</form>
		</div>
	</nav>
	<div class="edit-form">
		<spring:form modelAttribute="itemmodel" method="post" action="edittedditem">
			<div class="col-sm text-center mt-4">
				<h1><span class="accent-color">Edit</span> Product</h1>
			</div>
			<div class="row h-100 justify-content-center align-items-center">
				<div class="col-lg-6 col-md-10 ml-auto mr-auto">
					<img src="https://image.freepik.com/free-vector/admin-concept-illustration_114360-2139.jpg" alt=""
						width="100%">
				</div>
				<div class="col-lg-6 col-md-10 ml-auto mr-auto">
					<div class="add-form mb-4">
						<div class="form-label-group mb-2">
							<label class="small" for="itemname">Product Name</label>
							<spring:input path="itemDesc" type="text" class="form-control item"
								placeholder="Product Name" required="required" value='${item.getItemDesc()}' />
						</div>
						<div class="form-label-group mb-2">
							<label class="small" for="quantity">Quantity</label>
							<spring:input path="stockQuantity" type="text" class="form-control item"
								placeholder="Product Quantity" required="required" value='${item.getStockQuantity()}' />
						</div>
						<div class="form-label-group mb-2">
							<label class="small" for="price">Price</label>
							<spring:input path="itemPrice" type="text" class="form-control item"
								placeholder="Product Price" required="required" value='${item.getItemPrice()}' />
						</div>
						<div class="form-label-group mb-2">
							<label class="small" for="unit">Unit</label>
							<spring:input path="itemUnit" type="text" class="form-control item"
								placeholder="Product Unit" required="required" value='${item.getItemUnit()}' />
						</div>
						<div class="form-label-group mb-2">
							<label class="small" for="imageurl">Image URL</label>
							<spring:input path="imgurl" type="text" class="form-control item" placeholder="Image URL"
								required="required" value='${item.getImgurl()}' />
						</div>
						<div class="form-label-group mb-2">
							<spring:input path="itemNo" type="hidden" class="form-control item"
								placeholder="Item Number" required="required" value='${item.getItemNo()}' />
						</div>
						<div class="form-label-group mb-2">
							<label class="small" for="role">Category</label>
							<spring:select class="form-control item" path="itemCategory">
								<spring:option value='${item.getItemCategory()}' label='${item.getItemCategory()}' />
								<spring:option value="grocery" label="Grocery" />
								<spring:option value="clothing" label="Apparel" />
								<spring:option value="jewellery" label="Jewellery" />
							</spring:select>
						</div>
						<div class="form-label-group mb-2">
							<button type="submit" class="btn btn-lg btn-block btn-main">EDIT PRODUCT</button>
						</div>
					</div>
				</div>
			</div>
		</spring:form>
	</div>
</body>

</html>