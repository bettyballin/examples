(async () => {
    var key = await generateKey();
    
    var plaintext = {"data": "The quick brown fox jumps over the lazy dog"};
    var ciphertext = await encrypt(plaintext, key);
    console.log(ciphertext.replace(/(.{48})/g,'$1\n'));
    
    var decrypted = await decrypt(ciphertext, key);
    console.log(JSON.parse(decrypted));
})();

// generate key
function generateKey (){                                            
    return crypto.subtle.generateKey(                                   
        { name: "AES-GCM", length: 256 },
        false,
        ["encrypt", "decrypt"]
    );
}

// encrypt
async function encrypt(data, secretKey) {                                   
    const initializationVector = crypto.getRandomValues(new Uint8Array(12)); 
    const encodedData = new TextEncoder().encode(JSON.stringify(data));

    const encryptedBuffer = await crypto.subtle.encrypt(
        {
            name: "AES-GCM",
            iv: initializationVector,
            tagLength: 128,
        },
        secretKey,
        encodedData
    );

    const encryptedDataBase64 = ab2b64(encryptedBuffer); 
    const initializationVectorBase64 = ab2b64(initializationVector); 
    return `${encryptedDataBase64}.${initializationVectorBase64}`;
}

// decrypt
async function decrypt(encryptedData, secretKey) {                      
    const [data, iv] = encryptedData.split(".");
    const initializationVector = b642ab(iv); 
    const _data = b642ab(data); 
    const decryptedData = await crypto.subtle.decrypt(
        {
            name: "AES-GCM",
            iv: initializationVector,
            tagLength: 128,
        },
        secretKey,
        _data
    );
    return new TextDecoder().decode(decryptedData)
}

function ab2b64(arrayBuffer) {
      return btoa(String.fromCharCode.apply(null, new Uint8Array(arrayBuffer)));
}

function b642ab(base64string){
      return Uint8Array.from(atob(base64string), c => c.charCodeAt(0));
}