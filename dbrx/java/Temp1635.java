public class Temp1635 {
    public static void main(String[] args) {
        String jwtSecret = System.getProperty("JWT_SECRET", "default-secret");
        System.out.println("JWT_SECRET: " + jwtSecret);
    }
}