<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.HashMap"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grocery Shop</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons">
    <link rel="stylesheet"
        href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css"
        integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css"
        href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons">
        <link
	href="https://fonts.googleapis.com/css?family=Cabin|Roboto:400,700|Roboto+Condensed:400,700"
	rel="stylesheet">
	<link
	href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css"
	rel="stylesheet" />
<style>
	.container h3 {
            font-family: "Roboto Condensed", Sans-Serif;
            margin-top: 20px;
            margin-bottom: 10px;
            font-weight: 300;
            color: #3c4858;
        }

        small {
            font-size: 75% !important;
            color: #777;
        }

        .btn-group {
            position: relative;
            margin: 10px 1px;
            display: inline-flex;
            vertical-align: middle;
        }

        .btn-group .btn {
            padding: 6.5px 20px !important;
        }

        .btn.btn-round {
            border-radius: 30px !important;
        }

        .btn-group .btn.btn-round {
            border-radius: 30px !important;
        }

        .btn-group>.btn:not(:last-child):not(.dropdown-toggle) {
            border-top-right-radius: 0 !important;
            border-bottom-right-radius: 0 !important;
        }

        .btn-group>.btn:not(:first-child) {
            border-top-left-radius: 0 !important;
            border-bottom-left-radius: 0 !important;
        }

        .btn {
            padding: 12px 30px !important;
            margin: 5px 1px;
            font-size: 12px !important;
            box-shadow: 0 2px 2px 0 hsla(0, 0%, 60%, .14), 0 3px 1px -2px hsla(0, 0%, 60%, .2), 0 1px 5px 0 hsla(0, 0%, 60%, .12);
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


        .table {
            width: 100%;
            max-width: 100%;
            margin-bottom: 16px;
            background-color: transparent;
        }

        .table thead tr th {
            font-size: 17px;
            font-weight: 300;
        }

        .table>thead>tr>th {
            padding: 12px 8px;
            vertical-align: middle;
            border-color: #ddd;
            font-weight: 300;
        }

        .table>tbody>tr>td {
            padding: 12px 8px;
            vertical-align: middle;
            border-color: #ddd;
            font-weight: 300;
            font-size: 14px;
            color: #3c4858;
        }

        .table .td-actions .btn {
            margin: 0;
            padding: 5px;
        }

        .table .form-check {
            margin: 0;
            padding-left: 0;
        }

        .table .td-total {
            font-weight: 500;
            font-size: 17px;
            padding-top: 20px;
            text-align: right;
        }

        .table .td-price {
            font-size: 26px;
            font-weight: 300;
            margin-top: 5px;
            text-align: right;
        }

        .table-shopping>thead>tr>th {
            font-size: 14px;
            text-transform: uppercase;
            font-family: "Cabin", Sans-Serif;
            color: #555;
        }

        .table-shopping .td-name {
            min-width: 200px;
            font-weight: 400;
            font-size: 24px;
            line-height: 1.42857143;
        }

        .table-shopping .td-name small {
            color: #999;
            font-size: 18px;
            font-weight: 300;
        }

        .table-shopping .img-container {
            width: 120px;
            max-height: 160px;
            overflow: hidden;
            display: block;
        }

        .table-shopping .img-container img {
            width: 100%;
        }

        .table-shopping>tbody>tr>td {
            font-size: 14px;
        }

        .table-shopping .td-number {
            text-align: right;
            min-width: 150px;
            font-size: 18px;
        }

        .table-shopping .td-number small {
            margin-right: 3px;
        }

        .form-check {
            padding-left: 0;
        }

        .form-check .form-check-label {
            cursor: pointer;
            padding-left: 0px;
            position: relative;
            margin-bottom: 0;
        }

        .form-check .form-check-label span {
            display: block;
            left: -1px;
            top: -1px;
            transition-duration: .2s;
        }

        .form-check .form-check-input {
            opacity: 0;
            height: 0;
            width: 0;
            overflow: hidden;
            position: absolute;
            margin: 0;
            z-index: -1;
            left: 0;
            pointer-events: none;
        }

        .form-check .form-check-sign:before {
            display: block;
            position: absolute;
            left: 0;
            content: "";
            background-color: rgba(0, 0, 0, .84);
            height: 20px;
            width: 20px;
            border-radius: 100%;
            z-index: 1;
            opacity: 0;
            margin: 0;
            top: 0;
            transform: scale3d(2.3, 2.3, 1);
        }

        .form-check .form-check-sign .check {
            position: relative;
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 1px solid rgba(0, 0, 0, .54);
            overflow: hidden;
            z-index: 1;
            border-radius: 3px;
            top: 3px;
        }

        .form-check .form-check-sign .check:before {
            position: absolute;
            content: "";
            transform: rotate(45deg);
            display: block;
            margin-top: -3px;
            margin-left: 7px;
            width: 0;
            color: #fff;
            height: 0;
            box-shadow: 0 0 0 0, 0 0 0 0, 0 0 0 0, 0 0 0 0, 0 0 0 0, 0 0 0 0, inset 0 0 0 0;
            animation: checkbox-off .3s forwards;
        }

        .form-check .form-check-input:checked+.form-check-sign .check:before {
            color: #fff;
            box-shadow: 0 0 0 10px, 10px -10px 0 10px, 32px 0 0 20px, 0 32px 0 20px, -5px 5px 0 10px, 20px -12px 0 11px;
            animation: checkbox-on .3s forwards;
        }

        .form-check .form-check-input:checked+.form-check-sign .check {
            background: #dfa01e;
        }

        .table .form-check .form-check-sign {
            top: -13px;
            left: 0;
            padding-right: 0;
        }

        .table-striped>tbody>tr:nth-of-type(odd) {
            background-color: #f9f9f9 !important;
        }

        /*animation*/

        @keyframes checkbox-on {
            0% {
                box-shadow:
                    0 0 0 10px,
                    10px -10px 0 10px,
                    32px 0 0 20px,
                    0px 32px 0 20px,
                    -5px 5px 0 10px,
                    15px 2px 0 11px;
            }

            50% {
                box-shadow:
                    0 0 0 10px,
                    10px -10px 0 10px,
                    32px 0 0 20px,
                    0px 32px 0 20px,
                    -5px 5px 0 10px,
                    20px 2px 0 11px;
            }

            100% {
                box-shadow:
                    0 0 0 10px,
                    10px -10px 0 10px,
                    32px 0 0 20px,
                    0px 32px 0 20px,
                    -5px 5px 0 10px,
                    20px -12px 0 11px;
            }
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
				<li class="nav-item active"><a class="navbar-brand" href="#">
						<!-- <img src="./assets/logo.png" alt="" width="50%" class="d-inline-block align-top" /> -->
						<span class="text-center" style="color: #dfa01e">ONE STOP</span> <span
						class="text-center"> SHOP</span> <span class="sr-only">(current)</span>
				</a></li>
			</ul>
			<spring:form class="form-inline my-2 my-lg-0 " action="logout">
			<p class="mr-sm-2 form-icon">
				<span><i class="icon icon-user"></i>
				</span>&nbsp;
				Welcome,${user.getUname()}!&nbsp;
			</p>
				<button class="btn logout my-2 my-sm-0" type="submit">Logout</button>
			</spring:form>
		</div>
	</nav>
	<div class="container">
		<form  method="post">
			<div class="row h-100 justify-content-center align-items-center">
				<div class="col-lg-8 col-md-10 ml-auto mr-auto">
					<div class="col-sm text-center">
						<h3>Products in Stock</h3>
					</div>
					<hr>
					<div class="table-responsive">
					<table class="table table-shopping">
					<thead>
						<tr>
							<th></th>
							<th>Product Image</th>
							<th>Product Name</th>
							<th>Stock Quantity</th>
							<th>Price</th>
						</tr>
					</thead>
						
					<tbody>
					<c:forEach items="${items}" var="item">
							<tr>
							 <td class="text-center">
                                        <div class="form-check">
                                            <label class="form-check-label">
                                                <input class="form-check-input" type="checkbox" name="selected" value=<c:out value='${item.getItemNo()}' />>
                                                <span class="form-check-sign">
                                                    <span class="check"></span>
                                                </span>
                                            </label>
                                        </div>
                                    </td>
								<td>
                                     <div class="img-container">
                                          <img src=<c:out value='${item.getImgurl()}'/> alt="...">
                                      </div>
                                 </td>
                                <td class="text-right"><span>${item.getItemDesc()}</span></td> 
                                 
								<td class="text-right"><span>${item.getStockQuantity()}</span></td>
								
								<td class="text-right"><span>${item.getItemPrice()}</span></td>
								
								<td class="td-actions text-right">
                                        <button type="submit" rel="tooltip" class="btn btn-success btn-just-icon btn-sm"
                                            data-original-title="" title="" formaction="/itemcontrol/edit">
                                            <i class="material-icons">edit</i>
                                        </button>
                                        <button type="submit" rel="tooltip" class="btn btn-danger btn-just-icon btn-sm"
                                            data-original-title="" title="" formaction="/itemcontrol/deleteditem">
                                            <i class="material-icons">close</i>
                                        </button>
                                    </td>
							</tr>
						</c:forEach>
					</tbody>
						
					</table>
					<div class="col-sm w-25 mb-3 mt-3" style="margin: auto">
					<button type="submit"
						class="btn btn-block my-2 my-sm-0 main-button" formaction="/itemcontrol/add">Add Items</button>
				</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
        <script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js"
            integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U"
            crossorigin="anonymous"></script>
        <script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js"
            integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9"
            crossorigin="anonymous"></script>
</body>
</html>