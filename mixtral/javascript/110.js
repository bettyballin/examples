const uuidNamespace = "b9cfdb9d-f741-4e1f-89ae-fac6b2a5d740";
const name = "something";

// Convert UUID to byte array
function parseUUID(uuid) {
  const bytes = new ArrayBuffer(16);
  let view = new DataView(bytes);

  uuid.replace(/[a-fA-F\d]{2}/g, (hexStr) => {
    // Convert hex string to byte and write it into the buffer
    const intVal = parseInt(hexStr, 16);

    view.setUint8(view.byteLength / 4, intVal & 0xff);

    return '';
  });

  return bytes;
}

const namespaceBytes = parseUUID(uuidNamespace);

console.log(namespaceBytes);