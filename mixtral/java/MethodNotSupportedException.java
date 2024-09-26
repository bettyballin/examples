import org.springframework.web.HttpRequestMethodNotSupportedException;

public class MethodNotSupportedException extends HttpRequestMethodNotSupportedException {
    public MethodNotSupportedException(String msg) {
        super(msg);
    }

    public static void main(String[] args) {
        try {
            throw new MethodNotSupportedException("GET method not supported");
        } catch (MethodNotSupportedException e) {
            e.printStackTrace();
        }
    }
}