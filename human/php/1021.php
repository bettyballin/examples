<?php
$base64_string = "your_base64_string_here";
$salt_length = 10;

$modified_base_64_string = str_replace('+', '.', $base64_string);
$salt = substr($modified_base_64_string, 0, $salt_length);

print($salt);
?>