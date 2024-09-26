public class Configurator {
    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();
        String ourHack = os.contains("win") ? "/" : "";
        String ourHome = System.getProperty("user.home");
        String policyUrl = "file:" + ourHack + ourHome + "/lib/OurSecurity.policy";
        System.setProperty("policy.url.3", policyUrl);
        // Now you can use the property somewhere in your application
        // Example: System.out.println(System.getProperty("policy.url.3"));
    }
}