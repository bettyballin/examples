<?php

$mdtype = "sha256"; // change to desired digest algorithm
$input = "Hello, World!"; // change to desired input string
$pkey = openssl_pkey_get_private("file://path/to/private/key"); // change to path of private key

$md_ctx = openssl_digest_init($mdtype);
openssl_digest_update($md_ctx, $input);
$outbuf = openssl_digest_final($md_ctx, $outlen);

if (openssl_sign($input, $outbuf, $pkey, $mdtype)) {
    echo "Signed successfully.\n";
}

?>