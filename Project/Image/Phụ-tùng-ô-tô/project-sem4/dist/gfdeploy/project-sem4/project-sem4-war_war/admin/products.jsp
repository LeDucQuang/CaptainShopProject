<%-- 
    Document   : products
    Created on : Oct 26, 2016, 9:59:05 PM
    Author     : Cgc_Shyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>sản phẩm</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
        </head>
        <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
            <div class="w3-container">
                <h3>Tổng số mặt hàng: 100 đơn</h3>
                <a class="w3-btn w3-blue" href="Products?action=add" ><i class="fa fa-plus fa-2" aria-hidden="true"></i> Thêm mặt hàng</a>
                <h5>Tất cả mặt hàng</h5>
                <p>
                    <input id="filter-input" class="w3-input w3-border w3-padding" type="text" placeholder="Nhập dữ liệu cần tìm vào..." />
                </p>
                <div class="w3-responsive">
                    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
                        <thead>
                            <tr>
                                <th>Mã sản phẩm</th>
                                <th>Tên</th>
                                <th>Số lượng</th>
                                <th>Giá</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${productlist}" var="i">
                                <tr>
                                    <td><c:out value="${i.PId}" /></a></td>
                                    <td><c:out value="${i.productName}" /></td>
                                    <td><c:out value="${i.quantity}" /></td>
                                    <td><c:out value="${i.productPrice}"/></td>
                                    <td><a class="w3-btn w3-ripple w3-blue" href="Products?action=edit&pId=${i.PId}">Edit</a></td>
                                    <td><a class="w3-btn w3-ripple w3-blue" href="Products?action=delete&pId=${i.PId}">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
        </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
        <script>
            $(document).ready(function () {
                make_menu_active(4);
            });
        </script>
    </body>
</html>

