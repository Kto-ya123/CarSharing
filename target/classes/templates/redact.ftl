    <style>
        .brd {
            border: 4px double black; /* Параметры границы */
            background: #fc3; /* Цвет фона */
            padding: 10px; /* Поля вокруг текста */
        }
    </style>
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
    </br>
    <form action="/subdivision/redact/${subdivision.id}" method="post">
        <div><label> Name : <input type="text" name="name"/> </label></div>
        <div><label> Full Name: <input type="text" name="fullName"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div><input type="submit" value="Обновить"/></div>
    </form>
    </br>
    <form action="/subdivision/addflat/${subdivision.id}" method="post">
        <div>Добавить комнату:</div>
        <div><label> Number: <input type="number" name="number"/> </label></div>
        <div><label> Square: <input type="number" name="square"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div><input type="submit" value="Добавить"/></div>
    </form>
    </br>
    <form action="/subdivision/addemployee/${subdivision.id}" method="post">
        <div>Добавить сотрудника:</div>
        <div><label> Name : <input type="text" name="name"/> </label></div>

        <div>
            <label>
                Position:
                <select name="position"  style="width: 200px">
                    <option value="finance">Материально-отвественный</option>
                    <option value="boss">Начальник</option>
                    <option value="employee">Работник</option>
                </select>
            </label>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div><input type="submit" value="Добавить"/></div>
    </form>
    </br>
    <div>
        <a href="/subdivision">Назад</a>
    </div>
