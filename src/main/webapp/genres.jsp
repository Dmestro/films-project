<%--
  Created by IntelliJ IDEA.
  User: Lytki
  Date: 22.03.2017
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
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
    <script src="js/genres.js"></script>
</head>
<body>
<div class="row">
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <img src="img/camera.png" alt="Фильмы" class="camera-logo">
                <a class="navbar-brand" href="">Кинобаза</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="index.jsp">Фильмы</a></li>
                <li class="active"><a href="#">Жанры</a></li>
                <li><a href="countries.jsp">Страны</a></li>
                <li><a href="peoples.jsp">Люди</a></li>
            </ul>
        </div>

    </nav>
</div>
<div class="container" style="margin-top: 80px;">
    <div class="col-md-3"></div>
    <div class="col-md-6">
        <table class="table table-hover table-genres">
            <thead>
            <tr>
                <th>#</th>
                <th>Жанр</th>
                <th>Опции</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <div id="add-dialog-button" class="action-button">
        <i class="glyphicon glyphicon-plus" title="Добавить страну"></i>
    </div>

</div>
<div class="opacifier">
</div>

<div class="container ">
    <div class="add-dialog input-group">
        <div id="country-name-input" class="form-group">
            <span class="input-group-addon">Название жанра:</span>
            <input id="genre-name" type="text" class="form-control">
        </div>
        <div id="add-button" class="action-button"><i class="glyphicon glyphicon-ok" title="Добавить"></i></div>
        <div id="cancel-add-button" class="action-button"><i class="glyphicon glyphicon-remove" title="Отмена"></i></div>
    </div>
</div>

</body>
</html>
