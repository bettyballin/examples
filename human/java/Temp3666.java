public class Temp3666 {
    public static void main(String[] args) {
        String interceptUrl = "/settings/.*\\.(yaml|json)\\?tag=.*";
        String access = "hasAnyRole('ROLE')";
        System.out.println("Intercept URL pattern: " + interceptUrl);
        System.out.println("Access rule: " + access);
    }
}