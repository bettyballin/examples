<?php
$hmac = hash_hmac("sha256", "2012-10-01T17:48:56", "secret", true);
$hmac = base64_encode($hmac);
echo $hmac;
?>