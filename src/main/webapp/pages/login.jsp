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
	background-image: url(./assets/bg.jpeg);
	background-repeat: no-repeat;
	background-size: cover;
}

.login-form {
	padding: 50px 0;
}

.login-form form {
	background-color: #fff;
	max-width: 600px;
	margin: auto;
	padding: 50px 70px;
	border-radius: 30px;
	box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.5);
	font-family: "Cabin", Sans-Serif;
	font-size: 16px;
}

.login-form .form-icon {
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

.login-form .item {
	border-radius: 20px;
	margin-bottom: 25px;
	padding: 7px 20px;
}

.login-form .main-button {
	border-radius: 30px;
	padding: 10px 20px;
	font-size: 18px;
	font-family: "Roboto Condensed", Sans-Serif;
	background-color: #031729;
	border: none;
	color: white;
	margin-top: 20px;
}

.login-form .alternate {
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

</style>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img src="./assets/logo.png"
				alt="" width="50%" class="d-inline-block align-top" /> 
			</a>
			<form class="form-inline">
				<button class="btn btn-block my-2 my-sm-0 logout" type="button">
					<a href="gotoregForm">
					Create Account</button>
					</a>
			</form>
		</div>
	</nav>
	<div class="login-form">
		<spring:form modelAttribute="user" method="post" action="submitForm">
			<div class="form-icon">
				<span> <i class="icon icon-user"></i>
				</span>
			</div>
			<div class="form-group">
				<spring:input path="uname" type="text" class="form-control item"
					placeholder="Username" required="required" />
			</div>
			<div class="form-group">
				<spring:input path="upass" type="password" class="form-control item"
					placeholder="Password" required="required" />
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-block my-2 my-sm-0 main-button">Login</button>
			</div>
			<hr style="border: 1px solid grey">
			<p class="text-center">Don't have an account?</p>
			<div class="form-group">
				<a href="gotoregForm">
					<button type="button" class="btn btn-block my-2 my-sm-0 alternate">Create Account</button>
				</a>
			</div>
		</spring:form>
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
</body>
</html>