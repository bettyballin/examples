<?php

function LastBytes($input, $count) {
    return substr($input, -$count);
}

function Decrypt($input) {
    // assuming a decryption function is implemented elsewhere
    // for demonstration purposes, a simple identity function
    return $input;
}

$c = array();
$c[1] = pack('H*', '1D66DB972E2C');
$m = array();
$m[0] = pack('H*', 'F07B79F2AF27B152D60B');
$CV = pack('H*', '01010101010101010101010101010101');

$y = $c[1] . LastBytes($m[0], 10);
$decrypted_y = Decrypt($y);
$m[1] = $decrypted_y ^ $CV;

print('y = ' . bin2hex($y) . "\n");
print('Decrypt(y) = ' . bin2hex($decrypted_y) . "\n");
print('m[1] = ' . bin2hex($m[1]) . "\n");

?>