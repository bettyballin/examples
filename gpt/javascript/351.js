
async function calculateHash(file) {
  const chunkSize = 10485760; // 10 MB
  const reader = new FileReader();
  let offset = 0;
  let hashBuffer = await crypto.subtle.digest('SHA-512', new ArrayBuffer(0)); // initial hash

  function readNextChunk() {
    const chunk = file.slice(offset, offset + chunkSize);
    reader.readAsArrayBuffer(chunk);
  }

  reader.onload = async function (e) {
    hashBuffer = await crypto.subtle.digest('SHA-512', [
      hashBuffer,
      e.target.result
    ]);
    offset += chunkSize;
    if (offset <
