<?php

function encode_password($plaintext, $salt) {
    // Convert the salt from hexadecimal representation
    if (strlen($salt) % 2 != 0 || ctype_digit(substr($salt, -1)) === false){
        throw new Exception("Invalid Salt");
    }

    $iterations = 1000;

    // Convert the salt to binary
    $binarySalt = hex2bin($salt);

    for ($i=0; $i<$iterations; ++$i) {
        if (function_exists('hash')){
            $plaintext .= hash("sha256", $plaintext.$binarySalt, true);
        } else {
            throw new Exception("Hash function not supported");
        }
    }

    return bin2hex($plaintext);
}

$password = "123456789";
$salt = "123456";

echo encode_password($password, $salt) . "\n";

?>