<?php
function decrypt($cipher, $messagelen, $key) {
    if($messagelen % 2) { $messagelen++; }
    $x = substr($cipher, -$messagelen + 2);
    $y = substr($x, 0, strlen($key) - 1) ^ substr($key, 1);
    $z = substr($x, strlen($key) - 1);
    return $y . $z; 
}

// Example usage:
$cipher = "your_cipher_text";
$messagelen = strlen($cipher);
$key = "your_secret_key";
echo decrypt($cipher, $messagelen, $key);
?>