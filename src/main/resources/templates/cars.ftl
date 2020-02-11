<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
>
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
                <form action="/cars/add" method="post">
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
                                    <form>
                                        <div class="input-group mb-3 input-group-sm">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">Model</span>
                                            </div>
                                            <input type="text" name="model" class="form-control">
                                        </div>
                                        <div class="input-group mb-3 input-group-sm">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">Color</span>
                                            </div>
                                            <input type="text" name="color" class="form-control">
                                        </div>
                                        <div class="input-group mb-3 input-group-sm">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">Body type</span>
                                            </div>
                                            <select name="bodyType" class="custom-select mb-1">
                                                <option selected value="sedan">Sedan</option>
                                                <option value="miniven">Minivan</option>
                                                <option value="coup">Coup</option>
                                                <option value="hatchback">Hatchback</option>
                                                <option value="liftback">Liftback</option>
                                                <option value="universalis">Universal</option>
                                            </select>
                                        </div>
                                        <div class="input-group mb-3 input-group-sm">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">Transmission</span>
                                            </div>
                                            <select name="transmission" class="custom-select mb-1">
                                                <option selected value="Auto">Automatic transmission</option>
                                                <option value="Manual">Manual transmission</option>
                                            </select>
                                        </div>
                                        <div class="input-group mb-3 input-group-sm">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">Vehicle number</span>
                                            </div>
                                            <input type="text" name="vehicleNumber" class="form-control">
                                        </div>
                                        <div class="input-group mb-3 input-group-sm">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">Status</span>
                                            </div>
                                            <form>
                                                <select name="isFree" class="custom-select mb-1">
                                                    <option selected value="false">Booked</option>
                                                    <option value="true">Free</option>
                                                </select>
                                            </form>
                                        </div>
                                        <div class="input-group mb-3 input-group-sm">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">Price per day rent</span>
                                            </div>
                                            <input type="number" name="price" class="form-control">
                                        </div>
                                    </form>
                                </div>

                                <!-- Modal footer -->
                                <div class="modal-footer">
                                    <button class="btn btn-outline-success p-2" type="submit">Save</button>
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
            <th scope="col">Model</th>
            <th scope="col">Color</th>
            <th scope="col">Body type</th>
            <th scope="col">Transmission</th>
            <th scope="col">Vehicle number</th>
            <th scope="col">Status</th>
            <th scope="col">Price</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <#list cars as car>
            <tr class="text-left">
                <td>${car.model}</td>
                <td>${car.color}</td>
                <td>${car.bodyType}</td>
                <td>${car.transmission}</td>
                <td>${car.vehicleNumber}</td>
                <td>${car.isFree?c}</td>
                <td>${car.price}</td>
                <td>
                    <a class="nav-link" data-toggle="modal" data-target="#reduct${car.id}">Update</a>
                    <!-- The Modal -->
                    <form action="/cars/reduct/${car.id}" method="post">
                        <div class="modal fade" id="reduct${car.id}">
                            <div class="modal-dialog">
                                <div class="modal-content">

                                    <!-- Modal Header -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">Updating</h4>
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>

                                    <!-- Modal body -->
                                    <div class="modal-body">
                                        <form>
                                            <div class="input-group mb-3 input-group-sm">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Model</span>
                                                </div>
                                                <input type="text" name="model" value="${car.model}"
                                                       class="form-control">
                                            </div>
                                            <div class="input-group mb-3 input-group-sm">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Color</span>
                                                </div>
                                                <input type="text" name="color" value="${car.color}"
                                                       class="form-control">
                                            </div>
                                            <div class="input-group mb-3 input-group-sm">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Body type</span>
                                                </div>
                                                <select name="bodyType" class="custom-select mb-1">
                                                    <option selected value="sedan">Sedan</option>
                                                    <option value="miniven">Minivan</option>
                                                    <option value="coup">Coup</option>
                                                    <option value="hatchback">Hatchback</option>
                                                    <option value="liftback">Listback</option>
                                                    <option value="universalis">Universal</option>
                                                </select>
                                            </div>
                                            <div class="input-group mb-3 input-group-sm">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Transmission</span>
                                                </div>
                                                <select name="transmission" class="custom-select mb-1">
                                                    <option selected value="Auto">Automatic transmission</option>
                                                    <option value="Manual">Manual transmission</option>
                                                </select>
                                            </div>
                                            <div class="input-group mb-3 input-group-sm">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Vehicle number</span>
                                                </div>
                                                <input type="text" name="vehicleNumber" value="${car.vehicleNumber}"
                                                       class="form-control">
                                            </div>
                                            <div class="input-group mb-3 input-group-sm">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Status</span>
                                                </div>
                                                <form>
                                                    <select name="isFree" class="custom-select mb-1">
                                                        <option selected value="false">Free</option>
                                                        <option value="true">Booked</option>
                                                    </select>
                                                </form>
                                            </div>
                                            <div class="input-group mb-3 input-group-sm">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Price per day rent</span>
                                                </div>
                                                <input type="number" name="price" value="${car.price}"
                                                       class="form-control">
                                            </div>
                                        </form>
                                    </div>

                                    <!-- Modal footer -->
                                    <div class="modal-footer">
                                        <button class="btn btn-outline-success p-2" type="submit">Update</button>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </form>
                    <a class="nav-link" href="/cars/delete/${car.id}">Delete</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>