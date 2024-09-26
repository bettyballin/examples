const bcrypt = require('bcryptjs');
const saltRounds = 10;
const myPlaintextPassword = 'password123';
const someOtherPlaintextPassword = 'not_bacon';

// Hash a password for the first time.
bcrypt.genSalt(saltRounds, function(err, salt) {
    bcrypt.hash(myPlaintextPassword, salt, function(err, hash) {
        console.log('Hash:', hash);

        // Store hash in your password DB.

        // Load hash from your password DB.
        bcrypt.compare(myPlaintextPassword, hash, function(err, result) {
            console.log('Comparing myPlaintextPassword:', result); // result == true
        });
        bcrypt.compare(someOtherPlaintextPassword, hash, function(err, result) {
            console.log('Comparing someOtherPlaintextPassword:', result); // result == false
        });
    });
});