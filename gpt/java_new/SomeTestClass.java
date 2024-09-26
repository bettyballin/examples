import org.junit.jupiter.api.BeforeEach;

// Other imports and class declaration may be necessary depending on context.

public class SomeTestClass {

    private static final int EMPLOYEE_ID = 1; // Assuming EMPLOYEE_ID is a constant
    private Employee employee;
    private EmployeeDetails mockPrincipal;

    @BeforeEach
    void setUp() {
        employee = new Employee(); // Create an Employee object.
        employee.setId(EMPLOYEE_ID); // Set the employee ID.
        mockPrincipal = new EmployeeDetails(employee); // Initialize EmployeeDetails with employee.
    }
    
    // Other methods and class closing brace.
}