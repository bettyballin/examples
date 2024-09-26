import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

import java.math.BigInteger;

public class CustomBouncyCastleECPoint implements CustomECPoint {
    private final ECCurve curve;
    private ECPoint point;

    public CustomBouncyCastleECPoint(ECCurve curve) {
        this.curve = curve;
    }

    @Override
    public void setX(BigInteger x) {
        if (!curve.isValidFieldElement(x)) {
            throw new IllegalArgumentException("Invalid X coordinate");
        }
        if (point == null) {
            point = curve.createPoint(x, BigInteger.ZERO); // Placeholder, needs valid y-coordinate
        } else {
            point = curve.createPoint(x, point.getAffineYCoord().toBigInteger());
        }
    }

    @Override
    public BigInteger getX() {
        if (point == null) {
            throw new IllegalStateException("Point not initialized");
        }
        return point.getAffineXCoord().toBigInteger();
    }

    @Override
    public void setY(BigInteger y) {
        if (!curve.isValidFieldElement(y)) {
            throw new IllegalArgumentException("Invalid Y coordinate");
        }
        if (point == null) {
            point = curve.createPoint(BigInteger.ZERO, y); // Placeholder, needs valid x-coordinate
        } else {
            point = curve.createPoint(point.getAffineXCoord().toBigInteger(), y);
        }
    }

    @Override
    public BigInteger getY() {
        if (point == null) {
            throw new IllegalStateException("Point not initialized");
        }
        return point.getAffineYCoord().toBigInteger();
    }
}

interface CustomECPoint {
    void setX(BigInteger x);

    BigInteger getX();

    void setY(BigInteger y);

    BigInteger getY();
}