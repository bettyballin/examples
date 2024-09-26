
var iv = window.crypto.getRandomValues(new Uint8Array(16)); // 16 bytes for AES-CBC
var algo_key = { name: "AES-CBC", length: 128 };

// Use a Promise or async/await to wait for the key generation
window.crypto.subtle.generateKey(algo_key, true, ["encrypt", "decrypt"])
.then(function(key) {
    // Now '
