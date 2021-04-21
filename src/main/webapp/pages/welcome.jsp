<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Home</title>
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
.shop-grid {
	color: #313437;
	background-color: #fff;
}

.shop-grid p {
	color: #7d8285;
}

.shop-grid h2 {
	font-weight: bold;
	margin-bottom: 40px;
	padding-top: 40px;
	color: inherit;
}

@media ( max-width : 767px) {
	.shop-grid h2 {
		margin-bottom: 25px;
		padding-top: 25px;
		font-size: 24px;
	}
}

.shop-grid .intro {
	font-size: 16px;
	max-width: 500px;
	margin: 0 auto;
}

.shop-grid .intro p {
	margin-bottom: 0;
}

.shop-grid .people {
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
	color: #bbd8fb;
	letter-spacing: 2px;
	font-size: 13px;
	margin-bottom: 20px;
}

.form-icon {
	text-align: center;
	font-family: "Cabin", Sans-Serif;
	font-size: 16px;
	color: white;
	margin: auto;
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
			<spring:form class="form-inline my-2 my-lg-0 " action="logout">
				<p class="mr-sm-2 form-icon">
					<span><i class="icon icon-user"></i> </span>&nbsp; Welcome,
					${user.getUname()}!&nbsp;
				</p>
				<button class="btn logout my-2 my-sm-0" type="submit">Logout</button>
				<a href="cart" style="text-decoration: none">
					<p class="mr-sm-2 form-icon ml-3 cart">
						<span><i class="icon icon-basket"></i> </span>
					</p>
				</a>
			</spring:form>
		</div>
	</nav>
	<div class="shop-grid">
		<div class="container">
			<div class="intro">
				<h2 class="text-center">
					<span style="color: #dfa01e">One Stop</span> Shop
				</h2>
				<p class="text-center lead">Shopping made simple.</p>
			</div>
			<div class="row people">
				<div class="col-sm-6 col-md-4 item">
					<a href="shopping1">
						<div class="box"
							style="background-image: url(D:\java\workspace\springwebproject\WebContent\WEB-INF\assets\grocery.jpeg)">
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
							style="background-image: url(D:\java\workspace\springwebproject\WebContent\WEB-INF\assets\clothing.jpeg)">
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
							style="background-image: url(D:\java\workspace\springwebproject\WebContent\WEB-INF\assets\jewellery.jpeg)">
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
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
