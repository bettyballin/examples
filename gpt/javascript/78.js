
function sanitizeUri(uri) {
  var a = document.createElement('a');
  a.href = uri;
  
  // Decode HTML entities by assigning to an element's
