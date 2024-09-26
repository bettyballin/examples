public class PasswordRetry {
    public static void main(String[] args) {
        int maxRetries = 3; // Set your desired maximum password retry limit
        TokenInfo tokenInfo = new TokenInfo();
        
        boolean isFinalTry = tokenInfo.isSOpinInFinalRetry();

        if (isFinalTry) {
            System.out.println("This will be the final attempt before locking out.");
        } else if (maxRetries > 0) {
            maxRetries--;
            System.out.println("You have " + maxRetries + " attempts remaining");
        }
    }
}

class TokenInfo {
    public boolean isSOpinInFinalRetry() {
        // For demonstration purposes, we'll simulate a condition.
        // In a real-world scenario, this method would check actual token state.
        return false;
    }
}