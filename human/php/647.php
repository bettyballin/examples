<?php

function ctr_crypt($str, $key, $iv) {
    $numOfBlocks = ceil(strlen($str) / 16);

    $ctrStr = '';
    for ($i = 0; $i < $numOfBlocks; ++$i) {
        $ctrStr .= $iv;

        // increment IV
        for ($j = 0; $j < 16; ++$j) {
            $n = ord($iv[$j]);
            if (++$n == 0x100) {
                // overflow, set this one to 0, increment next
                $iv[$j] = "\0";
            } else {
                // no overflow, just write incremented number back and abort
                $iv[$j] = chr($n);
                break;
            }
        }
    }

    return $str ^ mcrypt_encrypt(MCRYPT_RIJNDAEL_128, $key, $ctrStr, MCRYPT_MODE_ECB);
}

// Usage example:
$key = 'your_secret_key_here';
$iv = 'your_initial_vector_here';
$message = 'Hello, World!';
$encrypted = ctr_crypt($message, $key, $iv);
echo "Encrypted: $encrypted\n";

$decrypted = ctr_crypt($encrypted, $key, $iv);
echo "Decrypted: $decrypted\n";

?>