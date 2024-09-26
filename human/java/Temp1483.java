public class Temp1483 {
    public static void main(String[] args) {
        String jdbcUserService = "<jdbc-user-service data-source-ref=\"dataSource\" " +
                "users-by-username-query=\"select email, password, true from users where email=?\" " +
                "authorities-by-username-query=\"select u.email, ur.role from user_roles ur left outer join users u on (ur.user_id = u.id) where u.email=?\"/>";
        
        System.out.println(jdbcUserService);
    }
}