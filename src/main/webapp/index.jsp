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
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap&subset=cyrillic" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="/js/functions.js"></script>

    <title>Телефонный справочник</title>
</head>

<body>


<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h5>Прототип телефонного справочника</h5>
        </div>
    </div>
</div>


<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="user-list-div">
                <div class="display-flex mobile-div">

                    <div class="button">
                        <form method="get" action="/allUsers">
                            <input class="black-button big-button" type="submit" value="Показать весь список пользователей">
                        </form>
                    </div>

                    <div class="button">
                        <form method="get" action="/allUsersWithNumbers">
                            <input type="hidden" name="userId" value="${id}">
                            <input class="black-button big-button" type="submit" value="Показать список пользователей с телефонными номерами">
                        </form>
                    </div>

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
                    <th>Номер телефона</th>
                </tr>
                </thead>



            </table>

        </div>
    </div>
</div>

</body>

</html>