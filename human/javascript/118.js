function sanitizeUri(uri) {
  if (!uri.match(/^https?:\/\//)) {
    uri = "http://" + uri;
  }
  return uri;
}

// Test the function
console.log(sanitizeUri("example.com"));
console.log(sanitizeUri("http://example.com"));
console.log(sanitizeUri("https://example.com"));