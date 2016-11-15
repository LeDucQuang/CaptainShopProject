<%-- 
    Document   : checkout
    Created on : Nov 1, 2016, 12:15:18 PM
    Author     : Cgc_Shyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                    <div class="check_box" id="do_action">	 
                        <div class="row">
                            <div class="col-md-6">
                                <div class="chose_area">
                                    <ul class="user_info">
                                        <form action="CheckOut">
                                            <input type="hidden" name="action" value="checkPlace"/>
                                        <li class="single_field">
                                            <label>Address: </label>
                                            <input type="text" name="address">
                                            <div class="clearfix"></div>
                                        </li>
                                        <li class="single_field">
                                            <label>Warehouse / State:</label>
                                            <select name="wareid">
                                                <c:forEach items="${wareList}" var="i">
                                                    <option value="${i.WId}"><c:out value="Name: ${i.wareName }  | Address: ${i.wareAddress }"/></option>
                                                </c:forEach>
                                            </select>
                                            <div class="clearfix"></div>
                                        </li>
                                    </ul>
                                    <input type="submit" class="order col-md-6 col-md-push-3" href="CheckOut" value="place order"/>
                                    </form>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="total_area">
                                    <ul>
                                        <li>Cart Sub Total: <span>${Total} vnd</span></li>
                                        <li>Eco Tax: <span>$2</span></li>
                                        <li>Shipping Cost: <span>Free</span></li>
                                        <li>Total: <span>${Total} vnd</span></li>
                                    </ul>
                                </div>
                            </div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>


    <jsp:include page="include/footer.jsp"></jsp:include>


</body>
</html>		
