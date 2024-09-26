<?php
$NUM_BITS = 256;
$random_bits = openssl_random_pseudo_bytes($NUM_BITS / 8);
$printable_key = base64_encode($random_bits);
echo $printable_key;
?>