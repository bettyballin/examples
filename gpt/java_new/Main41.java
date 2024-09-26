// Assuming this is a part of a larger code where 'rsa' is an object of a class that has 'e' and 'n' as fields.
class RSA {
    public int e;
    public int n;
    
    // Constructor, getters, setters, etc. are assumed to be present
}

public class Main41 {
    public static void main(String[] args) {
        RSA rsa = new RSA(); // Assume appropriate values are initialized in the constructor or elsewhere
        System.out.println("Public Key: (" + rsa.e + ", " + rsa.n + ")");
    }
}