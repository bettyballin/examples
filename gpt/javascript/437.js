
async function verify(jwt) {
  // Import the secret key for verification
  const secretKey = await crypto.subtle.importKey(
    "raw",
    new TextEncoder().encode(process
