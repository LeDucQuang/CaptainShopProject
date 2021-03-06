<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>khách hàng</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
    </head>
    <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
        <jsp:useBean id="warehouse" class="entity.Warehouse" scope="request"/>
        <div class="w3-container">
            <h3>Sửa kho</h3>
            <form action="Warehouses?action=checkEdit" method="post">
                <input type="hidden" name="wId" value="${warehouse.WId}"/>
                <p>
                    <label>Tên kho: </label>
                    <input class="w3-input w3-border w3-padding" type="text" name="name" value="${warehouse.wareName}" placeholder="tên kho" required="true" />
                </p>
                <p>
                    <label>Địa chỉ:</label>
                    <input class="w3-input w3-border w3-padding" type="text" name="address" value="${warehouse.wareAddress}" placeholder="địa chỉ" required="true" />
                </p>
                <p>
                    <input type="submit"  class="w3-btn w3-blue" value="SỬA" />
                </p>
            </form>

            <!-- End page content -->
        </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
        <script>
            $(document).ready(function () {
                make_menu_active(6);
            });
        </script>
    </body>
</html>
