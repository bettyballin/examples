import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.params.KeyParameter;

public class Temp3021 {

    public static void main(String[] args) {
        try {
            new Temp3021().getCMAC();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCMAC() throws Exception {
        byte[] msg = new byte[]{(byte) 0xA3, (byte) 0x00, (byte) 0x00, (byte) 0x35, (byte) 0xE7, (byte) 0x58,
                (byte) 0xC6, (byte) 0x09, (byte) 0x00, (byte) 0x4F, (byte) 0x44, (byte) 0x36, (byte) 0xF0,
                (byte) 0xEA, (byte) 0x31, (byte) 0x9A, (byte) 0xF4, (byte) 0x31, (byte) 0xE1,
                (byte) 0x98, (byte) 0xBC, (byte) 0x41, (byte) 0xA0, (byte) 0x67, (byte) 0xD1};

        byte[] keydata = new byte[]{(byte) 0x67, (byte) 0x1B, (byte) 0x9D, (byte) 0x1D, (byte) 0xC1, (byte) 0x54,
                (byte) 0x74, (byte) 0xA2, (byte) 0x5C, (byte) 0xB1, (byte) 0x77, (byte) 0xCA, (byte) 0x1A,
                (byte) 0x19, (byte) 0x9F, (byte) 0x0E};

        CipherParameters params = new KeyParameter(keydata);
        AESEngine aes = new AESEngine();
        CMac mac = new CMac(aes);
        mac.init(params);
        mac.update(msg, 0, msg.length);
        byte[] out = new byte[mac.getMacSize()];
        mac.doFinal(out, 0);

        StringBuilder s19 = new StringBuilder();
        for (byte b : out) {
            s19.append(String.format("%02X ", b));
        }
        System.out.println("Encrypted Kmac: " + s19.toString());
    }
}