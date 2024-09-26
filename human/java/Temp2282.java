class SecurityProperties {
    public static final int BASIC_AUTH_ORDER = 41;
}

class ManagementServerProperties {
    public static final int BASIC_AUTH_ORDER = 36;
}

public class Temp2282 {
    public static void main(String[] args) {
        int BASIC_AUTH_ORDER = SecurityProperties.BASIC_AUTH_ORDER - 5; // 36
        int ACCESS_OVERRIDE_ORDER = ManagementServerProperties.BASIC_AUTH_ORDER - 1; // 35

        System.out.println("BASIC_AUTH_ORDER: " + BASIC_AUTH_ORDER);
        System.out.println("ACCESS_OVERRIDE_ORDER: " + ACCESS_OVERRIDE_ORDER);
    }
}