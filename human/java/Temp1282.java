public class Temp1282 {
    public static void main(String[] args) {
        System.out.println("Content-Security-Policy: default-src 'self'   --only allow content from your own site");
        System.out.println("X-XSS-Protection: 1; mode=block   --prevent some reflective attacks in some browsers");
        System.out.println("X-Content-Type-Options: nosniff   --can't trick browser into detecting and running js in other content types");
    }
}