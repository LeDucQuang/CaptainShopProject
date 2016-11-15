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
        <title>Sửa chi tiết khách hàng</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
        </head>
        <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
        <jsp:useBean id = "customer" class="entity.Customer" scope = "request"></jsp:useBean>
            <div class="w3-container">
                <h3>Sửa loại khách hàng cho: ${customer.customerName}</h3>
                <form action="Customers?action=edit" method="POST">
                    <p>
                        <label>Loại Khách hàng: </label>
                        <input type="hidden" name="id" value="${customer.CId}" />
                        <input type="hidden" name="sub-action" value="1"/>
                        <select class="w3-input w3-border" name="customer-rate">
                            <option  value="1">Phổ Thông</option>
                            <option value="2">Bạch Kim</option>
                            <option value="3">Kim Cương</option>
                        </select>
                    </p>
                    <p>
                        <button class="w3-btn w3-blue">SỬA</button>
                    </p>
                </form>
            </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
        <script>
            $(document).ready(function () {
                make_menu_active(2);
            });
        </script>
    </body>
</html>
