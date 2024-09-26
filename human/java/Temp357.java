public class Temp357 {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java Temp357 <algorithm> <username> <realm> <cleartext-password>");
            return;
        }

        String algorithm = args[0];
        String username = args[1];
        String realm = args[2];
        String cleartextPassword = args[3];
        
        try {
            String result = digest(algorithm, username, realm, cleartextPassword);
            System.out.println("Digest: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String digest(String algorithm, String username, String realm, String password) throws Exception {
        String data = username + ":" + realm + ":" + password;
        java.security.MessageDigest md = java.security.MessageDigest.getInstance(algorithm);
        byte[] digest = md.digest(data.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) sb.append('0');
            sb.append(hex);
        }
        return sb.toString();
    }
}