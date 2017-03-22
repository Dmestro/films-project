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
</head>
<body>
<jsp:useBean id="filmDAO" scope="page" class="dao.FilmDAO" />
<c:set var="myName" value="Alex"/>
<h1>${myName}</h1>
${textA}
${textB}
${filmDAO.getFilm().getTitle()}
</body>
</html>
