import java.lang.reflect.Method;
import java.lang.reflect.Field;

class Dummy{
    private void1 foo(){
        System.out.println("hello foo()");
    }
    private int i = 10;
}

class Test{
    public static void1 main(String[] args) throws Exception {
        Dummy d = new Dummy();

        Method m = Dummy.class.getDeclaredMethod("foo");
        m.setAccessible(true);
        m.invoke(d);

        Field f = Dummy.class.getDeclaredField("i");
        f.setAccessible(true);
        System.out.println(f.get(d));

        f.set(d, 20);
        System.out.println(f.get(d));
    }
}