public class CommonAPIThreadLocalStorageManager {
    private static CommonAPIThreadLocalStorageManager instance;

    private CommonAPIThreadLocalStorageManager() {}

    public static synchronized CommonAPIThreadLocalStorageManager getInstance() {
        if (instance == null) {
            instance = new CommonAPIThreadLocalStorageManager();
        }
        return instance;
    }

    private ThreadLocal<String> userID = new ThreadLocal<>();

    public String getUserID() {
        return userID.get();
    }

    public void setUserID(String userID) {
        this.userID.set(userID);
    }

    public static void main(String[] args) {
        CommonAPIThreadLocalStorageManager manager = CommonAPIThreadLocalStorageManager.getInstance();
        manager.setUserID("user123");
        System.out.println("User ID: " + manager.getUserID());
    }
}