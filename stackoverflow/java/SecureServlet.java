import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.TransportGuarantee;

@ServletSecurity(httpMethodConstraints = {
    @HttpMethodConstraint(value = "GET", rolesAllowed = "SSORole"),
    @HttpMethodConstraint(value = "POST", rolesAllowed = "SSORole", transportGuarantee = TransportGuarantee.CONFIDENTIAL)
})
public class SecureServlet {
    // Implementation of the servlet
}