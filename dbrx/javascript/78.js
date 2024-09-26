const TwinBcrypt = require('twin-bcrypt');

const hash = "$2y$10$..."; // replace with your actual hash
const password = "your_password"; // replace with your actual password

TwinBcrypt.compare(password, hash)
    .then((res) => {
        console.log(res); // true or false
    })
    .catch((err) => {
        console.error(err);
    });