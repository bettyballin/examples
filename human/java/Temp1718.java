public class Temp1718 {
    public static void main(String[] args) {
        String filterMapping1 = "<filter-mapping>\n" +
                "    <filter-name>securityFilter</filter-name>\n" +
                "    <url-pattern>/*</url-pattern>\n" +
                "    <dispatcher>REQUEST</dispatcher>\n" +
                "    <dispatcher>FORWARD</dispatcher>\n" +
                "    <dispatcher>INCLUDE</dispatcher>\n" +
                "</filter-mapping>";

        String filterMapping2 = "<filter-mapping>\n" +
                "    <filter-name>sitemesh</filter-name>\n" +
                "    <url-pattern>/*</url-pattern>\n" +
                "    <dispatcher>REQUEST</dispatcher>\n" +
                "    <dispatcher>FORWARD</dispatcher>\n" +
                "</filter-mapping>";

        String filterMapping3 = "<filter-mapping>\n" +
                "    <filter-name>encodingFilter</filter-name>\n" +
                "    <url-pattern>/*</url-pattern>\n" +
                "</filter-mapping>";

        System.out.println(filterMapping1);
        System.out.println(filterMapping2);
        System.out.println(filterMapping3);
    }
}