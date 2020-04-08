<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
>
<head>
    <title>lab 2</title>

    <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/webjars/momentjs/2.24.0/moment.js"></script>
    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>


</head>
<body>
<div class="jumbotron text-center">
    <h1 style="color:Gray">CarSharing</h1>
    <div class="container-fluid">
        <div class="d-flex justify-content-center mt-5">
            <a href="/cars" class="btn btn-outline-secondary m-2">Cars</a>
            <a href="/clients" class="btn-outline-secondary btn m-2">Clients</a>
            <a href="/contracts" class="btn-outline-secondary btn m-2">Contracts</a>
            <a href="/accidents" class="btn-outline-secondary btn m-2">Accidents</a>
            <a class="btn-outline-secondary btn m-2" href="#" ng-click="logout()">Logout</a>
        </div>
    </div>
</div>
</body>
<style>
    /* Make the image fully responsive */
    .carousel-inner img {
        width: 100%;
        height: 100%;
        margin-top: -140px;
        z-index: -1;
    }
</style>
</head>
<body>

<div id="demo" class="carousel slide" data-ride="carousel">

    <!-- Indicators -->
    <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
    </ul>

    <!-- The slideshow -->
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://www.mercedes-benz.ru/passengercars/content-pool/marketing-pool/stage-homepage/homepage-2019/_jcr_content/par/stagepushableelement_1136026584.MQ6.12.20191206142312.jpeg"
                 alt="Lexus" width="1100" height="500">
        </div>
        <div class="carousel-item">
            <img src="https://files.porsche.com/filestore/image/multimedia/none/970-g2-4hy-modelimage-sideshot/model/75bba5f4-6044-11e9-80c4-005056bbdc38/porsche-model.png"
                 alt="Porche" width="1100" height="500">
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="carousel-control-prev" href="#demo" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#demo" data-slide="next">
        <span class="carousel-control-next-icon"></span>
    </a>
</div>
</body>
</html>
