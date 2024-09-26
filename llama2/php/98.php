<?php
function caesar_cipher($string, $key) {
    $result = "";
    for ($i = 0; $i < strlen($string); $i++) {
        $char = $string[$i];
        if (ctype_alpha($char)) {
            $ascii_offset = ord('A') <= ord($char) && ord($char) <= ord('Z') ? ord('A') : ord('a');
            $result .= chr((ord($char) - $ascii_offset + $key) % 26 + $ascii_offset);
        } else {
            $result .= $char;
        }
    }
    return $result;
}

$string = "sample@email_address.com";
$key = -3;
$encrypted_string = caesar_cipher($string, $key);
echo $encrypted_string; 
?>