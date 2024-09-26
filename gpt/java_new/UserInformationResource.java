import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/information")
public class UserInformationResource {

    @Context
    private SecurityContext securityContext;

    @GET
    public Response getInformation() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(securityContext.getUserPrincipal().getName());
        userInfo.setEmail("example@user.com");
        userInfo.setBorn("1.1.1111");
        
        return Response.ok(userInfo).build();
    }
    
    public static class UserInfo {
        private String username;
        private String email;
        private String born;
        
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getBorn() {
            return born;
        }

        public void setBorn(String born) {
            this.born = born;
        }
    }
}