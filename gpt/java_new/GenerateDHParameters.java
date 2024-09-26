import org.bouncycastle.asn1.pkcs.DHParameter;
import org.bouncycastle.crypto.generators.DHParametersGenerator;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;
import java.security.SecureRandom;

public class GenerateDHParameters {

    public static void main(String[] args) {
        try {
            // Generate DH Parameters
            DHParametersGenerator generator = new DHParametersGenerator();
            generator.init(2048, 20, new SecureRandom());
            DHParameters params = generator.generateParameters();

            // ASN.1 encoding
            DHParameter dhParameter = new DHParameter(params.getP(), params.getG(), params.getL());

            // Write to PEM file
            try (Writer writer = new FileWriter("dhparams.pem");
                 JcaPEMWriter pemWriter = new JcaPEMWriter(writer)) {
                pemWriter.writeObject(dhParameter);
            }
            System.out.println("DH parameters have been written to dhparams.pem");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}