<?php

$N = 10; // example value
$BlockSize = 16; // example value
$c = array_fill(0, $N, 'example_value'); // example values
$m = array_fill(0, $N, 'example_value'); // example values
$CV = 'example_value'; // example value

$y = substr($c[$N-1], 0, $BlockSize - strlen($c[$N-1])) . substr($m[$N-2], -$BlockSize + strlen($c[$N-1]));
$m[$N-1] = openssl_decrypt($y, 'example_cipher', 'example_key', OPENSSL_RAW_DATA) ^ $CV;

?>