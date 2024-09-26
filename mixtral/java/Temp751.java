import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp751 {
    public static void main(String[] args) {
        Temp751 temp = new Temp751();
        System.out.println("Generated OTP: " + temp.generateOTP());
    }

    public String generateOTP() {
        SecureRandom secureRandom = new SecureRandom();

        int otpLength = 6;

        StringBuilder stringBuilder = new StringBuilder(otpLength);

        for (int i = 0; i < otpLength; ++i)
            stringBuilder.append((char) (secureRandom.nextInt(10) + 48));

        return stringBuilder.toString();
    }
}