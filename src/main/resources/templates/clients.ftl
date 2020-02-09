<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>

    <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/webjars/momentjs/2.24.0/moment.js"></script>
    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
            <li class="nav-item">
                <a class="nav-link" href="/">На главную</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="modal" data-target="#myModal">Добавить</a>
                <!-- The Modal -->
                <div class="modal fade" id="myModal">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Добавление.</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <!-- Modal body -->
                            <div class="modal-body">
                                <form  action="/clients/add" method="post">
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Фамилия</span>
                                        </div>
                                        <input type="text" name="surname" class="form-control">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Имя</span>
                                        </div>
                                        <input type="text" name="name" class="form-control">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Отчество</span>
                                        </div>
                                        <input type="text" name="patronymic" class="form-control">
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Паспортные данные</span>
                                    </div>
                                        <input type="text" name="passport" class="form-control">
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Стаж</span>
                                        </div>
                                        <input type="text" name="experience" class="form-control">
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Телефон</span>
                                        </div>
                                        <input type="text" name="phone" class="form-control">
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Адрес</span>
                                        </div>
                                        <input type="text" name="address" class="form-control">
                                    </div>
                                    <!-- Modal footer -->
                                    <div class="modal-footer">
                                        <button class="btn btn-outline-success p-2" type="submit">Сохранить</button>
                                    </div>
                                </form>
                            </div>



                        </div>
                    </div>
                </div>
            </li>
            </li>
        </ul>
    </div>
</nav>
<br>
<div class="container">
    <table class="table table-hover table-light">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Фамилия</th>
            <th scope="col">Имя</th>
            <th scope="col">Отчество</th>
            <th scope="col">Паспортные данные</th>
            <th scope="col">Стаж</th>
            <th scope="col">Телефон</th>
            <th scope="col">Домашний адрес</th>
            <th scope="col">Действие</th>
        </tr>
        </thead>
        <tbody>
        <tr class ="text-left">
            <td>Лузгина</td>
            <td>Виктория</td>
            <td>Валерьевна</td>
            <td>КН2471141</td>
            <td>2</td>
            <td>375298325741</td>
            <td>Держинского 95</td>
            <td>
                <a class="nav-link" href="#">Изменить</a>
                <a class="nav-link" href="#">Удалить</a>
            </td>
        </tr>
        <#list clients as client>
        <tr class ="text-left">
            <td>${client.surname}</td>
            <td>${client.name}</td>
            <td>${client.patronymic}</td>
            <td>${client.passport}</td>
            <td>${client.experience}</td>
            <td>${client.phoneNumber}</td>
            <td>${client.address}</td>
            <td>
                <a class="nav-link" href="#">Изменить</a>
                <a class="nav-link" href="#">Удалить</a>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>