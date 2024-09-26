public class Temp2949 {
    public static void main(String[] args) {
        String name = "MYNAMEISJOHN";
        String paddedName = "$$" + name + "$$";
        for (int i = 0; i < paddedName.length() - 2; i++) {
            System.out.println(paddedName.substring(i, i + 3));
        }
    }
}