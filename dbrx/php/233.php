<?php

function random_int($min, $max)
{
    if ($min > $max) {
        throw new InvalidArgumentException('Minimum value must be less than or equal to the maximum value.');
    }

    // Generate a secure random integer between 0 and getrandmax()
    do {
        $random = unpack("N", openssl_random_pseudo_bytes(4));
        
        // Unpack returns an array so we need to access its first element
        $result = ($random[1] & PHP_INT_MAX) % (($max - $min) + 1);
    } while (!is_int($result));

    return (int)$result + $min;
}

// Test the function
echo random_int(1, 100);

?>