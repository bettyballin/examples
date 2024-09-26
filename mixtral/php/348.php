<?php
$binarySalt = random_bytes(16);
$hash = hash_pbkdf2('sha1', 'testing123', $binarySalt, 3000, 16, true);
echo bin2hex($hash);
?>