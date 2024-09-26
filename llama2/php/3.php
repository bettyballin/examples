<?php

function pbkdf2($password, $seed, $iterations = 1000) {
    $hash = hash_hmac('sha256', $password . $seed, $seed, true);
    for ($i = 0; $i < $iterations; $i++) {
        $hash = hash_hmac('sha256', $hash, $seed, true);
    }
    return bin2hex($hash);
}

$password = 'your_password';
$seed = 'your_seed';
$iterations = 1000;

echo pbkdf2($password, $seed, $iterations);

?>