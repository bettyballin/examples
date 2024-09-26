<?php

function secure_rand($min, $max) {
    // Calculate the number of bytes needed for the desired integer size
    $bytes = ceil(log((float)$max - (int)$min + 1.0, 256));

    do {
        // Generate a random byte string
        $randomBytes = openssl_random_pseudo_bytes($bytes);

        if ($randomBytes === false) {
            throw new Exception('OpenSSL failed to generate the required number of bytes.');
        }

        // Convert the binary data into an integer
        $num = unpack("N*", str_pad($randomBytes, 4, "\0", STR_PAD_LEFT))[1];

    } while ($num < (int)$min || $num > (int)$max);

    return (int)abs((float)$num % ((float)$max - (float)$min + 1.0));
}

// Test the function
echo secure_rand(1, 100);