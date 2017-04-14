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
                <li><a href="genres.jsp">Жанры</a></li>
                <li><a href="countries.jsp">Страны</a></li>
                <li><a href="peoples.jsp">Люди</a></li>
            </ul>
        </div>

    </nav>
</div>
<div class="container" style="margin-top: 100px">
    <div class="col-md-10 col-md-offset-1">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4>Рыцарь в доспехах </h4>
                <div style="position:absolute; top:0px;right:30px;">
                    <h3>Год: 2017</h3>
                </div>
            </div>
            <div class="panel-body">
                <div class="col-md-4">
                    <iframe width="100%" height="50%" src="https://www.youtube.com/embed/J3QyMIRAU20" frameborder="0" allowfullscreen></iframe>
                </div>
                <div class="col-md-8">
                    <div class="col-md-12">
                        <span class="label label-warning">В ролях:</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                    </div>
                    <div class="col-md-12" style="margin-top:35px;"><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam, architecto asperiores blanditiis cupiditate ea earum eum explicabo fugiat impedit incidunt libero magnam natus obcaecati optio porro qui, ratione ut voluptate! Lorem ipsum dolor sit amet, consectetur adipisicing elit. A aliquid, atque consectetur consequuntur debitis earum fugit impedit maxime nesciunt, officia optio quasi quia similique sit sunt tempore ullam, ut veritatis!</p></div>
                    <div class="col-md-offset-9 col-md-1"><a href="" class="btn btn-primary">Подробнее>></a></div>
                </div>
            </div>
            <div class="panel-footer">
                <span class="label label-info">Комедия</span>
                <span class="label label-info">фентези</span>
                <span class="label label-info">драмма</span>
                <div style="position:absolute; right:30px; bottom:30px;">
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart-empty"></i>
                    <i class="glyphicon glyphicon-heart-empty"></i>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-10 col-md-offset-1">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4>Рыцарь в доспехах </h4>
                <div style="position:absolute; top:0px;right:30px;">
                    <h3>Год: 2017</h3>
                </div>
            </div>
            <div class="panel-body">
                <div class="col-md-4">
                    <iframe width="100%" height="50%" src="https://www.youtube.com/embed/J3QyMIRAU20" frameborder="0" allowfullscreen></iframe>
                </div>
                <div class="col-md-8">
                    <div class="col-md-12">
                        <span class="label label-warning">В ролях:</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                    </div>
                    <div class="col-md-12" style="margin-top:35px;"><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam, architecto asperiores blanditiis cupiditate ea earum eum explicabo fugiat impedit incidunt libero magnam natus obcaecati optio porro qui, ratione ut voluptate! Lorem ipsum dolor sit amet, consectetur adipisicing elit. A aliquid, atque consectetur consequuntur debitis earum fugit impedit maxime nesciunt, officia optio quasi quia similique sit sunt tempore ullam, ut veritatis!</p></div>
                    <div class="col-md-offset-9 col-md-1"><a href="" class="btn btn-primary">Подробнее>></a></div>
                </div>
            </div>
            <div class="panel-footer">
                <span class="label label-info">Комедия</span>
                <span class="label label-info">фентези</span>
                <span class="label label-info">драмма</span>
                <div style="position:absolute; right:30px; bottom:30px;">
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart-empty"></i>
                    <i class="glyphicon glyphicon-heart-empty"></i>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-10 col-md-offset-1">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4>Рыцарь в доспехах </h4>
                <div style="position:absolute; top:0px;right:30px;">
                    <h3>Год: 2017</h3>
                </div>
            </div>
            <div class="panel-body">
                <div class="col-md-4">
                    <iframe width="100%" height="50%" src="https://www.youtube.com/embed/J3QyMIRAU20" frameborder="0" allowfullscreen></iframe>
                </div>
                <div class="col-md-8">
                    <div class="col-md-12">
                        <span class="label label-warning">В ролях:</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                    </div>
                    <div class="col-md-12" style="margin-top:35px;"><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam, architecto asperiores blanditiis cupiditate ea earum eum explicabo fugiat impedit incidunt libero magnam natus obcaecati optio porro qui, ratione ut voluptate! Lorem ipsum dolor sit amet, consectetur adipisicing elit. A aliquid, atque consectetur consequuntur debitis earum fugit impedit maxime nesciunt, officia optio quasi quia similique sit sunt tempore ullam, ut veritatis!</p></div>
                    <div class="col-md-offset-9 col-md-1"><a href="" class="btn btn-primary">Подробнее>></a></div>
                </div>
            </div>
            <div class="panel-footer">
                <span class="label label-info">Комедия</span>
                <span class="label label-info">фентези</span>
                <span class="label label-info">драмма</span>
                <div style="position:absolute; right:30px; bottom:30px;">
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart-empty"></i>
                    <i class="glyphicon glyphicon-heart-empty"></i>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-10 col-md-offset-1">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4>Рыцарь в доспехах </h4>
                <div style="position:absolute; top:0px;right:30px;">
                    <h3>Год: 2017</h3>
                </div>
            </div>
            <div class="panel-body">
                <div class="col-md-4">
                    <iframe width="100%" height="50%" src="https://www.youtube.com/embed/J3QyMIRAU20" frameborder="0" allowfullscreen></iframe>
                </div>
                <div class="col-md-8">
                    <div class="col-md-12">
                        <span class="label label-warning">В ролях:</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                    </div>
                    <div class="col-md-12" style="margin-top:35px;"><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam, architecto asperiores blanditiis cupiditate ea earum eum explicabo fugiat impedit incidunt libero magnam natus obcaecati optio porro qui, ratione ut voluptate! Lorem ipsum dolor sit amet, consectetur adipisicing elit. A aliquid, atque consectetur consequuntur debitis earum fugit impedit maxime nesciunt, officia optio quasi quia similique sit sunt tempore ullam, ut veritatis!</p></div>
                    <div class="col-md-offset-9 col-md-1"><a href="" class="btn btn-primary">Подробнее>></a></div>
                </div>
            </div>
            <div class="panel-footer">
                <span class="label label-info">Комедия</span>
                <span class="label label-info">фентези</span>
                <span class="label label-info">драмма</span>
                <div style="position:absolute; right:30px; bottom:30px;">
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart-empty"></i>
                    <i class="glyphicon glyphicon-heart-empty"></i>
                </div>
            </div>
        </div>
    </div>


    <div class="col-md-10 col-md-offset-1">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4>Рыцарь в доспехах </h4>
                <div style="position:absolute; top:0px;right:30px;">
                    <h3>Год: 2017</h3>
                </div>
            </div>
            <div class="panel-body">
                <div class="col-md-4">
                    <iframe width="100%" height="50%" src="https://www.youtube.com/embed/J3QyMIRAU20" frameborder="0" allowfullscreen></iframe>
                </div>
                <div class="col-md-8">
                    <div class="col-md-12">
                        <span class="label label-warning">В ролях:</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                    </div>
                    <div class="col-md-12" style="margin-top:35px;"><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam, architecto asperiores blanditiis cupiditate ea earum eum explicabo fugiat impedit incidunt libero magnam natus obcaecati optio porro qui, ratione ut voluptate! Lorem ipsum dolor sit amet, consectetur adipisicing elit. A aliquid, atque consectetur consequuntur debitis earum fugit impedit maxime nesciunt, officia optio quasi quia similique sit sunt tempore ullam, ut veritatis!</p></div>
                    <div class="col-md-offset-9 col-md-1"><a href="" class="btn btn-primary">Подробнее>></a></div>
                </div>
            </div>
            <div class="panel-footer">
                <span class="label label-info">Комедия</span>
                <span class="label label-info">фентези</span>
                <span class="label label-info">драмма</span>
                <div style="position:absolute; right:30px; bottom:30px;">
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart-empty"></i>
                    <i class="glyphicon glyphicon-heart-empty"></i>
                </div>
            </div>
        </div>
    </div>


    <div class="col-md-10 col-md-offset-1">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4>Рыцарь в доспехах </h4>
                <div style="position:absolute; top:0px;right:30px;">
                    <h3>Год: 2017</h3>
                </div>
            </div>
            <div class="panel-body">
                <div class="col-md-4">
                    <iframe width="100%" height="50%" src="https://www.youtube.com/embed/J3QyMIRAU20" frameborder="0" allowfullscreen></iframe>
                </div>
                <div class="col-md-8">
                    <div class="col-md-12">
                        <span class="label label-warning">В ролях:</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                        <span class="label label-default">Скарлет Иоххансон</span>
                        <span class="label label-default">Джорд Питт</span>
                        <span class="label label-default">Анджелика Варум</span>
                    </div>
                    <div class="col-md-12" style="margin-top:35px;"><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam, architecto asperiores blanditiis cupiditate ea earum eum explicabo fugiat impedit incidunt libero magnam natus obcaecati optio porro qui, ratione ut voluptate! Lorem ipsum dolor sit amet, consectetur adipisicing elit. A aliquid, atque consectetur consequuntur debitis earum fugit impedit maxime nesciunt, officia optio quasi quia similique sit sunt tempore ullam, ut veritatis!</p></div>
                    <div class="col-md-offset-9 col-md-1"><a href="" class="btn btn-primary">Подробнее>></a></div>
                </div>
            </div>
            <div class="panel-footer">
                <span class="label label-info">Комедия</span>
                <span class="label label-info">фентези</span>
                <span class="label label-info">драмма</span>
                <div style="position:absolute; right:30px; bottom:30px;">
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart"></i>
                    <i class="glyphicon glyphicon-heart-empty"></i>
                    <i class="glyphicon glyphicon-heart-empty"></i>
                </div>
            </div>
        </div>
    </div>




</div>
<div id="films-add-button" class="action-button"><i class="glyphicon glyphicon-plus" title="Добавить фильм"></i></div>

</body>
</html>
