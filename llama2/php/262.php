<?php
$input = 'some dangerous input';
$sanitizedInput = filter_var($input, FILTER_SANITIZE_STRING);
print($sanitizedInput);
?>