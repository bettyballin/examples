
const randomValue = parseInt(crypto.randomBytes(6).toString('hex'), 16);
const maxValue = Math.pow(2, 48);
const randomFloat = randomValue / maxValue;

