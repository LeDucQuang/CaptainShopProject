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
        <jsp:useBean id = "order" class="entity.Orders" scope = "request">
        </jsp:useBean>
        <div class="w3-container">
            <h3>Sửa hóa đơn: ${order.OId}</h3>
            <form action="Orders?action=edit" method="POST">
                <p>
                    <label>Trạng thái: </label>
                    <input type="hidden" name="id" value="${order.OId}" />
                    <input type="hidden" name="sub-action" value="1"/>
                    <select class="w3-input w3-border" name="status">
                        <option  value="1">Hoàn thành</option>
                        <option value="2">Đang đợi</option>
                    </select>
                </p>
                <p>
                    <label>Ghi chú: </label>
                    <input class="w3-input w3-border" name="note" value="${order.orderNote}" />
                </p>
                <p>
                    <button class="w3-btn w3-blue">SỬA</button>
                </p>
            </form>
        </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
        <script>
            $(document).ready(function () {
                make_menu_active(5);
            });
        </script>
    </body>
</html>
