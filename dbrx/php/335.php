<?php

function generateToken($length = 60)
{
    $string = bin2hex(random_bytes(ceil($length / 2)));
    return substr($string, 0, $length);
}

// Store the generated token in your database along with user data.
$token = generateToken();

print($token);

?>