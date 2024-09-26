import java.util.List;

public class Temp2460 {

    public static void main(String[] args) {
        // Example usage of these classes
        PrivateKeyInfo privateKeyInfo = new PrivateKeyInfo();
        privateKeyInfo.version = 1;
        privateKeyInfo.privateKeyAlgorithm = new AlgorithmIdentifier("RSA");
        privateKeyInfo.privateKey = new byte[]{1, 2, 3, 4, 5};
        privateKeyInfo.attributes = List.of(new Attribute("attr1"), new Attribute("attr2"));

        System.out.println(privateKeyInfo);
    }
}

class PrivateKeyInfo {
    int version;
    AlgorithmIdentifier privateKeyAlgorithm;
    byte[] privateKey;
    List<Attribute> attributes;

    @Override
    public String toString() {
        return "PrivateKeyInfo{" +
                "version=" + version +
                ", privateKeyAlgorithm=" + privateKeyAlgorithm +
                ", privateKey=" + privateKey +
                ", attributes=" + attributes +
                '}';
    }
}

class AlgorithmIdentifier {
    String name;

    public AlgorithmIdentifier(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AlgorithmIdentifier{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Attribute {
    String name;

    public Attribute(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "name='" + name + '\'' +
                '}';
    }
}