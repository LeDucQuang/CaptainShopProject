<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Warehouse</title>
        <jsp:include page="include/htmlhead.jsp"></jsp:include>
            <style>
                form {
                    display: none;
                }
                form#search-type {
                    display: block !important;
                }
            </style>
        </head>
        <body class="w3-light-grey">
        <jsp:include page="include/header-top.jsp"></jsp:include>
            <div class="w3-container">
            <c:choose>
                <c:when test="${ error_msg != null }">
                    <div class="w3-panel w3-red">
                        <span onclick="this.parentElement.style.display = 'none'" class="w3-closebtn">&times;</span> 
                        <h3>ERROR...!!!</h3>
                        <p>${error_msg}</p>
                    </div> 
                </c:when>
            </c:choose>
                <h3>Search</h3>
            <p>
                <label>Choose :</label>
                <select class="w3-select w3-border" id="type" name="option">
                    <option value="" disabled selected>Choose kind to search:</option>
                    <option value="customers">Customer</option>
                    <option value="orders">Order</option>
                    <option value="products">Product</option>
                </select>
            </p>
            <form id="customers" action="Search" >
                <input class="search-value" name="search-type" type="hidden" value="customers"/>
                <input name="action" type="hidden" value="search" />
                <p>
                    <label>Customer ID:</label>
                    <input class="w3-input w3-border" type="text" placeholder="could be empty " name="id"/>
                </p>
                <p>
                    <label>Customer Name:</label>
                    <input class="w3-input w3-border" type="text" placeholder="could be empty" name="name"/>
                </p>
                <p>
                    <button class="w3-btn w3-blue">SEARCH</button>
                </p>
            </form>
            <form id="orders" action = "Search" >
                <input class="search-value" name="search-type" type="hidden" value="orders"/>
                <input name="action" type="hidden" value="search" />
                <p>
                    <label>Order ID:</label>
                    <input class="w3-input w3-border" name="id" type="text" placeholder="could be empty"/>
                </p>
                <p>
                    <label>Customer ID:</label>
                    <input class="w3-input w3-border" name="customerId" type="text" placeholder="could be empty"/>
                </p>
                <p>
                    <label>Date created:</label>
                    <input class="w3-input w3-border" name="date" type="text" placeholder="(dd/MM/YYYY)could be empty"/>
                </p>
                <p>
                    <button class="w3-btn w3-blue">SEARCH</button>
                </p>
            </form>
            <form id="products" action="Search" >
                <input class="search-value" name="search-type" type="hidden" value="products"/>
                <input name="action" type="hidden" value="search" />
                <p>
                    <label>Product ID:</label>
                    <input name="id" type="text" class="w3-input w3-border" type="text" placeholder="could be empty"/>
                </p>
                <p>
                    <label>Product Name:</label>
                    <input name="name" type="text" class="w3-input w3-border" type="text" placeholder="could be empty"/>
                </p>
                <p>
                    <label>Price:</label>
                    <input name="price" class="w3-input w3-border" type="text" placeholder="could be empty"/>
                </p>
                <p>
                    <button class="w3-btn w3-blue">SEARCH</button>
                </p>
            </form>
            <c:choose>
                <c:when test="${productList != null || productList.size() > 0}">
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
                                    <th>Status</th>
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
                </c:when>
                <c:when test="${userList != null || userList.size() > 0}">
                    <div class="w3-responsive">
                        <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white" id="filter-table">
                            <thead>
                                <tr>
                                    <th>Customer ID</th>
                                    <th>Name</th>
                                    <th>Address</th>
                                    <th>Phone</th>
                                    <th>Email</th>
                                    <th>Passport</th>
                                    <th>Balance</th>
                                    <th>Customer Type</th>
                                    <th>Status</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${userList}" var="customer">
                                    <tr>
                                        <td><a href="Customers?action=details&id=${customer.CId}">${customer.CId}</a></td>
                                        <td>${customer.customerName}</td>
                                        <td>${customer.customerAddress}</td>
                                        <td>${customer.phonenumber}</td>
                                        <td>${customer.email}</td>
                                        <td>${customer.passport}</td>
                                        <td>${customer.balances} vnđ</td>
                                        <c:choose>
                                            <c:when test="${ customer.rate < 1000 }">
                                                <td>Normal</td>
                                            </c:when>
                                            <c:when test="${ customer.rate >= 1000 && customer.rate < 2000 }">
                                                <td>Platinum</td>
                                            </c:when>
                                            <c:when test="${ customer.rate >= 2000 }">
                                                <td>Diamond</td>
                                            </c:when>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${ customer.status == 1 }">
                                                <td>available</td>
                                            </c:when>
                                            <c:otherwise>
                                                <td>Disable</td>
                                            </c:otherwise>
                                        </c:choose>
                                        <td><a class="w3-btn w3-ripple w3-blue" href="Customers?action=edit&id=${customer.CId}">Edit</a></td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${ customer.status == 1 }">
                                                    <a class="w3-btn w3-ripple w3-blue" href="Customers?action=delete&id=${customer.CId}">Non-Active</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="w3-btn w3-ripple w3-blue" href="Customers?action=delete&id=${customer.CId}">Active</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>	
                    </div>    
                </c:when>
                <c:when test="${ordersList != null || ordersList.size() > 0}">
                    <div class="w3-responsive">
                <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white" id="filter-table">
                    <thead>
                        <tr>
                            <th>Product ID</th>
                            <th>Customer ID</th>
                            <th>Address</th>
                            <th>Date</th>
                            <th>Total</th>
                            <th>Status</th>
                            <th>Note</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${ordersList}" var="order">
                            <tr>
                                <td><a href="Orders?action=details&id=${order.OId}">${order.OId}</a></td>
                                <td><a href="Customers?action=details&id=${order.CId.CId}">${order.CId.CId}</a></td>
                                <td>${order.orderAddress}</td>
                                <td>${order.orderDateAsString}</td>
                                <td>${order.ordersFee} vnđ</td>
                                <td>${order.orderStatus}</td>
                                <td>${order.orderNote}</td>
                                <td><a class="w3-btn w3-ripple w3-blue" href="Orders?action=edit&id=${order.OId}">Edit</a></td>
                                <td><a class="w3-btn w3-ripple w3-blue" href="Orders?action=delete&id=${order.OId}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
                </c:when>
            </c:choose>
        </div>
        <jsp:include page="include/footer.jsp"></jsp:include>
        <script>
            $(document).ready(function () {
                make_menu_active(8);
            });
        </script>
        <script>
            $(document).ready(function () {
                var displayNode = "#" + $("#type").val();
                $("form").css("display", "none");
                $(displayNode).css("display", "block");
                $("#type").change(function () {
                    var displayNode = "#" + $(this).val();
                    $("form").css("display", "none");
                    $(displayNode).css("display", "block");
                    $(".w3-responsive").remove();
                });
            });
        </script>
    </body>
</html>
