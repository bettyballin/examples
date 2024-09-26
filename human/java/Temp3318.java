public class Temp3318 {
    public static void main(String[] args) {
        byte[] passwordb = "password".getBytes();
        String salt = "$2a$12$abcdefghijklmnopqrstuv";
        String hashedPassword = hashpw(passwordb, salt);
        System.out.println("Hashed Password: " + hashedPassword);
    }

    public static String hashpw(byte[] passwordb, String salt) {
        // Placeholder for actual hashing logic
        // Just for demonstration purposes
        String real_salt = salt.substring(7, 29);
        // Dummy hashed password for demonstration
        String hashedPassword = new String(passwordb) + real_salt;
        return hashedPassword;
    }
}