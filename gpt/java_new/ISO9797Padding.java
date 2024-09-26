import java.util.Arrays;

public class ISO9797Padding {

    public static byte[] pad(byte[] data, int blockSize) {
        int padLen = blockSize - (data.length % blockSize);
        padLen = padLen == 0 ? blockSize : padLen;

        byte[] paddedData = new byte[data.length + padLen];
        System.arraycopy(data, 0, paddedData, 0, data.length);

        Arrays.fill(paddedData, data.length, paddedData.length, (byte) 0x80);
        return paddedData;
    }
}