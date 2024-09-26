public class Temp2467 {
    public static void main(String[] args) {
        // Example usage of sync method
        Temp2467 temp = new Temp2467();
        MyClassRequest request = new MyClassRequest();
        try {
            ResponseClass response = temp.sync(request);
            // Handle response
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResponseClass sync(@BeanParam MyClassRequest request) throws Exception {
        // Your implementation here
        return new ResponseClass();
    }
}

// Assuming you have these classes defined somewhere
class MyClassRequest {
    // Your fields and methods here
}

class ResponseClass {
    // Your fields and methods here
}

// Placeholder annotation since @BeanParam is typically from JAX-RS
@interface BeanParam {
}