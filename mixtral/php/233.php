<?php
$random_value = bin2hex(random_bytes(32));
header("Content-Security-Policy: default-src 'self'; script-src 'nonce-$random_value'");
?>