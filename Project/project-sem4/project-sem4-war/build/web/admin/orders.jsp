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
        <title>Orders</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
    </head>
    <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
        <jsp:useBean id = "ordersList" class="java.util.List" scope = "request">
        </jsp:useBean>
        <div class="w3-container">
            <h3>Total Order: ${ordersQuantity} </h3>
            <h5>${ordersList.size()} First Order</h5>
            <p>
                <input class="w3-input filter-input w3-border w3-padding" type="text" placeholder="Input data to search...." data-filter="filter-table" />
            </p>
            <div class="w3-responsive">
                <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white" id="filter-table">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Customer ID</th>
                            <th>Address</th>
                            <th>Date</th>
                            <th>Total</th>
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
                                <td>${order.orderDateAsString}</td>
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
        <script>
            $(document).ready(function () {
                make_menu_active(5);
            });
        </script>
    </body>
</html>
