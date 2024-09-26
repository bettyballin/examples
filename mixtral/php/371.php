<?php

$message = 'your_message_here';
$key = 'your_key_here';

$utf_message = mb_convert_encoding($message, 'UTF-8');
$utf_key = trim(mb_convert_encoding($key, 'UTF-8'));

echo base64_encode(hash_hmac('sha384', $utf_message, $utf_key, true));

?>