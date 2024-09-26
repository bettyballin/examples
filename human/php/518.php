<?php
function utf8_to_iso8859_1($str) {
    return iconv('UTF-8', 'ISO-8859-1', $str);
}

// Test the function
$str = "HÃllo WÃrld!";
echo "Original: $str\n";
echo "Converted: " . utf8_to_iso8859_1($str) . "\n";
?>