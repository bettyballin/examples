<?php
function mix_strings($string1, $string2) {
    $hash = hash('sha256', $string1 . $string2);
    return substr($hash, 0, 32); // returns a 32-char string that contains both input strings
}

// Test the function
echo mix_strings("Hello", "World");
?>