<style>
    .brd {
        border: 4px double black; /* Параметры границы */
        background: #fc3; /* Цвет фона */
        padding: 10px; /* Поля вокруг текста */
    }
</style>
<#list subdivisions as subdivision>
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

        <div>
            <a href="/subdivision/${subdivision.id}">Просмотреть</a>
        </div>
        <div>
            <a href="/subdivision/redact/${subdivision.id}">Редактировать</a>
        </div>
        <div>
            <a href="/subdivision/delete/${subdivision.id}">Удалить</a>
        </div>
    </div>
</#list>
        <br/>
    <div>
        <a href="/subdivision/add">Добавить подразделение</a>
    </div>
    <div>
        <a href="/">Назад</a>
    </div>