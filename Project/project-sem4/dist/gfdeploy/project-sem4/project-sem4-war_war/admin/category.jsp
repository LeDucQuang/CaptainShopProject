<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Category</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
        </head>
        <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
            <div class="w3-container">
                <h3>Total Category: ${categoryList.size()}</h3>
            <a class="w3-btn w3-blue" href="Category?action=add" ><i class="fa fa-plus fa-2" aria-hidden="true"></i> Add Category</a>
            <p>
                <input class="w3-input filter-input w3-border w3-padding" type="text" placeholder="Input data to search..." data-filter="filter-table" />
            </p>
            <div class="w3-responsive">
                <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white" id="filter-table">
                    <thead>
                        <tr>
                            <th>Category ID</th>
                            <th>Category Name</th>
                            <th>Brand</th>
                            <th>Status</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${categoryList}" var="category">
                            <tr>
                                <td><a href="Category?action=details&id=${category.cateId}"><c:out value="${category.cateId}" /></a></td>
                                <td><c:out value="${category.categoryName}" /></td>
                                <td><c:out value="${category.brand}" /></td>
                                <c:choose>
                                    <c:when test="${ category.status == 1 }">
                                        <td>Available</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Disable</td>
                                    </c:otherwise>
                                </c:choose>
                                <td><a class="w3-btn w3-ripple w3-blue" href="Category?action=edit&id=${category.cateId}">Edit</a></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${ category.status == 1 }">
                                            <a class="w3-btn w3-ripple w3-blue" href="Category?action=delete&id=${category.cateId}">Non-Active</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="w3-btn w3-ripple w3-blue" href="Category?action=delete&id=${category.cateId}">Active</a>
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
                make_menu_active(7);
            });
        </script>
    </body>
</html>
