import java.lang.reflect.Field;

public class RefactorSnippet {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Safe safe = new Safe();
        Field field = safe.getClass().getDeclaredField("secret");
        field.setAccessible(true);
        String secret = (String) field.get(safe);
        System.out.println("The secret is: " + secret);
    }
}

class Safe {
    private String secret = "No More Secrets";
}