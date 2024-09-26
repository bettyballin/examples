public class Temp135 {
    public static void main(String[] args) {
        // spacing modified for readability
        String strongName = "02F159CD1F48EEB372B36E0BA704A0BE";
        String moduleBase = "http://example.com/";

        String result = gwtStartLoadingFragment(moduleBase, strongName, "fragmentName");
        System.out.println(result);
    }

    public static String gwtStartLoadingFragment(String moduleBase, String strongName, String frag) {
        return moduleBase + "deferredjs/"  + strongName + '/' + frag + ".cache.js";
    }
}