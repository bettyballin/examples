const crypto = require('crypto');

const testEnc = "bLdmGA+HLLyFEVtBEuCzVg==";
const enc = Buffer.from(testEnc, 'base64');
const derivedKey = Buffer.from("LefjQ2pEXmiy/nNZvEJ43i8hJuaAnzbA1Cbn1hOuAgA=", 'base64');
const iv = "1020304050607080";

const decipher = crypto.createDecipheriv('aes-256-cbc', derivedKey, iv);
decipher.setAutoPadding(false);

const decrypted = Buffer.concat([decipher.update(enc), decipher.final()]);
const unpadded = decrypted.slice(0, decrypted.length - decrypted[decrypted.length - 1]);

console.log(unpadded.toString()); // hello