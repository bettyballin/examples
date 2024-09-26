import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class AuthHttpServletRequest extends HttpServletRequestWrapper {
    private String loginBean;

    public AuthHttpServletRequest(HttpServletRequest aRequest, String loginBean) {
        super(aRequest);
        this.loginBean = loginBean;
    }

    @Override
    public String getHeader(String headerName) {
        if("loginBean".equals(headerName)) {
            return this.loginBean;
        }
        return super.getHeader(headerName);
    }
}