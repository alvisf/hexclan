<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apparel Shop</title>
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
.item-list {
	color: #313437;
	background-color: #fff;
}

.item-list p {
	color: #7d8285;
	font-family: "Cabin", Sans-Serif;
}

.item-list h2 {
	font-family: "Roboto Condensed", Sans-Serif;
	font-weight: bold;
	margin-bottom: 40px;
	padding-top: 40px;
	color: inherit;
}

h2 {
	font-family: "Roboto Condensed", Sans-Serif;
	font-weight: bold;
}

@media ( max-width :767px) {
	.item-list h2 {
		margin-bottom: 25px;
		padding-top: 25px;
		font-size: 24px;
	}
}

.item-list .intro {
	font-size: 16px;
	max-width: 500px;
	margin: 0 auto;
}

.item-list .intro p {
	margin-bottom: 0;
}

.item-list .items {
	padding-bottom: 40px;
}

.item-list .item {
	padding-top: 50px;
	/* min-height:425px; */
	text-align: center;
}

.item-list .item .name {
	font-family: "Cabin", Sans-Serif;
	font-weight: bold;
	font-size: 16px;
	margin-top: 20px;
	color: inherit;
}

.item-list .item .description {
	font-family: "Cabin", Sans-Serif;
	font-size: 14px;
	margin-top: 15px;
	margin-bottom: 0;
}

.item-list .item .action {
	font-size: 24px;
	width: 24px;
	margin: 22px auto 0;
	line-height: 1;
	display: block;
	color: #4f86c3;
	opacity: 0.85;
	transition: opacity 0.2s;
	text-decoration: none;
}

.item-list .item .action:hover {
	opacity: 1;
}

.main-button {
	border-radius: 30px;
	padding: 10px 20px;
	font-size: 18px;
	font-family: "Roboto Condensed", Sans-Serif;
	background-color: #031729;
	border: none;
	color: white;
	margin-top: 20px;
}

.main-button:hover {
	color: #dfa01e;
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

span {
	font-family: "Roboto Condensed", Sans-Serif;
}

.form-icon {
	text-align: center;
	font-family: "Cabin", Sans-Serif;
	font-size: 16px;
	color: white;
	margin: auto;
}

.cart:hover {
	color: #dfa01e;
}
</style>
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
				<li class="nav-item active"><a class="navbar-brand" href="home">
						<!-- <img src="./assets/logo.png" alt="" width="50%" class="d-inline-block align-top" /> -->
						<span class="text-center" style="color: #dfa01e">ONE STOP</span> <span
						class="text-center"> SHOP</span> <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="shopping1">Grocery
						Shop</a></li>
				<li class="nav-item"><a class="nav-link" href="shopping2">Apparel
						Shop</a></li>
				<li class="nav-item"><a class="nav-link" href="shopping3">Jewellery
						Shop</a></li>
			</ul>

			<!-- LOGOUT -->
			<spring:form class="form-inline my-2 my-lg-0" action="logout">
				<p class="mr-sm-2 form-icon ml-2">
					<span><i class="icon icon-user"></i>&nbsp;&nbsp;<%=session.getAttribute("username")%></span>
				</p>
				<button class="btn logout my-2 my-sm-0" type="submit">Logout</button>

				<!-- SHOPPING CART ICON -->
				<a href="cart" style="text-decoration: none">
					<p class="mr-sm-2 form-icon ml-3 cart">
						<span><i class="icon icon-basket"></i> </span>
					</p>
				</a>

			</spring:form>

		</div>
	</nav>
	<div>
		<h2 class="text-center mt-4">
			<span style="color: #dfa01e">APPAREL</span> SHOP
		</h2>
	</div>
	<p class="lead text-center">
		Happy Shopping!
	</p>
	<div class="item-list">
		<div class="container">
			<spring:form commandName="items" action="submitShoppingForm2"
				method="post">
				<div class="row items">
					<c:forEach items="${items}" var="item">
						<div class="col-sm-6 col-md-4 item text-center">
							<input type="checkbox" name="selected"
								value=<c:out value='${item.getItemNo()}' />> <br /> <img
								src=<c:out value='${item.getImgurl()}'/> class="img-fluid"
								style="width: 50%">
							<h3 class="name">${item.getItemDesc()}</h3>
							<p class="description">MRP: Rs. ${item.getItemPrice()}</p>
							<select class="form-control mt-2 mb-2 w-50"
								name=<c:out value='${item.getItemNo()}'
								/>
								style="margin: auto;">
								<option value="none" selected disabled hidden="true">Select
									Quantity</option>
								<option value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</div>
					</c:forEach>
				</div>
				<div class="col-sm w-25 mb-3 float-right">
					<button type="submit"
						class="btn btn-block my-2 my-sm-0 main-button">Add to
						Cart</button>
				</div>
			</spring:form>
		</div>
	</div>
</body>
</html>