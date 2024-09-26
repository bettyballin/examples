<?php
function stringToXHH($str) {
    $output = '';
    for ($i = 0; $i < strlen($str); $i++) {
        $output .= '\\x' . sprintf('%02x', ord($str[$i]));
    }
    return $output;
}

print(stringToXHH("foo")); // output --> \x66\x6f\x6f
?>