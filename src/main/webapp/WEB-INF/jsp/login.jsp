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
    
<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">You have no permission!</div>
</c:if>

<c:choose>
    <c:when test="${pageContext.request.userPrincipal.name == null}">
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
    </c:when>
    <c:when test="${pageContext.request.userPrincipal.name != null}">
        <h3 class="text-center">You're already logged in. <a href="<c:url value="/" />">CLICK HERE</a> to homepage.</h3>
    </c:when>
</c:choose>

        