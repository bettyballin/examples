public class Temp520 {
    public static void main(String[] args) {
        // Mock classes to simulate the behavior
        class EAXE {
            @Override
            public String toString() {
                return "Instance of e.a.x.e";
            }
        }

        class EAXD {
            public EAXE a = new EAXE();

            public void asd() {
                System.out.println("Original e.a.x.d.asd() called");
            }
        }

        // Now we simulate the hooking and overriding asd method
        EAXD var_ddd = new EAXD() {
            @Override
            public void asd() {
                super.asd();
                System.out.println("e.a.x.d.asd() " + a);
            }
        };

        // Call the method to see the output
        var_ddd.asd();
    }
}