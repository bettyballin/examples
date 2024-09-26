<?php

$key = 'mysecretkey'; // Use a secure method to generate and manage keys

// Encryption function
function encrypt($string) {
    global $key;
    $ivSize = mcrypt_get_iv_size(MCRYPT_RIJNDAEL_128, MCRYPT_MODE_CBC);
    $iv = random_bytes($ivSize); // Generate a random IV
    $ciphertext = mcrypt_encrypt(MCRYPT_RIJNDAEL_128, $key, $string, MCRYPT_MODE_CBC, $iv);
    return base64_encode($iv . $ciphertext);
}

// Decryption function
function decrypt($ciphertext) {
    global $key;
    $ciphertext = base64_decode($ciphertext);
    $ivSize = mcrypt_get_iv_size(MCRYPT_RIJNDAEL_128, MCRYPT_MODE_CBC);
    $iv = substr($ciphertext, 0, $ivSize);
    $ciphertext = substr($ciphertext, $ivSize);
    return mcrypt_decrypt(MCRYPT_RIJNDAEL_128, $key, $ciphertext, MCRYPT_MODE_CBC, $iv);
}

// Example usage
$string = 'Hello, World!';
$encrypted = encrypt($string);
echo "Encrypted: $encrypted\n";
$decrypted = decrypt($encrypted);
echo "Decrypted: $decrypted\n";

?>