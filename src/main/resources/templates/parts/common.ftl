<#ftl encoding="utf-8">
<#import "style.ftl" as s>
<#macro page login user>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <@s.style/>
    </head>
    <body>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm border">
        <nav class="col-sm ">
            <a class="p-2 text-dark" href="/">Main Page</a>
            <a class="p-2 text-dark" href="/TShirts">T-shirts</a>
        </nav>
        <#if login>
            <div class="btn-group my-2 my-md-0 mr-md-3">
                <button type="button" onclick="location.href= '/${user.username}'" class="btn btn-outline-primary">${user.username}</button>
                <button type="button" class="btn btn-outline-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span class="sr-only ">Toggle Dropdown</span>
                </button>
                <div class="dropdown-menu ">
                    <#if user ??>
                        <#list user.roles as role>
                            <#if role == "ADMIN">
                                <a class="dropdown-item" href="/user">Admin Panel</a>
                            </#if>
                        </#list>
                    </#if>
                    <a class="dropdown-item" onclick="signOut();">Sign out</a>
                    <div class="dropdown-divider"></div>
                </div>
            </div>
        <#else>
            <nav class="my-2 my-md-0 mr-md-3">
                <a class="btn btn-outline-primary" href="#login_form" id="join_pop">Log In</a>
            </nav>
        </#if>
    </div>
    <!--   ==========         ЛОГИН     ==========          -->
    <a href="#x" class="overlay" id="login_form"></a>
    <div class="bg-white border-bottom shadow-sm popup">
        <h2>Welcome </h2>
        <p>Please enter your login and password here</p>
        <form method="post" action="/">
            <div>
                <label for="login" >Login:</label>
                <input class="form-control searchcolor" type="text" id="login" value="" name="username" />
            </div>
            <div>
                <label for="password">Password:</label>
                <input class="form-control searchcolor" type="password" id="password" value="" name="password" />
            </div>
            <input type="submit" class="btn btn-outline-primary" value="Sign In" />
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            &nbsp;&nbsp;&nbsp;or&nbsp;&nbsp;&nbsp;
            <a href="/registration" id="join_pop" >Sign Up</a>
        </form>
        <a class="close" href="#close"></a>
    </div>
    <#nested>
    </body>
    <div class="null"></div>
</html>
    <script>
        function signOut(){
            document.write('<form action="/logout" method="post">');
            document.write('<input type="hidden" name="_csrf" value="${_csrf.token}"/>');
            document.write('<input style="display:none;" type="submit" id="signout"/>');
            document.write('</form>');
            var button = document.getElementById('signout');
            button.click();
        }
    </script>
</#macro>
