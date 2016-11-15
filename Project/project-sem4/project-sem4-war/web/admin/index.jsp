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

        <jsp:useBean id = "ordersList" class="java.util.List" scope = "request">
        </jsp:useBean>
        <jsp:useBean id = "customerList" class="java.util.List" scope = "request">
        </jsp:useBean>
        <!-- New feed table -->
           <jsp:include page="include/header-top.jsp"></jsp:include>


            <div class="w3-row-padding w3-margin-bottom">
                <div class="w3-quarter w3-card-4">
                    <div class="w3-container w3-red w3-padding-16">
                        <div class="w3-left"><i class="fa fa-bell w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>${ordersCount}</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Order</h4>
                    </div>
                </div>
                <div class="w3-quarter w3-card-4">
                    <div class="w3-container w3-blue w3-padding-16">
                        <div class="w3-left"><i class="fa fa-bank w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>${wareHousesCount}</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Warehose</h4>
                    </div>
                </div>
                <div class="w3-quarter w3-card-4">
                    <div class="w3-container w3-teal w3-padding-16">
                        <div class="w3-left"><i class="fa fa-diamond w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>${productsCount}</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Product</h4>
                    </div>
                </div>
                <div class="w3-quarter w3-card-4">
                    <div class="w3-container w3-orange w3-text-white w3-padding-16">
                        <div class="w3-left"><i class="fa fa-users w3-xxxlarge"></i></div>
                        <div class="w3-right">
                            <h3>${usersCount}</h3>
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Customer</h4>
                    </div>
                </div>
            </div>
            <div class="w3-container w3-section">
                <div class="w3-row-padding">
                    <div class="chart-container">
                        <h5>Sales chart</h5>
                        <div id="chart_div" class="w3-card-4 w3-padding">loading...</div>
                    </div>
                </div>
            </div>
            <div class="w3-container">
                <div class="recent-user">
                    <h5>most recent customer</h5>
                    <ul class="w3-ul w3-white">
                        <c:forEach items="${customerList}" var="customer">
                            <li class="w3-padding-16">
                                <span class="w3-closebtn w3-padding w3-margin-right w3-medium">x</span>
                                <img src="images/img_avatar2.png" class="w3-left w3-circle w3-margin-right" style="width:35px">
                                <span class="w3-xlarge"><a href="Customers?action=details&id=${customer.CId}">${customer.customerName}</a></span><br>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="w3-container">
                <h5>5 most recent orders</h5>
                <div class="w3-responsive">
                    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
                        <thead>
                            <tr>
                                <th>Order ID</th>
                                <th>Customer ID</th>
                                <th>Address</th>
                                <th>Date</th>
                                <th>Price</th>
                                <th>Status</th>
                                <th>Note</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${ordersList}" var="order">
                                <tr>
                                    <td><a href="Orders?action=details&id=${order.OId}">${order.OId}</a></td>
                                    <td><a href="Customers?action=details&id=${order.CId.CId}">${order.CId.CId}</a></td>
                                    <td>${order.orderAddress}</td>
                                    <td>${order.orderDate}</td>
                                    <td>${order.ordersFee} vnđ</td>
                                    <td>${order.orderStatus}</td>
                                    <td>${order.orderNote}</td>
                                    <td><a class="w3-btn w3-ripple w3-blue" href="Orders?action=edit&id=${order.OId}">Edit</a></td>
                                    <td><a class="w3-btn w3-ripple w3-blue" href="Orders?action=delete&id=${order.OId}">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script src="js/chart.js"></script>
    </body>
</html>
