import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CpabeStringHandler {

    public static void encryptString(String publicKeyFilePath, String policy, String inputStr, String outputFilePath) throws IOException, AbeEncryptionException {
        AbePublicKey publicKey = AbePublicKey.readFromFile(Paths.get(publicKeyFilePath));
        try (ByteArrayInputStream in = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            Cpabe.encrypt(publicKey, policy, in, byteArrayOutputStream);
            try (FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath)) {
                byteArrayOutputStream.writeTo(fileOutputStream);
            }
        }
    }

    public static String decryptString(String privateKeyFilePath, String inputFilePath) throws IOException, AbeDecryptionException {
        AbePrivateKey privateKey = AbePrivateKey.readFromFile(Paths.get(privateKeyFilePath));
        byte[] encryptedData = Files.readAllBytes(Paths.get(inputFilePath));
        try (ByteArrayInputStream in = new ByteArrayInputStream(encryptedData);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            Cpabe.decrypt(privateKey, in, byteArrayOutputStream);
            return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
        }
    }
}