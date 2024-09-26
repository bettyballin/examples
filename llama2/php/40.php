<?php
$user_input = "Hello, World!";
$sanitized_data = filter_var($user_input, FILTER_SANITIZE_STRING);
print($sanitized_data);
?>