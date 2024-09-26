public class Temp31 {
    public static void main(String[] args) {
        System.out.println("<http>");
        System.out.println("  <http-basic/>");
        System.out.println("  <port-mappings>");
        System.out.println("     <port-mapping http=\"8080\" https=\"8443\"/>");
        System.out.println("  </port-mappings>");
        System.out.println("  <intercept-url pattern=\"/url1**\" access=\"ROLE_USER\" requires-channel=\"https\"/>");
        System.out.println("  <intercept-url pattern=\"/url2**\" access=\"ROLE_TELLER\" method=\"GET\"/>");
        System.out.println("  <intercept-url pattern=\"/url3**\" access=\"ROLE_SUPERVISOR\" />");      
        System.out.println("</http>");
    }
}