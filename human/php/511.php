<?php
$ciphertext = base64_decode('AQAAAAAAAABwdhJYTjgc4ZLKNPuaN8UKdfILRqHfVmDUXHZLUhnagw==');

echo "Ciphertext: ";
for ($i = 0; $i < strlen($ciphertext); $i++) {
    echo sprintf("%02X ", ord($ciphertext[$i]));
}
?>