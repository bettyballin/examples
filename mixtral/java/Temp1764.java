public class Temp1764 {
    public static void main(String[] args) {
        Temp1764 app = new Temp1764();
        MyTransformedPrincipal principal = new MyTransformedPrincipal();
        app.getWithTransformedPrincipal(principal);
    }

    public void getWithTransformedPrincipal(@CustomAuthPrincipal MyTransformedPrincipal principal) {
        // Implement your logic here
        System.out.println("Method called with principal: " + principal);
    }
}

// Mock classes to make the code executable
class MyTransformedPrincipal {
    @Override
    public String toString() {
        return "MyTransformedPrincipal Instance";
    }
}

@interface CustomAuthPrincipal {
}