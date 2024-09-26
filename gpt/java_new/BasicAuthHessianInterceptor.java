import com.caucho.hessian.client.HessianProxyFactory;

public class BasicAuthHessianInterceptor extends HessianProxyFactory {

    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void afterPropertiesSet() {
        HessianProxyFactory proxyFactory = this;
        proxyFactory.setUser(username);
        proxyFactory.setPassword(password);
    }
}