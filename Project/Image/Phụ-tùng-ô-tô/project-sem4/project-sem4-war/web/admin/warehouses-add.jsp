<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>khách hàng</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
    </head>
    <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
        <div class="w3-container">
            <h3>Thêm kho</h3>
            <form action="Warehouses?action=checkadd" method="post">
                <p>
                    <label>Tên kho: </label>
                    <input class="w3-input w3-border w3-padding" type="text" name="name"  placeholder="tên kho" />
                </p>
                <p>
                    <label>Địa chỉ:</label>
                    <input class="w3-input w3-border w3-padding" type="text" name="address"  placeholder="địa chỉ"/>
                </p>
                 <p>
                    <label>Trạng thái: </label>
                    <select class="w3-input w3-border" name="status">
                        <option  value="1">Available</option>
                        <option value="2">Disable</option>
                    </select>
                </p>
                <p>
                    <input type="submit"  class="w3-btn w3-blue" value="THÊM" />

                </p>
            </form>
        </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
        <script>
            $(document).ready(function () {
                make_menu_active(6);
            });
        </script>
    </body>
</html>