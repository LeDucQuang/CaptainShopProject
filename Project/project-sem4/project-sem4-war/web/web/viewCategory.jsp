<%-- 
    Document   : product
    Created on : Nov 3, 2016, 12:13:52 AM
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

                                <!--                                <div class="category">
                                                                    <h3 class="menu_head">Category Options</h3>
                            <c:forEach items="${listCategory}" var="cate">
                                <ul class="category_nav">
                                    <li><a href="#">${cate.categoryName}</a></li>
                                </ul>                                   
                            </c:forEach>                                    
                            </div>-->
                        </div>
                        <div class="col-md-9 khoi-product-container">
                            <h3 class="m_1">Products</h3>
                            <div class="content_grid">
                                <c:forEach items="${listProduct}" var="prod">
                                    <div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem"> 
                                        <a href="ProductDetails?proId=${prod.PId}">
                                            <div class="inner_content clearfix">
                                                <div class="product_image">
                                                    <img src="${prod.imageLink}" class="img-responsive" alt=""/>
                                                    <a href="AddToCart?proId=${prod.PId}&page=Product" class="button item_add item_1"> </a>	
                                                    <div class="product_container">
                                                        <div class="cart-left">
                                                            <p class="title">${prod.productName}</p>
                                                        </div>
                                                        <span class="amount item_price">${prod.productPrice}</span>
                                                        <div class="clearfix"></div>
                                                    </div>		
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                </c:forEach>                                
                                <div class="clearfix"></div>
                            </div>                                                        
                        </div>
                    </div>
                </div>
            </div>
           
        </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
    </body>
</html>	

