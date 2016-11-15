<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Customer</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
    </head>
    <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
        <div class="w3-container">
            <c:choose>
                <c:when test="${ error_msg != null }">
                    <div class="w3-panel w3-red">
                        <span onclick="this.parentElement.style.display='none'" class="w3-closebtn">&times;</span> 
                        <h3>ERROR...!!!</h3>
                        <p>${error_msg}</p>
                    </div> 
                </c:when>
            </c:choose>
            <h3>Add new Warehouse</h3>
            <form action="Warehouses?action=checkadd" method="post">
                <p>
                    <label>Warehouse Name: </label>
                    <input class="w3-input w3-border w3-padding" type="text" name="name"  placeholder="tên kho" />
                </p>
                <p>
                    <label>Address:</label>
                    <input class="w3-input w3-border w3-padding" type="text" name="address"  placeholder="địa chỉ"/>
                </p>
                 <p>
                    <label>Status: </label>
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