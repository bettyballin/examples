import java.lang.reflect.Method;

class Dummy {
    private void safeMethod() {
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        if (st.length > 5 &&
            st[4].getClassName().equals("java.lang.reflect.Method")) {
            throw new RuntimeException("safeMethod() is accessible only by Dummy object");
        }
        System.out.println("code of safe method");
    }

    public void trySafeMethod(){
        safeMethod();
    }

    Dummy() {
        safeMethod();
    }
}

class Dummy1 extends Dummy {}

class Test {
    public static void main(String[] args) throws Exception {
        Dummy1 d1 = new Dummy1();
        d1.trySafeMethod();
        System.out.println("-------------------");

        Method m2 = Dummy.class.getDeclaredMethod("safeMethod");
        m2.setAccessible(true);
        m2.invoke(d1);
    }
}