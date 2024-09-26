xml
<!-- CORS configuration -->
<filter>
    <filter-name>corsFilter</filter-name>
    <filter-class>by.eventcat.rest.MyCorsFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>corsFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>