<%--
  Created by IntelliJ IDEA.
  User: Lytki
  Date: 22.03.2017
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple JSP</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="libs/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="libs/bootstrap/css/bootstrap-theme.min.css">
    <script src="libs/jquery.min.js"></script>
    <script src="libs/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="row">
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <img src="img/camera.png" alt="Фильмы" class="camera-logo">
                <a class="navbar-brand" href="#">Кинобаза</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Фильмы</a></li>
                <li><a href="#">Жанры</a></li>
                <li><a href="countries.jsp">Страны</a></li>
                <li><a href="#">Люди</a></li>
            </ul>
        </div>

    </nav>
</div>
<div class="container">
    <div class="col-md-3" style="background-color: #2aabd2; height: 80%">NOMER RAZ</div>
    <div class="col-md-9" >NOMER DVA</div>
</div>

</body>
</html>
