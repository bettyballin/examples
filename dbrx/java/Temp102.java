public class Temp102 {
    public static void main(String[] args) {

        String inputStr = "ABCZ";
        int numToAdd = 2;

        StringBuilder resultBuilder = new StringBuilder();
        for (char c : inputStr.toCharArray()) {
            int asciiCode = (int)c;
            if (numToAdd > 0) {
                asciiCode = (asciiCode - 'A' + numToAdd) % 26 + 'A';
            } else if (numToAdd < 0) {
                asciiCode = (asciiCode - 'A' + 26 + numToAdd) % 26 + 'A';
            }

            resultBuilder.append((char)asciiCode);
        }

        String outputStr = resultBuilder.toString();
        System.out.println("Output: " + outputStr); 
    }
}