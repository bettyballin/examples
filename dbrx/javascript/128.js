module.exports = function(environment) {
  const ENV = {
    contentSecurityPolicy: {
      'style-src': ["'self'", "'unsafe-inline'"]
      // other directives...
    }
    // ...other configurations
  };

  if (environment === 'test') {
    // Testem prefers this...
    ENV.contentSecurityPolicyReportOnly = true;
    
    // Other test-related configs
  }

  return ENV;
};