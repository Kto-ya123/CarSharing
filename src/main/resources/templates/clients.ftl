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
                                <form  action="/clients/add" method="post">
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Surname</span>
                                        </div>
                                        <input type="text" name="surname" class="form-control">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Name</span>
                                        </div>
                                        <input type="text" name="name" class="form-control">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Patronymic</span>
                                        </div>
                                        <input type="text" name="patronymic" class="form-control">
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Passport data</span>
                                    </div>
                                        <input type="text" name="passport" class="form-control">
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Experience</span>
                                        </div>
                                        <input type="text" name="experience" class="form-control">
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Phone number</span>
                                        </div>
                                        <input type="text" name="phone" class="form-control">
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Address</span>
                                        </div>
                                        <input type="text" name="address" class="form-control">
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
        </ul>
    </div>
</nav>
<br>
<div class="container">
    <table class="table table-hover table-light">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Surname</th>
            <th scope="col">Name</th>
            <th scope="col">Patronymic</th>
            <th scope="col">Passport data</th>
            <th scope="col">Experience</th>
            <th scope="col">Phone number</th>
            <th scope="col">Address</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
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
                <a class="nav-link" data-toggle="modal" data-target="#reduct${client.id}">Update</a>
                <!-- The Modal -->
                <div class="modal fade" id="reduct${client.id}">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Updating</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <!-- Modal body -->
                            <div class="modal-body">
                                <form  action="/clients/reduct/${client.id}" method="post">
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Surname</span>
                                        </div>
                                        <input type="text" name="surname" value="${client.surname}" class="form-control">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Name</span>
                                        </div>
                                        <input type="text" name="name" value="${client.name}" class="form-control">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Patronymic</span>
                                        </div>
                                        <input type="text" name="patronymic" value="${client.patronymic}" class="form-control">
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Passport data</span>
                                        </div>
                                        <input type="text" name="passport" value="${client.passport}" class="form-control">
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Experience</span>
                                        </div>
                                        <input type="text" name="experience" value="${client.experience}" class="form-control">
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Phone number</span>
                                        </div>
                                        <input type="text" name="phone" value="${client.phoneNumber}" class="form-control">
                                    </div>
                                    <div class="input-group mb-3 input-group-sm">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">Address</span>
                                        </div>
                                        <input type="text" name="address" value="${client.address}" class="form-control">
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
                <a class="nav-link" href="/clients/delete/${client.id}">Delete</a>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>