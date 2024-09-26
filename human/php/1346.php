<?php
$hash = hash_pbkdf2('sha1', 'testing123', "lg4YdsfGNm9zuRizCmk9rA==", 3000, 32, true);
$base64 = base64_encode($hash);
print($base64);
?>