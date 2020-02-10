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
                                <h4 class="modal-title">Добавление</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <!-- Modal body -->
                            <div class="modal-body">
                                <form action="/contracts/add" method="post">
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Клиент</span>
                                        </div>
                                        <select name="client" class="custom-select mb-1">
                                            <#list clients as client>
                                                <option selected value="${client.id}">${client.surname} ${client.name}</option>
                                            </#list>
                                        </select>
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Автомобиль</span>
                                        </div>
                                        <select name="car" class="custom-select mb-1">
                                            <#list cars as car>
                                                <option selected value="${car.id}">${car.model} ${car.vehicleNumber} ${car.price}BYN</option>
                                            </#list>
                                        </select>
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Дата начала аренды</span>
                                        </div>
                                        <input type="date" name="dateOfStart" class="form-control">
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Дата конца аренды</span>
                                        </div>
                                        <input type="date" name="dateOfEnd" class="form-control">
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
            </li>
        </ul>
    </div>
</nav>
<br>
<div class="container">
    <table class="table table-hover table-light">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Клиент</th>
            <th scope="col">Номер автомобиля</th>
            <th scope="col">Дата начала аренды</th>
            <th scope="col">Дата конца аренды</th>
            <th scope="col">Стоимость</th>
            <th scope="col">Действие</th>
        </tr>
        </thead>
        <tbody>
        <#list contracts as contract>
            <tr class ="text-left">
                <td>${contract.client.surname}</td>
                <td>${contract.car.vehicleNumber}</td>
                <td>${contract.dateOfStart?date}</td>
                <td>${contract.dateOfEnd?date}</td>
                <td>${contract.totalCost}</td>
                <td>
                    <a class="nav-link" data-toggle="modal" data-target="#reduct${contract.id}">Изменить</a>
                    <!-- The Modal -->
                    <div class="modal fade" id="reduct${contract.id}">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title">Редактирование</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>

                                <!-- Modal body -->
                                <div class="modal-body">
                                    <form action="/contracts/reduct/${contract.id}" method="post">
                                        <div class="input-group mb-3 input-group-sm">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">Клиент</span>
                                            </div>
                                            <select name="client" class="custom-select mb-1">
                                                <#list clients as client>
                                                    <option selected value="${client.id}">${client.surname} ${client.name}</option>
                                                </#list>
                                            </select>
                                        </div>
                                        <div class="input-group mb-3 input-group-sm">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">Автомобиль</span>
                                            </div>
                                            <select name="car" class="custom-select mb-1">
                                                <#list cars as car>
                                                    <option selected value="${car.id}">${car.model} ${car.vehicleNumber} ${car.price}BYN</option>
                                                </#list>
                                            </select>
                                        </div>
                                        <div class="input-group mb-3 input-group-sm">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">Дата начала аренды</span>
                                            </div>
                                            <input type="date" name="dateOfStart" value="${contract.dateOfStart}" class="form-control">
                                        </div>
                                        <div class="input-group mb-3 input-group-sm">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">Дата конца аренды</span>
                                            </div>
                                            <input type="date" name="dateOfEnd" value="${contract.dateOfEnd}" class="form-control">
                                        </div>
                                        <div class="input-group mb-3 input-group-sm">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">Стоимость</span>
                                            </div>
                                            <input type="number" name="totalCost" value="${contract.totalCost}" class="form-control">
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
                    <a class="nav-link" href="/contracts/delete/${contract.id}">Удалить</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>