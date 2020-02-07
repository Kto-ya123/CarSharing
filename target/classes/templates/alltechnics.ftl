<style>
    .brd {
        border: 4px double black; /* Параметры границы */
        background: #fc3; /* Цвет фона */
        padding: 10px; /* Поля вокруг текста */
    }
</style>
<#list technicses as technics>
    <br/>
    <div class="brd">
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
            <a href="/tech/redact/${technics.idNumber}">Редактировать</a>
        </div>
        <div>
            <a href="/broadcast/${technics.idNumber}">Переместить</a>
        </div>
        <div>
            <a href="/tech/delete/${technics.idNumber}">Удалить</a>
        </div>
    </div>
</#list>
        <br/>
    <div>
        <a href="/tech/add">Добавить Технику</a>
    </div>
<div>
    <a href="/">Назад</a>
</div>
