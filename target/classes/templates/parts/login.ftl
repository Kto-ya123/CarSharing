<#macro login1 path>
<form action="${path}" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div><input type="submit" value="Sign In"/></div>
</form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Sign Out"/>
    </form>
</#macro>

<#macro login path>
    <form action="${path}" method="post">
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div><input type="submit" value="Sign In"/></div>

        <a href="#x" class="overlay" id="login_form"></a>
        <div class="bg-white border-bottom shadow-sm popup">
            <h2>Welcome </h2>
            <p>Please enter your login and password here</p>
            <div>
                <label for="login" >Login:</label>
                <input class="form-control searchcolor" type="text" id="login" value="" />
            </div>
            <div>
                <label for="password">Password:</label>
                <input class="form-control searchcolor" type="password" id="password" value="" />
            </div>
            <input type="button" class="btn btn-outline-primary" value="Sign In" />
            <a href="#join_form" id="join_pop">Sign Up</a>
            <a class="close" href="#close"></a>
        </div>
    </form>
</#macro>
