import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

public class Temp2554 {

    public static void main(String[] args) {
        try {
            // Replace these with actual RSA public key modulus and exponent
            RSAPublicKey rsapubkey = null; // Obtain the RSA public key from somewhere

            byte[] n = rsapubkey.getModulus().toByteArray(); // Java is 2sC bigendian
            byte[] e = rsapubkey.getPublicExponent().toByteArray(); // and so is SSH
            byte[] tag = "ssh-rsa".getBytes(); // charset very rarely matters here
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeInt(tag.length);
            dos.write(tag);
            dos.writeInt(e.length);
            dos.write(e);
            dos.writeInt(n.length);
            dos.write(n);
            byte[] encoded = os.toByteArray();
            // now hash that (you don't really need Apache)
            // assuming SHA256-base64 (see below)
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] result = digest.digest(encoded);
            String output = Base64.getEncoder().encodeToString(result);

            System.out.println(output);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}