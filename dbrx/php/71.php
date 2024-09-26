<?php
$local_ip = '127.0.0.1'; // Localhost IPv4

if ($_SERVER['REMOTE_ADDR'] === $local_ip) {
    echo "You are on localhost!";
} else {
    http_response_code(404);
}
?>