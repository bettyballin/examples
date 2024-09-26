import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class Temp1103 {
    public static void main(String[] args) {
        Temp1103 temp = new Temp1103();
        User user = temp.getUser();
        System.out.println(user);
    }

    @PostAuthorize("hasRole('ADMIN')")
    // or
    // @PreAuthorize("hasRole('ADMIN')")
    public User getUser() {
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
                "username",
                "password",
                true,
                true,
                true,
                true,
                AuthorityUtils.createAuthorityList("ADMIN")
        );

        return user;
    }
}