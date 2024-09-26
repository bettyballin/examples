<?php
$nonce = wp_create_nonce('my-nonce');
$csp_header = "Content-Security-Policy: default-src 'none'; script-src 'nonce-" . rawurlencode($nonce) . "' ...";
header($csp_header);
?>