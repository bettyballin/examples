import java.security.SecureRandom;

public class MagicEightBall {
    private static void getAnswer() {
        int magic = new SecureRandom().nextInt(10) + 1;
        String answer;
        switch (magic) {
            case 1:
                answer = "Yes";
                break;
            case 2:
                answer = "No";
                break;
            case 3:
                answer = "Ask again later";
                break;
            case 4:
                answer = "Cannot predict now";
                break;
            case 5:
                answer = "Don't count on it";
                break;
            case 6:
                answer = "My sources say no";
                break;
            case 7:
                answer = "Outlook not so good";
                break;
            case 8:
                answer = "Yes, definitely";
                break;
            case 9:
                answer = "You may rely on it";
                break;
            case 10:
                answer = "Most likely";
                break;
            default:
                answer = "Error";
                break;
        }
        System.out.println("Magic 8 Ball says: " + answer);
    }

    public static void main(String[] args) {
        getAnswer();
    }
}