import java.util.Arrays;

class SecureImage {
    private byte[] data;
    private String mimeType;

    public SecureImage(byte[] data, String mimeType) {
        this.data = data;
        this.mimeType = mimeType;
    }

    public void stripMetadata() {
        // Stub method to strip metadata
        System.out.println("Stripping metadata...");
    }

    public void removeUnsupportedChunks() {
        // Stub method to remove unsupported chunks
        System.out.println("Removing unsupported chunks...");
    }

    public byte[] getData() {
        return data;
    }
}

public class Temp554 {
    public static void main(String[] args) {
        byte[] pbmData = {0x50, 0x34, 0x0A, 0x32, 0x20, 0x32, 0x0A, 0x30, 0x20, 0x30, 0x20, 0x31, 0x20, 0x31, 0x0A};
        SecureImage secureImage = new SecureImage(pbmData, "image/x-portable-bitmap");
        secureImage.stripMetadata();
        secureImage.removeUnsupportedChunks();
        byte[] sanitizedPbmData = secureImage.getData();
        System.out.println(Arrays.toString(sanitizedPbmData));
    }
}