public class Temp2893 {
    public static void main(String[] args) {
        formLogin()
            .loginPage("/login")
            .usernameParameter("email")
            .passwordParameter("password")
            .defaultSuccessUrl("/app/user/dashboard")
            .failureUrl("/login?error=true");
    }

    public static FormLoginConfigurer formLogin() {
        return new FormLoginConfigurer();
    }
}

class FormLoginConfigurer {
    public FormLoginConfigurer loginPage(String url) {
        System.out.println("Login Page: " + url);
        return this;
    }

    public FormLoginConfigurer usernameParameter(String parameter) {
        System.out.println("Username Parameter: " + parameter);
        return this;
    }

    public FormLoginConfigurer passwordParameter(String parameter) {
        System.out.println("Password Parameter: " + parameter);
        return this;
    }

    public FormLoginConfigurer defaultSuccessUrl(String url) {
        System.out.println("Default Success URL: " + url);
        return this;
    }

    public FormLoginConfigurer failureUrl(String url) {
        System.out.println("Failure URL: " + url);
        return this;
    }
}