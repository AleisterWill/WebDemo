<%-- 
    Document   : newjsp
    Created on : Aug 16, 2021, 7:45:41 PM
    Author     : three
--%>

<%@page contentType="text/html;" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center text-danger">Danh sách sản phẩm</h1>
<form action="">
    <div class="row">
        <div class="col-md-11">
            <input class="form-control" type="text" name="kw" placeholder="Nhập từ khóa để tìm kiếm" />
        </div>
        <div class="col-md-1">
            <input type="submit" value="Search" class="btn btn-danger" />
        </div>
    </div>
</form>

${counter}
${page}
                            <!<!-- PAGINATION -->
<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(counter/6)}" var="i">
        <c:if test="${page == i}">
            <li class="page-item active"><a class="page-link" href="<c:url value="/" />?page=${i}">${i}</a></li>
        </c:if>
        <c:if test="${page != i}">
            <li class="page-item"><a class="page-link" href="<c:url value="/" />?page=${i}">${i}</a></li>
        </c:if>
    </c:forEach>

</ul>

<div class="row">
    <c:forEach var="p" items="${products}">
        <div class="card col-md-4">
            <div class="card-body">
                <c:if test="${p.image != null && p.image.startsWith('https') == true}">
                    <img class="img-fluid" src="<c:url value="${p.image}"/>" alt="alt"/>
                </c:if>
                <c:if test="${p.image == null || p.image.startsWith('https') != true}">
                    <img class="img-fluid" src="<c:url value="/images/khoasol.jpg"/>" alt="alt"/>
                </c:if>
            </div>
            <div class="card-footer">
                <h3>${p.name}</h3>
                <p>${p.price} VND </p>
            </div>
        </div>
    </c:forEach>
</div>
