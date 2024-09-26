import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

public class RefactorSnippet5 {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");

        int count = 5;
        byte[] salt = new byte[8];

        generator.initialize(1024);
        KeyPair kPair = generator.genKeyPair();

        byte[] privateKey = kPair.getPrivate().getEncoded();

        String stringPb = "PBEWithSHA1AndDESede";
        String password = "your_own_password";

        SecureRandom rndm = new SecureRandom();
        rndm.nextBytes(salt);

        PBEParameterSpec paramSpec = new PBEParameterSpec(salt, count);
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());

        SecretKeyFactory factory = SecretKeyFactory.getInstance(stringPb);
        SecretKey pbeKey = factory.generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance(stringPb);

        cipher.init(Cipher.ENCRYPT_MODE, pbeKey, paramSpec);

        byte[] text = cipher.doFinal(privateKey);

        AlgorithmParameters parameters = AlgorithmParameters.getInstance(stringPb);
        parameters.init(paramSpec);
        EncryptedPrivateKeyInfo encinfo = new EncryptedPrivateKeyInfo(parameters, text);
    }
}