xml
<!-- Map the REST Servlet to /rest/ -->
<servlet>
    <servlet-name>RestService</servlet-name>
    <servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class>
    <init-param>
        <!--Every class inside of this package (com.unsubcentral.rest) will be available to Jersey-->
        <param-name>jersey.config.server.provider.packages</param-name>
        <param-value>com.rince.rest</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
    <servlet-name>RestService</servlet-name>
    <url-pattern>/rest/*</url-pattern>
</servlet-mapping>