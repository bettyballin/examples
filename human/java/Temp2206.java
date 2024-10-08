xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
         xmlns:web="http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
         version="3.0">

    <servlet-mapping>
        <servlet-name>default</servlet-name>
        <url-pattern>/WEB-INF/classes/static/login/*</url-pattern>
    </servlet-mapping>

    <security-constraint>
        <web-resource-collection>
            <web-resource-name>Authentication</web-resource-name>
            <url-pattern>/test/auth/*</url-pattern>
        </web-resource-collection>
        <auth-constraint>
            <role-name>users</role-name>
        </auth-constraint>
    </security-constraint>

    <login-config>
        <auth-method>FORM</auth-method>
        <form-login-config>
            <form-login-page>/WEB-INF/classes/static/login/login.html</form-login-page>
            <form-error-page>/WEB-INF/classes/static/login/loginerror.html</form-error-page>
        </form-login-config>
    </login-config>

    <security-role>
        <role-name>users</role-name>
    </security-role>

</web-app>