import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Secured {
    String[] value();
}

public class Temp283 {
    public static void main(String[] args) {
        Temp283 temp = new Temp283();
        temp.doWork();
    }

    @Secured({"ROLE_OPERATOR", "ROLE_USER"})
    public void doWork() {
        System.out.println("Work is being done.");
    }
}