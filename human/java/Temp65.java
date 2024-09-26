public class Main {

    static class MyDomainObject {
        // Add fields and methods as needed
    }

    static class ObjectIdentity {
        private final Object object;

        public ObjectIdentity(Object object) {
            this.object = object;
        }

        @Override
        public String toString() {
            return "ObjectIdentity{" +
                    "object=" + object +
                    '}';
        }
    }

    static class ObjectIdentityImpl extends ObjectIdentity {
        public ObjectIdentityImpl(Object object) {
            super(object);
        }
    }

    public static void main(String[] args) {
        MyDomainObject secured = new MyDomainObject();
        ObjectIdentity securedIdentity = new ObjectIdentityImpl(secured);
        System.out.println(securedIdentity);
    }
}