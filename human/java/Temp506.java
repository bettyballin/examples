public class Temp506 {
    public static void main(String[] args) {
        String authenticationManager = "<authentication-manager>" +
                "<authentication-provider>" +
                "<jdbc-user-service id=\"jdbcUserService\" data-source-ref=\"dataSource\"" +
                " users-by-username-query=\"select username,password, enabled from users where username=?\"" +
                " authorities-by-username-query=\"select u.username, ur.authority from users u, user_roles ur where u.user_id = ur.user_id and u.username =?\"" +
                "/>" +
                "</authentication-provider>" +
                "</authentication-manager>";

        System.out.println(authenticationManager);
    }
}