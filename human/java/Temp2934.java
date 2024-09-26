import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.*;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;

public class Temp2934 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            KeyPair kPair = generator.genKeyPair();

            byte[] privateKey = kPair.getPrivate().getEncoded();

            String stringPb = "PBEWithSHA1AndDESede";
            String password = "your_own_password";

            SecureRandom rndm = new SecureRandom();
            byte[] salt = new byte[8];
            rndm.nextBytes(salt);

            int count = 5;
            PBEParameterSpec paramSpec = new PBEParameterSpec(salt, count);
            PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());

            SecretKeyFactory factory = SecretKeyFactory.getInstance(stringPb);
            SecretKey pbeKey = factory.generateSecret(keySpec);

            Cipher cipher = Cipher.getInstance(stringPb);
            cipher.init(Cipher.ENCRYPT_MODE, pbeKey, paramSpec);

            byte[] text = cipher.doFinal(privateKey);

            AlgorithmParameters parametres = AlgorithmParameters.getInstance(stringPb);
            parametres.init(paramSpec);
            EncryptedPrivateKeyInfo encinfo = new EncryptedPrivateKeyInfo(parametres, text);

            System.out.println("Encryption successful");

        } catch (NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException |
                InvalidKeyException | InvalidAlgorithmParameterException | BadPaddingException |
                IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }
}