<?php
$pw = strtoupper(base64_encode(random_bytes(16)));
echo $pw;
?>