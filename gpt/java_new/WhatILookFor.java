public class WhatILookFor {
    public static void securelyWipe(char[] data) {
        if (data != null) {
            java.util.Arrays.fill(data, '\0');
        }
    }
    
    public static void main(String[] args) {
        char[] secret = new char[]{'f', 'o', 'o'};
        WhatILookFor.securelyWipe(secret);
    }
}