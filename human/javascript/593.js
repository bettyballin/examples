const bcrypt = require('bcrypt');

const hash = '$2y$07$BCryptRequires22Chrcte/VlQH0piJtjXl.0t1XkA8pw9dMXTpOq';
const password = 'your_password_here'; // replace with your password

bcrypt.compare(password, hash, (err, res) => {
  if (err) {
    console.error(err);
  } else if (res) {
    console.log('Password is valid!');
  } else {
    console.log('Invalid password.');
  }
});