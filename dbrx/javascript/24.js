function encryptLong(signedCert, msg) {
  const blockSize = signedCert.msg.subject.pk.n.bitLength() / 8 - 11;
  let ctxtBlocks = [];
  for (let i = 0; i < Math.ceil(msg.length / blockSize); ++i) {
    const blockStartIndex = i * blockSize;
    const blockEndIndex =
      msg.length > blockStartIndex + blockSize
        ? blockStartIndex + blockSize
        : msg.length;

    let ctxtBlock = encrypt(
      signedCert,
      asciiToHex(msg.slice(blockStartIndex, blockEndIndex))
    );
    ctxtBlocks.push(ctxtBlock);
  }
  return ctxtBlocks.join("");
}

function decryptLong(sk, ctxt) {
  const blockSize = sk.n.bitLength() / 8;
  let ptxtChunks = [];
  for (let i = 0; i < Math.ceil(ctxt.length / blockSize); ++i) {
    const blockStartIndex = i * blockSize;
    const blockEndIndex =
      ctxt.length > blockStartIndex + blockSize
        ? blockStartIndex + blockSize
        : ctxt.length;

    let ptxtChunk = decrypt(
      sk,
      hexToAscii(ctxt.slice(blockStartIndex, blockEndIndex))
    );
    ptxtChunks.push(ptxtChunk);
  }
  return ptxtChunks.join("");
}

// Helper functions
function asciiToHex(str) {
  return Array.from(str).map(c => c.charCodeAt(0).toString(16).padStart(2, '0')).join('');
}

function hexToAscii(hex) {
  return Array.from(hex.match(/.{2}/g)).map(byte => String.fromCharCode(parseInt(byte, 16))).join('');
}

// Example usage
const signedCert = {
  msg: {
    subject: {
      pk: {
        n: 2048 // example value
      }
    }
  }
};

const sk = {
  n: 2048 // example value
};

const encrypt = (cert, data) => {
  // example encryption function
  return data;
};

const decrypt = (sk, data) => {
  // example decryption function
  return data;
};

const msg = "Hello, World!";
const encrypted = encryptLong(signedCert, msg);
const decrypted = decryptLong(sk, encrypted);

console.log(decrypted);