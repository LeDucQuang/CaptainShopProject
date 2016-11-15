<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>kho</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
        </head>
        <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
            <div class="w3-container">
                <h3>Tổng số kho: ${warehouselist.size()}</h3>
            <a class="w3-btn w3-blue" href="Warehouses?action=add" ><i class="fa fa-plus fa-2" aria-hidden="true"></i> Thêm kho</a>
            <p>
                <input id="filter-input" class="w3-input w3-border w3-padding" type="text" placeholder="Nhập dữ liệu cần tìm vào..." />
            </p>
            <div class="w3-responsive">
                <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
                    <thead>
                        <tr>
                            <th>Mã kho</th>
                            <th>Tên</th>
                            <th>Địa chỉ</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${warehouselist}" var="i">
                            <tr>
                                <td><a href="Warehouses?action=details&wId=${i.WId}"><c:out value="${i.WId}" /></a></td>
                                <td><c:out value="${i.wareName}" /></td>
                                <td><c:out value="${i.wareAddress}" /></td>
                                <c:choose>
                                    <c:when test="${ i.status == 1 }">
                                        <td>Còn hoạt động</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Ngưng hoạt động</td>
                                    </c:otherwise>
                                </c:choose>
                                <td><a class="w3-btn w3-ripple w3-blue" href="Warehouses?action=edit&wId=${i.WId}">Edit</a></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${ i.status == 1 }">
                                            <a class="w3-btn w3-ripple w3-blue" href="Warehouses?action=delete&wId=${i.WId}">Vô hiệu</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="w3-btn w3-ripple w3-blue" href="Warehouses?action=delete&wId=${i.WId}">Kích hoạt</a>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
        <script>
            $(document).ready(function () {
                make_menu_active(6);
            });
        </script>
    </body>
</html>
