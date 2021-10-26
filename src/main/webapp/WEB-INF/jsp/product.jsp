<%-- 
    Document   : product
    Created on : Aug 29, 2021, 10:10:31 PM
    Author     : three
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/admin/products" var="upload" />
<h1 class="text-center text-danger">Trang quản lý sản phẩm</h1>
<c:if test="${successMsg} != null" >
    <div cssClass="alert alert-success">${successMsg}</div>
</c:if>
<c:if test="${errMsg} != null" >
    <div cssClass="alert alert-danger">${errMsg}</div>
</c:if>
<form:form method="post" action="${upload}" modelAttribute="product" 
           enctype="multipart/form-data">
    <form:errors path="*" cssClass="alert alert-warning" element="div" />
    <div class="form-group">
        <label for="file">Product's images</label>
        <form:input type="file" id="file" path="pFile" cssClass="form-control" />
    </div>
    <div class="form-group">
        <label for="name">Tên sản phẩm</label>
        <form:input type="text" id="name" path="name" cssClass="form-control" />
    </div>
    <div class="form-group">
        <label for="desc">Mô tả</label>
        <form:textarea id="desc" path="description" cssClass="form-control" />
    </div>
    <div class="form-group">
        <label for="price">Giá</label>
        <form:input type="text" id="price" path="price" cssClass="form-control" />
    </div>
    <div class="form-group">
        <label for="category">Loại sản phẩm</label>
        <form:select id="category" path="category" cssClass="form-control" >
            <c:forEach items="${categories}" var="cat">
                <form:option value="${cat.id}">${cat.name}</form:option>
            </c:forEach>
        </form:select>
    </div>
    <div class="form-group">
        <input type="submit" value="Upload" class="btn btn-danger"/>
    </div>
</form:form>