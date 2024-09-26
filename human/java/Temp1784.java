import java.util.ArrayList;
import java.util.List;

public class Temp1784 {
    public static void main(String[] args) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        System.out.println("Authorities: " + authorities);
    }
}

class SimpleGrantedAuthority {
    private String authority;

    public SimpleGrantedAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return authority;
    }
}