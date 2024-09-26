import java.math.BigInteger;

public class Temp656 {
    public static void main(String[] args) {
        // Example usage of CustomECPoint interface
        CustomECPoint point = new CustomECPoint() {
            private BigInteger x;

            @Override
            public void setX(BigInteger x) {
                this.x = x;
            }

            @Override
            public BigInteger getX() {
                return this.x;
            }
        };

        point.setX(new BigInteger("123456789"));
        System.out.println("X coordinate: " + point.getX());
    }

    public interface CustomECPoint {
        void setX(BigInteger x);
        BigInteger getX();
    }

    public interface ECKey {
        // Define ECKey methods if necessary
    }
}