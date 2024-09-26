Here is the executable JavaScript code:


const generateKey = async () => {
    const key = await window.crypto.subtle.generateKey(
        {
            name: "AES-GCM",
            length: 128
        }, true, ["encrypt", "decrypt"]);
    const key_exported = await window.crypto.subtle.exportKey("jwk", key);
    return key_exported.k;
}

const text = "This is an encrypted message";
const printCurrent = async () => {
    let kkey = await generateKey();
    await window.crypto.subtle.importKey(
        "jwk",
        {
            k: kkey,
            alg: "A128GCM",
            ext: true,
            key_ops: ["encrypt", "decrypt"],
            kty: "oct",
        },
        {
            name: "AES-GCM",
            length: 128
        },
        false,
        ["encrypt", "decrypt"]
    ).then(function (key) {
        window.crypto.subtle.encrypt(
            {
                name: "AES-GCM",
                iv: new Uint8Array(12)
            }, key, new TextEncoder().encode(JSON.stringify(text))).then(function (encryptedObject) {
                let kkeyB64 = kkey.replace(/-/g, '+').replace(/_/g, '/'); 
                let bkey = sjcl.codec.base64.toBits(kkeyB64); 
                let cipher = new sjcl.cipher.aes(bkey);

                let bdata = sjcl.codec.arrayBuffer.toBits(encryptedObject) 
                let ive = sjcl.codec.arrayBuffer.toBits(new Uint8Array(12).buffer) 

                let decbits = sjcl.mode.gcm.decrypt(cipher, bdata, ive);

                decryptedData = sjcl.codec.utf8String.fromBits(decbits);
                document.getElementById("pt").innerHTML = JSON.parse(decryptedData);
            });
    });
}

printCurrent();


Please note that you need to include the Stanford JavaScript Crypto Library (SJCL) in your HTML file for this code to work:

html
<script src="https://cdnjs.cloudflare.com/ajax/libs/sjcl/1.0.8/sjcl.min.js"></script>


Also, make sure you have an HTML element with the id "pt" to display the decrypted data:

html
<div id="pt"></div>