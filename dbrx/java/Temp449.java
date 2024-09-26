public class Temp449 {
    public static void main(String[] args) {
        // Example usage of CustomExpressionHandler
        CustomExpressionHandler handler = new CustomExpressionHandlerImpl();
        System.out.println(handler.hasOAuth2Scope("read"));
    }

    public interface CustomExpressionHandler {
        boolean hasOAuth2Scope(String scope);
    }

    public static class CustomExpressionHandlerImpl implements CustomExpressionHandler {
        @Override
        public boolean hasOAuth2Scope(String scope) {
            // Dummy implementation for demonstration
            return "read".equals(scope);
        }
    }
}