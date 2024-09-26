function RSADecryption($key, $iv) {
    $PrivateKeyFile = 'RSA_Private'; // assuming this is the path to your private key file
    require_once 'Crypt/RSA.php'; // assuming you have the Crypt_RSA library installed
    $rsa = new Crypt_RSA();
    $rsa->setEncryptionMode(CRYPT_RSA_ENCRYPTION_PKCS1);
    $rsa->loadKey(file_get_contents($PrivateKeyFile)); // load private key from file
    $aes_key = $rsa->decrypt(base64_decode($key));
    $aes_iv = $rsa->decrypt(base64_decode($iv));
    return array($aes_key, $aes_iv); // return the decrypted key and iv
}

// example usage:
$key = 'your_base64_encoded_key_here';
$iv = 'your_base64_encoded_iv_here';
list($aes_key, $aes_iv) = RSADecryption($key, $iv);