const expiry = localStorage.getItem("expiry");
if (new Date().getTime() >= parseInt(expiry)) {
    // Key has expired delete keys and ciphertext from local storage.
    localStorage.removeItem("encryptedData");
} else {
    // Decrypt data if key hasn't yet expired.
    const encryptedObj = JSON.parse(localStorage.getItem("encryptedData"));
    const decryptedData = sjcl.decrypt(encryptedObj.aesKey, encryptedObj.data);
    console.log(decryptedData);
}