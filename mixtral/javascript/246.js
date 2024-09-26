const randomBuffer = new Uint32Array(1);
window.crypto.getRandomValues(randomBuffer);

console.log(randomBuffer[0]);