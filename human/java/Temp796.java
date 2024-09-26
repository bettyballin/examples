public class Temp796 {
    public static void main(String[] args) {
        try {
            throw new NoClassDefFoundError("org/springframework/aop/config/AbstractInterceptorDrivenBeanDefinitionDecorator");
        } catch (NoClassDefFoundError e) {
            System.out.println("Constructor threw exception; nested exception is " + e);
        }
    }
}