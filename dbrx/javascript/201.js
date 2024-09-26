Here is the modified code:


async function calculateHash(file) {
  const chunkSize = 10485760; 
  let offset = 0;
  let hasher;

  while (offset < file.size) {
    const chunk = await readFileChunkAsArrayBuffer(file, offset, Math.min(chunkSize, file.size - offset));
    if (!hasher) hasher = new Hasher();
    hasher.update(new Uint8Array(chunk));

    offset += chunk.byteLength;
  }

  return hasher.digest('hex');
}

function readFileChunkAsArrayBuffer(file, start, length) {
  const reader = new FileReader();

  return new Promise((resolve, reject) => {
    reader.onloadend = (event) => resolve(event.target.result);
    reader.onerror = () => reject(new Error('Failed to read file chunk'));
    reader.readAsArrayBuffer(file.slice(start, start + length));
  });
}

class Hasher {
  constructor() {
    this.hash = crypto.subtle.digest('SHA-512', new Uint8Array(0)); 
  }

  update(data) {
    const prevHashPromise = this.hash;
    this.hash = Promise.all([prevHashPromise, data]).then(([hashBuffer, newData]) => {
      return crypto.subtle.digest('SHA-512', concatBuffers(hashBuffer, new Uint8Array(newData)));
    });
  }

  digest(format) {
    return this.hash.then(hashBuffer => {
      const hashArray = new Uint8Array(hashBuffer);
      const hashHex = Array.from(hashArray, b => ('00' + b.toString(16)).slice(-2)).join('');
      return hashHex;
    });
  }
}

function concatBuffers(buffer1, buffer2) {
  const tmp = new Uint8Array(buffer1.byteLength + buffer2.byteLength);
  tmp.set(new Uint8Array(buffer1), 0);
  tmp.set(new Uint8Array(buffer2), buffer1.byteLength);
  return tmp.buffer;
}