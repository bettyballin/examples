<?php
$encoded_variable = "%22This%20is%20a%20test%22";
$decoded_variable = urldecode($encoded_variable);
echo $decoded_variable; // Output: "This is a test"
?>