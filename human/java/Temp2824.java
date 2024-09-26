public class Temp2824 {
    public static void main(String[] args) {
        interceptUrlPattern("/blabla/**", "isAnonymous() and hasIpAddress('127.0.0.1')");
    }

    private static void interceptUrlPattern(String pattern, String access) {
        System.out.println("Intercepting URL pattern: " + pattern);
        System.out.println("Access condition: " + access);
    }
}