import java.math.BigInteger;

class Point {
    private BigInteger x;
    private BigInteger y;

    public Point(BigInteger x, BigInteger y) {
        this.x = x;
        this.y = y;
    }

    public BigInteger getX() {
        return x;
    }

    public BigInteger getY() {
        return y;
    }
}

public class Temp1392 {
    public static void main(String[] args) {
        Point P = new Point(BigInteger.valueOf(3), BigInteger.valueOf(6));
        Point Q = new Point(BigInteger.valueOf(9), BigInteger.valueOf(12));

        BigInteger lambda = Q.getY().subtract(P.getY()).divide(Q.getX().subtract(P.getX()));
        System.out.println("Lambda: " + lambda);
    }
}