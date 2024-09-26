import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Arrays;

public class Temp404 {
    public static void main(String[] args) throws Exception {
        String message = "Hello, World!";
        String publicKeyString = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAo4hV7uc2b6fYFjXy5E0W" +
                "o5yD8Q5VjC7tB1yLwZg+D/HJSDxjZ2D6v4H3F9uF8w5EwJZ4BhJxCybk8F5ZQO1r" +
                "9p5B8nT5Y5Qo8V5x+Z6l7k6dBzVQX5Z5N3vqNFyfZtH9cGQ3tXk5IkYq0Vf5cG3y" +
                "mM8vG9B5GxY4K1Xr4hw7y8X1tM1Zz6TYP6XbQWmy5Xh9l0y6Q4+6h6y6gN8WzW3y" +
                "3vP5ZxFf8mXyKZ5wpuK8Xx7dY5RZyXz5v+q5h5er5Q5jvQ6v+6t5I5Xz5v+v5X5Y" +
                "5b+z7u5A5xD5o5l5o6v5m5z5u5o5x5r5n5s5t5v5w5x5y5z5A5B5C5D5E5F5G5H5" +
                "I5J5K5L5M5N5O5P5Q5R5S5T5U5V5W5X5Y5Z5a5b5c5d5e5f5g5h5i5j5k5l5m5n5" +
                "o5p5q5r5s5t5u5v5w5x5y5z5A5B5C5D5E5F5G5H5I5J5K5L5M5N5O5P5Q5R5S5T5" +
                "U5V5W5X5Y5Z5a5b5c5d5e5f5g5h5i5j5k5l5m5n5o5p5q5r5s5t5u5v5w5x5y5z5" +
                "A5B5C5D5E5F5G5H5I5J5K5L5M5N5O5P5Q5R5S5T5U5V5W5X5Y5Z5a5b5c5d5e5f5" +
                "g5h5i5j5k5l5m5n5o5p5q5r5s5t5u5v5w5x5y5z5A5B5C5D5E5F5G5H5I5J5K5L5" +
                "M5N5O5P5Q5R5S5T5U5V5W5X5Y5Z5a5b5c5d5e5f5g5h5i5j5k5l5m5n5o5p5q5r5" +
                "s5t5u5v5w5x5y5z5A5B5C5D5E5F5G5H5I5J5K5L5M5N5O5P5Q5R5S5T5U5V5W5X5" +
                "Y5Z5a5b5c5d5e5f5g5h5i5j5k5l5m5n5o5p5q5r5s5t5u5v5w5x5y5z5A5B5C5D5" +
                "E5F5G5H