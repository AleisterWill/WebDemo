<%-- 
    Document   : cart
    Created on : Aug 29, 2021, 8:40:23 PM
    Author     : three
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center text-danger">GIỎ HÀNG</h1>

<table class="table">
    <tr>
        <th>Product ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
    </tr>
    <c:forEach var="c" items="${cart}">
        <tr>
            <td>${c.productId}</td>
            <td>${c.name}</td>
            <td>${c.price}</td>
            <td>${c.amount}</td>
        </tr>
    </c:forEach>
</table>