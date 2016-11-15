<%-- 
    Document   : products-edit
    Created on : Oct 26, 2016, 10:00:11 PM
    Author     : Cgc_Shyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>sản phẩm</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
    </head>
    <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
        <jsp:useBean id="product" class="entity.Product" scope="request" />
        <div class="w3-container">
            <h3>Chỉnh sửa sản phẩm mã: ${product.PId}</h3>
            <form action="Products?action=checkEdit" method="post" enctype="multipart/form-data">
                <p>
                    <label>Tên sản phẩm: </label>
                    <input type="hidden" name="pId" value="${product.PId}" />
                    <input class="w3-input w3-border w3-padding" type="text" name="name"  placeholder="tên sản phẩm" value="${product.productName}"/>
                </p>
                <p>
                    <label>Chọn Ảnh:</label>
                    <input class="w3-input w3-border w3-padding" type="file" name="imglink"/>
                </p>
                <p>
                    <label>Số lượng:</label>
                    <input class="w3-input w3-border w3-padding" type="text" name="quantity"  placeholder="số lượng" value="${product.quantity}"/>
                </p>
                <p>
                    <label>Giá: </label>
                    <input class="w3-input w3-border w3-padding" type="text" name="price" placeholder="giá" value="${product.productPrice}"/>
                </p>
                <p>
                    <label>Mô tả: </label>
                    <input class="w3-input w3-border w3-padding" type="text" name="des" placeholder="mô tả" value="${product.description}"/>
                </p>
                <jsp:useBean id = "cateList" class="java.util.List" scope = "request"></jsp:useBean>
                    <p>
                        <label>Loại hàng:</label>
                        <select class="w3-input w3-border" name="cateid">
                        <c:forEach items="${cateList}" var="i">
                            <option value="${i.cateId}"><c:out value="${i.categoryName}"/></option>
                        </c:forEach>
                    </select>
                </p>
                <p>
                    <button class="w3-btn w3-blue">SỬA</button>
                </p>
            </form>

            <!-- End page content -->
        </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
        <script>
            $(document).ready(function () {
                make_menu_active(4);
            });
        </script>
    </body>
</html>