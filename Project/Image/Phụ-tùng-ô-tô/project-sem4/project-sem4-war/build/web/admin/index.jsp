<%-- 
    Document   : customer
    Created on : Oct 15, 2016, 12:54:22 AM
    Author     : Khoi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin title</title>
        <link rel="stylesheet" href="css/w3.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css" />
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
    </head>
    <body class="w3-light-grey">

        <!-- New feed table -->
        <div class="nortification-table">
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
                    <span>Xin Chào, <strong>Khôi</strong></span><br>
                    <a href="#" class="w3-hover-none w3-hover-text-red w3-show-inline-block"><i class="fa fa-envelope"></i></a>
                    <a href="#" class="w3-hover-none w3-hover-text-green w3-show-inline-block"><i class="fa fa-user"></i></a>
                    <a href="#" class="w3-hover-none w3-hover-text-blue w3-show-inline-block"><i class="fa fa-cog"></i></a>
                </div>
            </div>
            <hr>
            <div class="w3-container">
                <h5>Trang Quản Lý</h5>
            </div>
            <a href="index.html" class="w3-padding w3-blue"><i class="fa fa-eye fa-fw"></i> Trang chủ</a>
            <a href="customers.html" class="w3-padding"><i class="fa fa-users fa-fw"></i> Khách hàng</a>
            <a href="users.html" class="w3-padding"><i class="fa fa-users fa-fw"></i> Admin</a>
            <a href="products.html" class="w3-padding"><i class="fa fa-diamond fa-fw"></i> Hàng hóa</a>
            <a href="orders.html" class="w3-padding"><i class="fa fa-bell fa-fw"></i> Order</a>
            <a href="warehouses.html" class="w3-padding"><i class="fa fa-bank fa-fw"></i>  Kho</a>
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
                <div class="w3-quarter w3-card-4">
                    <div class="w3-container w3-red w3-padding-16">
                        <div class="w3-left"><i class="fa fa-bell w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>52</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Order</h4>
                    </div>
                </div>
                <div class="w3-quarter w3-card-4">
                    <div class="w3-container w3-blue w3-padding-16">
                        <div class="w3-left"><i class="fa fa-bank w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>99</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Kho</h4>
                    </div>
                </div>
                <div class="w3-quarter w3-card-4">
                    <div class="w3-container w3-teal w3-padding-16">
                        <div class="w3-left"><i class="fa fa-diamond w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>23</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Hàng Hóa</h4>
                    </div>
                </div>
                <div class="w3-quarter w3-card-4">
                    <div class="w3-container w3-orange w3-text-white w3-padding-16">
                        <div class="w3-left"><i class="fa fa-users w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>50</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Người dùng</h4>
                    </div>
                </div>
            </div>
            <div class="w3-container w3-section">
                <div class="w3-row-padding">
                    <div class="chart-container">
                        <h5>Biểu đồ doanh số bán hàng</h5>
                        <div id="chart_div" class="w3-card-4 w3-padding">loading...</div>
                    </div>
                </div>
            </div>
            <div class="w3-container">
                <div class="recent-user">
                    <h5>Người dùng hoạt động gần đây</h5>
                    <ul class="w3-ul w3-white">
                        <li class="w3-padding-16">
                            <span class="w3-closebtn w3-padding w3-margin-right w3-medium">x</span>
                            <img src="images/img_avatar2.png" class="w3-left w3-circle w3-margin-right" style="width:35px">
                            <span class="w3-xlarge">Khôi</span><br>
                        </li>
                        <li class="w3-padding-16">
                            <span class="w3-closebtn w3-padding w3-margin-right w3-medium">x</span>
                            <img src="images/img_avatar5.png" class="w3-left w3-circle w3-margin-right" style="width:35px">
                            <span class="w3-xlarge">Quang</span><br>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="w3-container">
                <h5>5 Đơn hàng gần đây nhất</h5>
                <div class="w3-responsive">
                    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
                        <thead>
                            <tr>
                                <th>Mã đơn hàng</th>
                                <th>Mã khách hàng</th>
                                <th>Địa chỉ</th>
                                <th>Ngày tạo</th>
                                <th>Giá trị đơn hàng</th>
                                <th>Trạng thái</th>
                                <th>Ghi chú</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>ĐH1</td>
                                <td>KH1</td>
                                <td>Quan Hoa Cầu Giấy</td>
                                <td>20/09/2016</td>
                                <td>100.000 vnđ</td>
                                <td>Hoàn Thành</td>
                                <td>Trống</td>
                            </tr>
                            <tr>
                                <td>ĐH1</td>
                                <td>KH1</td>
                                <td>Quan Hoa Cầu Giấy</td>
                                <td>20/09/2016</td>
                                <td>100.000 vnđ</td>
                                <td>Hoàn Thành</td>
                                <td>Trống</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- Footer -->
            <footer class="w3-container w3-padding-16 w3-light-grey">
                2015 - 2016 Copyright Eshoper
            </footer>

            <!-- End page content -->
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript" src="js/chart.js"></script>
        <script src="js/myjs.js"></script>
    </body>
</html>
