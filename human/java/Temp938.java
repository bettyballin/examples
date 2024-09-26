public class Temp938 {
    public static void main(String[] args) {
        try {
            throw new NoSuchBeanDefinitionException("customUserDetailsService");
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'customUserDetailsService'");
        }
    }
}

class NoSuchBeanDefinitionException extends Exception {
    public NoSuchBeanDefinitionException(String message) {
        super(message);
    }
}