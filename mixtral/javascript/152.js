document.addEventListener('securitypolicyviolation', function(e) {
  console.log("CSP Violated", e);
});