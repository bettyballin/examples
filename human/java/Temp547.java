xml
<filter>
    <filter-name>SessionFilter</filter-name>
    <filter-class>com.something.SessionFilter</filter-class>
    <init-param>
        <param-name>max-period</param-name>
        <param-value>60000</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>SessionFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>