<?php

$CV = hex2bin("01000000000000000000000000000000");
$c = [hex2bin("175CC097FFEF635A88836C0062BF87E5")];

function Decrypt($c) {
    // Assuming Decrypt function is already implemented
    // For demonstration purposes, let's assume it's a simple XOR
    $key = hex2bin("00000000000000000000000000000000"); // Replace with actual key
    return $c ^ $key;
}

$m = [];
$m[0] = Decrypt($c[0]) ^ $CV;

echo "CV: " . bin2hex($CV) . "\n";
echo "c[0]: " . bin2hex($c[0]) . "\n";
echo "Decrypt(c[0]): " . bin2hex(Decrypt($c[0])) . "\n";
echo "m[0]: " . bin2hex($m[0]) . "\n";

?>