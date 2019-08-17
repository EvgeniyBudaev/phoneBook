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
    <link rel="stylesheet" href="css/deleteRecord.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="/js/functions.js"></script>

    <title>Добавить запись</title>
</head>

<body>


<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h5>Добавление записи</h5>
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
            <form method="post" action="/deleteRecord">
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
                    <tr>
                        <input type="hidden" name="id" value="${id}">
                        <td></td>
                        <td><input name="surname" type="text" autocomplete="off"></td>
                        <td><input name="name" type="text" autocomplete="off"></td>
                        <td><input name="patronymic" type="text" autocomplete="off"></td>
                        <td><input name="phoneNumber" type="text" autocomplete="off"></td>
                    </tr>

                    <div class="container">
                        <div class="row">
                            <div class="col-sm-12">
                    <div class="display-flex btn "><input type="submit" value="Создать"></div>
                            </div>
                        </div>
                    </div>
                </tbody>

                <c:if test="${error eq '1'}">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="display-flex error">
                                    <div class="text-error">
                                        <p class="color-text-error">Поля Ф.И.О. должны быть заполнены!</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>

            </table>
            </form>
        </div>
    </div>
</div>

</body>

</html>