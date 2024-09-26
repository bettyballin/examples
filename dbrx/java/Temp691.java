class RequestContext {
    private static int index;

    public static void setIndex(int newIndex) {
        index = newIndex;
    }

    public static int getIndex() {
        return index;
    }
}

public class Temp691 {
    public static void main(String[] args) {
        RequestContext.setIndex(getCurrentProviderIndex("request"));
        System.out.println("Index set to: " + RequestContext.getIndex());
    }

    public static int getCurrentProviderIndex(String request) {
        // Assuming some logic to determine the index based on request
        return 42; // Placeholder value
    }
}