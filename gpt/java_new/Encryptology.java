import java.io.*;

public class Encryptology {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int move = Integer.parseInt(br.readLine());
        String st = br.readLine();
        StringBuilder s = new StringBuilder();

        for (int x = 0; x < st.length(); x++) {
            char c = st.charAt(x);
            if (Character.isLowerCase(c)) {
                c = (char) ((c - 'a' + move) % 26 + 'a');
            } else if (Character.isUpperCase(c)) {
                c = (char) ((c - 'A' + move) % 26 + 'A');
            }
            s.append(c);
        }

        System.out.println(s.toString());
    }
}