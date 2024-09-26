<?php

function generatePassword($length) {
    $charset = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+-=';
    $password = '';

    for ($i = 0; $i < $length * 2; $i++) { 
        $randomByte = random_bytes(1);
        if (strpos($charset, bin2hex($randomByte)) !== false) {
            $password .= substr(bin2hex($randomByte), 0, 1); 
         }
    }

    return base64_encode(hex2bin(substr(str_replace(['+', '/', '='], '', $password), 0, $length)));
}

echo generatePassword(16);

?>