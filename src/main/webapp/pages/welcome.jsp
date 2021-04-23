<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="utf-8" />
			<meta name="viewport" content="width=device-width, initial-scale=1.0" />
			<title>Home</title>
			<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
				crossorigin="anonymous" />
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
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
			<title>Home</title>
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

				/* Common CSS End */

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

				.shop-grid {
					color: #313437;
				}

				.shop-grid h2 {
					font-weight: bold;
					margin-bottom: 40px;
					padding-top: 40px;
					color: inherit;
				}

				.shop-grid .intro {
					font-size: 16px;
					max-width: 500px;
					margin: 0 auto;
				}

				.shop-grid .intro p {
					margin-bottom: 0;
				}

				.shop-grid .shop-card {
					padding: 50px 0;
				}

				.shop-grid .item {
					margin-bottom: 30px;
				}

				.shop-grid .item .box {
					text-align: center;
					background-repeat: no-repeat;
					background-size: cover;
					background-position: center;
					height: 280px;
					position: relative;
					overflow: hidden;
				}

				.shop-grid .item .cover {
					position: absolute;
					top: 0;
					left: 0;
					width: 100%;
					height: 100%;
					/* background-color: rgba(30, 133, 125, 0.75); */
					background-color: rgba(3, 23, 41, 0.75);
					transition: opacity 0.15s ease-in;
					opacity: 0;
					padding-top: 100px;
					color: #fff;
					text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.15);
				}

				.shop-grid .item:hover .cover {
					opacity: 1;
				}

				.shop-grid .item .name {
					font-weight: bold;
					margin-bottom: 8px;
				}

				.shop-grid .item .title {
					text-transform: uppercase;
					font-weight: bold;
					color: #DBD2D2;
					letter-spacing: 2px;
					font-size: 13px;
					margin-bottom: 20px;
				}

				.no-decoration {
					text-decoration: none;
				}
			</style>
		</head>

		<body>
			<nav class="navbar navbar-expand-lg navbar-light">
				<a class="navbar-brand brand-text" href="home"><span class="accent-color">One Stop</span> Shop</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active">
							<a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="shopping1">Grocery Shop</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="shopping2">Apparel Shop</a>
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
			<div class="shop-grid">
				<div class="container">
					<div class="intro">
						<h1 class="text-center m-4">
							<span class="accent-color">One Stop</span> Shop
						</h1>
						<p class="text-center lead accent-color">Shopping made simple.</p>
					</div>
					<div class="row shop-card">
						<div class="col-sm-6 col-md-4 item">
							<a href="shopping1">
								<div class="box"
									style="background-image: url('https://images.pexels.com/photos/890507/pexels-photo-890507.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940')">
									<div class="cover">
										<h3 class="name">Grocery Shop</h3>
										<br>
										<p class="title">Shop Now</p>
									</div>
								</div>
							</a>
						</div>
						<div class="col-sm-6 col-md-4 item">
							<a href="shopping2">
								<div class="box"
									style="background-image: url('https://images.pexels.com/photos/4947543/pexels-photo-4947543.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940')">
									<div class="cover">
										<h3 class="name">Apparel Shop</h3>
										<br>
										<p class="title">Shop Now</p>
									</div>
								</div>
							</a>
						</div>
						<div class="col-sm-6 col-md-4 item">
							<a href="shopping3">
								<div class="box"
									style="background-image: url('https://images.pexels.com/photos/5497303/pexels-photo-5497303.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940')">
									<div class="cover">
										<h3 class="name">Jewellery Shop</h3>
										<br>
										<p class="title">Shop Now</p>
									</div>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
		</body>

		</html>