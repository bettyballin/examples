public class Temp182 {
    public static void main(String[] args) {
        System.setProperty("java.security.manager", "");
        System.setProperty("java.security.policy", "src/dir1/dir2/important.policy");
        
        // Your code logic here
        System.out.println("Security manager and policy set.");
    }
}