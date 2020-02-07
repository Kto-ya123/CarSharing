<form action="/subdivision/add" method="post">
    <div><label> Name : <input type="text" name="name"/> </label></div>
    <div><label> Full Name: <input type="text" name="fullName"/> </label></div>
    <div><label> Number: <input type="number" name="number"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div><input type="submit" value="Добавить"/></div>
</form>
<div>
    <a href="/subdivision">Назад</a>
</div>