import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShiroServlet", urlPatterns = {"/login", "/account/*", "/logout"})
public class ShiroServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        // Load the Shiro INI configuration
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if ("/logout".equals(path)) {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            response.sendRedirect("/login.xhtml");
        } else if ("/login".equals(path)) {
            request.getRequestDispatcher("/login.xhtml").forward(request, response);
        } else if (path.startsWith("/account")) {
            Subject subject = SecurityUtils.getSubject();
            if (!subject.isAuthenticated()) {
                response.sendRedirect("/login.xhtml");
            } else {
                request.getRequestDispatcher("/account.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if ("/login".equals(path)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);

            try {
                subject.login(token);
                response.sendRedirect("/account.jsp");
            } catch (AuthenticationException e) {
                request.setAttribute("error", "Invalid username or password");
                request.getRequestDispatcher("/login.xhtml").forward(request, response);
            }
        }
    }
}


**shiro.ini:**
ini
[main]
shiro.loginURL = /login.xhtml
myRealm = com.example.shiro.MyRealm
securityManager.realms = $myRealm

[urls]
/account/** = authc
/logout = logout


**com/example/shiro/MyRealm.java:**

package com.example.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm implements Realm {

    @Override
    public String getName() {
        return "myRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        String username = userToken.getUsername();
        String password = new String(userToken.getPassword());

        // Replace with your own user lookup logic
        if ("user".equals(username) && "password".equals(password)) {
            return new SimpleAuthenticationInfo(username, password, getName());
        } else {
            throw new AuthenticationException("Invalid username or password.");
        }
    }
}


**web.xml:**
xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
         http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">
    <servlet>
        <servlet-name>ShiroServlet</servlet-name>
        <servlet-class>ShiroServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>ShiroServlet</servlet-name>
        <url-pattern>/login</url-pattern>
        <url-pattern>/account/*</url-pattern>
        <url-pattern>/logout</url-pattern>
    </servlet-mapping>
</web-app>


**login.xhtml