import java.security.SecureRandom;
import java.util.stream.Collectors;

public class Temp1922 {
    public static void main(String[] args) {
        String randomCode = createRandomCode(10, "abcdefghijklmnopqrstuvwxyz");
        System.out.println(randomCode);
    }

    public static String createRandomCode(int codeLength, String id) {
        return new SecureRandom()
                .ints(codeLength, 0, id.length())
                .mapToObj(id::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}