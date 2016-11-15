<%-- 
    Document   : menutab
    Created on : Nov 3, 2016, 12:20:41 AM
    Author     : VuNK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<div class="menu_box">
    <h3 class="menu_head">Menu</h3>
    <ul class="nav" id="menutab1">
        <li><a href="Home">Home</a></li>
        <li><a href="ViewCategory?brand=Auto">Auto</a></li>
        <li><a href="ViewCategory?brand=Moto">Moto</a></li>
        <li><a href="contact.jsp">Contact</a></li>
    </ul>
</div>
<div class="category" id="menutab2">
    <h3 class="menu_head">CATEGORY</h3>
    <ul class="nav">
        <c:forEach items="${categoryList}" var="cateItem">
            <li><a href="ViewCategory?cateId=${cateItem.cateId}"><c:out value="${cateItem.categoryName}"/></a></li>
            </c:forEach>
    </ul>
</div>
