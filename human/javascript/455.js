const exportPrivateKey = async () => {
  try {
    const keyData = await window.crypto.subtle.exportKey(
      "pkcs8",
      privateKey
    );
    console.log(keyData);
  } catch (err) {
    console.error(err);
  }
};

exportPrivateKey();