<?php
$nonce1 = "abc123";
$nonce2 = "def456";
$csp = "Content-Security-Policy: script-src  'nonce-".$nonce1."' 'nonce-".$nonce2."'";
header($csp);
?>