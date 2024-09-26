async function sha256(message) {
  const encoder = new TextEncoder();
  const data = await crypto.subtle.digest('SHA-256', encoder.encode(message));
  return Array.from(new Uint8Array(data)).map(b => b.toString(16).padStart(2, '0')).join('');
}

// Usage
(async () => {
  const hash = await sha256("your message");
  console.log(hash);
})();