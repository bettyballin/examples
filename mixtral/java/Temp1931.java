import java.util.ArrayList;
import java.util.List;

public class Temp1931 {
    static class SimpleGrantedAuthority {
        private String role;

        public SimpleGrantedAuthority(String role) {
            this.role = role;
        }

        @Override
        public String toString() {
            return role;
        }
    }

    public static void main(String[] args) {
        List<SimpleGrantedAuthority> roleList = new ArrayList<>();
        roleList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        for (SimpleGrantedAuthority authority : roleList) {
            System.out.println(authority);
        }
    }
}