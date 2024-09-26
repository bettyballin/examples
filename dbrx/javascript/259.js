let ivvv = new Uint8Array(12);
// ... set values for `ivvv` ...
let cipher = new sjcl.cipher.aes(sjcl.codec.utf8String.toBits("your_secret_key"));
let bdata = sjcl.codec.base64.toBits("your_base64_encoded_ciphertext");
let decbits = sjcl.mode.gcm.decrypt(cipher, bdata, ivvv);