
   // config/environment.js
   module.exports = function(environment) {
     let ENV = {
       // ... other configurations
       contentSecurityPolicy: {
         'default-src': "'none'",
         'script-src': "'self'",
         // ... other CSP settings
         'style-src': "'self' 'unsafe-inline'", // Add 'unsafe-inline' here
