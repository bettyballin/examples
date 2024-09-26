class YourSecurityManager extends SecurityManager {
    // Customize your security manager here if needed
}

public class Temp82 {
    public static void main(String[] args) {
        System.setSecurityManager(new YourSecurityManager());
        System.out.println("Security manager set successfully.");
    }
}