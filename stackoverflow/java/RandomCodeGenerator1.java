import java.security.SecureRandom;
import java.util.stream.Collectors;

public class RandomCodeGenerator1 {

    public static String createRandomCode(int codeLength, String id) {
        return new SecureRandom()
                .ints(codeLength, 0, id.length())
                .mapToObj(id::charAt)
                .collect(Collectors.joining());
    }
}