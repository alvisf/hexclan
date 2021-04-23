<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
		<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="ISO-8859-1">
				<title>Apparel Shop</title>
				<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
					integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
					crossorigin="anonymous" />
				<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
					integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
					crossorigin="anonymous"></script>
				<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
					integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o"
					crossorigin="anonymous"></script>
				<link
					href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css"
					rel="stylesheet" />
				<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
				<link rel="stylesheet" type="text/css"
					href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons">
				<link href="https://fonts.googleapis.com/css?family=Anton|Signika:300" rel="stylesheet">

				<style>
					/* Common CSS */
					:root {
						--input-padding-x: 1.5rem;
						--input-padding-y: 0.75rem;
					}

					body {
						font-family: 'Signika', Sans-Serif;
						background-color: #F1F1E6;
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
						font-size: 0.9rem;
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

					.logout {
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
						text-align: center;
						font-size: 16px;
						font-weight: bolder;
						margin: auto;
					}

					.form-icon {
						text-align: center;
						font-family: "Signika", Sans-Serif;
						font-size: 16px;
						color: black;
						margin: auto;
					}

					.cart {
						font-size: larger;
					}

					.cart:hover {
						color: #2D4A6B;
					}

					.caption {
						font-size: 15px;
					}

					/* Common CSS End */

					.item-list {
						color: #313437;
					}

					.item-list p {
						color: #313437;
						font-size: 14px;
						font-family: "Signika", Sans-Serif;
						margin-top: 10px;
					}

					.item-list h2 {
						font-family: "Roboto Condensed", Sans-Serif;
						font-weight: bold;
						margin-bottom: 40px;
						padding-top: 40px;
						color: inherit;
					}

					@media (max-width :767px) {
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
						font-family: "Signika", Sans-Serif;
						font-weight: bold;
						font-size: 16px;
						margin-top: 20px;
						color: inherit;
					}

					.item-list .item .description {
						color: #D0110F;
						/* color: #7d8285; */
						font-family: "Signika", Sans-Serif;
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
				</style>
			</head>

			<body>
				<nav class="navbar navbar-expand-lg navbar-light">
					<a class="navbar-brand brand-text" href="home"><span class="accent-color">One Stop</span> Shop</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
						aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item">
								<a class="nav-link" href="home">Home</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="shopping1">Grocery Shop</a>
							</li>
							<li class="nav-item active">
								<a class="nav-link" href="shopping2">Apparel Shop <span
										class="sr-only">(current)</span></a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="shopping3">Jewellery Shop</a>
							</li>
						</ul>
						<form class="form-inline my-2 my-lg-0" action="logout">
							<p class="mr-sm-2 nav-username pr-2">Hello, ${user.getUname()}</p>
							<button class="btn logout my-2 my-sm-0" type="submit">Logout</button>
							<a href="cart" style="text-decoration: none;">
								<p class="mr-sm-2 form-icon ml-3 cart">
									<span><i class="icon icon-basket"></i> </span>
									<span class="small font-weight-bolder">Cart</span>
								</p>
							</a>
						</form>
					</div>
				</nav>
				<div>
					<h1 class="text-center mt-4">
						<span class="accent-color">APPAREL</span> SHOP
					</h1>
				</div>
				<p class="lead text-center mt-2 accent-color">
					Up your style quotient.
				</p>
				<p class="text-center caption">Select products to add to your cart.</p>
				<div class="item-list">
					<div class="container">
						<spring:form commandName="items" action="submitShoppingForm2" method="post">
							<div class="row items">
								<c:forEach items="${items}" var="item">
									<div class="col-sm-6 col-md-4 item text-center">
										<input type="checkbox" name="selected" value=<c:out
											value='${item.getItemNo()}' />> <br />
										<img src=<c:out value='${item.getImgurl()}' /> class="img-fluid" style="width:
										50%">
										<h3 class="name">${item.getItemDesc()}</h3>
										<p class="description">MRP: Rs. ${item.getItemPrice()}</p>
										<p>In Stock: ${item.getStockQuantity()} units</p>
										<select class="form-control mt-2 mb-2 w-50" name=<c:out
											value='${item.getItemNo()}' />
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
										<div class="col-sm mt-2 mb-4 m-auto">
											<button type="submit"
												class="btn btn-block my-2 my-sm-0 btn-main text-uppercase">Add to
												Cart</button>
										</div>
									</div>
								</c:forEach>
							</div>
						</spring:form>
					</div>
				</div>
			</body>

			</html>