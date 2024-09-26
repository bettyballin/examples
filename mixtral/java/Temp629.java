import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Constraint(validatedBy = PathVariableValidatorImpl.class)
public @interface ValidPathVariable {
    String message() default "Invalid path variable";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

// PathVariableValidatorImpl.java
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PathVariableValidatorImpl implements ConstraintValidator<ValidPathVariable, String> {

    @Override
    public void initialize(ValidPathVariable constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Implement your validation logic here
        return value != null && !value.trim().isEmpty();
    }
}

// Main.java
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Method method = Main.class.getMethod("exampleMethod", String.class);
        Object[] parameterValues = {""}; // Invalid value for demonstration

        Set<ConstraintViolation<Main>> violations = validator.forExecutables().validateParameters(
                new Main(), method, parameterValues);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Main> violation : violations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("No validation errors.");
        }
    }

    public void exampleMethod(@ValidPathVariable String pathVariable) {
        // Method implementation here
    }
}