import java.util.ArrayList;

public class Temp1599 {

    public static void main(String[] args) {
        
        ArrayList<TokenEnhancer> tokenEnhancers = new ArrayList<>();
        
        TokenEnhancer accessTokenConverter = new TokenEnhancer() {
            @Override
            public String enhance(String token) {
                return "EnhancedToken_" + token;
            }
        };
        
        tokenEnhancers.add(accessTokenConverter);
        
        EnhancerChain enhancerChain = new EnhancerChain();
        enhancerChain.setTokenEnhancers(tokenEnhancers);
        
        System.out.println(enhancerChain.enhanceToken("SampleToken"));
    }
}

interface TokenEnhancer {
    String enhance(String token);
}

class EnhancerChain {
    private ArrayList<TokenEnhancer> tokenEnhancers;

    public void setTokenEnhancers(ArrayList<TokenEnhancer> tokenEnhancers) {
        this.tokenEnhancers = tokenEnhancers;
    }

    public String enhanceToken(String token) {
        for (TokenEnhancer enhancer : tokenEnhancers) {
            token = enhancer.enhance(token);
        }
        return token;
    }
}