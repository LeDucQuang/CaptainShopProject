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
        <div class="w3-container">
            <h3>Tổng số admin: 100 người</h3>
            <a class="w3-btn w3-blue" href="Admin?action=add" ><i class="fa fa-plus fa-2" aria-hidden="true"></i> Thêm admin</a>
            <p>
                <input id="filter-input" class="w3-input w3-border w3-padding" type="text" placeholder="Nhập dữ liệu cần tìm vào..." />
            </p>
            <div class="w3-responsive">
                <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
                    <thead>
                        <tr>
                            <th>Mã admin</th>
                            <th>Tên Tài khoản</th>
                            <th>Loại admin</th>
                            <th>Kho</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>       
                        <c:forEach items="${userlist}" var="i">
                            <tr>
                                <td><c:out value="${i.UId}" /></a></td>
                                <td><c:out value="${i.username}" /></td>
                                <td><c:out value="${i.roles}" /></td>
                                <td><a href="Warehouses?action=details&wId=${i.WId.WId}"><c:out value="${i.WId.WId}"/></a></td>
                                <td><a class="w3-btn w3-ripple w3-blue" href="Admin?action=edit&uId=${i.UId}">Edit</a></td>
                                <td><a class="w3-btn w3-ripple w3-blue" href="Admin?action=delete&uId=${i.UId}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
        <script>
            $(document).ready(function () {
                make_menu_active(3);
            });
        </script>
    </body>
</html>
