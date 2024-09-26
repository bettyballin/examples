<?php
$salt = strtr(base64_encode(random_bytes(16)), '+', '.');
print($salt);
?>