import org.springframework.security.access.prepost.PreAuthorize;

public class Temp1310 {

    public static void main(String[] args) {
        Temp1310 temp = new Temp1310();
        temp.methodAccessibleByAnyone();
    }

    @PreAuthorize("hasAnyRole('GOOD_ROLE1','GOOD_ROLE2','GOOD_ROLE3') or !hasRole('THIRD_PARTY_ROLE')")
    public void methodAccessibleByAnyone() {
        System.out.println("Method executed");
    }
}