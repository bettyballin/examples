generateHash();

function generateHash() {
    var value = "mypassword";
    var crypto = window.crypto;
    var buffer = str2ab(value); 
    var hash_bytes = crypto.subtle.digest("SHA-1", buffer);
    hash_bytes.then(value => document.write([...new Uint8Array(value)].map(x => x.toString(16).padStart(2, '0')).join('')));
}

function str2ab(str) {
    const buf = new ArrayBuffer(str.length);
    const bufView = new Uint8Array(buf);
    for (let i = 0, strLen = str.length; i < strLen; i++) {
        bufView[i] = str.charCodeAt(i);
    }
    return buf;
}