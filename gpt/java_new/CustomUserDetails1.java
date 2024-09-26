import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails1 extends User {
    private final YourExtraUserInfo extraUserInfo;
    
    public CustomUserDetails1(String username, String password, Collection<? extends GrantedAuthority> authorities, YourExtraUserInfo extraUserInfo) {
        super(username, password, true, true, true, true, authorities);
        this.extraUserInfo = extraUserInfo;
    }
    
    public YourExtraUserInfo getExtraUserInfo() {
        return extraUserInfo;
    }
}

class YourExtraUserInfo {
    // This class must be defined with appropriate fields and methods
}