public final class RequestContext {
    private static final ThreadLocal<RequestContext> instance = new ThreadLocal<>();
    private int index;

    public static void setIndex(int index) {
        getInstance().index = index;
    }

    public static int getIndex() {
        return getInstance().index;
    }

    private static RequestContext getInstance() {
        if (instance.get() == null)
            instance.set(new RequestContext());
        return instance.get();
    }

    public static void main(String[] args) {
        RequestContext.setIndex(42);
        System.out.println("Index: " + RequestContext.getIndex());
    }
}