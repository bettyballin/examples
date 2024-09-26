Here is the corrected Java code:


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyAuthenticationEntryPoint extends org.springframework.security.web.authentication.Http403ForbiddenEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {

        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        super.commence(request, responseWrapper, exception);

        String jsonStr = new String(responseWrapper.getContentAsByteArray());
        ObjectMapper objectMapper = new ObjectMapper();

        // Convert JSON string to Java object
        ExceptionResponse libraryExceptionResponse = objectMapper.readValue(jsonStr, ExceptionResponse.class);

        // Create a company-specific error message and add the original error as reason
        CompanyError companyError = new CompanyError("COMPANY_001",
                "Authentication token is missing but its company standard message!");

        List<Error> errors = libraryExceptionResponse.getErrors();
        if (errors == null || errors.isEmpty()) {
            responseWrapper.resetBuffer();
            responseWrapper.getWriter().write(objectMapper.writeValueAsString(companyError));
            responseWrapper.copyBodyToResponse();
            return;
        }

        List<Reason> reasons = libraryExceptionResponse.getErrors().get(0).getReasons();
        if (reasons == null) {
            reasons = new ArrayList<>();
        }
        if (!reasons.isEmpty()) {
            Reason reason = new Reason(libraryExceptionResponse.getErrors().get(0).getReasons().get(0));
            reasons.add(reason);
        }
        companyError.setReasons(reasons);

        // Convert Java object to JSON string
        String modifiedJsonStr = objectMapper.writeValueAsString(companyError);

        responseWrapper.resetBuffer();
        responseWrapper.getWriter().write(modifiedJsonStr);
        responseWrapper.copyBodyToResponse();
    }
}

class ExceptionResponse {
    private List<Error> errors;

    // getters and setters

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}

class Error {
    private List<Reason> reasons;

    // getters and setters

    public List<Reason> getReasons() {
        return reasons;
    }

    public void setReasons(List<Reason> reasons) {
        this.reasons = reasons;
    }
}

class Reason {
    private String message;

    public Reason() {}

    public Reason(Reason reason) {
        this.message = reason.getMessage();
    }

    // getters and setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

class CompanyError {
    private String code;
    private String message;
    private List<Reason> reasons;

    public CompanyError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    // getters and setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Reason> getReasons() {
        return reasons;
    }

    public void setReasons(List<Reason> reasons) {
        this.reasons = reasons;
    }
}