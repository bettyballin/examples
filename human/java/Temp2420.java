public class Temp2420 {
    public static void main(String[] args) {
        String filterMapping = "<filter-mapping>\n" +
                "    <filter-name>springSecurityFilterChain</filter-name>\n" +
                "    <url-pattern>/*</url-pattern>\n" +
                "</filter-mapping>";
        
        System.out.println(filterMapping);
    }
}