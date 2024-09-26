const getKeyBit = () => Math.round(Math.random()); // Simulate a key bit generator

const getKeyByte = () => {
  const byte = []

  // Get 8 key bits
  for (let i = 0; i < 8; ++i) {
    byte.push(getKeyBit())
  }

  // Parse the byte string as base 2
  return parseInt(byte.join(''), 2)
}

const encryptFile = (file) => {
  const fileReader = new FileReader()
  fileReader.readAsArrayBuffer(file)

  return new Promise(resolve => {
    fileReader.onload = () => {
      const buffer = new Uint8Array(fileReader.result)
    
      // Resolve the promise with mapped Uint8Array
      resolve(buffer.map(byte => {
        // XOR each byte with a byte from the key 
        return byte ^ getKeyByte()
      }))
    } 
  })
}

// Example usage
const fileInput = document.createElement('input');
fileInput.type = 'file';
fileInput.addEventListener('change', (e) => {
  const file = e.target.files[0];
  encryptFile(file).then((encryptedBuffer) => {
    console.log(encryptedBuffer);
  });
});
document.body.appendChild(fileInput);