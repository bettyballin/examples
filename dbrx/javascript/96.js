document.addEventListener('securitypolicyviolation', function(e){
  console.log("CSP Violation: " + e.blockedURI);
});