import java.security.Principal;

public class CustomPrincipal implements Principal {
    private String name;

    public CustomPrincipal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object another) {
        if (!(another instanceof CustomPrincipal)) return false;
        return ((CustomPrincipal) another).getName().equals(getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public String toString() {
        return "CustomPrincipal: " + name;
    }

    @Override
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        CustomPrincipal cp1 = new CustomPrincipal("Alice");
        CustomPrincipal cp2 = new CustomPrincipal("Bob");
        CustomPrincipal cp3 = new CustomPrincipal("Alice");

        System.out.println(cp1);
        System.out.println(cp2);
        System.out.println(cp3);
        System.out.println(cp1.equals(cp2)); // false
        System.out.println(cp1.equals(cp3)); // true
    }
}