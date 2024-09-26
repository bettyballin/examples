const crypto = require('crypto');

function encrypt(stringData) {
  const ivMessage = "a";
  const apiSecret = "secret_key";

  const encryptMethod = 'aes-256-cbc';
  const iv = crypto.createHash('sha256').update(ivMessage).digest('hex').substr(0, 16);
  const cipher = crypto.createCipheriv(encryptMethod, apiSecret, iv);
  let encrypted = cipher.update(stringData, 'utf8', 'base64');
  encrypted += cipher.final('base64');

  return encrypted;
}

const stringData = '{"uid":19,"price":10000000,"duration":240,"credit_purpose":5,"new_tab":false,"cssFile":"kalkulatorok","css":[],"supported":false,"email":"test@test.hu","productType":"home_loan","method":"calculator","calculatorType":"calculator","unique":true}';
console.log(encrypt(stringData) + "\n");