String.prototype.sha256 = async function() {
  const encoder = new TextEncoder();
  const data = encoder.encode(this);

  // Compute the SHA-256 hash
  const digest = await crypto.subtle.digest('SHA-256', data);

  return Array.from(new Uint8Array(digest))
    .map((b) => b.toString(16).padStart(2, '0'))
    .join('');
};

// Usage:
const message = "Hello World";
message
  .sha256()
  .then((hash) => console.log(`Hash: ${hash}`))
  .catch((error) => console.error(error));