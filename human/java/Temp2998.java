public class Temp2998 {
    public static void main(String[] args) {
        BindingResult bindingResult = new BindingResult();
        if (bindingResult.hasErrors()) {
            System.out.println("register");
        }
    }
}

class BindingResult {
    public boolean hasErrors() {
        // Simulating an error for demonstration purposes
        return true;
    }
}