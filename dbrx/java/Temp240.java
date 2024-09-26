import org.bouncycastle.crypto.generators.Argon2BytesGenerator;
import org.bouncycastle.crypto.params.Argon2Parameters;

public class Temp240 {

    public static void main(String[] args) {
        String password = "password"; // Example password
        String salt = "salt"; // Example salt

        int iterations = 3; // or more depending on your requirements
        int memory = 65536; // in KB
        int parallelism = 1;

        Argon2BytesGenerator gen = new Argon2BytesGenerator();
        gen.init(new Argon2Parameters.Builder(Argon2Parameters.ARGON2_i)
                .withVersion(Argon2Parameters.ARGON2_VERSION_13)
                .withIterations(iterations)
                .withMemoryAsKB(memory)
                .withParallelism(parallelism)
                .withSalt(salt.getBytes())
                .build());
        
        byte[] hash = new byte[32];
        gen.generateBytes(password.getBytes(), hash);

        System.out.println("Hash: " + bytesToHex(hash));
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}