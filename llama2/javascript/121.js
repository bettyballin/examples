const bip39 = require('bip39');

(async () => {
  // Generate a private key using window.crypto.subtle.generateKey
  const privateKey = await window.crypto.subtle.generateKey(
    {
      name: "AES-GCM",
      length: 256
    },
    true,
    ["encrypt", "decrypt"]
  );

  // Convert the private key to a mnemonic phrase using bip39
  const mnemonic = bip39.entropyToMnemonic(await crypto.subtle.exportKey('raw', privateKey));

  console.log("Mnemonic phrase: ", mnemonic);
})();