<?php
function StringToXHH($input) {
    $encoded = bin2hex(strrev($input));

    // Add \\x before each pair
    return "\\x" . str_replace(" ", "\\x", chunk_split($encoded, 2)) ;
}

print(StringToXHH('foo'));
// Output: \\x6f\\x6f\\x66
?>