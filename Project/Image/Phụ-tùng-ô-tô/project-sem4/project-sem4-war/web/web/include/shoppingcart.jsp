<%-- 
    Document   : bannertop-box
    Created on : Nov 2, 2016, 11:31:22 PM
    Author     : VuNK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="cart_bg">
    <ul class="cart">
        <a href="ShoppingCart">
            <h4><i class="cart_icon"> </i><p>Cart: <span class="simpleCart_total"></span> (${sessionScope.CartCount} items)</p><div class="clearfix"> </div></h4>
        </a>
        <h5 class="empty"><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></h5>
        <div class="clearfix"> </div>
    </ul>
</div>
<ul class="quick_access">
    <li class="view_cart"><a href="ShoppingCart">View Cart</a></li>
    <li class="check"><a href="CheckOut">Checkout</a></li>
    <div class='clearfix'></div>
</ul>
<div class="search">
    <input type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {
                            this.value = 'Search';
                        }">
    <input type="submit" value="">
</div>
