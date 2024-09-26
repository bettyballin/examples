public class Temp673 {
    public static void main(String[] args) {
        String sessionId = "exampleSessionId"; // Replace with actual session ID
        String url = "/endsession?sessionId=" + sessionId;
        String htmlLink = "<a href=\"" + url + "\">End Session</a>";

        System.out.println(htmlLink);
    }
}