import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AuthenticationDetailsSource;

public class ExtraParamSource implements AuthenticationDetailsSource<HttpServletRequest, ExtraParam> {

    @Override
    public ExtraParam buildDetails(HttpServletRequest context) {
        return new ExtraParam(context.getParameter("extraParam"));
    }
}

class ExtraParam {
    private String extraParam;

    public ExtraParam(String extraParam) {
        this.extraParam = extraParam;
    }

    // Getters and setters for extraParam
    public String getExtraParam() {
        return extraParam;
    }

    public void setExtraParam(String extraParam) {
        this.extraParam = extraParam;
    }
}