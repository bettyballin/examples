(async () => {
  try {
    const key = await window.crypto.subtle.generateKey(
      {
        name: "ECDH",
        namedCurve: "P-256"
      },
      false, // not extractable
      [] // no flags
    );
    console.log(key);
    console.log(key.publicKey);
    console.log(key.privateKey);
  } catch (err) {
    console.error(err);
  }
})();