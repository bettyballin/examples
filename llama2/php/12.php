<?php

function encrypt($data) {
    $cipher = mcrypt_module_open(MCRYPT_RIJNDAEL_128, '', MCRYPT_MODE_CBC, '');
    $iv = mcrypt_create_iv(mcrypt_enc_get_iv_size($cipher), MCRYPT_RAND);
    $padding = mcrypt_get_block_size($cipher) - (strlen($data) % mcrypt_get_block_size($cipher));
    $encrypted = mcrypt_encrypt($cipher, 'your_secret_key_here', $data . str_repeat(chr($padding), $padding), MCRYPT_MODE_CBC, $iv);
    mcrypt_module_close($cipher);
    return $encrypted;
}

// Test the function
$data = "This is a test string";
$encrypted = encrypt($data);
echo "Encrypted data: " . bin2hex($encrypted) . "\n";

?>