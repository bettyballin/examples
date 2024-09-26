<?php
function stringToXHH($string) {
    $binary = bin2hex($string);
    return preg_replace('/(..)/', '\\x$1', $binary);
}

print(stringToXHH("foo")); // output --> \x66\x6f\x6f
?>