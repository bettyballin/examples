import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Temp584 {
    public static void main(String[] args) {

    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CourseRoleCheck {
        String courseId();
        Role role();
    }

    public enum Role {
        STUDENT, INSTRUCTOR, ADMIN
    }
}