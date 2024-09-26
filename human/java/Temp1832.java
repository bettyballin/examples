public class Temp1832 {
    public static void main(String[] args) {
        // Java doesn't support directly embedding JavaScript within its source code.
        // The following would be the correct approach to write the intended functionality in Java.

        // Example of using Java's built-in libraries for cryptographic functions
        try {
            java.security.MessageDigest sha1 = java.security.MessageDigest.getInstance("SHA-1");
            String text = "hello world";
            sha1.update(text.getBytes("UTF-8"));
            byte[] digest = sha1.digest();
            System.out.println("SHA-1 hash: " + javax.xml.bind.DatatypeConverter.printHexBinary(digest));
            
            // AES encryption/decryption example
            javax.crypto.KeyGenerator keyGen = javax.crypto.KeyGenerator.getInstance("AES");
            keyGen.init(128);
            javax.crypto.SecretKey secretKey = keyGen.generateKey();
            javax.crypto.Cipher aesCipher = javax.crypto.Cipher.getInstance("AES");
            
            // Encrypt
            aesCipher.init(javax.crypto.Cipher.ENCRYPT_MODE, secretKey);
            byte[] encrypted = aesCipher.doFinal(text.getBytes("UTF-8"));
            System.out.println("Encrypted text (AES): " + javax.xml.bind.DatatypeConverter.printHexBinary(encrypted));
            
            // Decrypt
            aesCipher.init(javax.crypto.Cipher.DECRYPT_MODE, secretKey);
            byte[] decrypted = aesCipher.doFinal(encrypted);
            System.out.println("Decrypted text (AES): " + new String(decrypted, "UTF-8"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}