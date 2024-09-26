import java.util.Objects;

public final class CextenderWrapper {
    private final Class<?> value;

    public CextenderWrapper(Class<? extends C> c) throws Exception {
        this.value = Objects.requireNonNull(c);

        if (!C.class.isAssignableFrom(this.value))
            throw new IllegalArgumentException("The given class is not extending C");
    }

    public Class<?> getValue() {
         return value;
     }

    public static void main(String[] args) {
        try {
            CextenderWrapper wrapper = new CextenderWrapper(D.class);
            System.out.println("Wrapped class: " + wrapper.getValue().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class C {
    // Base class
}

class D extends C {
    // Subclass of C
}