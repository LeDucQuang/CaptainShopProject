<%-- 
    Document   : categorys-details
    Created on : Oct 15, 2016, 7:25:59 AM
    Author     : Khoi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Detail</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
        </head>
        <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
        <jsp:useBean id = "category" class="entity.Category" scope = "request"></jsp:useBean>
            <div class="w3-container">
                <h3>Category Info: ${category.cateId}</h3>
                <p>Category Name: ${category.categoryName}</p>
                <p>Brand: ${category.brand}</p>
                <p>Status:
                    <c:choose>
                        <c:when test="${category.status == 1}">
                            Non Active
                        </c:when>
                        <c:otherwise>
                            Active
                        </c:otherwise>
                    </c:choose>
                </p>
                <p>Product List:</p>
                <p>
                    <input class="w3-input filter-input w3-border w3-padding" type="text" placeholder="Input data to search..." data-filter="filter-table" />
                </p>
                <div class="w3-responsive">
                    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white" id="filter-table">
                        <thead>
                            <tr>
                                <th>Product ID</th>
                                <th>Name</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            <c:forEach items="${productList}" var="i">
                                <tr>
                                    <td><c:out value="${i.PId}" /></a></td>
                                    <td><c:out value="${i.productName}" /></td>
                                    <td><c:out value="${i.quantity}" /></td>
                                    <td><c:out value="${i.productPrice}"/> vnđ</td>
                                    <td><a class="w3-btn w3-ripple w3-blue" href="Products?action=edit&pId=${i.PId}">Edit</a></td>
                                    <td><a class="w3-btn w3-ripple w3-blue" href="Products?action=delete&pId=${i.PId}">Delete</a></td>
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
