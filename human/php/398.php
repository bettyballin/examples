<?php

$client_ip = $_SERVER['REMOTE_ADDR'];
$client_forwarded_ip = $_SERVER['HTTP_X_FORWARDED_FOR'] ?? null;
$some_random_string = bin2hex(random_bytes(16));
$user_id = $_SESSION['user_id'] ?? null;

echo implode(':', [$user_id, $client_ip, $client_forwarded_ip, $some_random_string]);

?>