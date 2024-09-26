module.exports = function(environment) {
  let ENV = {
    contentSecurityPolicy: {
      'default-src': "'none'",
      'style-src': ["'self'", "'unsafe-inline'"],
      'report-uri': "/csr-reports"
    }
  };

  return ENV;
};