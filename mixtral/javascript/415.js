Here is the executable JavaScript code:


const padding = new Uint8Array(16).fill(16);
const chunkSize = 16;
let index = 0;
const chunks = [];
let prevChunkIv = subtleIv; // initialize with the original IV
const length = ciphertext.length;

async function decrypt(ciphertext, subtleKey, subtleIv) {
  do {
    const chunk = ciphertext.slice(index, index + chunkSize);

    if (prevChunkIv) {
      let decryptedPrevBlock = await crypto.subtle.decrypt({ name: 'AES-CBC', iv: prevChunkIv }, subtleKey, new Uint8Array([...chunk].slice(0, 16)));

      // The last block of the previous chunk is used as IV for this chunk
      let decryptedPrevBlockArr = Array.from(new Uint8Array(decryptedPrevBlock));

      prevChunkIv = new Uint8Array([...chunk].slice(-16)).buffer;

      // The rest of the current block is appended to form a complete chunk
      let decryptedCurrentBlockArr = Array.from(new Uint8Array(await crypto.subtle.decrypt({ name: 'AES-CBC', iv: prevChunkIv }, subtleKey, new Uint8Array([...chunk].slice(16)))));

      chunks.push(Uint8Array.from([...decryptedPrevBlockArr].concat(decryptedCurrentBlockArr).slice(-16 * 2)).buffer);
    } else {

      // For the first chunk use original IV

      let decryptFirstChunk = await crypto.subtle.decrypt({ name: 'AES-CBC', iv: subtleIv }, subtleKey, new Uint8Array([...chunk].slice(0, 16)));

      chunks.push((new Uint8Array(decryptFirstChunk)).buffer);

    }

    index += chunkSize;
  } while (index < length - chunkSize);

  // Decode and output
  var mergedChunks = mergeByteArrays(chunks);

  var fullyDecrypted = String.fromCharCode.apply(null, new Uint8Array(mergedChunks));

  return fullyDecrypted;
}

// Helper function to merge byte arrays
function mergeByteArrays(arrays) {
  let merged = new Uint8Array(0);
  for (let array of arrays) {
    let newArray = new Uint8Array(merged.length + array.byteLength);
    newArray.set(merged);
    newArray.set(new Uint8Array(array), merged.length);
    merged = newArray;
  }
  return merged.buffer;
}