<?php

$baKeyRandom = openssl_random_pseudo_bytes(16);
$secret = "your_secret_here";

$random = md5(pack("H*", bin2hex($baKeyRandom)));

$context = hash_init("md5");

hash_update($context, $random);
$hash = hash_final($context, true);

$context = hash_init("md5");
hash_update($context, $hash);
hash_update($context, pack("H*", bin2hex($secret)));
$finalHash = hash_final($context, true);

echo "Final Hash: " . bin2hex($finalHash) . PHP_EOL;

?>