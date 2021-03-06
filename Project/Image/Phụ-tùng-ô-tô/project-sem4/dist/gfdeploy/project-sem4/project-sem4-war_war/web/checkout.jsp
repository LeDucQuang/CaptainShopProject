<%-- 
    Document   : checkout
    Created on : Nov 1, 2016, 12:15:18 PM
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
        <title>Shape an E-Commerce online Shopping Category Flat Bootstarp responsive Website Template| Checkout :: w3layouts</title>
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
                <div class="container">
                    <div class="check_box">	 
                        <div class="col-md-9 cart-items">

                            <h1>My Shopping Bag (${listCartProduct.size()})</h1>
                        <script>$(document).ready(function (c) {
                                $('.close1').on('click', function (c) {
                                    $('.cart-header').fadeOut('slow', function (c) {
                                        $('.cart-header').remove();
                                    });
                                });
                            });
                        </script>
                        <c:forEach items="${listShoppingCartItem}" var="i">
                            <div class="cart-header">
                                <a href="ShoppingCart?action=delete&proId=${i.PId.PId}" class="close1"> </a>
                                <div class="cart-sec simpleCart_shelfItem">
                                    <div class="cart-item cyc">
                                        <img src="${i.PId.imageLink}" class="img-responsive" alt="">
                                    </div>
                                    <div class="cart-item-info">
                                        <h3><a href="ProductDetails"><c:out value="${i.PId.productName}"/></a><span>${i.PId.PId}</span></h3>
                                        <ul class="qty">
                                            <li><p>Quantity : <c:out value="${i.quantity}"/></p></li>
                                        </ul>
                                        <div class="delivery">
                                            <p>Price: <c:out value="${i.PId.productPrice}"/> </p>
                                            <span>Delivered in 2-3 bussiness days</span>
                                            <div class="clearfix"></div>
                                        </div>	
                                    </div>
                                    <div class="clearfix"></div>

                                </div>
                            </div>
                        </c:forEach>
                        <script>$(document).ready(function (c) {
                                $('.close2').on('click', function (c) {
                                    $('.cart-header2').fadeOut('slow', function (c) {
                                        $('.cart-header2').remove();
                                    });
                                });
                            });
                        </script>

                    </div>

                    <div class="col-md-3 cart-total">
                        <a class="continue" href="Home?action=index">Back To Home</a>
                        <div class="price-details">
                            <h3>Price Details</h3>
                            <span>Total</span>
                            <span class="total1">${Total}</span>				 
                        </div>

                        <div class="clearfix"></div>
                        <a class="order" href="CheckOut">Place Order</a>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="brands">
                <ul class="brand_icons">
                    <li><img src='images/icon1.jpg' class="img-responsive" alt=""/></li>
                    <li><img src='images/icon2.jpg' class="img-responsive" alt=""/></li>
                    <li><img src='images/icon3.jpg' class="img-responsive" alt=""/></li>
                    <li><img src='images/icon4.jpg' class="img-responsive" alt=""/></li>
                    <li><img src='images/icon5.jpg' class="img-responsive" alt=""/></li>
                    <li><img src='images/icon6.jpg' class="img-responsive" alt=""/></li>
                    <li class="last"><img src='images/icon7.jpg' class="img-responsive" alt=""/></li>
                </ul>
            </div>
        </div>
        <div class="container">
            <div class="instagram_top">
                <div class="instagram text-center">
                    <h3><i class="insta_icon"> </i> Instagram feed:&nbsp;<span class="small">#Surfhouse</span></h3>
                </div>
                <ul class="instagram_grid">
                    <li><a class="popup-with-zoom-anim" href="#small-dialog1"><img src="images/i1.jpg" class="img-responsive"alt=""/></a></li>
                    <li><a class="popup-with-zoom-anim" href="#small-dialog1"><img src="images/i2.jpg" class="img-responsive" alt=""/></a></li>
                    <li><a class="popup-with-zoom-anim" href="#small-dialog1"><img src="images/i3.jpg" class="img-responsive" alt=""/></a></li>
                    <li><a class="popup-with-zoom-anim" href="#small-dialog1"><img src="images/i4.jpg" class="img-responsive" alt=""/></a></li>
                    <li><a class="popup-with-zoom-anim" href="#small-dialog1"><img src="images/i5.jpg" class="img-responsive" alt=""/></a></li>
                    <li class="last_instagram"><a class="popup-with-zoom-anim" href="#small-dialog1"><img src="images/i6.jpg" class="img-responsive" alt=""/></a></li>
                    <div class="clearfix"></div>
                    <div id="small-dialog1" class="mfp-hide">
                        <div class="pop_up">
                            <h4>A Sample Photo Stream</h4>
                            <img src="images/i_zoom.jpg" class="img-responsive" alt=""/>
                        </div>
                    </div>
                </ul>
            </div>
            <ul class="footer_social">
                <li><a href="#"> <i class="fb"> </i> </a></li>
                <li><a href="#"><i class="tw"> </i> </a></li>
                <li><a href="#"><i class="pin"> </i> </a></li>
                <div class="clearfix"></div>
            </ul>
        </div>
        <jsp:include page="include/footer.jsp"></jsp:include>


    </body>
</html>		
