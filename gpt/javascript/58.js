
async function md5(text) {
    // Encode the string into a Uint8Array
    const msgUint8 = new TextEncoder().encode(text);
    
    // Hash the Uint8Array
    const hashBuffer = await crypto.subtle.digest('MD5', msgUint8);
    
    // Convert the buffer to a hex string
    const hashArray = Array.from(new Uint8Array(hashBuffer));
    const hashHex = hashArray.map(b => b.toString(16).padStart(2, '0')).join('');
    
    return hashHex
