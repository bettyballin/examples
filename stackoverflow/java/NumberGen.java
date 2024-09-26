public class NumberGen {

    public static void main(String[] args) {

        long timeSeed = System.nanoTime();

        double randSeed = Math.random() * 1000;

        long midSeed = (long) (timeSeed * randSeed);

        String s = Long.toString(midSeed);
        String subStr = s.substring(0, Math.min(9, s.length()));

        int finalSeed;
        try {
            finalSeed = Integer.parseInt(subStr);
        } catch (NumberFormatException e) {
            finalSeed = -1; // Handle the parsing error
        }

        System.out.println(finalSeed);
    }

}