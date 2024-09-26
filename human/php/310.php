<?php

function pbkdf2($hashFunc, $password, $salt, $iterations, $length = 32) {
    $size   = strlen(hash($hashFunc, '', true));
    $len    = ceil($length / $size);
    $result = '';
    for ($i = 1; $i <= $len; $i++) {
        $tmp = hash_hmac($hashFunc, $salt . pack('N', $i), $password, true);
        $res = $tmp;
        for ($j = 1; $j < $iterations; $j++) {
            $tmp  = hash_hmac($hashFunc, $tmp, $password, true);
            $res ^= $tmp;
        }
        $result .= $res;
    }
    return substr($result, 0, $length);
}

$password = 'my_password';
$salt = 'my_salt';
$iterations = 1000;
$length = 32;
$hashFunc = 'sha256';

$result = pbkdf2($hashFunc, $password, $salt, $iterations, $length);

echo "Result: " . bin2hex($result) . "\n";

?>