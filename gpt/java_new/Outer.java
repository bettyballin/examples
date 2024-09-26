public class Outer {

    private static Outer instance;
    private Outer() {}
    
    public static synchronized Outer getInstance() {
        if (instance == null) {
            instance = new Outer();
        }
        return instance;
    }

    public static class Inner {
        public Inner() {}
        
        // Inner class methods, which can access Outer's private members
        // but should not instantiate Outer to preserve Singleton property.
    }
}