public class Temp2075 {
    public static void main(String[] args) {
        System.out.println("This is a placeholder for the web.xml content.");
        // The XML content below is an example of a web.xml configuration in a Java web application.
        String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<web-app xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
            "         xmlns=\"http://java.sun.com/xml/ns/javaee\" xmlns:web=\"http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd\"\n" +
            "         xsi:schemaLocation=\"http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd\"\n" +
            "         metadata-complete=\"false\" version=\"3.0\">\n" +
            "\n" +
            "    <security-constraint>\n" +
            "        <web-resource-collection>\n" +
            "            <web-resource-name>portal</web-resource-name>\n" +
            "            <description>This is the protected area of the application.</description>\n" +
            "            <url-pattern>/*</url-pattern>\n" +
            "        </web-resource-collection>\n" +
            "        <auth-constraint>\n" +
            "            <description>Requires users to be authenticated but does not require them to be authorized.</description>\n" +
            "            <role-name>*</role-name>\n" +
            "        </auth-constraint>\n" +
            "        <user-data-constraint>\n" +
            "            <description>Encryption is not required for this area.</description>\n" +
            "            <transport-guarantee>NONE</transport-guarantee>\n" +
            "        </user-data-constraint>\n" +
            "    </security-constraint>\n" +
            "\n" +
            "</web-app>";

        System.out.println(xmlContent);
    }
}