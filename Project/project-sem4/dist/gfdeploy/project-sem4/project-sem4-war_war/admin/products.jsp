<%-- 
    Document   : products
    Created on : Oct 26, 2016, 9:59:05 PM
    Author     : Cgc_Shyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Product</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
        </head>
        <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
            <div class="w3-container">
                <h3>Total Product: ${productQuantity} </h3>
            <a class="w3-btn w3-blue" href="Products?action=add" ><i class="fa fa-plus fa-2" aria-hidden="true"></i> Add Product</a>
            <h5>${productlist.size()} First Product</h5>
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
                            <th>Category</th>
                            <th>Price</th>
                            <th>Status</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${productlist}" var="i">
                            <tr>
                                <td><c:out value="${i.PId}" /></a></td>
                                <td><c:out value="${i.productName}" /></td>
                                <td><c:out value="${i.quantity}" /></td>
                                <td><c:out value="${i.cateId.categoryName}" /></td>
                                <td><c:out value="${i.productPrice}"/> vnđ</td>
                                <c:choose>
                                    <c:when test="${i.status == 1}">
                                        <td>Non active</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Active</td>
                                    </c:otherwise>
                                </c:choose>
                                <td><a class="w3-btn w3-ripple w3-blue" href="Products?action=edit&pId=${i.PId}">Edit</a></td>
                                <c:choose>
                                    <c:when test="${i.status == 1}">
                                        <td><a class="w3-btn w3-ripple w3-blue" href="Products?action=delete&pId=${i.PId}">Sell</a></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td><a class="w3-btn w3-ripple w3-blue" href="Products?action=delete&pId=${i.PId}">Not Sell</a></td>
                                    </c:otherwise>
                                </c:choose>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
        <script>
            $(document).ready(function () {
                make_menu_active(4);
            });
        </script>
    </body>
</html>

