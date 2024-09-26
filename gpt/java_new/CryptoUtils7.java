import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CryptoUtils7 {

    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for (byte b : a)
            sb.append(String.format("%02x", b & 0xff));
        return sb.toString();
    }

    public static String createSignature(String query, String secret) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA1");
        Mac hmac = Mac.getInstance("HmacSHA1");
        hmac.init(secretKeySpec);
        hmac.update(query.getBytes("US-ASCII"));
        byte[] hmacResult = hmac.doFinal();
        return byteArrayToHex(hmacResult);
    }
}