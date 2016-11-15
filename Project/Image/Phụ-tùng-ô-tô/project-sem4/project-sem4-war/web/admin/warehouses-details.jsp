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
            <h3>Thông tin chi tiêt kho: ${warehouse.WId}</h3>
            <p>Tên kho: ${warehouse.wareName}</p>
            <p>Địa chỉ: ${warehouse.wareAddress}</p>
            <p>Danh sách quản lí của ${warehouse.wareName}: </p>
            <p>
                <input id="filter-input" class="w3-input w3-border w3-padding" type="text" placeholder="Nhập dữ liệu cần tìm vào..." />
            </p>
            <div class="w3-responsive">
                <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
                    <thead>
                        <tr>
                            <th>Mã admin</th>
                            <th>Tên Tài khoản</th>
                            <th>Loại admin</th>
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
                                <td><a class="w3-btn w3-ripple w3-blue" href="Admin?action=edit">Sửa</a></td>
                                <td><a class="w3-btn w3-ripple w3-blue" href="Admin?action=delete">Xóa</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <p>Danh sách các order thuộc ${warehouse.wareName}: </p>
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
                        <c:forEach items="${warehouse.ordersCollection}" var="order">
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
                make_menu_active(6);
            });
        </script>
    </body>
</html>
