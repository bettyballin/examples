import java.util.ArrayList;
import java.util.List;

public class Temp2087 {

    public static void main(String[] args) {
        // Example usage
        UserVO userVO = new UserVO(new RoleVO("ADMIN"));
        Temp2087 temp = new Temp2087();
        List<SimpleGrantedAuthority> authorities = temp.buildSimpleGrantedAuthority(userVO);
        authorities.forEach(authority -> System.out.println(authority.getAuthority()));
    }

    private List<SimpleGrantedAuthority> buildSimpleGrantedAuthority(final UserVO userVO) {
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (userVO.getRoleVO() != null) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + userVO.getRoleVO().getRoleName()));
        }
        return grantedAuthorities;
    }
}

class SimpleGrantedAuthority {
    private String authority;

    public SimpleGrantedAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}

class UserVO {
    private RoleVO roleVO;

    public UserVO(RoleVO roleVO) {
        this.roleVO = roleVO;
    }

    public RoleVO getRoleVO() {
        return roleVO;
    }

    public void setRoleVO(RoleVO roleVO) {
        this.roleVO = roleVO;
    }
}

class RoleVO {
    private String roleName;

    public RoleVO(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}