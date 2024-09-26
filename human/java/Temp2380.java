public class Temp2380 {
    public static void main(String[] args) {
        String[] authMethods = {"password", "authorization_code", "refresh_token", "implicit"};
        for (String method : authMethods) {
            System.out.println(method);
        }
    }
}