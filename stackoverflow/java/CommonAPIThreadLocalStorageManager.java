public class CommonAPIThreadLocalStorageManager {
    private static final CommonAPIThreadLocalStorageManager instance = new CommonAPIThreadLocalStorageManager();

    private ThreadLocal<String> userID = new ThreadLocal<>();

    private CommonAPIThreadLocalStorageManager() {}

    public static CommonAPIThreadLocalStorageManager getInstance() {
        return instance;
    }

    public String getUserID() {
        return userID.get();
    }

    public void setUserID(String userID) {
        this.userID.set(userID);
    }
}