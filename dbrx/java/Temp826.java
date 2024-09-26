public class Temp826 {
    public static void main(String[] args) {
        System.out.println("Temp826 main method executed.");
    }

    public interface MethodSecurityService {
        boolean hasRole(String role);
    }
}


Should be:


public class Temp826 {
    public static void main(String[] args) {
        System.out.println("Temp826 main method executed.");
    }
}

interface MethodSecurityService {
    boolean hasRole(String role);
}