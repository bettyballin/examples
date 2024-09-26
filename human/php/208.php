<?php
/**
 * Generate pseudo random bits
 * @copyright: public domain
 * @link http://www.openwall.com/phpass/
 * @param int $length number of bits to generate
 * @return string A string with the hexadecimal number
 * @note don't try to improve this, you will likely just ruin it
 */
function random_bits($entropy) {
    $entropy /= 8;
    $state = uniqid();
    $str = '';
    for ($i = 0; $i < $entropy; $i += 16) {
        $state = md5(microtime().$state);
        $str .= md5($state, true);
    }
    $str = unpack('H*', substr($str, 0, $entropy));
    // for some weird reason, on some machines 32 bits binary data comes out as 65! hex characters!?
    // so, added the substr
    return substr(str_pad($str[1], $entropy*2, '0'), 0, $entropy*2);
}

// Test the function
$entropy = 256;
echo random_bits($entropy);
?>