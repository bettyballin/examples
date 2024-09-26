<?php
$input = "Hello, <script>alert('XSS')</script> World!";
$output = filter_var($input, FILTER_SANITIZE_STRING);
echo $output;
?>