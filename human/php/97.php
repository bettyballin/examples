<?php

function crypto_rand_secure($min, $max) {
    $range = $max - $min;
    if ($range < 0) return $min; 
    $log = log($range, 2);
    $bytes = (int) ($log / 8) + 1; 
    $bits = (int) $log + 1; 
    $filter = (int) (1 << $bits) - 1; 
    do {
        $rnd = hexdec(bin2hex(openssl_random_pseudo_bytes($bytes)));
        $rnd = $rnd & $filter; 
    } while ($rnd >= $range);
    return $min + $rnd;
}

function getToken($length=32){
    $token = "";
    $codeAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    $codeAlphabet.= "abcdefghijklmnopqrstuvwxyz";
    $codeAlphabet.= "0123456789";
    for($i=0;$i<$length;$i++){
        $token .= $codeAlphabet[crypto_rand_secure(0,strlen($codeAlphabet)-1)];
    }
    return $token;
}

// Test the function
echo getToken();

?>