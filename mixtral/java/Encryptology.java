import java.io.*;

public class Encryptology {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int move = Integer.parseInt(br.readLine());

        String st = br.readLine();
        String s = "";

        for (int x = 0; x < st.length(); x++) {
            char c = st.charAt(x);

            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                int t = (int) c;
                int offset = move % 26;

                // For lowercase letters
                if ('a' <= c && c <= 'z') {
                    t = (t - 'a' + offset) % 26 + 'a';
                    c = (char) t;
                    s += c;
                } else {
                    // For uppercase letters
                    t = (t - 'A' + offset) % 26 + 'A';
                    c = (char) t;
                    s += c;
                }
            } else {
                s += st.charAt(x);
            }
        }

        System.out.println("Encrypted text: " + s);
    }
}