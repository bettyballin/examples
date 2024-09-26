import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class Temp169 {
    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager());
        Unsafe unsafe = getUnsafe();
        if (unsafe == null) {
            System.out.println("Unable to obtain Unsafe instance");
        } else {
            System.out.println("Unsafe instance obtained");
        }
    }

    private static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}