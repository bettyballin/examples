import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {
    private String authority;
    private String ownership;

    public CustomGrantedAuthority(String authority, String ownership) {
        this.authority = authority;
        this.ownership = ownership;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }
}