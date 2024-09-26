const crypto = require("crypto");

const AES_BLOCK_SIZE = 16;

function unpad(data){
    let b = Buffer.from(data);

    // get last byte
    const tail = b[b.length - 1];

    if (tail > AES_BLOCK_SIZE) {
        throw new Error('Input is not padded or padding is corrupt');
    }

    return data.slice(0, data.length - tail);
}

let password = "key";

// generate key
const md5sum = crypto.createHash("md5");

md5sum.update(password);

const key = md5sum.digest();

var decipher = crypto.createDecipheriv('aes-128-ecb', key, '');

let encrypted = "your_encrypted_data_here";
let decrypted = decipher.update(encrypted, 'hex', 'utf8');
decrypted += decipher.final('utf8');

console.log(unpad(decrypted));