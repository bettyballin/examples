
function StringToXHH($string) {
    $hex = bin2hex($string); // Convert string to hex
    $hexArray = str_split($hex, 2); // Split hex string into chunks of two characters
    $xhhString = "\\x" . implode("\\x", $hexArray); // Prepend each chunk with \x
    return $xhhString;
}

echo StringToXHH("foo");
// outputs: \x66\x6f\x6f

