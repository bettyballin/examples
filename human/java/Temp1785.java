import java.util.ArrayList;
import java.util.List;

class SimpleGrantedAuthority {
    private String role;

    public SimpleGrantedAuthority(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SimpleGrantedAuthority{" +
                "role='" + role + '\'' +
                '}';
    }
}

public class Temp1785 {
    public static void main(String[] args) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        
        System.out.println(authorities);
    }
}