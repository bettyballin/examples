import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Temp1921 {
    public static void main(String[] args) {
        Temp1921 temp = new Temp1921();
        String randomCode = temp.createRandomCode(5, "exampleID");
        System.out.println(randomCode);
    }

    public String createRandomCode(int codeLength, String id) {   
        List<Character> temp = id.chars()
                .mapToObj(i -> (char)i)
                .collect(Collectors.toList());
        Collections.shuffle(temp, new SecureRandom());
        return temp.stream()
                .map(Object::toString)
                .limit(codeLength)
                .collect(Collectors.joining());
    }
}