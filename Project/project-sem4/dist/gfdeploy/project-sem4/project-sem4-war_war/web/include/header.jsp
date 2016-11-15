<%-- 
    Document   : header
    Created on : Nov 3, 2016, 12:02:24 AM
    Author     : VuNK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="Customer" class="entity.Customer" scope="session"/>

<!DOCTYPE html>
<div class="header">	
    <div class="container"> 
        <div class="header-top">
            <div class="logo">
                <a href="Home"><img src="images/logo.png" alt=""/></a>
            </div>
            <div class="header_right">
                <ul class="login">
                    <c:choose>
                        <c:when test="${Customer == null || Customer.customerName == null || Customer.CId == null}">
                                <li class="login_text"><a href="Home?action=login">Login</a></li>
                            </c:when>
                            <c:otherwise>
                            <li class="login_text"><a href="CustomerDetails?cusId=${Customer.CId}">Welcome: ${Customer.customerName}</a></li>
                                <li class="login_text"><a href="Home?action=logOut">Log out</a></li>
                            </c:otherwise>
                        </c:choose>
                    <div class='clearfix'></div>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="clearfix"></div>
        </div>  
        <div class="banner_wrap">
            <div class="banner_right">
                <h1>Your kind of<br>Vehicle</h1>
                <p>Let's our shop make a satisfaction</p>
            </div>
            <div class='clearfix'></div>
        </div>
    </div>
</div>
