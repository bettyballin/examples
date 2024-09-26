const AES_BLOCK_SIZE = 16;
const subtleIv = new Uint8Array(AES_BLOCK_SIZE);

class AesCbcDecryptTransform extends TransformStream {
  constructor(key) {
    super({
      async transform(chunk, controller) {
        if (this.prevChunk === null && chunk.length < AES_BLOCK_SIZE) {
          throw new Error('First chunk must be at least ' + AES_BLOCK_SIZE);
        }

        const iv = this.prevChunk || subtleIv;
        let decrypted;

        // If the last block of prevChunk is incomplete merge it with current chunk
        if (this.incompleteBlock && chunk.length >= AES_BLOCK_SIZE) {
          const mergedChunk = new Uint8Array(this.incompleteBlock.byteLength + chunk.byteLength);
          mergedChunk.set(new Uint8Array(this.incompleteBlock));
          mergedChunk.set(chunk, this.incompleteBlock.byteLength);

          decrypted = await crypto.subtle.decrypt({ name: 'AES-CBC', iv }, key, mergedChunk);
        } else {
          // Decrypt the current chunk
          const encryptedPadding = new Uint8Array(AES_BLOCK_SIZE).fill(16 - (chunk.length % AES_BLOCK_SIZE));
          const paddedChunk = new Uint8Array(chunk.length + encryptedPadding.byteLength);
          paddedChunk.set(chunk);
          paddedChunk.set(encryptedPadding, chunk.length);

          decrypted = await crypto.subtle.decrypt({ name: 'AES-CBC', iv }, key, paddedChunk);
        }

        controller.enqueue(new Uint8Array(decrypted));

        this.prevChunk = chunk;
      }
    });

    // Initialize the state
    this.prevChunk = null;
    this.incompleteBlock = null;
  }
}

// Usage:
const key = await crypto.subtle.importKey('raw', new Uint8Array(32), 'AES-CBC', false, ['decrypt']);
const ciphertext = new Blob([new Uint8Array(32).fill(1), new Uint8Array(16).fill(2)]);

const decryptStream = new AesCbcDecryptTransform(key);

ciphertext.stream()
  .pipeThrough(decryptStream)
  .pipeTo(new WritableStream({
    write(chunk) {
      console.log(String.fromCharCode.apply(null, chunk));
    }
  }));