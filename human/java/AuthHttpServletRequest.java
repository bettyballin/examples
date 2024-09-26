import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class AuthHttpServletRequest extends HttpServletRequestWrapper
{
    private String loginBean;

    public AuthHttpServletRequest(HttpServletRequest aRequest, String loginBean)
    {
        super(aRequest);
        this.loginBean = loginBean;
    }

    @Override
    public String getHeader(String headerName)
    {
        if(CommonVariables.LOGIN_BEAN.equals(headerName)) {
            return this.loginBean;
        }
        return super.getHeader(headerName);
    }

    public static void main(String[] args) {
        // You can write your test code here if needed
    }
}

class CommonVariables {
    public static final String LOGIN_BEAN = "loginBean";
}