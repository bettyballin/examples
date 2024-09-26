import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Temp164 {

    public static void main(String[] args) {
        FileEncryption secure = new FileEncryption();

        // Encrypt code
        {
            File encryptFile = new File("encrypt.data");
            File publicKeyData = new File("public.der");
            File originalFile = new File("sys_data.db");
            File secureFile = new File("secure.data");

            // create AES key
            secure.makeKey();

            // save AES key using public key
            secure.saveKey(encryptFile, publicKeyData);

            // save original file securely 
            secure.encrypt(originalFile, secureFile);
        }

        // Decrypt code
        {
            File encryptFile = new File("encrypt.data");
            File privateKeyFile = new File("private.der");
            File secureFile = new File("secure.data");
            File unencryptedFile = new File("unencryptedFile");

            // load AES key
            secure.loadKey(encryptFile, privateKeyFile);

            // decrypt file
            secure.decrypt(secureFile, unencryptedFile);
        }
    }
}

class FileEncryption {
    private SecretKey secretKey;

    public void makeKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            secretKey = keyGen.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void saveKey(File encryptFile, File publicKeyFile) {
        try {
            byte[] publicKeyBytes = Files.readAllBytes(publicKeyFile.toPath());
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(keySpec);

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.WRAP_MODE, publicKey);
            byte[] wrappedKey = cipher.wrap(secretKey);

            try (FileOutputStream fos = new FileOutputStream(encryptFile)) {
                fos.write(wrappedKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadKey(File encryptFile, File privateKeyFile) {
        try {
            byte[] privateKeyBytes = Files.readAllBytes(privateKeyFile.toPath());
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            byte[] wrappedKey = Files.readAllBytes(encryptFile.toPath());

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.UNWRAP_MODE, privateKey);
            secretKey = (SecretKey) cipher.unwrap(wrappedKey, "AES", Cipher.SECRET_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void encrypt(File inputFile, File outputFile) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            try (FileInputStream fis = new FileInputStream(inputFile);
                 FileOutputStream fos = new FileOutputStream(outputFile);
                 CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    cos.write(buffer, 0, bytesRead);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void decrypt(File inputFile, File outputFile) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            try (FileInputStream fis = new FileInputStream(inputFile);
                 FileOutputStream fos = new FileOutputStream(outputFile);
                 CipherInputStream cis = new CipherInputStream(fis, cipher)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = cis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}