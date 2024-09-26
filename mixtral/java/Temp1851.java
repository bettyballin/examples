import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Base64;

public class EncryptFile {
    public static void main(String[] args) throws Exception {
        String sourceFilePath = "sourceFile.txt"; // Replace with your source file path
        String destFilePath = "destFile.txt";     // Replace with your destination file path

        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");

        byte[] secretKey = Base64.getDecoder().decode("uQsaW+WMUrjcsq1HMf+2JQ==".getBytes());

        SecretKeySpec key = new SecretKeySpec(secretKey, "AES");
        IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(secretKey, 0, cipher.getBlockSize()));

        cipher.init(Cipher.ENCRYPT_MODE, key, iv);

        FileInputStream fileInputStream = new FileInputStream(sourceFilePath);
        FileOutputStream fileOutputStream = new FileOutputStream(destFilePath);

        int read;
        while ((read = fileInputStream.available()) > 0) {
            byte[] block = new byte[4096];
            int bytesRead = fileInputStream.read(block, 0, Math.min(read, block.length));

            if (bytesRead >= 0) {
                byte[] writeBuffer = cipher.update(Arrays.copyOfRange(block, 0, bytesRead));

                // Write the encrypted data to file
                fileOutputStream.write(writeBuffer);

                // If this is the last block and there's no more input
                if (bytesRead < read) {
                    byte[] writeFinal = cipher.doFinal();

                    // Write any remaining bytes from doFinal()
                    fileOutputStream.write(Arrays.copyOfRange(writeFinal, 0, writeFinal.length));

                    break;
                }
            }
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}