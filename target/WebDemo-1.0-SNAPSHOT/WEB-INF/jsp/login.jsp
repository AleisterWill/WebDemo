<%-- 
    Document   : login
    Created on : Sep 21, 2021, 6:04:25 PM
    Author     : three
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/login" var="action" />
<form method="post" action="${action}" class="was-validated">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="Enter Username" required />
        <div class="valid-feedback">Valid</div>
        <div class="invalid-feedback">Invalid Username</div>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="text" id="password" name="password" placeholder="Enter Password" required />
        <div class="valid-feedback">Valid</div>
        <div class="invalid-feedback">Please enter password!</div>
    </div>
    <div>
        <input class="btn btn-success" type="submit">Submit</div>
    </div>
</form>