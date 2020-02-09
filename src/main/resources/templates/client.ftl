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
<div>
    <a href="/">На главную</a>
</div>
<div>
    <a href="/client/add">Добавить Клиента</a>
</div>
<b>Clients:</b>
<#list clients as client>
    <br/>
    <div class="brd-employee">
        <div>
            Name: ${client.name}
        </div>
        <div>
            Surname: ${client.surname}
        </div>
        <div>
            Patronymic: ${client.patronymic}
        </div>
        <div>
            Passport: ${client.passport}
        </div>
        <div>
            Experience: ${client.experience}
        </div>
        <div>
            Phone Number: ${client.phoneNumber}
        </div>
        <div>
            Adress: ${client.adress}
        </div>

        <div>
            <a href="/client/reduct/${client.id}">Редактировать</a>
        </div>
        <div>
            <a href="/client/delete/${client.id}">Удалить</a>
        </div>
    </div>
</#list>
