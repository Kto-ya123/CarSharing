<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
</head>
<body>
<a th:href="${uri}">Click me</a>

<tr th:each="info : ${infoList}">
    <td th:text="${info.apiProviderName}"></td>
    <a th:href="${info.url}">Авторизоваться</a>
</tr>
</body>
</html>
