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
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="modal" data-target="#myModal">Add</a>
                <!-- The Modal -->
                <div class="modal fade" id="myModal">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Adding</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <!-- Modal body -->
                            <div class="modal-body">
                                <form action="/accidents/add" method="post">
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Contract number</span>
                                        </div>
                                        <select name="contract" class="custom-select mb-1">
                                            <#list contracts as contract>
                                                <option selected value="${contract.id}">${contract.id}-${contract.car.model}-${contract.car.vehicleNumber}</option>
                                            </#list>
                                        </select>
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Date of accident</span>
                                        </div>
                                        <input type="date" name="dateOfAccident" class="form-control">
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Cost of damage</span>
                                        </div>
                                        <input type="number" name="costOfDamage" class="form-control">
                                    </div>
                                    <!-- Modal footer -->
                                    <div class="modal-footer">
                                        <button class="btn btn-outline-success p-2" type="submit">Save</button>
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
            <th scope="col">Contact number</th>
            <th scope="col">Date of accident</th>
            <th scope="col">Cost of damage</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <#list accidents as accident>
            <tr class ="text-left">
                <td>${accident.contract.id}</td>
                <td>${accident.dateOfAccident?date}</td>
                <td>${accident.costOfDamage}</td>
                <td>
                    <a class="nav-link" data-toggle="modal" data-target="#reduct${accident.id}">Update</a>
                    <!-- The Modal -->
                    <div class="modal fade" id="reduct${accident.id}">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title">Updating</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>

                                <!-- Modal body -->
                                <div class="modal-body">
                                    <form action="/accidents/reduct/${accident.id}" method="post">
                                        <div class="input-group mb-3 input-group-sm">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">Contract number</span>
                                            </div>
                                            <select name="contract" class="custom-select mb-1">
                                                <#list contracts as contract>
                                                    <option selected value="${contract.id}">${contract.id}-${contract.car.model}-${contract.car.vehicleNumber}</option>
                                                </#list>
                                            </select>
                                        </div>
                                        <div class="input-group mb-3 input-group-sm">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">Date of accident</span>
                                            </div>
                                            <input type="date" name="dateOfAccident" class="form-control">
                                        </div>
                                        <div class="input-group mb-3 input-group-sm">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">Cost of damage</span>
                                            </div>
                                            <input type="number" name="costOfDamage" value="${accident.costOfDamage}" class="form-control">
                                        </div>
                                        <!-- Modal footer -->
                                        <div class="modal-footer">
                                            <button class="btn btn-outline-success p-2" type="submit">Update</button>
                                        </div>
                                    </form>
                                </div>



                            </div>
                        </div>
                    </div>
                    <a class="nav-link" href="/accidents/delete/${accident.id}">Delete</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>