import java.lang.reflect.Field;

class Safe {
    private String secret = "This is a secret message";
}

public class Temp168 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Safe safe = new Safe();
        Field field = safe.getClass().getDeclaredField("secret");
        field.setAccessible(true);
        String secret = (String) field.get(safe);
        System.out.println(secret);
    }
}