import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Class<?>, String[]> fieldFilterMap;
    private static final Map<Class<?>, String[]> methodFilterMap;

    static {
        Map<Class<?>, String[]> map = new HashMap<>();
        map.put(Reflection.class, new String[]{"fieldFilterMap", "methodFilterMap"});
        map.put(System.class, new String[]{"security"});
        fieldFilterMap = map;

        methodFilterMap = new HashMap<>();
    }

    public static void main(String[] args) {
        // Your code to use fieldFilterMap and methodFilterMap
        System.out.println(fieldFilterMap);
        System.out.println(methodFilterMap);
    }

    private static class Reflection {
        // Dummy class to make the code compile
    }
}