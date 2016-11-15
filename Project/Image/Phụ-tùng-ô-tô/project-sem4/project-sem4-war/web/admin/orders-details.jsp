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
        <title>khách hàng</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
        </head>
        <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
        <jsp:useBean id = "order" class="entity.Orders" scope = "request">
        </jsp:useBean>
        <div class="w3-container">
            <h3>Thông tin chi tiêt đơn hàng: ${order.OId}</h3>
            <p>Thông tin khách hàng:</p>
            <div class="w3-responsive">
                <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
                    <thead>
                        <tr>
                            <th>Mã khách hàng</th>
                            <th>Tên</th>
                            <th>Số điện thoại</th>
                            <th>Địa chỉ</th>
                            <th>Email</th>
                            <th>Loại khách hàng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><a href="Customers?action=details&id=${order.CId.CId}">${order.CId.CId}</a></td>
                            <td>${order.CId.customerName}</td>
                            <td>${order.CId.phonenumber}</td>
                            <td>${order.CId.customerAddress}</td>
                            <td>${order.CId.email}</td>
                            <c:choose>
                                <c:when test="${ order.CId.rate < 1000 }">
                                    <td>Phổ thông</td>
                                </c:when>
                                <c:when test="${ order.CId.rate >= 1000 && order.CId.rate < 2000 }">
                                    <td>Bạch kim</td>
                                </c:when>
                                <c:when test="${ order.CId.rate >= 2000 }">
                                    <td>Kim cương</td>
                                </c:when>
                            </c:choose>
                        </tr>
                    </tbody>
                </table>
            </div>
            <p>Địa chỉ: ${order.orderAddress}</p>
            <p>Ngày tạo: ${order.orderDate}</p>
            <p>Trạng thái: ${order.orderStatus}</p>
            <p>Note: ${order.orderNote}</p>
            <p>Danh sách các sản phẩm được đặt:</p>
            <div class="w3-responsive">
                <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
                    <thead>
                        <tr>
                            <th>Mã sản phẩm</th>
                            <th>Tên</th>
                            <th>Giá</th>
                            <th>Số lượng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${order.orderProductCollection}" var="orderProduct">
                            <tr>
                                <td>${orderProduct.PId.PId}</td>
                                <td>${orderProduct.PId.productName}</td>
                                <td>${orderProduct.PId.productPrice} vnđ</td>
                                <td>${orderProduct.quantity} cái</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <p>Thông tin kho hàng:</p>
                <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
                    <thead>
                        <tr>
                            <th>Mã kho</th>
                            <th>Tên</th>
                            <th>Địa chỉ</th>
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
            <h5>Tổng tiền: ${order.ordersFee} vnđ</h5>
        </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
        <script>
            $(document).ready(function () {
                make_menu_active(5);
            });
        </script>
    </body>
</html>
