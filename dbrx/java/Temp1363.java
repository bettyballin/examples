import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        // Assuming e.a.x.e is some class you want to use
        class E {
            // This is just a placeholder for e.a.x.e
        }

        class MyClass {
            public E myField = new E();
        }

        Class<?> eType = E.class;
        MyClass myObject = new MyClass();

        for (Field field : myObject.getClass().getDeclaredFields()) {
            if (field.getType().equals(eType)) {
                try {
                    field.setAccessible(true);
                    System.out.println(field.get(myObject));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}