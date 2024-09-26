import java.lang.reflect.Field;

public class Temp3004 {
    private e.a.x.e a; // Sample field for demonstration

    public static void main(String[] args) {
        Temp3004 instance = new Temp3004();
        instance.execute();
    }

    public void execute() {
        Field lo_fld_eaxe = null;
        boolean lv_found = false;
        Field[] lt_fields = this.getClass().getDeclaredFields();
        for (int i = 0; i < lt_fields.length && lv_found == false; i++) {
            if (lt_fields[i].getName().equals("a") && lt_fields[i].getType().getName().equals("e.a.x.e")) {
                lo_fld_eaxe = lt_fields[i];
                lv_found = true;
            }
        }
        if (lv_found) {
            lo_fld_eaxe.setAccessible(true);
            try {
                Object lv_e_a_x_e = lo_fld_eaxe.get(this);
                System.out.println("Field value: " + lv_e_a_x_e);
            } catch (IllegalAccessException err) {
                System.out.println("Error: " + err);
            }
        }
    }
}

class e {
    public static class a {
        public static class x {
            public static class e {
                @Override
                public String toString() {
                    return "Instance of e.a.x.e";
                }
            }
        }
    }
}