<#-- @ftlvariable name="handle" type="java.lang.String" -->
<#import "./commons.ftlh" as c>

<@c.page>
    <#if userEntity?has_content>

        <div class="information-user-block">
            <div class="user-avatar">
                <img src="https://userpic.codeforces.org/no-title.jpg" alt="${userEntity.login} avatar" title="${userEntity.login} avatar">
            </div>
            <ul>
                <li>
                    id: ${userEntity.id}
                </li>
                <li>
                    login: ${userEntity.login}
                </li>
                <li>
                    creationTime: ${userEntity.creationTime}
                </li>
            </ul>
        </div>
    <#else>
        No such user
    </#if>
</@c.page>
