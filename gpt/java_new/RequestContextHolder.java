public class RequestContextHolder {
    private static final ThreadLocal<RequestContext> requestContext = new ThreadLocal<>();

    public static RequestContext getRequestContext() {
        RequestContext context = requestContext.get();
        if (context == null) {
            context = new RequestContext();
            requestContext.set(context);
        }
        return context;
    }

    public static void setRequestContext(RequestContext context) {
        requestContext.set(context);
    }

    public static void clear() {
        requestContext.remove();
    }
}

class RequestContext {
    private int index;
    // Add other request-specific information as needed

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    // Add getters and setters for other information
}