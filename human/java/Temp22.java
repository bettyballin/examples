public class Temp22 {
    public static void main(String[] args) {
        try {
            Temp22 temp = new Temp22();
            temp.loadClass("javax.lang.ClassIDontLike");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals("javax.lang.ClassIDontLike")) {
            throw new ClassNotFoundException("I'm sorry, Dave. I'm afraid I can't do that.");
        }
        return Class.forName(name);
    }
}