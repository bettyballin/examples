<?php
$bytes = random_bytes(10); 
$asciiString = base64_encode($bytes);
echo "ASCII String: " . htmlspecialchars($asciiString, ENT_QUOTES) . "";
?>