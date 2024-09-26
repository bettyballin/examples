const nacl_factory = require('libsodium-wrappers');

nacl_factory.ready.then(function (sodium) {

    var credentials = {
        "zip":"265",
        "account_number":"10028979739",
        "passcode":"1234",
        "account_type":"personal",
        "request":"login",
        "device":"iPhone 11"
    };

    // Convert JavaScript object to string
    var data = JSON.stringify(credentials);

    // Utf8 encode key, nonce and data
    var keyUtf8 = sodium.from_string("827ccb0eea8a706c4c34a16891f84e7b");
    var nonceUtf8 = sodium.from_string("0123456789abcdefghijvbnm");
    var dataUtf8 = sodium.from_string(data);
   
    // Encrypt
    var encrypted = sodium.crypto_secretbox(dataUtf8, nonceUtf8, keyUtf8);

    // Hex encode encrypted data for transfer 
    var encryptedHex = sodium.to_hex(encrypted);

    console.log("Ciphertext (hex):\n" + encryptedHex.replace(/(.{64})/g, "$1\n"));
});