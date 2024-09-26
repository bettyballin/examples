// Define the LFSR class
class LFSR {
  constructor(seed, taps) {
    this.state = seed;
    this.taps = taps;
  }

  nextBit() {
    let xor = 0;
    for (let i = 0; i < this.taps.length; i++) {
      xor ^= (this.state >> this.taps[i]) & 1;
    }
    this.state = (this.state >> 1) | (xor << (this.state.toString(2).length - 1));
    return xor;
  }
}

// Create an instance of LFSR
const lfsr = new LFSR(0b11010101, [0, 2, 3, 5]);

// Create a file input element
const fileInput = document.createElement('input');
fileInput.type = 'file';
fileInput.id = 'fileInput';

// Add the file input element to the body
document.body.appendChild(fileInput);

// Add an event listener to the file input element
fileInput.addEventListener('change', (e) => {
  const file = e.target.files[0];
  const reader = new FileReader();
  reader.onload = async () => {
    const buffer = new Uint8Array(reader.result);
    for (let i = 0; i < buffer.length; i++) {
      buffer[i] ^= lfsr.nextBit();
    }
    console.log(buffer);
  };
  reader.readAsArrayBuffer(file);
});