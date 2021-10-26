<%-- 
    Document   : login
    Created on : Sep 21, 2021, 6:04:25 PM
    Author     : three
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/login" var="action" />
<div class="alert alert-success text-center">
    <strong>LOGIN</strong>
</div>
<c:if test="${param.error != null}">
    <div class="alert alert-danger">An error has occurred!</div>
</c:if>
<form method="post" action="${action}" class="form-group">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="Enter Username" />
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Enter Password" />
    </div>
    <div class="form-group">
        <input type="submit" value="Login" />
    </div>
</form>