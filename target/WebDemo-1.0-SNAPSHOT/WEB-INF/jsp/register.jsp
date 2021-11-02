<%-- 
    Document   : register
    Created on : Nov 1, 2021, 7:18:28 AM
    Author     : three
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="action" value="/register" />

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<form:form method="post" action="${action}" modelAttribute="user" >
    <form:errors path="*" cssClass="alert alert-warning animated fadeInDown" element="div"  />
    <div class="input-group mb-3">
        <div class="input-group-prepend]">
            <span class="input-group-text">First Name</span>
        </div>
        <form:input type="text" id="firstName" path="firstName" placeholder="First Name" cssClass="form-control" />            
    </div>
    <form:errors path="firstName" cssClass="text text-center text-danger mb-3" element="label"  />
    
    <div class="input-group mb-3">
        <div class="input-group-prepend]">
            <span class="input-group-text">Last Name</span>
        </div>
        <form:input type="text" id="lastName" path="lastName" placeholder="Last Name" cssClass="form-control" />            
    </div>
    <form:errors path="lastName" cssClass="text text-center text-danger mb-3" element="label"  />
    
    <div class="input-group mb-3">
        <div class="input-group-prepend]">
            <span class="input-group-text">Email</span>
        </div>
        <form:input type="email" id="email" path="email" placeholder="Enter Email" cssClass="form-control" />            
    </div>
    <form:errors path="email" cssClass="text text-center text-danger mb-3" element="label"  />
    
    <div class="input-group mb-3">
        <div class="input-group-prepend]">
            <span class="input-group-text">Username</span>
        </div>
        <form:input type="text" id="username" path="username" placeholder="Enter Username" cssClass="form-control" />            
    </div>
    <form:errors path="username" cssClass="text text-center text-danger mb-3" element="label"  />
    
    <div class="input-group mb-3">
        <div class="input-group-prepend]">
            <span class="input-group-text">Password</span>
        </div>
        <form:input type="password" id="password" path="password" placeholder="Enter Password" cssClass="form-control" />            
    </div>
    <form:errors path="password" cssClass="text text-center text-danger mb-3" element="label"  />
    
    <div class="input-group mb-3">
        <div class="input-group-prepend]">
            <span class="input-group-text">Confirm Password</span>
        </div>
        <form:input type="password" id="confirmPW" path="confirmPW" placeholder="Confirm Password" cssClass="form-control" />            
    </div>
    <form:errors path="confirmPW" cssClass="text text-center text-danger mb-3" element="label"  />
    
    <div class="form-group">
        <input type="submit" value="Register" class="btn btn-primary" />
    </div>
</form:form>