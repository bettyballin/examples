(async () => {
  const key = await window.crypto.subtle.generateKey(
    {
      name: "AES-GCM",
      length: 256,
    },
    true,
    ["encrypt", "decrypt"]
  );

  console.log(`Generated key: ${key instanceof window.crypto.CryptoKey ? 'Yes' : 'No'}`);
})();