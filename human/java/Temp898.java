xml
<filter>
    <filter-name>saveRequestResponseFilter</filter-name>
    <filter-class>sample.save.request.filter.SaveRequestResponseFilter</filter-class>
</filter>

<filter-mapping>
    <filter-name>saveRequestResponseFilter</filter-name>
    <url-pattern>/mobilews/*</url-pattern>
</filter-mapping>