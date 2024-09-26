public class Temp1121 {

    private String name;

    public Temp1121(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Temp1121 role1 = new Temp1121("Admin");
        Temp1121 role2 = new Temp1121("admin");
        System.out.println(role1.equals(role2)); // should print true
        System.out.println(role1.hashCode());
        System.out.println(role2.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Temp1121 role = null;

        try {
            role = (Temp1121) obj;
        } catch (ClassCastException e) {
            // log error
            throw new IllegalArgumentException("Cannot compare with " + obj.getClass().getName());
        }

        return this.name.equalsIgnoreCase(role.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = (prime * result) + ((name == null) ? 0 : this.name.hashCode());
        return result;
    }
}