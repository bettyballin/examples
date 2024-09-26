
const b64ToBin = (b64) => {
    const binaryString = window.atob(b64);
    const length = binaryString.length;
    const bytes = new Uint8Array(length);
    for (let i = 0; i < length; i++) {
        bytes[i] = binaryString.charCodeAt(i);
    }
    return bytes.buffer;
};

const importB64SpkiKey = async (base64key) => {
