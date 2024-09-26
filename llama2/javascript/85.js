const iframe = document.querySelector('iframe');

// Compute a hash of the iframe's content
crypto.subtle.digest({
  name: 'SHA-256',
  input: new TextEncoder('utf-8').encode(iframe.contentDocument.body.textContent)
})
.then(hash => {
  const hashHex = Array.from(new Uint8Array(hash)).map(b => b.toString(16).padStart(2, '0')).join('');

  // Compare the hash to a precomputed value
  if (hashHex === 'your-precomputed-hash-value') {
    // Your code to run when the iframe is loaded
  } else {
    // The content of the iframe has been modified - take appropriate action
  }
})
.catch(error => console.error(error));