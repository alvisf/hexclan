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
	<link href="https://fonts.googleapis.com/css?family=Anton|Signika:300" rel="stylesheet">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
	<style>
		:root {
			--input-padding-x: 1.5rem;
			--input-padding-y: 0.75rem;
		}

		body {
			font-family: 'Signika', Sans-Serif;
		}

		.login,
		.image {
			min-height: 100vh;
		}

		.bg-image {
			background-image: url('https://images.unsplash.com/photo-1527769929977-c341ee9f2033?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=334&q=80');
			background-size: cover;
			background-position: center;
		}

		.login-heading {
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

		.caption {
			font-size: 15px;
		}
	</style>
	<meta charset="ISO-8859-1">
	<title>Login</title>
</head>

<body>
	<div class="container-fluid">
		<div class="row no-gutter">
			<div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
			<div class="col-md-8 col-lg-6">
				<div class="login d-flex align-items-center py-5">
					<div class="container">
						<div class="row">
							<div class="col-md-9 col-lg-8 mx-auto">
								<h3 class="login-heading mb-2">Welcome back!</h3>
								<spring:form modelAttribute="user" method="post" action="submitForm">
									<div class="form-label-group mb-2">
										<label class="small" for="uname">Username</label>
										<spring:input path="uname" type="text" class="form-control"
											placeholder="Username" required="required" />
									</div>
									<div class="form-label-group mb-3">
										<label class="small" for="upass">Password</label>
										<spring:input path="upass" type="password" class="form-control"
											placeholder="Password" required="required" />
									</div>
									<div class="form-group">
										<button
											class="btn btn-lg btn-block btn-main text-uppercase font-weight-bold mb-2"
											type="submit">Login</button>
									</div>
									<div class="text-center">
										<span class="caption">New here?
											<a href="gotoregForm" style="text-decoration: none;">
												Create an account.</a>
										</span>
									</div>
								</spring:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>