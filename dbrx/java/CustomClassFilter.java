// Save this file as CustomClassFilter.java
public interface ClassFilter {
    boolean isPermitted(String className);
}

class CustomClassFilter implements ClassFilter {
    @Override
    public boolean isPermitted(String className) {
        // Deny access to System.class or any other classes you want.
        return !className.equals("java.lang.System");
    }

    public static void main(String[] args) {
        CustomClassFilter filter = new CustomClassFilter();
        System.out.println("Is java.lang.String permitted? " + filter.isPermitted("java.lang.String"));
        System.out.println("Is java.lang.System permitted? " + filter.isPermitted("java.lang.System"));
    }
}