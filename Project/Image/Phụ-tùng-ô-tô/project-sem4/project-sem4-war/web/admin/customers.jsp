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
        <jsp:useBean id = "customerList" class="java.util.List" scope = "request">
        </jsp:useBean>
        <div class="w3-container">
            <h3>Tổng số khách hàng: ${customerQuantity} người</h3>
            <h5>${customerList.size()} khách hàng đầu tiên</h5>
            <p>
                <input id="filter-input" class="w3-input w3-border w3-padding" type="text" placeholder="Nhập dữ liệu cần tìm vào..." />
            </p>
            <div class="w3-responsive">
                <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
                    <thead>
                        <tr>
                            <th>Mã khách hàng</th>
                            <th>Tên</th>
                            <th>Địa chỉ</th>
                            <th>Số điện thoại</th>
                            <th>Email</th>
                            <th>Passport</th>
                            <th>Số dư tài khoản</th>
                            <th>Loại khách hàng</th>
                            <th>Trạng thái tài khoản</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${customerList}" var="customer">
                            <tr>
                                <td><a href="Customers?action=details&id=${customer.CId}">${customer.CId}</a></td>
                                <td>${customer.customerName}</td>
                                <td>${customer.customerAddress}</td>
                                <td>${customer.phonenumber}</td>
                                <td>${customer.email}</td>
                                <td>${customer.passport}</td>
                                <td>${customer.balances} vnđ</td>
                                <c:choose>
                                    <c:when test="${ customer.rate < 1000 }">
                                        <td>Phổ thông</td>
                                    </c:when>
                                    <c:when test="${ customer.rate >= 1000 && customer.rate < 2000 }">
                                        <td>Bạch kim</td>
                                    </c:when>
                                    <c:when test="${ customer.rate >= 2000 }">
                                        <td>Kim cương</td>
                                    </c:when>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${ customer.status == 1 }">
                                        <td>Còn hoạt động</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Ngưng hoạt động</td>
                                    </c:otherwise>
                                </c:choose>
                                <td><a class="w3-btn w3-ripple w3-blue" href="Customers?action=edit&id=${customer.CId}">Sửa</a></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${ customer.status == 1 }">
                                            <a class="w3-btn w3-ripple w3-blue" href="Customers?action=delete&id=${customer.CId}">Vô hiệu</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="w3-btn w3-ripple w3-blue" href="Customers?action=delete&id=${customer.CId}">Kích hoạt</a>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
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
