if (typeof crypto.subtle.encrypt === 'function') {
  const rawMessage = 'Hello, World!';
  const encoder = new TextEncoder();
  const message = encoder.encode(rawMessage);
  const key = await window.crypto.subtle.generateKey(
    {
      name: 'AES-GCM',
      length: 256,
    },
    true,
    ['encrypt', 'decrypt']
  );

  const iv = window.crypto.getRandomValues(new Uint8Array(12));
  const encrypted = await window.crypto.subtle.encrypt(
    {
      name: 'AES-GCM',
      iv: iv,
    },
    key,
    message
  );

  console.log(`Encrypted: ${new Uint8Array(encrypted).join(' ')}`);
} else {
  console.log('crypto.subtle.encrypt is not supported');
}