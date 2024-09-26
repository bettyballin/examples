<?php
function random_string($length, $alphabet) {
    $string = '';
    for ($i = 0; $i < $length; $i++) {
        $string .= $alphabet[rand(0, strlen($alphabet) - 1)];
    }
    return $string;
}

$alphabet = 'abcdefghijkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ23456789';
$string = random_string(12, $alphabet);
print($string);
?>