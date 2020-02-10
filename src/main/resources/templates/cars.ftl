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
                <form action="/cars/add" method="post" >
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
                                <form>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Модель</span>
                                        </div>
                                        <input type="text" name="model" class="form-control">
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Цвет</span>
                                        </div>
                                        <input type="text" name="color" class="form-control">
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Тип</span>
                                        </div>
                                        <select name="bodyType" class="custom-select mb-1">
                                            <option selected value="sedan">Седан</option>
                                            <option value="miniven">Минивен</option>
                                            <option value="coup">Купе</option>
                                            <option value="hatchback">Хэтчбек</option>
                                            <option value="liftback">Лифтбек</option>
                                            <option value="universalis">Универсал</option>
                                        </select>
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Трансмиссия</span>
                                        </div>
                                        <select name="transmission" class="custom-select mb-1">
                                            <option selected value="Auto">АКПП</option>
                                            <option value="Manual">МКПП</option>
                                        </select>
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Номер</span>
                                        </div>
                                        <input type="text" name="vehicleNumber" class="form-control">
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Статус</span>
                                        </div>
                                        <form>
                                            <select name="isFree" class="custom-select mb-1">
                                                <option selected value="false">Занята</option>
                                                <option value="true">Свободна</option>
                                            </select>
                                        </form>
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Цена за сутки аренды</span>
                                        </div>
                                        <input type="number" name="price" class="form-control">
                                    </div>
                                </form>
                            </div>

                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <button class="btn btn-outline-success p-2" type="submit">Сохранить</button>
                            </div>

                        </div>
                    </div>
                </div>
                </form>
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
            <th scope="col">Модель</th>
            <th scope="col">Цвет</th>
            <th scope="col">Тип</th>
            <th scope="col">Трансмиссия</th>
            <th scope="col">Номер</th>
            <th scope="col">Статус</th>
            <th scope="col">Цена</th>
            <th scope="col">Действие</th>
        </tr>
        </thead>
        <tbody>
        <#list cars as car>
            <tr class ="text-left">
                <td>${car.model}</td>
                <td>${car.color}</td>
                <td>${car.bodyType}</td>
                <td>${car.transmission}</td>
                <td>${car.vehicleNumber}</td>
                <td>${car.isFree?c}</td>
                <td>${car.price}</td>
                <td>
                    <a class="nav-link" data-toggle="modal" data-target="#reduct${car.id}">Изменить</a>
                    <!-- The Modal -->
                    <form action="/cars/reduct/${car.id}" method="post" >
                        <div class="modal fade" id="reduct${car.id}">
                            <div class="modal-dialog">
                                <div class="modal-content">

                                    <!-- Modal Header -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">Редактирование</h4>
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>

                                    <!-- Modal body -->
                                    <div class="modal-body">
                                        <form>
                                            <div class="input-group mb-3 input-group-sm">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Модель</span>
                                                </div>
                                                <input type="text" name="model" value="${car.model}" class="form-control">
                                            </div>
                                            <div class="input-group mb-3 input-group-sm">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Цвет</span>
                                                </div>
                                                <input type="text" name="color" value="${car.color}" class="form-control">
                                            </div>
                                            <div class="input-group mb-3 input-group-sm">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Тип</span>
                                                </div>
                                                <select name="bodyType" class="custom-select mb-1">
                                                    <option selected value="sedan">Седан</option>
                                                    <option value="miniven">Минивен</option>
                                                    <option value="coup">Купе</option>
                                                    <option value="hatchback">Хэтчбек</option>
                                                    <option value="liftback">Лифтбек</option>
                                                    <option value="universalis">Универсал</option>
                                                </select>
                                            </div>
                                            <div class="input-group mb-3 input-group-sm">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Трансмиссия</span>
                                                </div>
                                                <select name="transmission" class="custom-select mb-1">
                                                    <option selected value="Auto">АКПП</option>
                                                    <option value="Manual">МКПП</option>
                                                </select>
                                            </div>
                                            <div class="input-group mb-3 input-group-sm">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Номер</span>
                                                </div>
                                                <input type="text" name="vehicleNumber" value="${car.vehicleNumber}" class="form-control">
                                            </div>
                                            <div class="input-group mb-3 input-group-sm">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Статус</span>
                                                </div>
                                                <form>
                                                    <select name="isFree" class="custom-select mb-1">
                                                        <option selected value="false">Занята</option>
                                                        <option value="true">Свободна</option>
                                                    </select>
                                                </form>
                                            </div>
                                            <div class="input-group mb-3 input-group-sm">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Цена за сутки аренды</span>
                                                </div>
                                                <input type="number" name="price" value="${car.price}" class="form-control">
                                            </div>
                                        </form>
                                    </div>

                                    <!-- Modal footer -->
                                    <div class="modal-footer">
                                        <button class="btn btn-outline-success p-2" type="submit">Сохранить</button>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </form>
            <a class="nav-link" href="/cars/delete/${car.id}">Удалить</a>
            </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>