<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="ISO-8859-1">
                <title>Shopping Cart</title>
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
                <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
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

                    .shopping-cart {
                        padding-bottom: 50px;
                        font-family: 'Signika', sans-serif;
                    }

                    .shopping-cart .content {
                        box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.075);
                        background-color: white;
                    }

                    .shopping-cart .block-heading {
                        padding-top: 50px;
                        margin-bottom: 40px;
                        text-align: center;
                    }

                    .shopping-cart .block-heading p {
                        text-align: center;
                        max-width: 420px;
                        margin: auto;
                        opacity: 0.7;
                    }

                    .shopping-cart .dark .block-heading p {
                        opacity: 0.8;
                    }

                    .shopping-cart .items {
                        margin: auto;
                    }

                    .shopping-cart .items .product {
                        margin-bottom: 20px;
                        padding: 3rem;
                    }

                    .shopping-cart .items .product .info {
                        /* padding-top: 0px; */
                        text-align: center;
                    }

                    .shopping-cart .items .product .info .product-name {
                        font-weight: 600;
                    }

                    .shopping-cart .items .product .info .product-name .product-info {
                        font-size: 14px;
                        margin-top: 15px;
                    }

                    .shopping-cart .items .product .info .product-name .product-info .value {
                        font-weight: 400;
                    }

                    .shopping-cart .items .product .info .quantity .quantity-input {
                        margin: auto;
                        width: 80px;
                    }

                    .shopping-cart .items .product .info .price {
                        margin-top: 15px;
                        /* font-weight: bold; */
                        font-size: 20px;
                    }

                    .shopping-cart .summary {
                        border-top: 2px solid #2D4A6B;
                        background-color: #f7fbff;
                        height: 100%;
                        padding: 30px;
                    }

                    .shopping-cart .summary h3 {
                        font-family: 'Signika', sans-serif;
                        text-align: center;
                        font-size: 1.3em;
                        font-weight: 600;
                        padding-top: 20px;
                        padding-bottom: 20px;
                    }

                    .shopping-cart .summary .summary-item:not(:last-of-type) {
                        padding-bottom: 10px;
                        padding-top: 10px;
                        border-bottom: 1px solid rgba(0, 0, 0, 0.1);
                    }

                    .shopping-cart .summary .text {
                        font-family: 'Signika', sans-serif;
                        font-size: 1em;
                        font-weight: bold;
                    }

                    .shopping-cart .summary .price {
                        font-family: 'Signika', sans-serif;
                        font-size: 1em;
                        float: right;
                    }

                    .shopping-cart .summary button {
                        font-family: 'Signika', sans-serif;
                        margin-top: 20px;
                    }

                    /* Add and edit buttons */

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

                    .btn .material-icons {
                        position: relative;
                        display: inline-block;
                        top: 0;
                        margin-top: -1.2em;
                        margin-bottom: -1em;
                        font-size: 1.1rem;
                        vertical-align: middle;
                    }

                    .btn-close {
                        background-color: #D0110F;
                        color: white;
                    }

                    .btn-close:hover {
                        background-color: rgba(210, 18, 15, 0.9);
                        color: white;
                    }

                    @media (min-width: 768px) {
                        .shopping-cart .items .product .info {
                            /* padding: 25px; */
                            text-align: left;
                        }

                        .shopping-cart .items .product .info .price {
                            /* font-weight: bold; */
                            font-size: 20px;
                            top: 17px;
                        }

                        .shopping-cart .items .product .info .quantity {
                            text-align: center;
                        }

                        .shopping-cart .items .product .info .quantity .quantity-input {
                            padding: 4px 10px;
                            text-align: center;
                        }
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
                                <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="shopping1">Grocery Shop</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="shopping2">Apparel Shop</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="shopping3">Jewellery Shop <span
                                        class="sr-only">(current)</span></a>
                            </li>
                        </ul>
                        <form class="form-inline my-2 my-lg-0" action="logout">
                            <p class="mr-sm-2 nav-username pr-2">Hello, ${user.getUname()}!</p>
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
                <section class="shopping-cart dark">
                    <div class="container">
                        <div class="block-heading">
                            <h1><span class="accent-color">Shopping </span>Cart</h1>
                        </div>
                        <div class="content">
                            <div class="row">
                                <div class="col-md-12 col-lg-8">
                                    <div class="items">
                                        <div class="product">
                                            <c:forEach items="${items.keySet()}" var="item">
                                                <div class="row mb-2">
                                                    <div class="col-md-4 p-2">
                                                        <img src=<c:out value='${item.getImgurl()}' />
                                                        class="img-fluid"
                                                        style="width: 50%">
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="info">
                                                            <div class="product-name">
                                                                <span class="product-title">${item.getItemDesc()}</span>
                                                                <div class="product-info">
                                                                    <div>Category: <span
                                                                            class="value">${item.getItemCategory()}</span>
                                                                    </div>
                                                                    <div>Item Unit: <span
                                                                            class="value">${item.getItemUnit()}</span>
                                                                    </div>
                                                                    <div>Quantity: <span
                                                                            class="value">${items.get(item)}</span>
                                                                    </div>
                                                                    <div style="color: #D0110F;">Price: <span
                                                                            class="value">Rs.
                                                                            ${item.getItemPrice()}</span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2 text-left">
                                                        <form method="post">
                                                            <input type="checkbox" name="selected" value=<c:out
                                                                value='${item.getItemNo()}' />>
                                                            <button type="submit" rel="tooltip"
                                                                class="btn btn-close btn-just-icon btn-sm"
                                                                data-original-title="" title="" formaction="remove">
                                                                <!-- <input type="checkbox" name="selected" style="display: none" value=<c:out
                                                            value='${item.getItemNo()}' />> -->
                                                                <i class="material-icons">close</i>
                                                            </button>
                                                        </form>
                                                    </div>
                                                </div>
                                                <hr style="color: #D0110F;">
                                            </c:forEach>
                                        </div>
                                    </div>

                                </div>
                                <div class="col-md-12 col-lg-4">
                                    <div class="summary">
                                        <h3>Summary</h3>
                                        <div class="summary-item"><span class="text">Subtotal</span><span
                                                class="price">Rs.${total}</span>
                                        </div>
                                        <div class="summary-item"><span class="text">Discount</span><span
                                                class="price">Rs. 0</span>
                                        </div>
                                        <div class="summary-item"><span class="text">Shipping</span><span
                                                class="price">Rs. 0
                                            </span>
                                        </div>
                                        <div class="summary-item"><span class="text">Total</span><span class="price">Rs.
                                                ${total}</span>
                                        </div>
                                        <div class="form-group mt-3">
                                            <!-- <button type="submit" class="btn btn-block mt-4 main-button"><a href="confirmorder">Checkout</a></button> -->
                                            <form:form action="order" method="post" modelAttribute="orderDetails">
                                                <form:input path="amount" type="hidden" value="${total}" />
                                                <form:button class="btn btn-block my-2 my-sm-0 btn-main text-uppercase">
                                                    Checkout</form:button>
                                            </form:form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </section>
                <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
            </body>

            </html>