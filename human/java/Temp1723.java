public class Temp1723 {
    public static void main(String[] args) {
        String[] paths = {"/public/**", "/resources/**", "/resources/public/**"};
        permitAll(paths);
    }

    public static void permitAll(String[] paths) {
        for (String path : paths) {
            System.out.println("Permitting access to: " + path);
        }
    }
}