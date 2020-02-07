<form action="/tech/add" method="post">
    <div><label> IdNumber : <input type="number" name="idNumber"/> </label></div>
    <div><label> Title: <input type="text" name="title"/> </label></div>
    <div><label> Model: <input type="text" name="model"/> </label></div>
    <div><label> Date: <input type="date" name="date"/> </label></div>
    <div><label> Cash: <input type="number" name="cash"/> </label></div>

    <div>
        Flat
        <select name="flatId"  style="width: 200px">
            <#list flats as flat>
                <option value="${flat.id}">${flat.id}</option>
            </#list>
        </select>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div><input type="submit" value="Добавить"/></div>
</form>
<div>
    <a href="/tech">Назад</a>
</div>
