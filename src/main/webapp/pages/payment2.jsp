<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <!DOCTYPE html>
            <html>

            <head>
                <title>Payment</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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

        .payment-form {
            padding-bottom: 50px;
            font-family: 'Montserrat', sans-serif;
        }

        .payment-form.dark {
            background-color: #f6f6f6;
        }

        .payment-form .content {
            box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.075);
            background-color: white;
        }

        .payment-form .block-heading {
            padding-top: 50px;
            margin-bottom: 40px;
            text-align: center;
        }

        .payment-form .block-heading p {
            text-align: center;
            max-width: 420px;
            margin: auto;
            opacity: 0.7;
        }

        .payment-form.dark .block-heading p {
            opacity: 0.8;
        }

        .payment-form .block-heading h1,
        .payment-form .block-heading h2,
        .payment-form .block-heading h3 {
            margin-bottom: 1.2rem;
            color: #2D4A6B;
        }

        .payment-form {
            /* border-top: 2px solid #2D4A6B; */
            box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.075);
            background-color: #ffffff;
            padding: 0;
            max-width: 600px;
            margin: auto;
        }

        .payment-form .title {
            font-size: 1em;
            border-bottom: 1px solid rgba(0, 0, 0, 0.1);
            margin-bottom: 0.8em;
            font-weight: 600;
            padding-bottom: 8px;
        }

        .payment-form .products {
            background-color: #f7fbff;
            padding: 25px;
        }

        .payment-form .products .item {
            margin-bottom: 1em;
        }

        .payment-form .products .item-name {
            font-weight: 600;
            font-size: 0.9em;
        }

        .payment-form .products .item-description {
            font-size: 0.8em;
            opacity: 0.6;
        }

        .payment-form .products .item p {
            margin-bottom: 0.2em;
        }

        .payment-form .products .price {
            font-family: 'Signika', Sans-Serif;
            float: right;
            font-weight: 600;
            font-size: 0.9em;
        }

        .payment-form .products .total {
            font-family: 'Signika', Sans-Serif;
            border-top: 1px solid rgba(0, 0, 0, 0.1);
            margin-top: 10px;
            padding-top: 19px;
            font-weight: bold;
            line-height: 1;
        }

        .payment-form .products .subtotal {
            font-family: 'Signika', Sans-Serif;
            border-top: 1px solid rgba(0, 0, 0, 0.1);
            margin-top: 10px;
            padding-top: 19px;
            line-height: 1;
        }

        .payment-form .card-details {
            font-family: 'Signika', Sans-Serif;
            padding: 25px 25px 15px;
        }

        .payment-form .card-details label {
            font-family: 'Signika', Sans-Serif;
            font-size: 12px;
            font-weight: 400;
            margin-bottom: 15px;
            color: #79818a;
            text-transform: uppercase;
        }

        .payment-form .card-details button {
            font-family: 'Signika', Sans-Serif;
            margin-top: 0.6em;
            padding: 12px 0;
            /* font-weight: 400; */
        }

        .payment-form .date-separator {
            margin-left: 10px;
            margin-right: 10px;
            margin-top: 5px;
        }

        @media (min-width: 576px) {
            .payment-form .title {
                font-size: 1.2em;
            }

            .payment-form .products {
                padding: 40px;
            }

            .payment-form .products .item-name {
                font-size: 1em;
            }

            .payment-form .products .price {
                font-size: 1em;
            }

            .payment-form .card-details {
                padding: 40px 40px 30px;
            }

            .payment-form .card-details button {
                margin-top: 2em;
            }
        }

        .btn-close {
            background-color: #D0110F;
            width: 8.8rem;
            color: white;
        }

        .btn-close:hover {
            background-color: rgba(210, 18, 15, 0.9);
            color: white;
        }
    </style>
            </head>

            <body>
                <main class="page payment-page">
                    <section class="payment-form dark">
                        <div class="container">
                            <div class="block-heading">
                                <h1>Payment</h1>
                                <p>Complete your order.</p>
                            </div>
                            <!-- <form> -->
                            <div class="products">
                                <h3 class="title">Checkout</h3>
                                <c:forEach items="${items.keySet()}" var="item">
                                    <div class="item">
                                        <!-- <span class="price">${item.getItemPrice()}</span> -->
                                        <span class="price">
                                            <img src=<c:out value='${item.getImgurl()}' /> class="img-fluid" style="width: 55px; height: 55px;">
                                        </span>
                                        <p class="item-name">${item.getItemDesc()}</p>
                                        <p class="item-description">${item.getItemCategory()}</p>
                                    </div>
                                </c:forEach>
                                <hr>
                                <div class="subtotal">Subtotal<span class="price">Rs. ${total}</span></div>
                                <div class="subtotal">Discount<span class="price">Rs. 0</span></div>
                                <div class="subtotal">Shipping<span class="price">Rs. 0</span></div>
                                <div class="total">Total<span class="price">Rs. ${total}</span></div>
                            </div>
                            <div class="card-details">
                                <form action="redirectToServices" method="POST">
                                    <script src="https://checkout.razorpay.com/v1/checkout.js"
                                        data-key="rzp_test_uwFPahVNP7SemQ" data-amount="${amt}" data-currency="INR"
                                        data-order_id="${order_id}" data-buttontext="Pay with Razorpay"
                                        data-name="Acme Corp"
                                        data-description="A Wild Sheep Chase is the third novel by Japanese author Haruki Murakami"
                                        data-image="https://example.com/your_logo.jpg" data-prefill.name="Gaurav Kumar"
                                        data-prefill.email="gaurav.kumar@example.com"
                                        data-theme.color="#F37254"></script>
                                    <input type="hidden" class="btn btn-primary btn-block" custom="Hidden Element"
                                        name="hidden">
                                </form>
                                <!-- GO BACK TO CART -->
                                <spring:form modelAttribute="user" method="post">
                                    <div class="form-group col-sm-12 p-0">
                                        <a href="showCart" style="text-decoration: none;">
                                            <button type="button" class="btn btn-close btn-block p-1">Cancel</button>
                                        </a>
                                    </div>
                                </spring:form>
                            </div>
                        </div>
                        <!-- </form> -->
                        </div>
                    </section>
                </main>
            </body>
            <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
            </body>

            </html>