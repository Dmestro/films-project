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
    <script src="js/film.js"></script>
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
                <li><a href="index.jsp">Фильмы</a></li>
                <li><a href="genres.jsp">Жанры</a></li>
                <li><a href="countries.jsp">Страны</a></li>
                <li><a href="peoples.jsp">Люди</a></li>
            </ul>
        </div>

    </nav>
</div>
<div class="container" style="margin-top: 100px">
   <div class="col-md-8 col-md-offset-2">
       <div class="col-md-10 col-md-offset-1" id="video">

       </div>

       <div class="page-header" id="title" style="text-align: center; margin-top: 30px;">

       </div>




       <div class="panel panel-default" id="description">
           <div class="panel-heading">Описание</div>
           <div class="panel-body">
           </div>
       </div>

       <div class="panel panel-default" id="actors">
           <div class="panel-heading">Актеры</div>
           <div class="panel-body">
           </div>
       </div>

       <div class="panel panel-default" id="producers">
           <div class="panel-heading">Режиссеры</div>
           <div class="panel-body">
           </div>
       </div>

       <div class="panel panel-default" id="genres">
           <div class="panel-heading">Жанр</div>
           <div class="panel-body">
           </div>
       </div>

       <div class="panel panel-default" id="countries">
           <div class="panel-heading">Страна</div>
           <div class="panel-body">
           </div>
       </div>

   </div>

    <div id="add-dialog-button" class="action-button" style="right:140px; position: fixed;">
        <i class=" glyphicon glyphicon-pencil" title="Редактировать"></i>
    </div>

    <div id="cancel-add-button" class="action-button" style="right:140px; bottom: 120px; position: fixed;">
        <i class="glyphicon glyphicon-trash" title="Удалить"></i>
    </div>

</div>


</body>
</html>
