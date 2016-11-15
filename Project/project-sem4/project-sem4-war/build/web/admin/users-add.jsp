<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Product</title>
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
            <form action="Admin?action=checkadd" method="post">
                <p>
                    <label>Account: </label>
                    <input class="w3-input w3-border w3-padding" type="text" name="username" value="" placeholder="nhập tên tài khoản" />
                </p>
                <p>
                    <label>Password: </label>
                    <input class="w3-input w3-border w3-padding" type="password" name="password" value="" placeholder="nhập mật khẩu" />
                </p>
                <p>
                    <label>Confirm your password: </label>
                    <input class="w3-input w3-border w3-padding" type="password" name="repassword" value="" placeholder="nhập lại mật khẩu" />
                </p>
                <p>
                    <label>Rank: </label>
                    <select class="w3-input w3-border" name="roles">
                        <option  value="1">Super admin</option>
                        <option value="2">Admin</option>
                    </select>
                </p>
                <jsp:useBean id = "wareList" class="java.util.List" scope = "request"></jsp:useBean>
                    <p>
                        <label>Warehouse:</label>
                        <select class="w3-input w3-border" name="warehouse">
                        <c:forEach items="${wareList}" var="i">
                            <option value="${i.WId}"><c:out value="${i.wareName}"/></option>
                        </c:forEach>
                    </select>
                </p>
                <p>
                    <button class="w3-btn w3-blue">Create</button>
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
