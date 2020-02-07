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
<b>Broadcast:</b>
<#list broadcasts as broadcast>
    <br/>
    <div class="brd-employee">
        <div>
            <b>idTech: ${broadcast.technics.idNumber}</b>
        </div>
        <div>
            Date: ${broadcast.date}
        </div>
        <div>
            From Subdivision: ${broadcast.fromSubvision.name}
        </div>
        <div>
            To Subdivision: ${broadcast.toEmployee.subdivision.name}
        </div>
    </div>
</#list>
<div>
    <a href="/">На главную</a>
</div>