const yourKeyBit = 0x01; // replace with your key bit

class FileLoader {
  constructor() {
    this.binaryData = [];
  }

  loadFile(event) {
    const file = event.target.files[0];

    let reader = new FileReader();

    // This will trigger when the read operation is done
    reader.onloadend = () => {
      this.binaryData = Array.from(new Uint8Array(reader.result));

      // Now you can perform XOR operations on each bit of binary data

      for (let i=0;i<this.binaryData.length;i++)
        console.log(`Xor operation: ${this.binaryData[i]} ^ ${yourKeyBit} = ${this.binaryData[i] ^ yourKeyBit}`);
    };

    reader.readAsArrayBuffer(file);
  }
}

// Usage
const fileLoader = new FileLoader();
const fileInput = document.createElement('input');
fileInput.type = 'file';
fileInput.addEventListener('change', (event) => {
  fileLoader.loadFile(event);
});
document.body.appendChild(fileInput);