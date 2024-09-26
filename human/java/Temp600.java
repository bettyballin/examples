public class Temp600 {
    public static void main(String[] args) {
        String interceptUrl = "<intercept-url pattern=\"/ws/**\" access=\"ROLE_ADMIN\"/>";
        System.out.println(interceptUrl);
    }
}