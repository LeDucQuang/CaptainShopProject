<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <form action="Admin?action=checkadd" method="post">
                <p>
                    <label>Tên tài khoản: </label>
                    <input class="w3-input w3-border w3-padding" type="text" name="username" value="" placeholder="nhập tên tài khoản" />
                </p>
                <p>
                    <label>Mật khẩu: </label>
                    <input class="w3-input w3-border w3-padding" type="password" name="password" value="" placeholder="nhập mật khẩu" />
                </p>
                <p>
                    <label>Nhập lại mật khẩu: </label>
                    <input class="w3-input w3-border w3-padding" type="password" name="repassword" value="" placeholder="nhập lại mật khẩu" />
                </p>
                <p>
                    <label>Loại admin: </label>
                    <select class="w3-input w3-border" name="roles">
                        <option  value="1">Super admin</option>
                        <option value="2">Admin</option>
                    </select>
                </p>
                <jsp:useBean id = "wareList" class="java.util.List" scope = "request"></jsp:useBean>
                    <p>
                        <label>Kho hàng:</label>
                        <select class="w3-input w3-border" name="warehouse">
                        <c:forEach items="${wareList}" var="i">
                            <option value="${i.WId}"><c:out value="${i.wareName}"/></option>
                        </c:forEach>
                    </select>
                </p>
                <p>
                    <button class="w3-btn w3-blue">TẠO</button>
                </p>
            </form>
        </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
        <script>
            $(document).ready(function () {
                make_menu_active(3);
            });
        </script>
    </body>
</html>
