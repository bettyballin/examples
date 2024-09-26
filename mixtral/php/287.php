<?php
$token = filter_input(INPUT_GET, 'k', FILTER_SANITIZE_STRING);
// Now use $token in your queries
echo $token;
?>