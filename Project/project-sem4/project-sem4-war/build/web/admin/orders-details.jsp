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
        <title>Customer</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
        </head>
        <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
        <jsp:useBean id = "order" class="entity.Orders" scope = "request">
        </jsp:useBean>
        <div class="w3-container">
            <h3>Order Detail: ${order.OId}</h3>
            <p>Customer Detail:</p>
            <div class="w3-responsive">
                <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
                    <thead>
                        <tr>
                            <th>Customer ID</th>
                            <th>Name</th>
                            <th>Address</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Passport</th>
                            <th>Balance</th>
                            <th>Customer Type</th>
                            <th>Status</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                                <td><a href="Customers?action=details&id=${order.CId.CId}">${order.CId.CId}</a></td>
                                <td>${order.CId.customerName}</td>
                                <td>${order.CId.customerAddress}</td>
                                <td>${order.CId.phonenumber}</td>
                                <td>${order.CId.email}</td>
                                <td>${order.CId.passport}</td>
                                <td>${order.CId.balances} vnđ</td>
                                <c:choose>
                                    <c:when test="${ customer.rate < 1000 }">
                                        <td>Normal</td>
                                    </c:when>
                                    <c:when test="${ customer.rate >= 1000 && customer.rate < 2000 }">
                                        <td>Platinum</td>
                                    </c:when>
                                    <c:when test="${ customer.rate >= 2000 }">
                                        <td>Diamond</td>
                                    </c:when>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${ customer.status == 1 }">
                                        <td>available</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Disable</td>
                                    </c:otherwise>
                                </c:choose>
                                <td><a class="w3-btn w3-ripple w3-blue" href="Customers?action=edit&id=${order.CId.CId}">Edit</a></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${ customer.status == 1 }">
                                            <a class="w3-btn w3-ripple w3-blue" href="Customers?action=delete&id=${order.CId.CId}">Non-Active</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="w3-btn w3-ripple w3-blue" href="Customers?action=delete&id=${order.CId.CId}">Active</a>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                    </tbody>
                </table>
            </div>
            <p>Address: ${order.orderAddress}</p>
            <p>Date: ${order.orderDate}</p>
            <p>Status: ${order.orderStatus}</p>
            <p>Note: ${order.orderNote}</p>
            <p>List Order Product:</p>
            <div class="w3-responsive">
                <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
                    <thead>
                        <tr>
                            <th>Product ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${order.orderProductCollection}" var="orderProduct">
                            <tr>
                                <td>${orderProduct.PId.PId}</td>
                                <td>${orderProduct.PId.productName}</td>
                                <td>${orderProduct.PId.productPrice} vnđ</td>
                                <td>${orderProduct.quantity}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <p>Warehouse Detail:</p>
                <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
                    <thead>
                        <tr>
                            <th>Warehouse ID</th>
                            <th>Name</th>
                            <th>Address</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${order.WId.WId}</td>
                            <td>${order.WId.wareName}</td>
                            <td>${order.WId.wareAddress}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <h5>Total: ${order.ordersFee} vnđ</h5>
        </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
        <script>
            $(document).ready(function () {
                make_menu_active(5);
            });
        </script>
    </body>
</html>
