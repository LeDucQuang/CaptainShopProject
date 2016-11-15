<%-- 
    Document   : products-add
    Created on : Oct 26, 2016, 10:00:48 PM
    Author     : Cgc_Shyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h3>Add Product</h3>
            <form action="Products?action=checkadd" method="post" enctype="multipart/form-data">
                <p>
                    <label>Name Product: </label>
                    <input class="w3-input w3-border w3-padding" type="text" name="name"  placeholder="name" />
                </p>
                <p>
                    <label>Picture:</label>
                    <input class="w3-input w3-border w3-padding" type="file" name="imglink"/>
                </p>
                <p>
                    <label>Number:</label>
                    <input class="w3-input w3-border w3-padding" type="text" name="quantity"  placeholder="quantity"/>
                </p>
                <p>
                    <label>Price: </label>
                    <input class="w3-input w3-border w3-padding" type="text" name="price" placeholder="price"/>
                </p>
                <p>
                    <label>Describe: </label>
                    <input class="w3-input w3-border w3-padding" type="text" name="des" placeholder="description"/>
                </p>
                <jsp:useBean id = "cateList" class="java.util.List" scope = "request"></jsp:useBean>
                    <p>
                        <label>Category:</label>
                        <select class="w3-input w3-border" name="cateid">
                        <c:forEach items="${cateList}" var="i">
                            <option value="${i.cateId}"><c:out value="${i.categoryName}"/></option>
                        </c:forEach>
                    </select>
                </p>
                <p>
                    <button class="w3-btn w3-blue">Add</button>
                </p>
            </form>

            <!-- End page content -->
        </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
        <script>
            $(document).ready(function () {
                make_menu_active(4);
            });
        </script>
    </body>
</html>