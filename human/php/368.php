<?php

function to64($bytes) {
    $alphabet = './0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
    $result = '';
    foreach (unpack('C*', $bytes) as $byte) {
        $result .= $alphabet[$byte % 64];
    }
    return $result;
}

function getRandomBytes($length) {
    return random_bytes($length);
}

function migrateMD5Password($md5Hash) {
    $salt = to64(getRandomBytes(16));
    $salt = '$2a$10$' . $salt;
    $hash = crypt($md5Hash, $salt);
    return '$md5' . $hash;
}

$md5Hash = 'your_md5_hash_here'; // Replace with your MD5 hash
echo migrateMD5Password($md5Hash);

?>