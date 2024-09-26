public class SecurityExpressionBuilder {

    private StringBuilder expression = new StringBuilder();

    public static SecurityExpressionBuilder builder() {
        return new SecurityExpressionBuilder();
    }

    public SecurityExpressionBuilder hasOAuth2Scope(String scope) {
        expression.append("#oauth2.hasScope('").append(scope).append("') ");
        return this;
    }

    public SecurityExpressionBuilder isNotOAuth2Request() {
        expression.append("!#oauth2.isOAuth() ");
        return this;
    }

    public SecurityExpressionBuilder hasRole(String role) {
        expression.append("hasRole('").append(role).append("') ");
        return this;
    }

    public SecurityExpressionBuilder and() {
        expression.append("and ");
        return this;
    }

    public String build() {
        return expression.toString().trim();
    }
}