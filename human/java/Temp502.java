public class Temp502 {
    public static void main(String[] args) {
        System.out.println("<filter-mapping>");
        System.out.println("    <filter-name>springSecurityFilterChain</filter-name>");
        System.out.println("    <url-pattern>/*</url-pattern>");
        System.out.println("    <dispatcher>REQUEST</dispatcher>");
        System.out.println("    <!-- apply Spring Security authentication to error-pages -->");
        System.out.println("    <dispatcher>ERROR</dispatcher>");
        System.out.println("</filter-mapping>");
    }
}