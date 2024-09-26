const bcrypt = require('bcrypt');

const password = 'your_password_here';

bcrypt.genSalt(10, (error, salt) => {
    if(error){
        throw error;
    }
    bcrypt.hash(password, salt, null, (err, hash) => {
        console.log(hash); // $2y$10$... string.
    });
});