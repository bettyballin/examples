public class Temp1946 {
    public static void main(String[] args) {
        String interceptUrlPattern = "<intercept-url pattern=\"/admin/**\" access=\"hasRole('ROLE_ADMIN')\" />";
        System.out.println(interceptUrlPattern);
    }
}