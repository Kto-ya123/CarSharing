<style>
    .brd {
        border: 4px double black; /* Параметры границы */
        background: #fc3; /* Цвет фона */
        padding: 10px; /* Поля вокруг текста */
    }
</style>
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
            Flat: ${technics.flat.id}
        </div>
        <br/>
    </div>
    <div>
        <form action="/broadcast/${technics.idNumber}" method="post">
            <div><label> Date: <input type="date" name="date"/> </label></div>
            <div>
                Flat
                <select name="flatId"  style="width: 200px">
                    <#list flats as flat>
                        <option value="${flat.id}">${flat.id}</option>
                    </#list>
                </select>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div><input type="submit" value="Переместить"/></div>
        </form>
    </div>
<div>
    <a href="/tech">Назад</a>
</div>

