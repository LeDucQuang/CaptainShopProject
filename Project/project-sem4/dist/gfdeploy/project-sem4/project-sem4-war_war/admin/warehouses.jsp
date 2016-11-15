<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Warehouse</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
        </head>
        <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
            <div class="w3-container">
                <h3>Total Warehouse: ${warehouselist.size()}</h3>
            <a class="w3-btn w3-blue" href="Warehouses?action=add" ><i class="fa fa-plus fa-2" aria-hidden="true"></i>Add Warehouse</a>
            <p>
                <input class="w3-input filter-input w3-border w3-padding" type="text" placeholder="Nhập dữ liệu cần tìm vào..." data-filter="filter-table" />
            </p>
            <div class="w3-responsive">
                <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white" id="filter-table">
                    <thead>
                        <tr>
                            <th>Warehouse ID</th>
                            <th>Name</th>
                            <th>Address</th>
                            <th>Status</th>
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
                                        <td>Available</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Disable</td>
                                    </c:otherwise>
                                </c:choose>
                                <td><a class="w3-btn w3-ripple w3-blue" href="Warehouses?action=edit&wId=${i.WId}">Edit</a></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${ i.status == 1 }">
                                            <a class="w3-btn w3-ripple w3-blue" href="Warehouses?action=delete&wid=${i.WId}">Non-Active</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="w3-btn w3-ripple w3-blue" href="Warehouses?action=delete&wid=${i.WId}">Active</a>
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
