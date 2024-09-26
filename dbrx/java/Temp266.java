public class Temp266 {
    public static void main(String[] args) {
        int idxN = 5; // Example index value, replace with actual logic
        int idxR = 3; // Example index value, replace with actual logic
        String clean = "ExampleString"; // Example string, replace with actual logic

        if (idxN >= 0 && idxR >= 0) {
            if (idxN > idxR) {
                if(idxN <= clean.length()) {
                    clean = clean.substring(0, idxN);
                } else {
                    clean = clean;
                }
            } else {
                if(idxR <= clean.length()) {
                    clean = clean.substring(0, idxR);
                } else {
                    clean = clean;
                }
            }
        }

        System.out.println(clean);
    }
}