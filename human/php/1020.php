<?php
$base64_string = "your_base64_string_here";
$length = 10; // desired length of salt

$modified_base_64_string = str_replace('+', '.', $base64_string);
$salt = substr($modified_base64_string, 0, $length);

print($salt);
?>