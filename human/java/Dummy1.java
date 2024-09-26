import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Dummy1{
    private void foo(){
        System.out.println("hello foo()");
    }
    private int i = 10;
}

class Test{
    public static void main(String[] args) throws Exception {
        Dummy1 d = new Dummy1();

        /*---  [INVOKING PRIVATE METHOD]  ---*/
        Method m = Dummy1.class.getDeclaredMethod("foo");
        //m.invoke(d); // Exception java.lang.IllegalAccessException
        m.setAccessible(true);//Abracadabra
        m.invoke(d); // Now it's OK

        /*---  [GETTING VALUE FROM PRIVATE FIELD]  ---*/
        Field f = Dummy1.class.getDeclaredField("i");
        //System.out.println(f.get(d)); // Not accessible now
        f.setAccessible(true); // Abracadabra
        System.out.println(f.get(d)); // Now it's OK

        /*---  [SETTING VALUE OF PRIVATE FIELD]  ---*/
        Field f2 = Dummy1.class.getDeclaredField("i");
        //f2.set(d,20); // Not accessible now
        f2.setAccessible(true); // Abracadabra
        f2.set(d, 20); // Now it's OK
        System.out.println(f2.get(d));
    }
}