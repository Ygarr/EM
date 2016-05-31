<#import "/spring.ftl" as spring />


<form action="${rc.contextPath}/j_spring_security_check" method="post">
    <label for="username">Username</label><input type="text" id="username" name="j_username"><br/>
    <label for="password">Password</label><input type="text" id="password" name="j_password"><br/>
    <input type="submit" value="Login!">
</form>

 <#if Session.SPRING_SECURITY_LAST_EXCEPTION?? && <Session.SPRING_SECURITY_LAST_EXCEPTION.message?has_content>
        <@spring.message "login.bad.credentials"/>
    </#if>