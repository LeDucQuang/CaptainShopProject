<%-- 
    Document   : users-edit
    Created on : Oct 26, 2016, 12:23:37 PM
    Author     : Cgc_Shyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
        </head>
        <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
        <jsp:useBean id="user" class="entity.Users" scope="request"/>

        <div class="w3-container">
            <h3>Sửa admin:${user.UId} </h3>
            <form action="Admin?action=checkEdit" method="post">
                <input type="hidden" name="uId" value="${user.UId}"/>

                <p>
                    <label>Loại admin: </label>
                    <select class="w3-input w3-border" name="role">
                        <option  value="1">SUPER ADMIN</option>
                        <option value="2">ADMIN</option>
                    </select>
                </p>
                <jsp:useBean id = "wareList" class="java.util.List" scope = "request"></jsp:useBean>
                    <p>
                        <label>Chọn warehouse: </label>
                        <select class="w3-input w3-border" name="warehouse">
                        <c:forEach items="${wareList}" var="i">
                            <option value="${i.WId}"><c:out value="${i.wareName}"/></option>
                        </c:forEach>
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
                make_menu_active(3);
            });
        </script>
    </body>
</html>

