<?php
$nonce = wp_create_nonce('my-unique-string');
header("Content-Security-Policy: default-src 'none'; script-src 'nonce-$nonce'");
?>