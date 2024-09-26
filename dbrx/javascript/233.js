window.crypto.subtle.exportKey(
    "spki", 
    publicKey //can be a publicKey or privateKey as long as extractable is true
)
.then(function(keydata){
    var pem = convertBinaryToPem(keydata);
    console.log(pem);
})
.catch(function(err){
    console.error(err);
});

function convertBinaryToPem(binaryData) {
    var bytes = new Uint8Array(binaryData);
    var pem = "-----BEGIN PUBLIC KEY-----\n";
    var base64 = btoa(String.fromCharCode.apply(null, bytes));
    pem += base64.match(/.{0,64}/g).join("\n");
    pem += "\n-----END PUBLIC KEY-----";
    return pem;
}