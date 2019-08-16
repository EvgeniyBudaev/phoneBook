<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!doctype html>
<html lang="ru">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap&subset=cyrillic"
          rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/usersWithNumbers.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="/js/functions.js"></script>

    <title>Список с номерами</title>
</head>

<body>


<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h5>Список всех пользователей с телефонными номерами</h5>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <a class="a-na-glavnuu" href="/index.jsp">На главную</a>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="user-list-div">
                <div class="display-flex mobile-div">

                    <div class="button">
                        <form method="get" action="/createRecord">
                            <input type="submit" class="black-button small-button" value="Добавить запись">
                        </form>
                    </div>

                    <form action="/allUsersWithNumbers" method="post" id="delete-user-form">
                        <input type="hidden" name="idUser" id="idUserDisc">
                    <div class="button">
                        <div><input type="submit" class="black-button small-button" value="Удалить запись"
                                    onclick="deleteRecord()"></div>
                    </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>


<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <table>

                <thead>
                <tr>
                    <th></th>
                    <th>Фамилия</th>
                    <th>Имя</th>
                    <th>Отчество</th>
                    <th>Телефонный номер</th>
                </tr>
                </thead>

                <tbody>

                <c:forEach items="${usersWithNumbers}" var="entry">
                    <tr>
                        <td><input type="checkbox" id="2" value="${entry.key.id}"></td>
                        <td>${entry.key.surname}</td>
                        <td>${entry.key.name}</td>
                        <td>${entry.key.patronymic}</td>
                        <td>${entry.value}</td>
                    </tr>
                </c:forEach>

                </tbody>

            </table>

        </div>
    </div>
</div>

</body>

</html>