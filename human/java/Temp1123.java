public class Temp1123 {
    public static void main(String[] args) {
        MyRememberMeServices myRememberMeServices = myRememberMeServices();
        System.out.println("RememberMeService cookie name: " + myRememberMeServices.getCookieName());
    }

    public static MyRememberMeServices myRememberMeServices(){
        String REMEMBERME_KEY = "someKey"; // Replace with actual key
        UserDetailsService formUserDetailsService = new InMemoryUserDetailsManager(); // Replace with actual UserDetailsService implementation

        MyRememberMeServices service = new MyRememberMeServices(REMEMBERME_KEY, formUserDetailsService);
        service.setAlwaysRemember(true);
        service.setCookieName("xxxx");
        service.setParameter("_spring_security_remember_me");
        service.setTokenValiditySeconds(123);
        return service;
    }
}

// Mock classes for the purpose of making the code executable
class MyRememberMeServices {
    private String key;
    private UserDetailsService userDetailsService;
    private boolean alwaysRemember;
    private String cookieName;
    private String parameter;
    private int tokenValiditySeconds;

    public MyRememberMeServices(String key, UserDetailsService userDetailsService) {
        this.key = key;
        this.userDetailsService = userDetailsService;
    }

    public void setAlwaysRemember(boolean alwaysRemember) {
        this.alwaysRemember = alwaysRemember;
    }

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public void setTokenValiditySeconds(int tokenValiditySeconds) {
        this.tokenValiditySeconds = tokenValiditySeconds;
    }

    public String getCookieName() {
        return cookieName;
    }
}

interface UserDetailsService {}

class InMemoryUserDetailsManager implements UserDetailsService {}