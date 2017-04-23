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
    <script src="js/update_film.js"></script>
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
        <form role="form-horizontal">
            <div class="form-group">
                <label for="title">Название фильма</label>
                <input type="text" class="form-control" id="title" placeholder="Введите название фильма">
            </div>
            <div class="form-group">
                <label for="trailer">Трейлер</label>
                <input type="url" class="form-control" id="trailer" placeholder="Введите YOUTUBE URL">
            </div>
        </form>

        <div style="margin-bottom: 20px;">
            <form class="form-inline" role="form">
                <div class="form-group col-md-4">
                    <label for="years">Год выпуска</label>
                    <select class="form-control" id="years">
                    </select>
                </div>
                <div class="form-group col-md-4">
                    <label for="raiting">Рейтинг</label>
                    <select class="form-control" id="raiting">
                    </select>
                </div>
            </form>
        </div>



        <form class="form description-form" role="form">
            <div class="form-group">
                <label for="description">Описание</label>
                <textarea class="form-control" rows="5" id="description"></textarea>
            </div>
        </form>


        <div class="col-md-12 add-prop-panel-outer">
            <div class="col-md-3">
                <button type="button" class="btn btn-primary add-prop-btn" id="add-actors-button" data-toggle="modal" data-target="#modal-actors">Добавить актеров</button>
            </div>
            <div class="col-md-9 add-prop-panel">
                <div class="panel panel-default add-prop-panel">
                    <div class="panel-body" id="actors-list">
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-12 add-prop-panel-outer">
            <div class="col-md-3">
                <button type="button" class="btn btn-primary add-prop-btn" id="add-producers-button" data-toggle="modal" data-target="#modal-producers">Изменить режиссеров</button>
            </div>
            <div class="col-md-9 add-prop-panel">
                <div class="panel panel-default add-prop-panel">
                    <div class="panel-body" id="producers-list">
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-12 add-prop-panel-outer">
            <div class="col-md-3">
                <button type="button" class="btn btn-primary add-prop-btn" id="add-genres-button" data-toggle="modal" data-target="#modal-genres">Изменить жанры</button>
            </div>
            <div class="col-md-9 add-prop-panel" >
                <div class="panel panel-default add-prop-panel">
                    <div class="panel-body" id="genres-list">
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-12 add-prop-panel-outer">
            <div class="col-md-3">
                <button type="button" class="btn btn-primary add-prop-btn" id="add-countries-button" data-toggle="modal" data-target="#modal-countries">Изменить страны</button>
            </div>
            <div class="col-md-9 add-prop-panel">
                <div class="panel panel-default add-prop-panel">
                    <div class="panel-body" id="countries-list">
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-12" style="margin-top: 20px; margin-bottom:40px;">
        <div class="col-md-6 col-md-offset-3">
            <button type="button" class="btn btn-success" id="add-film-button">Обновить</button>
            <a href="index.jsp" class="btn btn-danger" id="cancel-film-button">Отмена</a>
        </div>
    </div>
</div>


<div class="modal fade" tabindex="-1" role="dialog" id="modal-actors">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Актеры</h4>
            </div>
            <div class="modal-body">
                <table class="table table-hover table-actors">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Имя</th>
                        <th>Фамилия</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                <button type="button" class="btn btn-primary" id="add-actors-dialog-btn">Добавить</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<div class="modal fade" tabindex="-1" role="dialog" id="modal-producers">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Режиссеры</h4>
            </div>
            <div class="modal-body">
                <table class="table table-hover table-producers">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Имя</th>
                        <th>Фамилия</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                <button type="button" class="btn btn-primary" id="add-producers-dialog-btn">Добавить</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<div class="modal fade" tabindex="-1" role="dialog" id="modal-genres">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Жанры</h4>
            </div>
            <div class="modal-body">
                <table class="table table-hover table-genres">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Жанр</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                <button type="button" class="btn btn-primary" id="add-genres-dialog-btn">Добавить</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<div class="modal fade" tabindex="-1" role="dialog" id="modal-countries">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Страны</h4>
            </div>
            <div class="modal-body">
                <table class="table table-hover table-countries">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Страна</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                <button type="button" class="btn btn-primary" id="add-countries-dialog-btn">Добавить</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


</body>
</html>
