<%-- 
    Document   : single
    Created on : Nov 10, 2016, 12:14:44 AM
    Author     : Cgc_Shyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
    <head>
        <title>Shape an E-Commerce online Shopping Category Flat Bootstarp responsive Website Template| Single :: w3layouts</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Shape Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/simpleCart.min.js"></script>
        <script src="js/jquery.min.js"></script>
        <!-- Custom Theme files -->
        <link href="css/style.css" rel='stylesheet' type='text/css' />
        <!-- Custom Theme files -->
        <!--webfont-->
        <link href='http://fonts.googleapis.com/css?family=Raleway:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet' type='text/css'>
        <script src="js/jquery.easydropdown.js"></script>
        <!-- Add fancyBox main JS and CSS files -->
        <script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
        <link href="css/magnific-popup.css" rel="stylesheet" type="text/css">
        <link href="css/khoi.css" rel="stylesheet" type="text/css">
        <script>
            $(document).ready(function () {
                $('.popup-with-zoom-anim').magnificPopup({
                    type: 'inline',
                    fixedContentPos: false,
                    fixedBgPos: true,
                    overflowY: 'auto',
                    closeBtnInside: true,
                    preloader: false,
                    midClick: true,
                    removalDelay: 300,
                    mainClass: 'my-mfp-zoom-in'
                });
            });
        </script>
        <script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#horizontalTab').easyResponsiveTabs({
                    type: 'default', //Types: default, vertical, accordion           
                    width: 'auto', //auto or any width like 600px
                    fit: true   // 100% fit in a container
                });
            });
        </script>	
        <style>
            .khoi-user-profile-container {
                padding-top: 50px;
            }

            .khoi-user-profile-container h1 {
                color: #333;
                text-transform: uppercase;
                font-size: 1.7em;
                font-weight: 400;
                font-family: 'Audiowide', cursive;
                text-align: center;
            }

            .khoi-user-profile-container ul li {
                list-style: none;
                padding: 10px 0;
            }

            .khoi-user-profile-container h3 {
                text-align: center;font-weight: 400;
                font-family: 'Audiowide', cursive;
                text-align: center;
                color: #333;
                text-transform: uppercase;
            }

            .khoi-user-profile-container td, .khoi-user-profile-container th {
                background: #7901FB;
                color: #fff;
                font-size: 0.85em;
                text-transform: uppercase;
                font-weight: 400;
                font-family: 'Audiowide', cursive;
            }

        </style>
        <script src="js/khoiJs.js" type="text/javascript"></script>

    </head>
    <body>
        <div class="khoi-fixed-banner bannertop_box">
            <jsp:include page="include/shoppingcart.jsp"></jsp:include>
            </div>
            <div class="khoi-cart-btn"> 
                <i class="fa fa-arrow-right fa-2x" aria-hidden="true"></i>
            </div>
        <jsp:include page="include/header.jsp"></jsp:include>
            <div class="main">
                <div class="content_box">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-3">
                            <jsp:include page="include/menutab.jsp"></jsp:include>
                            </div>
                            <div class="col-md-9"> 
                            <jsp:useBean id = "customer" class="entity.Customer" scope = "request"></jsp:useBean>
                                <div class="khoi-user-profile-container">
                                    <h1>User profile for: ${customer.customerName}</h1>
                                <ul class="khoi-tab">
                                    <p>Customer Name: ${customer.customerName}<p>
                                    <p>Phone: ${customer.phonenumber}</p>
                                    <p>Address: ${customer.customerAddress}</p>
                                    <p>Email: ${customer.email}</p>
                                    <p>Customer Types:
                                    <c:choose>
                                        <c:when test="${ customer.rate < 1000 }">
                                            Normal
                                        </c:when>
                                        <c:when test="${ customer.rate >= 1000 && customer.rate < 2000 }">
                                            Platinum
                                        </c:when>
                                        <c:when test="${ customer.rate >= 2000 }">
                                            Diamond
                                        </c:when>
                                    </c:choose>
                                    </p>
                                    <li>
                                        <h3>5 MOST RECENT ORDERS</h3>
                                        <table class="table table-striped table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Order Codes</th>
                                                    <th>Address</th>
                                                    <th>Date</th>
                                                    <th>Price</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${customer.ordersCollection}" var="order">
                                                <tr>
                                                    <td>${order.OId}</a></td>
                                                    <td>${order.orderAddress}</td>
                                                    <td>${order.orderDateAsString}</td>
                                                    <td>${order.orderStatus}</td>                                                  
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <jsp:include page="include/footer.jsp"></jsp:include>

                <!-- FlexSlider -->
                <script defer src="js/jquery.flexslider.js"></script>
                <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

                <script>
            // Can also be used with $(document).ready()
            $(window).load(function () {
                $('.flexslider').flexslider({
                    animation: "slide",
                    controlNav: "thumbnails"
                });
            });
                </script>

                </body>
                </html>				
