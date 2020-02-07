    <style>
        .brd {
            border: 4px double black; /* Параметры границы */
            background: #fc3; /* Цвет фона */
            padding: 10px; /* Поля вокруг текста */
        }
    </style>
    <div class="brd">
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
    </br>
    <form action="/employee/redact/${employee.id}" method="post">
        <div><label> Name : <input type="text" name="name"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div><input type="submit" value="Обновить"/></div>
    </form>
    <form action="/employee/delete/${employee.id}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div><input type="submit" value="Удалить"/></div>
    </form>
    <div>
        <a href="/employee">Назад</a>
    </div>
