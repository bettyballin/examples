import org.springframework.security.access.vote.RoleVoter;

public class MyRoleVoter extends RoleVoter {
    public MyRoleVoter() {
        setRolePrefix("");
    }

    public static void main(String[] args) {
        MyRoleVoter voter = new MyRoleVoter();
        System.out.println("Role prefix: " + voter.getRolePrefix());
    }
}