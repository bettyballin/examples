<?php

$key = random_bytes(32); // Store me for long-term. Maybe per-client?

$data = "foo";
$mac = hash_hmac('sha256', $data, $key);
echo $data . $mac;

?>