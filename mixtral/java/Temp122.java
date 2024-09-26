public class Temp122 {
    public static void main(String[] args) {
        Temp122 temp = new Temp122();
        temp.Affine(5, 8);
    }

    public void Affine(int a, int b) {
        StringBuilder builder = new StringBuilder();
        String message = "examplemessage";  // Sample input message

        for (char currentChar : message.toCharArray()) {
            if (!Character.isLetter(currentChar)) {
                continue;
            }

            char finalChar = ((char) (((a * (currentChar - 'a') + b) % 26) + 'a'));

            builder.append(finalChar);
        }

        String result = builder.toString();

        System.out.println(result);  // Output the result
    }
}