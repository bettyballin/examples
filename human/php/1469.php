<?php

$nonce = "NTVkNjE4NzYtZjg4Mi00MmYwLWIzOTAtZGM2NjJhN2U3Mjc5";
$created = "2021-01-21T18:19:32Z";
$passwordHash = "olI18mUowhmeCwjb1FJNHtTHYDA=";

$decodedNonce = base64_decode($nonce);
echo "Decoded Nonce: $decodedNonce\n";

$date = new DateTime($created);
echo "Created Date: ".$date->format('Y-m-d H:i:s')."\n";

$decodedPasswordHash = base64_decode($passwordHash);
echo "Decoded Password Hash: $decodedPasswordHash\n";

?>