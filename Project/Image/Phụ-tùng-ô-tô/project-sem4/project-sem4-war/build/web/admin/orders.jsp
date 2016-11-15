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
            <h3>Tổng số đơn hàng: ${ordersQuantity} đơn</h3>
            <h5>${ordersList.size()} đơn hàng đầu tiên</h5>
            <p>
                <input id="filter-input" class="w3-input w3-border w3-padding" type="text" placeholder="Nhập dữ liệu cần tìm vào..." />
            </p>
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
                                <td><a class="w3-btn w3-ripple w3-blue" href="Orders?action=edit&id=${order.OId}">Sửa</a></td>
                                <td><a class="w3-btn w3-ripple w3-blue" href="Orders?action=delete&id=${order.OId}">Xóa</a></td>
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
