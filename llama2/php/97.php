<?php
function caesar_cipher($string, $key) {
    $result = "";
    for ($i = 0; $i < strlen($string); $i++) {
        $char = substr($string, $i, 1);
        $new_char = chr(ord($char) + $key);
        if ($new_char > 'z') {
            $new_char = chr(ord($char) - 26 + $key);
        }
        $result .= $new_char;
    }
    return $result;
}

$string = "hello";
$key = 3;
echo caesar_cipher($string, $key);
?>