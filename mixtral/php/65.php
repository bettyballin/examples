// Encrypt
$encryptedData = base64_encode($this->iv) . ':' . base64_encode($cipherText);

// Decode
list($encodedIv, $base64Ciphertext) = explode(':', $stringToDecrypt);
$iv = base64_decode($encodedIv);
$cipherText = base64_decode($base64Ciphertext);