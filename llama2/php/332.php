<?php
function stringToXHH($string) {
    return strtoupper(bin2hex($string));
}

// Example usage:
$string = "Hello, World!";
echo stringToXHH($string);
?>