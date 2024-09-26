class Foo {
    private String principal;

    public Foo(String principal) {
        this.principal = principal;
    }

    public String getPrincipal() {
        return principal;
    }
}

interface Authentication {
    String getPrincipal();
}

public class FooUtils {
    public static Foo generateFoo(Authentication a) {
        return new Foo(a.getPrincipal());
    }

    public static void main(String[] args) {
        Authentication auth = new Authentication() {
            @Override
            public String getPrincipal() {
                return "examplePrincipal";
            }
        };

        Foo foo = generateFoo(auth);
        System.out.println(foo.getPrincipal());
    }
}