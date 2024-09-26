public class Temp1600 {
    public static void main(String[] args) {
        System.out.println("<intercept-url pattern=\"/services/**\" access=\"hasAnyRole('ROLE_USER','ROLE_ADMIN')\"/>");
    }
}