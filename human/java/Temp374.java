xml
<context-param>
    <param-name>shiroConfigLocations</param-name>
    <param-value>classpath:auth.ini</param-value>
</context-param>

<!--  Shiro Environment Listener -->
<listener>
    <listener-class>org.apache.shiro.web.env.EnvironmentLoaderListener</listener-class>
</listener>

<!--  Shiro Filter Configuration -->
<filter>
    <filter-name>ShiroFilter</filter-name>
    <filter-class>org.apache.shiro.web.servlet.ShiroFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>ShiroFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>