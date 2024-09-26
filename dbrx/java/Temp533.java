public class Temp533 {
    public static void main(String[] args) {
        Object userDetails = getUserDetails(); // This is just a placeholder. Replace with actual user details retrieval.
        
        if (userDetails instanceof EmployerUserDetails) {
            // User is employer
            System.out.println("User is employer");
        } else {
            // User is employee
            System.out.println("User is employee");
        }
    }

    // Placeholder method. Replace with actual implementation.
    public static Object getUserDetails() {
        // Return an instance of EmployerUserDetails or EmployeeUserDetails for testing
        return new EmployerUserDetails(); // or new EmployeeUserDetails();
    }
}

class EmployerUserDetails {
    // Employer user details implementation
}

class EmployeeUserDetails {
    // Employee user details implementation
}