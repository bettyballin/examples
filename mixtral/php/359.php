<?php
$bytes = random_bytes(5); // Generate 5 bytes

// Convert each byte into an integer and map it onto the desired character set
$asciiString = '';
for ($i=0; $i<strlen($bytes); ++$i) {
    $asciiString .= chr(((int)$bytes[$i] % (126 - 32 + 1)) + 32);
}

echo "ASCII String: " . htmlspecialchars($asciiString, ENT_QUOTES);
?>