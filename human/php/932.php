This is not PHP code, it's C# code. However, I'll provide you with the equivalent PHP code:


function RSAEncryption($aes_key, $aes_iv)
{
    // Load the public key from file
    $publicKey = file_get_contents("publicKey.pem");

    // Encode key and iv to byte array
    $keyToEncrypt = utf8_encode($aes_key);
    $ivToEncrypt = utf8_encode($aes_iv);

    // Values to store encrypted symmetric keys.
    $encryptedKey = '';
    $encryptedIV = '';

    // Create a new instance of RSA
    $rsa = openssl_pkey_get_public($publicKey);

    // Encrypt the symmetric key and IV.
    openssl_public_encrypt($keyToEncrypt, $encryptedKey, $rsa);
    openssl_public_encrypt($ivToEncrypt, $encryptedIV, $rsa);

    // Write the encrypted key and IV to file
    file_put_contents("WriteTextCryptKey.txt", base64_encode($encryptedKey));
    file_put_contents("WriteTextCryptIV.txt", base64_encode($encryptedIV));

    return base64_encode($encryptedKey);
}


Note: In PHP, we don't use XML files to store public keys, but instead use PEM files. You'll need to convert your XML public key to a PEM file for this code to work. Also, the `utf8_encode` function is used to convert the strings to bytes, assuming they are in UTF-8 encoding. If your strings use a different encoding, you'll need to adjust this accordingly.