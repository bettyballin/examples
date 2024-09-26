public class Temp1755 {
    public static void main(String[] args) {
        System.out.println("This is a placeholder for the JSP content.");
    }
}


jsp
<%-- Save this as login.jsp --%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<c:if test="${failed==1}">  
    <font color="red">
    Authentication failed. Wrong email/password.
    </font>
</c:if>

<form action="<c:url value='/login' />" method="POST">
    <label> E-mail </label>
    <input type="email" name="username" required><br>
    <label> Password </label>
    <input type="password" name="password" required><br>
    <input type="submit" value="Sign in"><br>
</form>
</body>
</html>


xml
<!-- web.xml configuration for JSP -->
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
         http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">
    <servlet>
        <servlet-name>jsp</servlet-name>
        <jsp-file>/login.jsp</jsp-file>
    </servlet>
    <servlet-mapping>
        <servlet-name>jsp</servlet-name>
        <url-pattern>/login</url-pattern>
    </servlet-mapping>
</web-app>