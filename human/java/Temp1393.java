public class Temp1393 {
    public static void main(String[] args) {
        String ldapProviderConfig = "<security:ldap-authentication-provider\n" +
                "        group-search-filter=\"member={0}\"\n" +
                "        group-search-base=\"ou=groups\"\n" +
                "        user-search-base=\"ou=people\"\n" +
                "        user-search-filter=\"uid={0}\"\n" +
                "    />";

        System.out.println(ldapProviderConfig);
    }
}