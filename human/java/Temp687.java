public class Temp687 {
    public static final String DEF_USERS_BY_USERNAME_QUERY =
            "select username,password,enabled " +
            "from users " +
            "where username = ?";
    public static final String DEF_AUTHORITIES_BY_USERNAME_QUERY =
            "select username,authority " +
            "from authorities " +
            "where username = ?";
    public static final String DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY =
            "select g.id, g.group_name, ga.authority " +
            "from groups g, group_members gm, group_authorities ga " +
            "where gm.username = ? " +
            "and g.id = ga.group_id " +
            "and g.id = gm.group_id";

    public static void main(String[] args) {
        System.out.println(DEF_USERS_BY_USERNAME_QUERY);
        System.out.println(DEF_AUTHORITIES_BY_USERNAME_QUERY);
        System.out.println(DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY);
    }
}