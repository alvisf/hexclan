<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashMap" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

	<style>
		/* Common CSS */
		:root {
			--input-padding-x: 1.5rem;
			--input-padding-y: 0.75rem;
		}

		body {
			font-family: 'Signika', Sans-Serif;
			/* background-color: #F1F1E6; */
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
	</style>
	<meta charset="ISO-8859-1">
	<title>Home</title>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light">
		<a class="navbar-brand brand-text" href="/manage/home"><span class="accent-color">One Stop</span> Shop</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="/manage/home">Invoices <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/manage/submitallForm">Inventory</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0" action="logout">
				<p class="mr-sm-2 nav-username pr-2">Hello, ${user.getUname()}</p>
				<button class="btn logout my-2 my-sm-0" type="submit">Logout</button>
			</form>
		</div>
	</nav>

	<div class="login-form">
		<div class="col-sm text-center mb-0">
			<h1><span class="accent-color">View Invoice</span> Reports</h1>
		</div>
		<div style="text-align: center;">
			<img src="https://image.freepik.com/free-vector/data-inform-illustration-concept_114360-864.jpg">
		</div>
		<div class="flex" style="text-align: center;">
			<div class="form-group">
				<form method="post" action="/manage/invoicequery">
					<button class="btn w-25 my-2 my-sm-0 m-2 btn-main" type="submit">
						Search by Invoice
					</button>
				</form>
			</div>

			<div class="form-group">
				<form method="post" action="/manage/customerquery">
					<button class="btn my-2 w-25 my-sm-0 m-2 btn-main" type="submit">
						Search by Customer
					</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>