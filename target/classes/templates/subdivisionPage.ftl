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
    .brd-tech {
        border: 4px double black; /* Параметры границы */
        background: #1e7e34; /* Цвет фона */
        padding: 10px; /* Поля вокруг текста */
    }
</style>
    <br/>
    <div class="brd">
        <div>
            <b>Number: ${subdivision.id}</b>
        </div>
        <div>
            Name: ${subdivision.name}
        </div>
        <div>
            FullName: ${subdivision.fullName}
        </div>
    </div>
        <br/>
    <b>Employees:</b>
    <#list employees as employee>
        <br/>
        <div class="brd-employee">
            <div>
                <b>Name: ${employee.name}</b>
            </div>
            <div>
                Position: ${employee.position}
            </div>
            <div>
                Subdivision: ${employee.subdivision.name}
            </div>
        </div>
    </#list>
    <br/>
        <b>Flats:</b>
    <#list flats as flat>
        <br/>
        <div class="brd-flat">
            <div>
                <b>Number: ${flat.id}</b>
            </div>
            <div>
                Square: ${flat.square}
            </div>
        </div>
    </#list>
    </br>
        <b>Technics:</b>
    <#list technicses as technics>
        <br/>
        <div class="brd-tech">
            <div>
                <b>IdNumber: ${technics.idNumber}</b>
            </div>
            <div>
                Title: ${technics.title}
            </div>
            <div>
                Model: ${technics.model}
            </div>
            <div>
                Date: ${technics.datePurchase}
            </div>
            <div>
                Cash: ${technics.cash}
            </div>
            <div>
                Subdivision: ${technics.flat.subdivision.name}
            </div>
            <div>
                Flat: ${technics.flat.id}
            </div>
        </div>
    </#list>
<div>
    <a href="/subdivision">Назад</a>
</div>



