import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;

@ServletSecurity(
    httpMethodConstraints = {
        @HttpMethodConstraint(value = "GET", rolesAllowed = "SSORole"),
        @HttpMethodConstraint(value = "POST", rolesAllowed = "SSORole", transportGuarantee = TransportGuarantee.CONFIDENTIAL)
    }
)
public class Temp1122 {
    public static void main(String[] args) {
        System.out.println("Servlet security annotations applied.");
    }
}