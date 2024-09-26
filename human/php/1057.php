<?php
/**
 * Note: See https://paragonie.com/b/JvICXzh_jhLyt4y3 for an alternative implementation
 */
function random_string($length = 26, $alphabet = 'abcdefghijklmnopqrstuvwxyz234567')
{
    if ($length < 1) {
        throw new InvalidArgumentException('Length must be a positive integer');
    }
    $str = '';
    $alphamax = strlen($alphabet) - 1;
    if ($alphamax < 1) {
        throw new InvalidArgumentException('Invalid alphabet');
    }
    for ($i = 0; $i < $length; ++$i) {
        $str .= $alphabet[random_int(0, $alphamax)];
    }
    return $str;
}

// Test the function
echo random_string();
?>