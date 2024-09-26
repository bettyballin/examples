<?php

function createBlowfishHash($password) {
    $salt = to64(getRandomBytes(16));
    $salt = '$2a$10$' . $salt;
    $result = crypt($password, $salt);
    return $result;
}

function to64($input) {
    $itoa64 = './0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
    $output = '';
    $i = 0;
    do {
        $c1 = ord($input[$i++]);
        $output .= $itoa64[$c1 >> 2];
        if ($i < strlen($input)) {
            $c2 = ord($input[$i++]);
            $output .= $itoa64[(($c1 & 0x3) << 4) | ($c2 >> 4)];
            if ($i < strlen($input)) {
                $c3 = ord($input[$i++]);
                $output .= $itoa64[(($c2 & 0xf) << 2) | ($c3 >> 6)];
                $output .= $itoa64[$c3 & 0x3f];
            } else {
                $output .= $itoa64[($c2 & 0xf) << 2];
            }
        } else {
            $output .= $itoa64[($c1 & 0x3) << 4];
        }
    } while ($i < strlen($input));
    return $output;
}

function getRandomBytes($count) {
    if (function_exists('random_bytes')) {
        return random_bytes($count);
    } elseif (function_exists('openssl_random_pseudo_bytes')) {
        return openssl_random_pseudo_bytes($count);
    } else {
        throw new Exception('No cryptographically secure pseudo-random number generator available');
    }
}

$password = 'testpassword';
echo createBlowfishHash($password);

?>