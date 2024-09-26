<?php
$nonce = "your_nonce_value"; // replace with your nonce value

echo "Nonce Value is : $nonce";
header("Content-Security-Policy: default-src 'none'; script-src 'nonce-$nonce' 'nonce-hzthedtrh5' 'nonce-hjjftzrf56zf'");
?>