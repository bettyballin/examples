public class Temp682 {
    public static void main(String[] args) {
        System.out.println("Configure Authentication mechanism");
        
        System.out.println("authentication-manager alias=\"authenticationManager\"");
        
        System.out.println("<!-- DAO Based Security -->");
        System.out.println("authentication-provider");
        
        System.out.println("password-encoder hash=\"md5\"");
        System.out.println("jdbc-user-service data-source-ref=\"dataSource\"");
        System.out.println("users-by-username-query=\"SELECT U.username AS username, U.password as password, 'true' as enabled FROM user U where U.username=?\"");
        System.out.println("authorities-by-username-query=\"SELECT U.username as username, A.name as authority FROM user U left join user_roles UA on U.id=UA.user left join role A on UA.roles = A.id WHERE U.username=?\"");
        
        System.out.println("/authentication-provider");
        System.out.println("/authentication-manager");
    }
}