import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

class AlgorithmIdentifier {
    private String algorithm;

    public AlgorithmIdentifier(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    @Override
    public String toString() {
        return "AlgorithmIdentifier{" +
                "algorithm='" + algorithm + '\'' +
                '}';
    }
}

class DigestInfo {
    private AlgorithmIdentifier digestAlgorithm;
    private byte[] digest;

    public DigestInfo(AlgorithmIdentifier digestAlgorithm, byte[] digest) {
        this.digestAlgorithm = digestAlgorithm;
        this.digest = digest;
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return digestAlgorithm;
    }

    public byte[] getDigest() {
        return digest;
    }

    @Override
    public String toString() {
        return "DigestInfo{" +
                "digestAlgorithm=" + digestAlgorithm +
                ", digest=" + Arrays.toString(digest) +
                '}';
    }
}

public class Temp11 {
    public static void main(String[] args) {
        try {
            String algorithm = "SHA-256";
            String input = "Hello, World!";
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            byte[] digest = messageDigest.digest(input.getBytes());

            AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(algorithm);
            DigestInfo digestInfo = new DigestInfo(algorithmIdentifier, digest);

            System.out.println(digestInfo);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}