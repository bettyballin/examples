module.exports = function(environment) {
  var ENV = {
    contentSecurityPolicy: {
      'style-src': ["'self'", "'unsafe-inline'"],
    }
  };
  return ENV;
}