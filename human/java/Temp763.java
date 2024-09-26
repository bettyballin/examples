import java.nio.file.AccessDeniedException;

public class Temp763 {
    public static void main(String[] args) {
        try {
            throw new AccessDeniedException("Access is denied");
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
    }
}