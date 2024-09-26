import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface MyUserRoleCheck {
    MyAppRole value();
}

enum MyAppRole {
    Admin, User
}

public class Temp570 {
    public static void main(String[] args) {
        Temp570 temp = new Temp570();
        temp.someMethod();
    }

    @MyUserRoleCheck(MyAppRole.Admin)
    public void someMethod() {
        System.out.println("Method with MyUserRoleCheck annotation executed.");
    }
}