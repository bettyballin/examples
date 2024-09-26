public class Temp1717 {
    public static void main(String[] args) {
        String xmlConfiguration = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<beans xmlns=\"http://www.springframework.org/schema/beans\"\n" +
                "       xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:security=\"http://www.springframework.org/schema/security\"\n" +
                "       xsi:schemaLocation=\"http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd\n" +
                "        http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security-4.0.xsd\">\n" +
                "\n" +
                "       <security:global-method-security\n" +
                "               secured-annotations=\"enabled\" />\n" +
                "       <security:http>\n" +
                "              <security:form-login />\n" +
                "              <security:intercept-url pattern=\"/admin/get\" access=\"ROLE_ADMIN\"/>\n" +
                "       </security:http>\n" +
                "       <security:authentication-manager>\n" +
                "              <security:authentication-provider>\n" +
                "                     <security:user-service>\n" +
                "                            <security:user name=\"alpha\" authorities=\"ROLE_ADMIN\"\n" +
                "                                           password=\"password\" />\n" +
                "                            <security:user name=\"beta\" authorities=\"ROLE_USER\"\n" +
                "                                           password=\"password\" />\n" +
                "                     </security:user-service>\n" +
                "              </security:authentication-provider>\n" +
                "       </security:authentication-manager>\n" +
                "</beans>";

        System.out.println(xmlConfiguration);
    }
}