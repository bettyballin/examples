import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.ECParameterSpec;
import java.util.Enumeration;

import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPrivateKeySpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.util.encoders.Hex;

import java.security.Security;

public class Temp2502 {
    public static void main(String[] args) {
        // Add BouncyCastle as a Security Provider
        Security.addProvider(new BouncyCastleProvider());

        // Example usage (Replace with actual keys)
        // PublicKey publicKey = ...;
        // PrivateKey privateKey = ...;
        // try {
        //     System.out.println(deriveCurveName(publicKey));
        //     System.out.println(deriveCurveName(privateKey));
        // } catch (GeneralSecurityException e) {
        //     e.printStackTrace();
        // }
    }

    public static final String deriveCurveName(org.bouncycastle.jce.spec.ECParameterSpec ecParameterSpec) throws GeneralSecurityException {
        for (@SuppressWarnings("rawtypes")
             Enumeration names = ECNamedCurveTable.getNames(); names.hasMoreElements();) {
            final String name = (String) names.nextElement();

            final X9ECParameters params = ECNamedCurveTable.getByName(name);

            if (params.getN().equals(ecParameterSpec.getN())
                    && params.getH().equals(ecParameterSpec.getH())
                    && params.getCurve().equals(ecParameterSpec.getCurve())
                    && params.getG().equals(ecParameterSpec.getG())) {
                return name;
            }
        }

        throw new GeneralSecurityException("Could not find name for curve");
    }

    public static final String deriveCurveName(PublicKey publicKey) throws GeneralSecurityException {
        if (publicKey instanceof java.security.interfaces.ECPublicKey) {
            final java.security.interfaces.ECPublicKey pk = (java.security.interfaces.ECPublicKey) publicKey;
            final ECParameterSpec params = pk.getParams();
            return deriveCurveName(EC5Util.convertSpec(params, false));
        } else if (publicKey instanceof org.bouncycastle.jce.interfaces.ECPublicKey) {
            final org.bouncycastle.jce.interfaces.ECPublicKey pk = (org.bouncycastle.jce.interfaces.ECPublicKey) publicKey;
            return deriveCurveName(pk.getParameters());
        } else
            throw new IllegalArgumentException("Can only be used with instances of ECPublicKey (either jce or bc implementation)");
    }

    public static final String deriveCurveName(PrivateKey privateKey) throws GeneralSecurityException {
        if (privateKey instanceof java.security.interfaces.ECPrivateKey) {
            final java.security.interfaces.ECPrivateKey pk = (java.security.interfaces.ECPrivateKey) privateKey;
            final ECParameterSpec params = pk.getParams();
            return deriveCurveName(EC5Util.convertSpec(params, false));
        } else if (privateKey instanceof org.bouncycastle.jce.interfaces.ECPrivateKey) {
            final org.bouncycastle.jce.interfaces.ECPrivateKey pk = (org.bouncycastle.jce.interfaces.ECPrivateKey) privateKey;
            return deriveCurveName(pk.getParameters());
        } else
            throw new IllegalArgumentException("Can only be used with instances of ECPrivateKey (either jce or bc implementation)");
    }

    // Utility class to convert ECParameterSpec
    public static class EC5Util {
        public static org.bouncycastle.jce.spec.ECParameterSpec convertSpec(ECParameterSpec ecSpec, boolean withCompression) {
            ECCurve curve = new ECCurve.Fp(ecSpec.getCurve().getField().getFieldSize() > 0 ? ecSpec.getCurve().getField().getFieldSize() : 256,
                    ecSpec.getCurve().getA(), ecSpec.getCurve().getB());

            return new org.bouncycastle.jce.spec.ECParameterSpec(
                    curve,
                    new org.bouncycastle.math.ec.ECPoint.Fp(curve, ecSpec.getGenerator().getAffineX(), ecSpec.getGenerator().getAffineY(), withCompression),
                    ecSpec.getOrder(),
                    BigInteger.valueOf(ecSpec.getCofactor()));
        }
    }
}