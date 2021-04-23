<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
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
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js"
        integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U"
        crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js"
        integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9"
        crossorigin="anonymous"></script>

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

        .btn-alt {
            font-size: 0.9rem;
            letter-spacing: 0.05rem;
            padding: 0.75rem 1rem;
            border-radius: .25rem;
            color: white;
            background-color: #1A2E35;
        }

        .btn-alt:hover {
            color: white;
            background-color: #395B65;
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

        .table-shopping .img-container {
            width: 120px;
            max-height: 160px;
            overflow: hidden;
            display: block;
        }

        /* Common CSS End */
    </style>
    <meta charset="ISO-8859-1">
    <title>Thank You</title>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light">
        <a class="navbar-brand brand-text" href="/manage/home"><span class="accent-color">One Stop</span>
            Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" action="logout">
                <p class="mr-sm-2 nav-username pr-2">Hello, ${user.getUname()}</p>
                <button class="btn logout my-2 my-sm-0" type="submit">Logout</button>
            </form>
        </div>
    </nav>

    <div class="login-form">
        <div class="col-sm text-center m-3">
            <h1>Thank you for shopping with us!</h1>
        </div>

        <div style="text-align: center;">
            <img src="https://image.freepik.com/free-vector/online-shopping-concept-illustration_114360-1084.jpg">
        </div>
        <div class="row">
            <div class="col-lg-3"></div>

            <div class="col-lg-3">
                <spring:form modelAttribute="user" method="get" action="excel">
                    <div class="form-group">
                        <button class="btn w-100 my-2 my-sm-0 m-2 btn-main" type="submit">Generate Invoice
                            Excel</button>
                    </div>
                </spring:form>
                <spring:form modelAttribute="user" method="get" action="email">
                    <div class="form-group">
                        <button class="btn w-100 my-2 my-sm-0 m-2 btn-alt" type="submit">Send Email</button>
                    </div>
                </spring:form>
            </div>

            <div class="col-lg-3">
                <spring:form modelAttribute="user" method="get" action="pdf">
                    <div class="form-group">
                        <button class="btn w-100 my-2 my-sm-0 m-2 btn-main" type="submit">Generate Invoice
                            PDF</button>
                    </div>
                </spring:form>
                <spring:form modelAttribute="user" method="get" action="sms">
                    <div class="form-group">
                        <button class="btn w-100 my-2 my-sm-0 m-2 btn-alt" type="submit">Send SMS</button>
                    </div>
                </spring:form>
            </div>

            <div class="col-lg-3"></div>
        </div>

    </div>

</body>

</html>