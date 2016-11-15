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
        <title>Chi tiết khách hàng</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
        </head>
        <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
        <jsp:useBean id = "customer" class="entity.Customer" scope = "request"></jsp:useBean>
            <div class="w3-row-padding w3-margin-bottom">
                <div class="w3-container">
                    <h3>Thông tin khách hàng: ${customer.CId}</h3>
                <p>Tên khách hàng: ${customer.customerName}<p>
                <p>SĐT: ${customer.phonenumber}</p>
                <p>Địa chỉ: ${customer.customerAddress}</p>
                <p>Email: ${customer.email}</p>
                <p>Passport: ${customer.passport}</p>
                <p>Số dư tài khoản: ${customer.balances}</p>
                <p>Loại khách hàng:
                    <c:choose>
                        <c:when test="${ customer.rate < 1000 }">
                            Phổ thông
                        </c:when>
                        <c:when test="${ customer.rate >= 1000 && customer.rate < 2000 }">
                            Bạch kim
                        </c:when>
                        <c:when test="${ customer.rate >= 2000 }">
                            Kim cương
                        </c:when>
                    </c:choose>
                </p>
                <p>Danh sách các order:</p>
                <p>
                    <input id="filter-input" class="w3-input w3-border w3-padding" type="text" placeholder="Nhập dữ liệu cần tìm vào..." />
                </p>
                <div class="w3-responsive">
                    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
                        <thead>
                            <tr>
                                <th>Mã đơn hàng</th>
                                <th>Địa chỉ</th>
                                <th>Ngày tạo</th>
                                <th>Trạng thái</th>
                                <th>Ghi chú</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${customer.ordersCollection}" var="order">
                                <tr>
                                    <td><a href="Orders?action=details&id=${order.OId}">${order.OId}</a></td>
                                    <td>${order.orderAddress}</td>
                                    <td>${order.orderDate}</td>
                                    <td>${order.orderStatus} vnđ</td>
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
                    make_menu_active(2);
                });
            </script>
    </body>
</html>
