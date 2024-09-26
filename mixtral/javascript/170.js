const bcrypt = require('bcrypt');

// Generate salt
let saltRounds = 10;

async function hashPassword(password) {
    let hashedPassword = await new Promise((resolve, reject) =>
        bcrypt.hash(password, saltRounds, (err, res) =>
            err ? reject(err) : resolve(res)));

    return hashedPassword;
}

async function comparePasswords(plainTextPwd, hash) {
    let match = await new Promise((resolve, reject) =>
        bcrypt.compare(plainTextPwd, hash, (err, res) =>
            err ? reject(err) : resolve(res)));

    return match;
}

// Test the functions
async function main() {
    let password = "mysecretpassword";
    let hashed = await hashPassword(password);
    console.log("Hashed Password:", hashed);

    let isMatch = await comparePasswords(password, hashed);
    console.log("Passwords match?", isMatch);

    isMatch = await comparePasswords("wrongpassword", hashed);
    console.log("Passwords match?", isMatch);
}

main();