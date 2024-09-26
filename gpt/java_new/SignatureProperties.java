import java.util.ArrayList;
import java.util.List;

public class SignatureProperties {
   private List<String> acceptedC14nAlgorithms;

   public SignatureProperties() {
      this.acceptedC14nAlgorithms = new ArrayList<String>();
   }

   public void addAcceptedC14nAlgorithm(String algorithm) {
      this.acceptedC14nAlgorithms.add(algorithm);
   }

   public List<String> getAcceptedC14nAlgorithms() {
      return acceptedC14nAlgorithms;
   }
}