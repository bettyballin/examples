import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class SignatureEmbedder {

    private static final String SIGNATURE_DELIMITER = "--SIGNATURE--";

    public static void embedSignatureToFile(String filePath, byte[] signature) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath, true)) {
            fos.write(SIGNATURE_DELIMITER.getBytes());
            fos.write(signature);
        }
    }

    public static byte[] extractSignatureFromFile(String filePath) throws IOException {
        byte[] fileWithSignature = Files.readAllBytes(Paths.get(filePath));
        byte[] delimiter = SIGNATURE_DELIMITER.getBytes();
        for (int i = 0; i < fileWithSignature.length - delimiter.length; i++) {
            boolean match = true;
            for (int j = 0; j < delimiter.length; j++) {
                if (fileWithSignature[i + j] != delimiter[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return Arrays.copyOfRange(fileWithSignature, i + delimiter.length, fileWithSignature.length);
            }
        }
        throw new IOException("Signature delimiter not found in file");
    }
}