import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class SignFiles {

    public static void main(String[] args) throws Exception {
        // Initialize KeyPairGenerator for RSA algorithm with 2048 bit key size.
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);

        KeyPair keyPair = kpg.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();

        File folderToSign = new File("/path/to/folder");

        if (!folderToSign.isDirectory()) {
            throw new IllegalArgumentException("Provided path is not a directory");
        }

        List<String> signedFiles = new ArrayList<>();

        for (File file : folderToSign.listFiles()) {
            if (file.isFile()) {
                // Generate hash value of the current file's contents.
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] fileBytes = getFileBytes(file);
                byte[] hashedData = md.digest(fileBytes);

                Signature signature = Signature.getInstance("SHA256withRSA");
                signature.initSign(privateKey);
                signature.update(fileBytes); // Update with fileBytes not hashedData

                byte[] fileSignature = signature.sign();
                String encodedSignature = Base64.getEncoder().encodeToString(fileSignature);

                signedFiles.add(file.getName() + ": " + encodedSignature);
            }
        }

        // Combine all individual files' signed data into one single document (e.g., JSON)
        StringBuilder combinedSignatures = new StringBuilder("{\n");
        for (String signedFile : signedFiles) {
            combinedSignatures.append("  \"").append(signedFile).append("\",\n");
        }
        if(signedFiles.size() > 0) {
            combinedSignatures.deleteCharAt(combinedSignatures.length() - 2); // Remove last comma
        }
        combinedSignatures.append("}");

        System.out.println(combinedSignatures.toString());
    }

    private static byte[] getFileBytes(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] fileBytes = new byte[(int) file.length()];
            fis.read(fileBytes);
            return fileBytes;
        }
    }
}