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

        .table-shopping .img-container {
            width: 120px;
            max-height: 160px;
            overflow: hidden;
            display: block;
        }

        /* Common CSS End */
    </style>
    <meta charset="ISO-8859-1">
    <title>Search Invoice</title>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light">
        <a class="navbar-brand brand-text" href="home"><span class="accent-color">One Stop</span>
            Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="home">Inventory <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/itemcontrol/add">Add Item</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/itemcontrol/modifybill">Edit Invoice</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" action="logout">
                <p class="mr-sm-2 nav-username pr-2">Hello, ${user.getUname()}</p>
                <button class="btn logout my-2 my-sm-0" type="submit">Logout</button>
            </form>
        </div>
    </nav>

    <div class="container">
        <form method="post">
            <div class="row mt-3 justify-content-center align-items-center">
                <div class="col-lg-10 col-md-10 ml-auto mr-auto">
                    <div class="col-sm text-center mt-2">
                        <h1><span class="accent-color">Edit</span> Invoice</h1>
                        <p class="accent-color">Enter invoice ID to edit or delete invoice.</p>
                    </div>
                    <hr>
                    <div class="table-responsive">
                        <spring:form modelAttribute="itemdet" method="post" action="/itemcontrol/getinvoice">
                            <div class="flex inline-block">
                                <div>
                                    <input name="id" type="text" style="width: fit-content; margin: 0; float: right;"
                                        class="form-control" placeholder="Invoice ID" required="required" />
                                    <button class="btn btn-block my-2 my-sm-0 float-right m-2 btn-main p-2"
                                        type="submit" style="width: fit-content;">
                                        <span><i class="icon icon-magnifier"></i></span>
                                    </button>
                                </div>
                            </div>
                        </spring:form>
                        <table class="table table-shopping">
                            <thead class="thead-dark">
                                <tr>
                                    <th></th>
                                    <th>Product Image</th>
                                    <th>Product Name</th>
                                    <th>Category</th>
                                    <th>Stock Quantity</th>
                                    <th>Price</th>
                                    <th></th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${itemtrancs}" var="itemtranc">
                                    <tr>
                                        <td class="text-center">
                                            <div class="form-check">
                                                <label class="form-check-label">
                                                    <input class="form-check-input" type="checkbox" name="selected"
                                                        value=<c:out value='${itemtranc.getTransactionID()}' />>
                                                    <span class="form-check-sign">
                                                        <span class="check"></span>
                                                    </span>
                                                </label>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="img-container">
                                                <img src=<c:out value='${itemtranc.getItemDetailsDTO().getImgurl()}' />
                                                style="width: 50%">
                                            </div>
                                        </td>
                                        <td class="text-left"><span>${itemtranc.getItemDetailsDTO().getItemDesc()}</span>
                                        </td>

                                        <td class="text-left">
                                            <span>${itemtranc.getItemDetailsDTO().getItemCategory()}</span>
                                        </td>

                                        <td class="text-left">
                                            <span>${itemtranc.getItemQuantity()}</span>
                                        </td>

                                        <td class="text-left"><span>${itemtranc.getItemDetailsDTO().getItemPrice()}</span>
                                        </td>

                                        <td class="td-actions text-left">
                                            <button type="submit" rel="tooltip"
                                                class="btn btn-success btn-just-icon btn-sm" data-original-title=""
                                                title="" formaction="/itemcontrol/modifybillitem">
                                                <i class="material-icons">edit</i>
                                            </button>
                                            <button type="submit" rel="tooltip"
                                                class="btn btn-danger btn-just-icon btn-sm" data-original-title=""
                                                title="" formaction="/itemcontrol/deletebilltem">
                                                <i class="material-icons">close</i>
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>

</html>