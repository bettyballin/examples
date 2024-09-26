const encryptedData = await crypto.subtle.encrypt({
  name: "AES-GCM",
  iv: new Uint8Array(12) /* initialization vector */,
}, key, data);