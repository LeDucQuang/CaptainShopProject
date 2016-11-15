<%-- 
    Document   : productdetail
    Created on : Nov 3, 2016, 12:14:02 AM
    Author     : VuNK
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Shape an E-Commerce online Shopping Category Flat Bootstarp responsive Website Template| Home :: w3layouts</title>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel='stylesheet' type='text/css' />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Shape Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
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
        <link href="css/khoi.css" rel='stylesheet' type='text/css' />
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
                                <div class="side_banner">
                                    <div class="banner_img"><img src="images/pic9.jpg" class="img-responsive" alt=""/></div>
                                    <div class="banner_holder">
                                        <h3>Now <br> is <br> Open!</h3>
                                    </div>
                                </div>

                            <jsp:useBean id = "productDetails" class="entity.Product" scope = "request"></jsp:useBean>
                            </div>
                            <div class="col-md-9 khoi-product-container">
                                <h3 class="m_1">Product Details</h3>
                                <div class="content_grid">
                                    <div class="col-md-9">
                                        <div class="singel_right">
                                            <div class="labout span_1_of_a1">
                                                <div class="flexslider">
                                                    <ul class="slides">
                                                        <li>
                                                            <img src="${productDetails.imageLink}" style="width: 100%"/>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <!--                                        Product o day nhe                    -->
                                        <div class="cont1 span_2_of_a1 simpleCart_shelfItem">
                                            <h1>${productDetails.productName}</h1>
                                            <ul class="rating">
                                                <li><a class="product-rate" href="#"> <label> </label></a> <span> </span></li>
                                                <li><a href="#">1 Review(s) Add Review</a></li>
                                                <div class="clearfix"></div>
                                            </ul>
                                            <div class="price_single">
                                                <span class="amount item_price actual">${productDetails.productPrice}</span>
                                            </div>
                                            <h2 class="quick">Quick Overview:</h2>
                                            <p class="quick_desc">product info...</p>

                                            <form action="AddToCart?proId=${productDetails.PId}" method="post">
                                                <!--<input type="hidden" name="proId" value="${productDetails.PId}" />-->
                                                <ul class="product-qty">
                                                    <span>Quantity:</span>
                                                    <input type="text" name="productQuantity" />
                                                </ul>
                                                <div class="">
                                                    <input type="submit" value="Add to Cart" title="" class="btn_form button item_add item_1">
                                                </div>
                                            </form>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                    <script type="text/javascript">
            $(window).load(function () {
                $("#flexiselDemo3").flexisel({
                    visibleItems: 3,
                    animationSpeed: 1000,
                    autoPlay: true,
                    autoPlaySpeed: 3000,
                    pauseOnHover: true,
                    enableResponsiveBreakpoints: true,
                    responsiveBreakpoints: {
                        portrait: {
                            changePoint: 480,
                            visibleItems: 1
                        },
                        landscape: {
                            changePoint: 640,
                            visibleItems: 2
                        },
                        tablet: {
                            changePoint: 768,
                            visibleItems: 3
                        }
                    }
                });

            });
                                    </script>
                                    <script type="text/javascript" src="js/jquery.flexisel.js"></script>

                                </div>                          
                                <div class="clearfix"></div>
                            </div>                                                        
                        </div>
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
        </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
    </body>
</html>	
