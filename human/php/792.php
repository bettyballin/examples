<?php
// generate a 16-character salt string
$salt = substr(str_replace('+','.',base64_encode(md5(mt_rand(), true))),0,16);
// how many times the string will be hashed
$rounds = 10000;
// pass in the password, the number of rounds, and the salt
// $5$ specifies SHA256-CRYPT, use $6$ if you really want SHA512
echo crypt('password123', sprintf('$5$rounds=%d$%s$', $rounds, $salt));
?>