public class Temp265 {
    public static void main(String[] args) {
        System.out.println("Spring Security Configuration Example");
        
        String xmlConfig = """
        <?xml version="1.0" encoding="UTF-8"?>

        <beans:beans 
            xmlns:security="http://www.springframework.org/schema/security"
            xmlns:beans="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
                                http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security-3.0.xsd">

            <security:global-method-security secured-annotations="enabled">
            </security:global-method-security>

            <security:http auto-config="true" disable-url-rewriting="true">
               <security:intercept-url pattern="/*.do" access="ROLE_USER" />
               <security:intercept-url pattern="/index.jsp" access="ROLE_USER" />
               <security:intercept-url pattern="/**" access="IS_AUTHENTICATED_ANONYMOUSLY" />
               <security:intercept-url pattern="/login.jsp" filters="none" />
               <security:form-login login-page="/login.jsp" />
               <security:logout />
            </security:http>

            <security:authentication-manager>
                <security:authentication-provider>
                    <security:password-encoder hash="md5" />
                    <security:jdbc-user-service data-source-ref="my-ds"/>
                </security:authentication-provider>
            </security:authentication-manager>

        </beans:beans>
        """;
        
        System.out.println(xmlConfig);
    }
}