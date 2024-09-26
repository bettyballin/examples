import java.util.ArrayList;
import java.util.List;

public class Temp1261 {
    public static void main(String[] args) {
        Temp1261 temp = new Temp1261();
        temp.getGrantedAuthoritiesForStore();
    }

    private List<CustomGrantedAuthority> getGrantedAuthoritiesForStore() {
        List<CustomGrantedAuthority> authorities = new ArrayList<>();

        // Assuming you have a way of getting ownership for each role
        String storeRoleOwnership = "sec 18";

        CustomGrantedAuthority customAuth =
                new CustomGrantedAuthority("ROL_" + "store " + storeRoleOwnership);

        authorities.add(customAuth);

        System.out.print("authorities :" + authorities);

        return authorities;
    }

    class CustomGrantedAuthority {
        private String authority;

        public CustomGrantedAuthority(String authority) {
            this.authority = authority;
        }

        public String getAuthority() {
            return authority;
        }

        @Override
        public String toString() {
            return "CustomGrantedAuthority{" +
                    "authority='" + authority + '\'' +
                    '}';
        }
    }
}