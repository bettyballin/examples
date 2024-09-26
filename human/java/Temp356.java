public class Temp356 {
    public static void main(String[] args) {
        String algorithm = "SHA-256";
        String cleartextPassword = "your-password-here";
        try {
            // Assuming you have some method to generate the digest
            String hashedPassword = generateDigest(algorithm, cleartextPassword);
            System.out.println("Hashed Password: " + hashedPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generateDigest(String algorithm, String password) throws Exception {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance(algorithm);
        byte[] array = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : array) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}