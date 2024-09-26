class SecurityContext {
    private String principal;

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }
}

class Context {
    private SecurityContext securityContext;

    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    public void setSecurityContext(SecurityContext securityContext) {
        this.securityContext = securityContext;
    }
}

public class Temp946 {
    public static void main(String[] args) {
        Context ctx = new Context();
        SecurityContext securityContext = new SecurityContext();
        String customPrincipal = "customPrincipal";

        securityContext.setPrincipal(customPrincipal);
        ctx.setSecurityContext(securityContext);

        System.out.println("Security Context Principal: " + ctx.getSecurityContext().getPrincipal());
    }
}