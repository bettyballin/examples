class WebCrypt {
  md5(password) {
    return require('crypto').createHash('md5').update(password).digest('hex');
  }
}

const webcrypt = new WebCrypt();
const password = "my_secret_password";
const hashedPassword = webcrypt.md5(password);
console.log(hashedPassword);