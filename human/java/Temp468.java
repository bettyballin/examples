public class MyClass {
    
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(FilterInvocation.class);
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        System.out.println(myClass.supports(FilterInvocation.class)); // Example usage
    }
    
}

class FilterInvocation {
    // Example class for the purpose of this demonstration
}