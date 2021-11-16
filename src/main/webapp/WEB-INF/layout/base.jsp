<%-- 
    Document   : base
    Created on : Aug 29, 2021, 11:38:51 AM
    Author     : three
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <tiles:insertAttribute name="title" />
        </title>
        <link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <script src="<c:url value="/js/main.js" />"></script>
        <div class="container">
            <!-- HEADER -->
            <tiles:insertAttribute name="header" />

            <!-- FOOTER -->
            <tiles:insertAttribute name="CONTENT" />

            <!-- CONTENT -->
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>
