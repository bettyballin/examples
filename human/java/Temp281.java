import org.springframework.web.context.request.RequestContextHolder;

public class Temp281 {
    public static void main(String[] args) {
        RequestContextHolder requestAttributesHolder = RequestContextHolder.getRequestAttributes();
        System.out.println(requestAttributesHolder);
    }
}