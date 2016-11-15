<%-- 
    Document   : customers-details
    Created on : Oct 15, 2016, 7:25:59 AM
    Author     : Khoi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Detail</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
        </head>
        <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
        <jsp:useBean id = "customer" class="entity.Customer" scope = "request"></jsp:useBean>
                <div class="w3-container">
                    <h3>Customer Info: ${customer.CId}</h3>
                <p>Customer Name: ${customer.customerName}<p>
                <p>Phone: ${customer.phonenumber}</p>
                <p>Address: ${customer.customerAddress}</p>
                <p>Email: ${customer.email}</p>
                <p>Passport: ${customer.passport}</p>
                <p>Balances: ${customer.balances}</p>
                <p>Customer Types:
                    <c:choose>
                        <c:when test="${ customer.rate < 1000 }">
                            Normal
                        </c:when>
                        <c:when test="${ customer.rate >= 1000 && customer.rate < 2000 }">
                            Platinum
                        </c:when>
                        <c:when test="${ customer.rate >= 2000 }">
                            Diamond
                        </c:when>
                    </c:choose>
                </p>
                <p>Order List:</p>
                <p>
                    <input class="w3-input filter-input w3-border w3-padding" type="text" placeholder="Input data to search..." data-filter="filter-table" />
                </p>
                <div class="w3-responsive">
                    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white" id="filter-table">
                        <thead>
                            <tr>
                                <th>Order Codes</th>
                                <th>Address</th>
                                <th>Date</th>
                                <th>Status</th>
                                <th>Note</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${customer.ordersCollection}" var="order">
                                <tr>
                                    <td><a href="Orders?action=details&id=${order.OId}">${order.OId}</a></td>
                                    <td>${order.orderAddress}</td>
                                    <td>${order.orderDateAsString}</td>
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
                    make_menu_active(2);
                });
            </script>
    </body>
</html>
