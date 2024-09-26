import javax.validation.Valid;

public class Temp3628 {
    public static void main(String[] args) {
        // This is just for demonstration purposes.
        // In a real Spring Boot application, this would be handled by the framework.
    }

    @PostMapping("/addFriend")
    public String getPost(@Valid @ModelAttribute("formData") AssignFriendFormData formData) {
        CustomerService customerService = new CustomerService(); // Assuming you have a service to get customers
        
        Customer friendCustomer = customerService.findById(formData.getFriendId());
        Customer currCustomer = customerService.findById(formData.getCustomerId());
        
        System.out.println(currCustomer.getFirstName());
        System.out.println(friendCustomer.getFirstName());
        
        return "redirect:/home";
    }
}

// Assuming AssignFriendFormData, Customer, and CustomerService are defined elsewhere in your codebase.
// Below are dummy implementations for the sake of completeness.

class AssignFriendFormData {
    private Long friendId;
    private Long customerId;

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}

class Customer {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}

class CustomerService {
    public Customer findById(Long id) {
        Customer customer = new Customer();
        customer.setFirstName("John Doe"); // Dummy data
        return customer;
    }
}