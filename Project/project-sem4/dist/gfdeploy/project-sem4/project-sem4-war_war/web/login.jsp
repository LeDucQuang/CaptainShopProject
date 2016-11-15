<%-- 
    Document   : login
    Created on : Nov 1, 2016, 12:18:23 PM
    Author     : Cgc_Shyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
    <head>
        <title>Shape an E-Commerce online Shopping Category Flat Bootstarp responsive Website Template| Login :: w3layouts</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Shape Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
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
        <!----details-product-slider--->
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
                                <div class="dreamcrub">
                                    <ul class="breadcrumbs">
                                        <li class="home">
                                            <a href="index.html" title="Go to Home Page">Home</a>&nbsp;
                                            <span>&gt;</span>
                                        </li>
                                        <li class="home">&nbsp;
                                            &nbsp;Account
                                            <span>&gt;</span>&nbsp;
                                        </li>
                                        <li class="women">
                                            Login
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="account_grid">
                                    <div class="col-md-6 login-left">
                                        <h3>NEW CUSTOMERS</h3>
                                        <p>By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more.</p>
                                        <a class="acount-btn" href="Home?action=register">Create an Account</a>
                                    </div>
                                    <div class="col-md-6 login-right">
                                        <h3>REGISTERED CUSTOMERS</h3>
                                        <p>If you have an account with us, please log in.</p>
                                        <form action="Home?action=checkLogin" method="POST">
                                            <div>
                                                <span>Email Address<label>*</label></span>
                                                <input type="text" name="email"> 
                                            </div>
                                            <div>
                                                <span>Password<label>*</label></span>
                                                <input type="password" name="password"> 
                                            </div>
                                            <a class="forgot" href="ForgotPassword">Forgot Your Password?</a>
                                            <br>
                                            <input type="submit" value="Login">
                                        </form>
                                    </div>	
                                    <div class="clearfix"> </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        <jsp:include page="include/footer.jsp"></jsp:include>

    </body>
</html>		