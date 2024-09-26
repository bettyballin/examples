const crypto = require('crypto');

function generateRandomResiduePowerOfTen(N, cb) {
    const digitos = Math.ceil(Math.log10(N));

    if (!Number.isInteger(digitos))
        return cb("Numero no es potencia de 10", null);

    crypto.randomBytes((8 * digitos + 7) >> 3, (err, buf) => {
      if (err)
          return cb(err, null);

      let randomNumber = BigInt('0x' + buf.toString('hex'));

      // Perform modulo operation without bias
      const result = Number((randomNumber & ((BigInt(N)-1n))) % BigInt(N));

      if (result < 0)
          return cb("Error in calculation", null);

      cb(null, result);
    });
}

// Example usage
generateRandomResiduePowerOfTen(100, (err, result) => {
  if (err) console.error(err);
  else console.log(result);
});