<%-- 
    Document   : products-add
    Created on : Oct 26, 2016, 10:00:48 PM
    Author     : khoi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Customer</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
    </head>
    <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
        <jsp:useBean class="entity.Category" id="category" scope="request"></jsp:useBean>
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
            <h3>Add Category</h3>
            <form action="Category?action=checkEdit" method="POST">
                <input type="hidden" name="id" value="${category.cateId}"/>
                <p>
                    <label>Name Category: </label>
                    <input class="w3-input w3-border w3-padding" type="text" name="name"  placeholder=" category name" value="${category.categoryName}"/>
                </p>
                <p>
                    <label>Name Brand: </label>
                    <input class="w3-input w3-border w3-padding" type="text" name="brand"  placeholder=" brand name" value="${category.brand}"/>
                </p>
                <p>
                    <label>Status: </label>
                    <select class="w3-input w3-border" name="status">
                        <option value="1">Available</option>
                        <option value="2">Disable</option>
                    </select>
                </p>
                <p>
                    <input type="submit"  class="w3-btn w3-blue" value="UPDATE" />
                </p>
            </form>
        </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
        <script>
            $(document).ready(function () {
                make_menu_active(7);
            });
        </script>
    </body>
</html>