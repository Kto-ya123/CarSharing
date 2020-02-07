<#import "style.ftl" as s>
<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <@s.style/>
    </head>
    <body>
     <#nested>
    </body>
</html>
</#macro>