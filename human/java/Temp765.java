public class Temp765 {
    public static void main(String[] args) {
        Object ade = new AccessDeniedExceptionWithConfigAttributes();

        if (ade instanceof AccessDeniedExceptionWithConfigAttributes) {
            AccessDeniedExceptionWithConfigAttributes adeca = (AccessDeniedExceptionWithConfigAttributes) ade;
            // Add your code here
            System.out.println("Instance check passed");
        }
    }
}

class AccessDeniedExceptionWithConfigAttributes {
    // Add any necessary fields or methods here
}