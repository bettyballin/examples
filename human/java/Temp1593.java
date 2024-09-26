public class Temp1593 {
    public static void main(String[] args) {
        String filterName = "springSecurityFilterChain";
        String urlPattern = "/*";

        System.out.println("<filter-mapping>");
        System.out.println("    <filter-name>" + filterName + "</filter-name>");
        System.out.println("    <url-pattern>" + urlPattern + "</url-pattern>");
        System.out.println("</filter-mapping>");
    }
}