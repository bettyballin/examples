public class Temp540 {
    public static void main(String[] args) {
        // our.hack = "/" on windows
        // our.hack = "" on linux
        String ourHack = System.getProperty("os.name").toLowerCase().contains("win") ? "/" : "";
        String policyUrl = "file:" + ourHack + System.getProperty("user.home") + "/lib/OurSecurity.policy";
        System.out.println("Policy URL: " + policyUrl);
    }
}