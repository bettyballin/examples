<?php

function secure_rand($min, $max)
{
    return (unpack("N", openssl_random_pseudo_bytes(4))[1] % ($max - $min + 1)) + $min;
}

// Test the function
echo secure_rand(1, 100);

?>