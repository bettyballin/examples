<?php

function encrypt($encrypt, $mc_key, $iv) 
{
    $passcrypt = mcrypt_encrypt(MCRYPT_RIJNDAEL_256, $mc_key, $encrypt, MCRYPT_MODE_ECB, $iv);
    $encode = base64_encode($passcrypt);
    return $encode;
}

// Test the function
$encrypt = 'Hello, World!';
$mc_key = 'your_secret_key_here';
$iv = 'your_initialization_vector_here';

$encrypted = encrypt($encrypt, $mc_key, $iv);
echo $encrypted;

?>