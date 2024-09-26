<?php

function pkcs7Unpad($data) {
    $paddingLength = ord(substr($data, -1));

    if ($paddingLength > strlen($data))
        return false;

    for ($i=0 ; $i < $paddingLength ; ++$i){
       if (ord($data[strlen($data) - 2-$i]) != $paddingLength )
           return false;
   }

   // Remove padding
   return substr($data, 0, strlen($data)-$paddingLength);
}

// Read the key and IV from files
$key = file_get_contents('aes.key');
$iv = file_get_contents('initialization.vector');

// Assuming $encryptedData is set somewhere in your code...
$encryptedData = 'your_encrypted_data_here';

// Decrypt using OpenSSL with PKCS7 padding
$decryptedData = openssl_decrypt($encryptedData, 'AES-128-CBC', $key, OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING, $iv);

// Remove extra bytes added due to PKCS7 padding
$finalDecrypted = pkcs7Unpad($decryptedData);

print($finalDecrypted);

?>