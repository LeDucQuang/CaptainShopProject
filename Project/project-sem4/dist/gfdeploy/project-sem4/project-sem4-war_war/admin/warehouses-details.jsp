<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Warehouses</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
    </head>
    <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
        <jsp:useBean id = "warehouse" class="entity.Warehouse" scope = "request">
        </jsp:useBean>
        <div class="w3-container">
            <h3>Warehouse Detail: ${warehouse.WId}</h3>
            <p>Warehouse Name: ${warehouse.wareName}</p>
            <p>Address: ${warehouse.wareAddress}</p>
            <p>List of warehouse management ${warehouse.wareName}: </p>
            <p>
                <input class="w3-input filter-input w3-border w3-padding" type="text" placeholder="Nhập dữ liệu cần tìm vào..." data-filter="filter-table" />
            </p>
            <div class="w3-responsive">
                <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white" id="filter-table">
                    <thead>
                        <tr>
                            <th>Admin ID</th>
                            <th>Account</th>
                            <th>Rank</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${warehouse.usersCollection}" var="user">
                            <tr>
                                <td>${user.UId}</td>
                                <td>${user.username}</td>
                                <td>${user.roles}</td>
                                <td><a class="w3-btn w3-ripple w3-blue" href="Admin?action=edit">Edit</a></td>
                                <td><a class="w3-btn w3-ripple w3-blue" href="Admin?action=delete">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <p>List order of ${warehouse.wareName}: </p>
            <p>
                <input class="w3-input filter-input w3-border w3-padding" type="text" placeholder="Nhập dữ liệu cần tìm vào..." data-filter="filter-table1" />
            </p>
            <div class="w3-responsive">
                <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white" id="filter-table1">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Product ID</th>
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
                        <c:forEach items="${warehouse.ordersCollection}" var="order">
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
                make_menu_active(6);
            });
        </script>
    </body>
</html>
