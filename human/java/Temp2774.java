// File: src/main/java/edu/eci/cvds/security/OnlyNotAuthenticated.java
package edu.eci.cvds.security;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "OnlyNotAuthenticated", urlPatterns = {"/", "/login.xhtml"})
public class OnlyNotAuthenticated implements Filter {

    private static final String WELCOME_URL = "/bienvenida.xhtml";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Example condition to check if the user is authenticated, modify as needed
        boolean isAuthenticated = httpRequest.getSession().getAttribute("user") != null;

        if (isAuthenticated) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + WELCOME_URL);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}

// File: src/main/webapp/WEB-INF/web.xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">

    <filter>
        <filter-name>OnlyNotAuthenticated</filter-name>
        <filter-class>edu.eci.cvds.security.OnlyNotAuthenticated</filter-class>
    </filter>

    <filter-mapping>
        <filter-name>OnlyNotAuthenticated</filter-name>
        <url-pattern>/</url-pattern>
        <url-pattern>/login.xhtml</url-pattern>
    </filter-mapping>

    <welcome-file-list>
        <welcome-file>login.xhtml</welcome-file>
    </welcome-file-list>

    <!-- Other configurations -->

</web-app>

// File: src/main/webapp/login.xhtml
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html">

<h:head>
    <title>Login Page</title>
</h:head>
<h:body>
    <h:form>
        <!-- Login form content -->
        <h:inputText value="#{loginBean.username}" />
        <h:inputSecret value="#{loginBean.password}" />
        <h:commandButton value="Login" action="#{loginBean.login}" />
    </h:form>
</h:body>
</html>

// File: src/main/webapp/bienvenida.xhtml
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html">

<h:head>
    <title>Bienvenida</title>
</h:head>
<h:body>
    <h:outputText value="Bienvenido!" />
</h:body>
</html>

// File: src/main/java/edu/eci/cvds/beans/LoginBean.java
package edu.eci.cvds.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    private String username;
    private String password;

    // Getters and Setters for username and password

    public String login() {
        // Implement login logic
        // For example, store user in session
        return "bienvenida.xhtml?faces-redirect=true";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}