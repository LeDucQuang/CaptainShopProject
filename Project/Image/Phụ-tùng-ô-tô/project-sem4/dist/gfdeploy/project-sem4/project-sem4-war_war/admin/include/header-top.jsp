<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- New feed table -->
<div class="nortification-table w3-card-4">
    <table class="w3-table w3-striped w3-white">
        <tr>
            <td><h5>Thông báo</h5></td>
        </tr>
        <tr>
            <td><i class="fa fa-user w3-blue w3-padding-tiny"></i></td>
            <td>Khách hàng tên khôi vừa đăng ký.</td>
        </tr>
        <tr>
            <td><i class="fa fa-user w3-blue w3-padding-tiny"></i></td>
            <td>Khách hàng tên quang vừa đăng ký.</td>
        </tr>
    </table>
</div>
<!-- New feed button -->
<div class="nortification-btn" id="nortification-btn">
    <a class="w3-btn w3-blue" href="#a"><i class="fa fa-comment fa-2"></i>(3)</a>
</div>

<!-- Top container -->
<div class="w3-container w3-top w3-black w3-large w3-padding top-container">
    <button class="w3-btn w3-hide-large w3-padding-0 w3-hover-text-grey" id="open_nav_btn"><i class="fa fa-bars"></i>  Menu</button>
    <span class="w3-right">Logo</span>
</div>

<!-- Sidenav/menu -->
<nav class="w3-sidenav w3-collapse w3-white w3-animate-left w3-card-4 side-nav" id="mySidenav"><br>
    <div class="w3-container w3-row">
        <div class="w3-col s4">
            <img src="images/img_avatar2.png" class="w3-circle w3-margin-right">
        </div>
        <div class="w3-col s8">
            <span>Xin Chào, <strong>Admin</strong></span><br>
            <a href="#" class="w3-hover-none w3-hover-text-red w3-show-inline-block"><i class="fa fa-envelope"></i></a>
            <a href="#" class="w3-hover-none w3-hover-text-green w3-show-inline-block"><i class="fa fa-user"></i></a>
            <a href="#" class="w3-hover-none w3-hover-text-blue w3-show-inline-block"><i class="fa fa-cog"></i></a>
        </div>
    </div>
    <hr>
    <div class="w3-container">
        <h5>Trang Quản Lý</h5>
    </div>
    <div class="nav-item">
        <a href="index.html" class="w3-padding"><i class="fa fa-eye fa-fw"></i> Trang chủ</a>
        <a href="Customers" class="w3-padding"><i class="fa fa-users fa-fw"></i> Khách hàng</a>
        <a href="Admin?action=index" class="w3-padding"><i class="fa fa-users fa-fw"></i> Admin</a>
        <a href="Products?action=index" class="w3-padding"><i class="fa fa-diamond fa-fw"></i> Hàng hóa</a>
        <a href="Orders" class="w3-padding"><i class="fa fa-bell fa-fw"></i> Order</a>
        <a href="Warehouses?action=index" class="w3-padding"><i class="fa fa-bank fa-fw"></i>  Kho</a>
    </div>
</nav>


<!-- Overlay effect when opening sidenav on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main page-content">

    <!-- Header -->
    <header class="w3-container header-main">
        <h5><b><i class="fa fa-dashboard"></i> Trang Quản Lý</b></h5>
    </header>
    
    <div class="w3-row-padding w3-margin-bottom">