
function getSanitizedQueryString() {
  // Obtain the query string from the current URL
  var queryString = window.location.search;

  // Create a URLSearchParams object from the query string
  var params = new URLSearchParams(queryString);

  // Reconstruct the query string safely by encoding each parameter
  var sanitizedQueryString = '?';
  params.forEach(function(value, key) {
    if (sanitizedQueryString.length > 1) {
      sanitizedQueryString += '&';
    }
    sanitizedQueryString += encodeURIComponent(key) + '=' + encodeURIComponent(value);
  });

  return sanitizedQueryString;
}

// Later
