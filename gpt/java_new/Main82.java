// Assuming 'tokens' is a defined array/list and 'log' is a method
class Token {
    TokenInfo getTokenInfo() {
        // Implementation that returns TokenInfo
        return new TokenInfo();
    }
}

class TokenInfo {
    int getPinCountLeft() {
        // Implementation that returns the count
        return 0;
    }
}

public class Main82 {
    // Assuming 'tokens' is initialized earlier in the code
    private static Token[] tokens;
    
    // Dummy log method to simulate logging
    private static void log(String message) {
        // Logging implementation
        System.out.println(message);
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < tokens.length; i++) {
            TokenInfo tokenInfo = tokens[i].getTokenInfo();
            int retriesLeft = tokenInfo.getPinCountLeft();
            
            if (retriesLeft >= 0) {
                log("Retries left: " + retriesLeft);
            }
        }
    }
}