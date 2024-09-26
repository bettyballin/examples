
document.addEventListener('securitypolicyviolation', function(e) {
  console.log('CSP Violation Detected:');
  console.log('Blocked URI:', e.blockedURI);
  console.log('Directive:', e.violatedDirective);
  console.log('Document URI:', e.documentURI);
  
  // Display a hint to the user
  alert('We have detected an extension or plugin trying to modify the page content, which may not be allowed.');
});

