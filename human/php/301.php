<?php
$wasItSecure = false;
$iv = openssl_random_pseudo_bytes(16, $wasItSecure);
if ($wasItSecure) {
    echo "We're good to go!";
} else {
    echo "Insecure result. Fail closed, do not proceed.";
    exit;
}
?>