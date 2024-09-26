<?php
$secretKey = 'your_secret_key_here';
$secretKey = substr(hash('sha1', $secretKey, true), 0, 16);
print($secretKey);
?>