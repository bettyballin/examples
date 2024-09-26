async function calculateHash(file) {
  const chunkSize = 1048576; // Adjust the size as needed
  const reader = new FileReader();
  let hash = new jsSHA("SHA-512", "ARRAYBUFFER");

  for (let start = 0, end = Math.min(chunkSize, file.size);
       start < file.size;
       start += chunkSize, end = Math.min(start + chunkSize, file.size)) {
    const blobSlice = await new Promise((resolve) => {
      reader.onloadend = () => resolve(reader.result);
      reader.readAsArrayBuffer(file.slice(start, end));
    });

    hash.update(blobSlice);
  }

  return hash.getHash("HEX").toUpperCase();
}