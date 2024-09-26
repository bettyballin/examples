<?php
$token = 'asdflkjasdflkjasdflkjsadflkjasdf';

$headers = apache_request_headers();

foreach ($headers as $header => $value) {
    echo "$header: $value\n";
}

if ($headers['X-Auth-Token'] !== $token) {
    echo "BAD TOKEN!\n";
} else {
    echo "DO STUFF\n";
}