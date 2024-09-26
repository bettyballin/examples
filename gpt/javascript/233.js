
function decrypt(data, key) {
    // Decode the base64 data to get our iv and encrypted data
    var rawData = atob(data);
    var rawIv = rawData.substring(0, 16);
    var encrypted = rawData.slice(16);

    // Convert everything needed to CryptoJS format
    var wordArrayKey = CryptoJS.enc.Hex.parse(key);
    var wordArrayIv = CryptoJS.enc.Latin1.parse(rawIv);
    var encryptedWA = CryptoJS.enc.Latin1.parse(encrypted);

    // Create a decrypted object using the key and IV
    var decrypted =
