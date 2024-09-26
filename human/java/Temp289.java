import java.lang.reflect.Field;

public class Temp289 {
    public static void main(String[] args) {
        try {
            Field hack = Class.forName("sun.reflect.ReflectionFactory").getDeclaredField("inflationThreshold");
            hack.setAccessible(true);
            hack.setInt(null, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}