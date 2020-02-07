<style>
    .brd {
        border: 4px double black; /* Параметры границы */
        background: #fc3; /* Цвет фона */
        padding: 10px; /* Поля вокруг текста */
    }
    .brd-flat {
        border: 4px double black; /* Параметры границы */
        background: #17a2b8; /* Цвет фона */
        padding: 10px; /* Поля вокруг текста */
    }
    .brd-employee {
        border: 4px double black; /* Параметры границы */
        background: #856404; /* Цвет фона */
        padding: 10px; /* Поля вокруг текста */
    }
</style>
<b>Cars:</b>
<#list cars as car>
    <br/>
    <div class="brd-employee">
        <div>
            Model: ${car.model}
        </div>
        <div>
            Color: ${car.color}
        </div>
        <div>
            Body Type: ${car.bodyType}
        </div>
        <div>
            Transmission: ${car.transmission}
        </div>
        <div>
            Venicle Number: ${car.bodyType}
        </div>
        <div>
            Status: ${car.isFree}
        </div>
        <div>
            Price: ${car.price}
        </div>

    </div>
</#list>
<div>
    <a href="/">На главную</a>
</div>