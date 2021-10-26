<%-- 
    Document   : header
    Created on : Aug 29, 2021, 11:42:51 AM
    Author     : three
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="<c:url value="/"/>">Trang chủ</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Liên hệ</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/cart" />">Giỏ hàng</a>
    </li>
    <c:forEach var="cat" items="${categories}" >
        <li class="nav-item">
            <a class="nav-link" href="#">${cat.name}</a>
        </li>
    </c:forEach>
    <li class="nav-item">
      <a class="nav-link disabled" href="#">Đặt hàng</a>
    </li>
    <li class="nav-item active">
        <a class="nav-link text-danger" href="<c:url value="/login"/>">Login</a>
    </li>
  </ul>
</nav>