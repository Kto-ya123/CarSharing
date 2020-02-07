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
        <div>
            <a href="/employee/redact/${employee.id}">Редактировать</a>
        </div>
    </div>
</#list>
<div>
    <a href="/">На главную</a>
</div>