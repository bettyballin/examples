(async () => {
  const nonce = window.crypto.getRandomValues(new Uint32Array(1))[0];
  const secretKey = await window.crypto.subtle.importKey(
    'raw', 
    await fetch('path/to/your/secret/key').then(r => r.arrayBuffer()), 
    { name: "RSA-SSA", hash: "SHA-256" }, 
    false, 
    ["sign"]
  );

  // Generate the signature
  const message = new TextEncoder().encode('Hello world!');
  const signature = await window.crypto.subtle.sign({
    name: "RSA-SSA",
    hash: "SHA-256",
  }, secretKey, message);

  console.log(signature);
})();