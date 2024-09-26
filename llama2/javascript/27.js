const crypto = require('crypto');

function generateSalt() {
    return new Promise((resolve, reject) => {
        crypto.randomBytes(256, (err, buf) => {
            if (err) reject(err);
            resolve(buf.toString());
        });
    });
}

generateSalt().then((salt) => {
    console.log(salt);
}).catch((err) => {
    console.error(err);
});